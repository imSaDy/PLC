// start: Phase 3 location analyzers
package main.visitor.name;

import main.visitor.name.SemanticContext.ResolvedLocation;
import main.visitor.name.SemanticContext.TopLevelTypeAnalyzer;
import main.ast.expressions.Location;
import main.ast.expressions.MemberLoc;
import main.ast.expressions.MethodCallLoc;
import main.ast.expressions.SimpleLoc;
import main.ast.expressions.ThisLoc;
import main.ast.types.Identifier;
import main.ast.types.Type;
import main.ast.types.UserDefinedType;
import main.symbolTable.items.SymbolTableItem;
import main.symbolTable.items.VarItem;
import main.visitor.IVisitor;
import main.visitor.Visitor;

final class LocationAnalyzer {
    private final SemanticContext context;
    private final NameErrorAnalyzer names;
    private final InitializationErrorAnalyzer initialization;
    private final TopLevelTypeAnalyzer types;

    LocationAnalyzer(
            SemanticContext context,
            NameErrorAnalyzer names,
            InitializationErrorAnalyzer initialization
    ) {
        this.context = context;
        this.names = names;
        this.initialization = initialization;
        this.types = new TopLevelTypeAnalyzer(context);
    }

    ResolvedLocation resolve(
            Location location,
            boolean read,
            IVisitor<Type> expressionAnalyzer
    ) {
        return location.accept(new AbsoluteLocationAnalyzer(
                context,
                names,
                initialization,
                this,
                read,
                expressionAnalyzer
        ));
    }

    ResolvedLocation resolveRelative(
            SymbolTableItem container,
            Location location,
            boolean read
    ) {
        return location.accept(new RelativeLocationAnalyzer(
                context,
                names,
                initialization,
                this,
                container,
                read
        ));
    }

    ResolvedLocation resolveNamedBase(String name, int line) {
        VarItem variable = context.lookupVariable(name);
        if (variable != null) {
            return new ResolvedLocation(variable.getType(), variable);
        }
        SymbolTableItem container = context.findTopLevel(name);
        if (container != null) {
            return new ResolvedLocation(typeOf(container), null);
        }
        context.report(line, name + " not declared");
        return null;
    }

    SymbolTableItem containerFor(Type type) {
        return type == null ? null : type.accept(types);
    }

    Type typeOf(SymbolTableItem container) {
        return container == null
                ? null
                : new UserDefinedType(
                        new Identifier(container.getName())
                );
    }
}

final class AbsoluteLocationAnalyzer extends Visitor<ResolvedLocation> {
    private final SemanticContext context;
    private final NameErrorAnalyzer names;
    private final InitializationErrorAnalyzer initialization;
    private final LocationAnalyzer locations;
    private final boolean read;
    private final IVisitor<Type> expressions;

    AbsoluteLocationAnalyzer(
            SemanticContext context,
            NameErrorAnalyzer names,
            InitializationErrorAnalyzer initialization,
            LocationAnalyzer locations,
            boolean read,
            IVisitor<Type> expressions
    ) {
        this.context = context;
        this.names = names;
        this.initialization = initialization;
        this.locations = locations;
        this.read = read;
        this.expressions = expressions;
    }

    @Override
    public ResolvedLocation visit(SimpleLoc simpleLoc) {
        String name = simpleLoc.getId().getName();
        VarItem variable = context.lookupVariable(name);
        if (variable != null) {
            initialization.checkRead(variable, simpleLoc.getLine(), read);
            return new ResolvedLocation(variable.getType(), variable);
        }

        VarItem includedField =
                names.findField(context.currentContainer(), name);
        if (includedField != null) {
            boolean privateAccess =
                    names.checkPrivate(includedField, simpleLoc.getLine());
            if (!privateAccess) {
                initialization.checkRead(
                        includedField,
                        simpleLoc.getLine(),
                        read
                );
            }
            return new ResolvedLocation(
                    includedField.getType(),
                    privateAccess ? null : includedField
            );
        }

        SymbolTableItem container = context.findTopLevel(name);
        if (container != null) {
            return new ResolvedLocation(locations.typeOf(container), null);
        }
        context.report(simpleLoc.getLine(), name + " not declared");
        return null;
    }

