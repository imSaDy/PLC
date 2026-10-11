// start: Phase 3 reachability reference analyzer
package main.visitor.reachability;

import main.visitor.reachability.ReachabilityGraphAnalyzer.Graph;
import main.visitor.reachability.ReachabilityGraphAnalyzer.Node;
import main.ast.declarations.Member;
import main.ast.declarations.Method;
import main.ast.declarations.MethodDecl;
import main.ast.declarations.Parameter;
import main.ast.declarations.Var;
import main.ast.declarations.VarDecl;
import main.ast.expressions.BinaryExpression;
import main.ast.expressions.ConstructorCall;
import main.ast.expressions.Expression;
import main.ast.expressions.MemberLoc;
import main.ast.expressions.MethodCall;
import main.ast.expressions.MethodCallLoc;
import main.ast.expressions.ParanthesisExpr;
import main.ast.expressions.SimpleLoc;
import main.ast.expressions.ThisLoc;
import main.ast.expressions.UnaryExpression;
import main.ast.expressions.UnaryOpExpr;
import main.ast.statements.AssignStmt;
import main.ast.statements.Block;
import main.ast.statements.ForStmt;
import main.ast.statements.IfStmt;
import main.ast.statements.InputStmt;
import main.ast.statements.MethodCallStmt;
import main.ast.statements.OutputStmt;
import main.ast.statements.ReturnStmt;
import main.ast.statements.Statement;
import main.ast.statements.VarDeclStmt;
import main.ast.statements.WhileStmt;
import main.ast.types.UserDefinedType;
import main.visitor.Visitor;

import java.util.Set;

final class ReachabilityReferenceAnalyzer extends Visitor<Void> {
    private final Graph graph;
    private final Node node;

    ReachabilityReferenceAnalyzer(
            Graph graph,
            Node node
    ) {
        this.graph = graph;
        this.node = node;
    }

    void analyze() {
        for (String includedName : node.includedNames()) {
            addReference(includedName);
        }
        for (Member member : node.members()) {
            member.accept(this);
        }
    }

    private void addReference(String name) {
        if (graph.containsNode(name)) {
            node.references().add(name);
        }
    }

    private void analyzeExpression(Expression expression) {
        if (expression != null) {
            expression.accept(this);
        }
    }

    private void analyzeStatement(Statement statement) {
        if (statement != null) {
            statement.accept(this);
        }
    }

    @Override
    public Void visit(MethodDecl methodDecl) {
        methodDecl.getMethod().accept(this);
        return null;
    }

    @Override
    public Void visit(VarDecl varDecl) {
        varDecl.getVar().accept(this);
        return null;
    }

    @Override
    public Void visit(Method method) {
        method.getReturnType().accept(this);
        for (Parameter parameter : method.getParameters()) {
            parameter.accept(this);
        }
        method.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(Parameter parameter) {
        parameter.getType().accept(this);
        return null;
    }

    @Override
    public Void visit(Var var) {
        if (var.getType() != null) {
            var.getType().accept(this);
        }
        if (var.getConstructorCall() != null) {
            var.getConstructorCall().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Block block) {
        for (Statement statement : block.getStatements()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(VarDeclStmt varDeclStmt) {
        varDeclStmt.getVar().accept(this);
        analyzeExpression(varDeclStmt.getInitial());
        return null;
    }

    @Override
    public Void visit(AssignStmt assignStmt) {
        assignStmt.getLeft().accept(this);
        assignStmt.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCallStmt methodCallStmt) {
        methodCallStmt.getMethodCall().accept(this);
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        analyzeExpression(returnStmt.getValue());
        return null;
    }

    @Override
    public Void visit(IfStmt ifStmt) {
        ifStmt.getCondition().accept(this);
        analyzeStatement(ifStmt.getThenBranch());
        analyzeStatement(ifStmt.getElseBranch());
        return null;
    }

    @Override
    public Void visit(ForStmt forStmt) {
        for (Statement initializer : forStmt.getInitializers()) {
            initializer.accept(this);
        }
        analyzeExpression(forStmt.getCondition());
        for (AssignStmt updater : forStmt.getUpdaters()) {
            updater.accept(this);
        }
        analyzeStatement(forStmt.getBody());
        return null;
    }

    @Override
    public Void visit(WhileStmt whileStmt) {
        whileStmt.getCondition().accept(this);
        analyzeStatement(whileStmt.getBody());
        return null;
    }

    @Override
    public Void visit(InputStmt inputStmt) {
        inputStmt.getLoc().accept(this);
        return null;
    }

    @Override
    public Void visit(OutputStmt outputStmt) {
        outputStmt.getValue().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCall methodCall) {
        if (methodCall.getInstance() != null) {
            methodCall.getInstance().accept(this);
        }
        for (Expression argument : methodCall.getArguments()) {
            argument.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConstructorCall constructorCall) {
        addReference(constructorCall.getName().getName());
        for (Expression argument : constructorCall.getArguments()) {
            argument.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(SimpleLoc simpleLoc) {
        addReference(simpleLoc.getId().getName());
        return null;
    }

    @Override
    public Void visit(MemberLoc memberLoc) {
        addReference(memberLoc.getMemberName().getName());
        memberLoc.getLoc().accept(this);
        return null;
    }

    @Override
    public Void visit(ThisLoc thisLoc) {
        if (thisLoc.getLoc() != null) {
            thisLoc.getLoc().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(MethodCallLoc methodCallLoc) {
        methodCallLoc.getMethodCall().accept(this);
        return null;
    }

    @Override
    public Void visit(ParanthesisExpr paranthesisExpr) {
        paranthesisExpr.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryOpExpr unaryOpExpr) {
        unaryOpExpr.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        binaryExpression.getLeftOperand().accept(this);
        binaryExpression.getRightOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        unaryExpression.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(UserDefinedType userDefinedType) {
        addReference(userDefinedType.getId().getName());
        return null;
    }
}
// end: Phase 3 reachability reference analyzer
