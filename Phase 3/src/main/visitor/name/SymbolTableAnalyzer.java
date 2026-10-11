// start: Phase 3 symbol-table analyzers
package main.visitor.name;

import main.visitor.name.SemanticContext.DeclaredTypeResolver;
import main.ast.core.Program;
import main.ast.declarations.Member;
import main.ast.declarations.Method;
import main.ast.declarations.MethodDecl;
import main.ast.declarations.Module;
import main.ast.declarations.ModuleDecl;
import main.ast.declarations.Parameter;
import main.ast.declarations.Struct;
import main.ast.declarations.StructDecl;
import main.ast.declarations.TopLevelDecl;
import main.ast.declarations.Var;
import main.ast.declarations.VarDecl;
import main.ast.types.AccessModifier;
import main.ast.types.Identifier;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.MethodItem;
import main.symbolTable.items.ModuleItem;
import main.symbolTable.items.StructItem;
import main.symbolTable.items.SymbolTableItem;
import main.symbolTable.items.VarItem;
import main.visitor.Visitor;

final class SymbolTableAnalyzer {
    private final TopLevelSymbolAnalyzer topLevels;
    private final MemberSymbolAnalyzer members;

    SymbolTableAnalyzer(SemanticContext context) {
        topLevels = new TopLevelSymbolAnalyzer(context);
        members = new MemberSymbolAnalyzer(context);
    }

    void analyze(Program program) {
        for (TopLevelDecl declaration
                : program.getTopLevelDeclarations()) {
            declaration.accept(topLevels);
        }
        for (TopLevelDecl declaration
                : program.getTopLevelDeclarations()) {
            declaration.accept(members);
        }
    }
}

final class TopLevelSymbolAnalyzer extends Visitor<Void> {
    private final SemanticContext context;

    TopLevelSymbolAnalyzer(SemanticContext context) {
        this.context = context;
    }

    @Override
    public Void visit(ModuleDecl moduleDecl) {
        Module module = moduleDecl.getModule();
        ModuleItem item = new ModuleItem(module.getName().getName());
        context.bind(module, item);
        try {
            context.globalTable().put(item);
            context.registerTopLevel(item);
        } catch (ItemAlreadyExistsException exception) {
            context.report(
                    module.getLine(),
                    module.getName().getName() + " already defined"
            );
        }
        return null;
    }

    @Override
    public Void visit(StructDecl structDecl) {
        Struct struct = structDecl.getStruct();
        StructItem item = new StructItem(struct.getName().getName());
        context.bind(struct, item);
        try {
            context.globalTable().put(item);
            context.registerTopLevel(item);
        } catch (ItemAlreadyExistsException exception) {
            context.report(
                    struct.getLine(),
                    struct.getName().getName() + " already defined"
            );
        }
        return null;
    }
}

final class MemberSymbolAnalyzer extends Visitor<Void> {
    private final SemanticContext context;
    private SymbolTableItem currentContainer;
    private StructItem currentStruct;

    MemberSymbolAnalyzer(SemanticContext context) {
        this.context = context;
    }

    @Override
    public Void visit(ModuleDecl moduleDecl) {
        Module module = moduleDecl.getModule();
        analyzeMembers(
                module.getMembers(),
                context.itemFor(module),
                null
        );
        return null;
    }

    @Override
    public Void visit(StructDecl structDecl) {
        Struct struct = structDecl.getStruct();
        StructItem item = context.itemFor(struct);
        analyzeMembers(struct.getMembers(), item, item);
        return null;
    }

    private void analyzeMembers(
            Iterable<Member> members,
            SymbolTableItem container,
            StructItem struct
    ) {
        SymbolTableItem previousContainer = currentContainer;
        StructItem previousStruct = currentStruct;
        currentContainer = container;
        currentStruct = struct;
        for (Member member : members) {
            member.accept(this);
        }
        currentContainer = previousContainer;
        currentStruct = previousStruct;
    }

    @Override
    public Void visit(VarDecl varDecl) {
        Var var = varDecl.getVar();
        VarItem item = new VarItem(
                var.getName().getName(),
                DeclaredTypeResolver.typeOf(var),
                var.getIsMutable(),
                visibility(varDecl.getAccessModifier())
        );
        item.setInitialized(var.getConstructorCall() != null);
        context.trackVariable(item);
        context.bindDeclaration(item, currentContainer);

        try {
            context.memberTable(currentContainer).put(item);
            recordStructField(item);
        } catch (ItemAlreadyExistsException exception) {
            context.report(
                    var.getLine(),
                    var.getName().getName() + " already defined"
            );
            recordExistingStructField(var.getName().getName());
        }
        return null;
    }

    @Override
    public Void visit(MethodDecl methodDecl) {
        Method method = methodDecl.getMethod();
        MethodItem item = new MethodItem(
                method.getName().getName(),
                method.getReturnType(),
                visibility(methodDecl.getAccessModifier())
        );
        for (Parameter parameter : method.getParameters()) {
            item.addParameterType(parameter.getType());
        }
        context.bindMethod(item, method);
        context.bindDeclaration(item, currentContainer);

        try {
            context.memberTable(currentContainer).put(item);
        } catch (ItemAlreadyExistsException exception) {
            context.report(
                    method.getLine(),
                    method.getName().getName() + " already defined"
            );
        }
        return null;
    }

    private void recordStructField(VarItem field) {
        if (currentStruct != null) {
            currentStruct.addField(field);
        }
    }

    private void recordExistingStructField(String name) {
        if (currentStruct == null) {
            return;
        }
        try {
            currentStruct.addField(
                    (VarItem) currentStruct
                            .getStructSymbolTable()
                            .get(name)
            );
        } catch (ItemNotFoundException ignored) {
            currentStruct.addInvalidFieldSlot();
        }
    }

    private String visibility(AccessModifier modifier) {
        return modifier == AccessModifier.PRIVATE
                ? "private"
                : "public";
    }
}
// end: Phase 3 symbol-table analyzers
