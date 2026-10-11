// start: Phase 3 name and type analyzer
package main.visitor.name;

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
import main.ast.statements.AssignStmt;
import main.ast.statements.Block;
import main.ast.statements.BreakJump;
import main.ast.statements.ContinueJump;
import main.ast.statements.ForStmt;
import main.ast.statements.IfStmt;
import main.ast.statements.InputStmt;
import main.ast.statements.MethodCallStmt;
import main.ast.statements.OutputStmt;
import main.ast.statements.ReturnStmt;
import main.ast.statements.Statement;
import main.ast.statements.VarDeclStmt;
import main.ast.statements.WhileStmt;
import main.ast.types.Identifier;
import main.ast.types.Type;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.items.ModuleItem;
import main.symbolTable.items.StructItem;
import main.symbolTable.items.SymbolTableItem;
import main.symbolTable.items.VarItem;
import main.visitor.Visitor;
import main.visitor.name.SemanticContext.DeclaredTypeResolver;
import main.visitor.name.SemanticContext.ResolvedLocation;

import java.util.List;
import java.util.Map;

public final class NameAnalyzer extends Visitor<Type> {
    private final SemanticContext context;
    private final SymbolTableAnalyzer symbols;
    private final InitializationErrorAnalyzer initialization;
    private final LocationAnalyzer locations;
    private final TypeErrorAnalyzer types;

    public NameAnalyzer() {
        context = new SemanticContext();
        symbols = new SymbolTableAnalyzer(context);

        NameErrorAnalyzer names = new NameErrorAnalyzer(context);
        initialization = new InitializationErrorAnalyzer(context);
        locations = new LocationAnalyzer(
                context,
                names,
                initialization
        );
        types = new TypeErrorAnalyzer(
                context,
                names,
                locations,
                initialization
        );
    }

    public List<String> analyze(Program program) {
        symbols.analyze(program);
        program.accept(this);
        return context.messages();
    }

    @Override
    public Type visit(Program program) {
        for (TopLevelDecl declaration : program.getTopLevelDeclarations()) {
            declaration.accept(this);
        }
        return null;
    }

    @Override
    public Type visit(Module module) {
        ModuleItem item = context.itemFor(module);
        SymbolTableItem previousContainer = context.currentContainer();
        SymbolTable previousScope = context.currentScope();
        context.setCurrentContainer(item);
        context.setCurrentScope(context.memberTable(item));

        for (Identifier include : module.getIncludes()) {
            if (context.findModule(include.getName()) == null) {
                context.report(
                        module.getLine(),
                        include.getName() + " not declared"
                );
            }
        }
        for (Member member : module.getMembers()) {
            member.accept(this);
        }

        context.setCurrentScope(previousScope);
        context.setCurrentContainer(previousContainer);
        return null;
    }

    @Override
    public Type visit(ModuleDecl moduleDecl) {
        return moduleDecl.getModule().accept(this);
    }

    @Override
    public Type visit(Struct struct) {
        StructItem item = context.itemFor(struct);
        SymbolTableItem previousContainer = context.currentContainer();
        SymbolTable previousScope = context.currentScope();
        context.setCurrentContainer(item);
        context.setCurrentScope(context.memberTable(item));

        for (Member member : struct.getMembers()) {
            member.accept(this);
        }

        context.setCurrentScope(previousScope);
        context.setCurrentContainer(previousContainer);
        return null;
    }

    @Override
    public Type visit(StructDecl structDecl) {
        return structDecl.getStruct().accept(this);
    }

    @Override
    public Type visit(Method method) {
        Method previousMethod = context.currentMethod();
        SymbolTable previousScope = context.currentScope();
        context.setCurrentMethod(method);
        context.setCurrentScope(new SymbolTable(
                context.memberTable(context.currentContainer())
        ));

        analyzeType(method.getReturnType());
        for (Parameter parameter : method.getParameters()) {
            parameter.accept(this);
        }
        analyzeStatements(method.getBody());

        context.setCurrentScope(previousScope);
        context.setCurrentMethod(previousMethod);
        return method.getReturnType();
    }

    @Override
    public Type visit(MethodDecl methodDecl) {
        return methodDecl.getMethod().accept(this);
    }

    @Override
    public Type visit(Parameter parameter) {
        analyzeType(parameter.getType());
        VarItem item = new VarItem(
                parameter.getName().getName(),
                parameter.getType(),
                parameter.getIsMutable(),
                "public"
        );
        item.setInitialized(true);
        context.trackVariable(item);
        try {
            context.currentScope().put(item);
        } catch (ItemAlreadyExistsException exception) {
            context.report(
                    parameter.getLine(),
                    parameter.getName().getName() + " already defined"
            );
        }
        return parameter.getType();
    }

    @Override
    public Type visit(Var var) {
        Type type = DeclaredTypeResolver.typeOf(var);
        if (var.getConstructorCall() != null) {
            var.getConstructorCall().accept(types);
        } else {
            analyzeType(type);
        }
        return type;
    }

    @Override
    public Type visit(VarDecl varDecl) {
        return varDecl.getVar().accept(this);
    }