    @Override
    public ResolvedLocation visit(ThisLoc thisLoc) {
        if (thisLoc.getLoc() == null) {
            return new ResolvedLocation(
                    locations.typeOf(context.currentContainer()),
                    null
            );
        }
        return locations.resolveRelative(
                context.currentContainer(),
                thisLoc.getLoc(),
                read
        );
    }

    @Override
    public ResolvedLocation visit(MemberLoc memberLoc) {
        ResolvedLocation base = locations.resolveNamedBase(
                memberLoc.getMemberName().getName(),
                memberLoc.getLine()
        );
        if (base == null) {
            return null;
        }

        boolean baseIsUninitialized = read
                && base.variable() != null
                && !base.variable().isInitialized();
        if (baseIsUninitialized) {
            context.report(
                    memberLoc.getLine(),
                    base.variable().getName() + " is uninitialized"
            );
        }
        return locations.resolveRelative(
                locations.containerFor(base.type()),
                memberLoc.getLoc(),
                read && !baseIsUninitialized
        );
    }

    @Override
    public ResolvedLocation visit(MethodCallLoc methodCallLoc) {
        return new ResolvedLocation(
                methodCallLoc.getMethodCall().accept(expressions),
                null
        );
    }
}

final class RelativeLocationAnalyzer extends Visitor<ResolvedLocation> {
    private final SemanticContext context;
    private final NameErrorAnalyzer names;
    private final InitializationErrorAnalyzer initialization;
    private final LocationAnalyzer locations;
    private final SymbolTableItem container;
    private final boolean read;

    RelativeLocationAnalyzer(
            SemanticContext context,
            NameErrorAnalyzer names,
            InitializationErrorAnalyzer initialization,
            LocationAnalyzer locations,
            SymbolTableItem container,
            boolean read
    ) {
        this.context = context;
        this.names = names;
        this.initialization = initialization;
        this.locations = locations;
        this.container = container;
        this.read = read;
    }

    @Override
    public ResolvedLocation visit(SimpleLoc simpleLoc) {
        String name = simpleLoc.getId().getName();
        if (container == null) {
            context.report(simpleLoc.getLine(), name + " not declared");
            return null;
        }

        VarItem variable = names.findField(container, name);
        if (variable == null) {
            context.report(simpleLoc.getLine(), name + " not declared");
            return null;
        }
        boolean privateAccess =
                names.checkPrivate(variable, simpleLoc.getLine());
        if (!privateAccess) {
            initialization.checkRead(variable, simpleLoc.getLine(), read);
        }
        return new ResolvedLocation(
                variable.getType(),
                privateAccess ? null : variable
        );
    }

    @Override
    public ResolvedLocation visit(MemberLoc memberLoc) {
        String name = memberLoc.getMemberName().getName();
        if (container == null) {
            context.report(memberLoc.getLine(), name + " not declared");
            return null;
        }

        VarItem variable = names.findField(container, name);
        if (variable == null) {
            context.report(memberLoc.getLine(), name + " not declared");
            return null;
        }
        if (names.checkPrivate(variable, memberLoc.getLine())) {
            return new ResolvedLocation(variable.getType(), null);
        }
        return locations.resolveRelative(
                locations.containerFor(variable.getType()),
                memberLoc.getLoc(),
                read
        );
    }

    @Override
    public ResolvedLocation visit(ThisLoc thisLoc) {
        if (container == null) {
            return null;
        }
        return thisLoc.getLoc() == null
                ? new ResolvedLocation(locations.typeOf(container), null)
                : locations.resolveRelative(
                        container,
                        thisLoc.getLoc(),
                        read
                );
    }
}
// end: Phase 3 location analyzers