    @Override
    public Type visit(Block block) {
        SymbolTable previousScope = context.currentScope();
        context.setCurrentScope(new SymbolTable(previousScope));
        analyzeStatements(block);
        context.setCurrentScope(previousScope);
        return null;
    }

    private void analyzeStatements(Block block) {
        for (Statement statement : block.getStatements()) {
            statement.accept(this);
        }
    }

    @Override
    public Type visit(VarDeclStmt varDeclStmt) {
        Var var = varDeclStmt.getVar();
        Type type = DeclaredTypeResolver.typeOf(var);
        if (var.getConstructorCall() != null) {
            var.getConstructorCall().accept(types);
        } else {
            analyzeType(type);
        }

        VarItem item = new VarItem(
                var.getName().getName(),
                type,
                var.getIsMutable(),
                "public"
        );
        item.setInitialized(var.getConstructorCall() != null);
        context.trackVariable(item);
        try {
            context.currentScope().put(item);
        } catch (ItemAlreadyExistsException exception) {
            context.report(
                    var.getLine(),
                    var.getName().getName() + " already defined"
            );
        }

        if (varDeclStmt.getInitial() != null) {
            Type initialType =
                    varDeclStmt.getInitial().accept(types);
            types.checkInitializer(
                    type,
                    initialType,
                    varDeclStmt.getLine()
            );
            item.setInitialized(true);
        }
        return type;
    }

    @Override
    public Type visit(AssignStmt assignStmt) {
        ResolvedLocation left = locations.resolve(
                assignStmt.getLeft(),
                false,
                types
        );
        initialization.checkAssignmentTarget(
                left == null ? null : left.variable(),
                assignStmt.getLine()
        );
        Type rightType = assignStmt.getRight().accept(types);
        boolean mismatch = types.checkAssignment(
                left,
                rightType,
                assignStmt.getLine()
        );
        initialization.completeAssignment(
                left == null ? null : left.variable(),
                assignStmt.getLine(),
                mismatch
        );
        return null;
    }

    @Override
    public Type visit(MethodCallStmt methodCallStmt) {
        return methodCallStmt.getMethodCall().accept(types);
    }

    @Override
    public Type visit(ReturnStmt returnStmt) {
        Type actualType = returnStmt.getValue() == null
                ? types.voidType()
                : returnStmt.getValue().accept(types);
        types.checkReturn(actualType, returnStmt.getLine());
        return actualType;
    }

    @Override
    public Type visit(IfStmt ifStmt) {
        types.requireBoolean(
                ifStmt.getCondition().accept(types),
                ifStmt.getLine()
        );

        Map<VarItem, Boolean> before =
                context.snapshotInitialization();
        ifStmt.getThenBranch().accept(this);
        Map<VarItem, Boolean> thenState =
                context.snapshotInitialization();
        context.restoreInitialization(before);

        if (ifStmt.getElseBranch() != null) {
            ifStmt.getElseBranch().accept(this);
            Map<VarItem, Boolean> elseState =
                    context.snapshotInitialization();
            context.restoreInitialization(before);
            context.mergeBranchInitialization(
                    before,
                    thenState,
                    elseState
            );
        } else {
            context.restoreInitialization(before);
        }
        return null;
    }

    @Override
    public Type visit(ForStmt forStmt) {
        SymbolTable previousScope = context.currentScope();
        context.setCurrentScope(new SymbolTable(previousScope));

        for (Statement initializer : forStmt.getInitializers()) {
            initializer.accept(this);
        }
        if (forStmt.getCondition() != null) {
            types.requireBoolean(
                    forStmt.getCondition().accept(types),
                    forStmt.getLine()
            );
        }
        Map<VarItem, Boolean> beforeBody =
                context.snapshotInitialization();
        forStmt.getBody().accept(this);
        for (AssignStmt updater : forStmt.getUpdaters()) {
            updater.accept(this);
        }
        context.restoreInitialization(beforeBody);

        context.setCurrentScope(previousScope);
        return null;
    }

    @Override
    public Type visit(WhileStmt whileStmt) {
        types.requireBoolean(
                whileStmt.getCondition().accept(types),
                whileStmt.getLine()
        );
        Map<VarItem, Boolean> beforeBody =
                context.snapshotInitialization();
        whileStmt.getBody().accept(this);
        context.restoreInitialization(beforeBody);
        return null;
    }

    @Override
    public Type visit(BreakJump breakJump) {
        return null;
    }

    @Override
    public Type visit(ContinueJump continueJump) {
        return null;
    }

    @Override
    public Type visit(InputStmt inputStmt) {
        ResolvedLocation location = locations.resolve(
                inputStmt.getLoc(),
                false,
                types
        );
        if (location == null || location.variable() == null) {
            return null;
        }

        initialization.completeInput(
                location.variable(),
                inputStmt.getLine()
        );
        return null;
    }

    @Override
    public Type visit(OutputStmt outputStmt) {
        return outputStmt.getValue().accept(types);
    }

    private void analyzeType(Type type) {
        if (type != null) {
            type.accept(types);
        }
    }
}
// end: Phase 3 name and type analyzer
