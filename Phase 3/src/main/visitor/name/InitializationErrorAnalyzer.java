// start: Phase 3 initialization and mutability error analyzer
package main.visitor.name;

import main.ast.declarations.Method;
import main.ast.expressions.ThisLoc;
import main.ast.statements.AssignStmt;
import main.ast.statements.Block;
import main.ast.statements.ForStmt;
import main.ast.statements.IfStmt;
import main.ast.statements.InputStmt;
import main.ast.statements.Statement;
import main.ast.statements.WhileStmt;
import main.symbolTable.items.MethodItem;
import main.symbolTable.items.VarItem;
import main.visitor.Visitor;

final class InitializationErrorAnalyzer extends Visitor<Boolean> {
    private final SemanticContext context;

    InitializationErrorAnalyzer(SemanticContext context) {
        this.context = context;
    }

    void checkRead(VarItem variable, int line, boolean read) {
        if (read && !variable.isInitialized()) {
            context.report(
                    line,
                    variable.getName() + " is uninitialized"
            );
        }
    }

    void checkAssignmentTarget(VarItem variable, int line) {
        if (variable == null) {
            return;
        }
        if (!context.isMember(variable) && !variable.isMut()) {
            context.report(
                    line,
                    "Cannot modify immutable variable "
                            + variable.getName()
            );
        }
    }

    void completeAssignment(
            VarItem variable,
            int line,
            boolean typeMismatch
    ) {
        if (variable == null) {
            return;
        }
        variable.setInitialized(true);
    }

    void completeInput(VarItem variable, int line) {
        if (!context.isMember(variable) && !variable.isMut()) {
            context.report(
                    line,
                    "Cannot modify immutable variable "
                            + variable.getName()
            );
        }
        variable.setInitialized(true);
    }

    boolean methodInitializesReceiver(MethodItem methodItem) {
        if ("init".equals(methodItem.getName())) {
            return true;
        }
        Method declaration = context.declarationFor(methodItem);
        return declaration != null
                && statementInitializesReceiver(declaration.getBody());
    }

    private boolean statementInitializesReceiver(Statement statement) {
        return statement != null
                && Boolean.TRUE.equals(statement.accept(this));
    }

    @Override
    public Boolean visit(ThisLoc thisLoc) {
        return true;
    }

    @Override
    public Boolean visit(AssignStmt assignStmt) {
        return Boolean.TRUE.equals(assignStmt.getLeft().accept(this));
    }

    @Override
    public Boolean visit(InputStmt inputStmt) {
        return Boolean.TRUE.equals(inputStmt.getLoc().accept(this));
    }

    @Override
    public Boolean visit(Block block) {
        for (Statement statement : block.getStatements()) {
            if (statementInitializesReceiver(statement)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean visit(IfStmt ifStmt) {
        return statementInitializesReceiver(ifStmt.getThenBranch())
                || statementInitializesReceiver(ifStmt.getElseBranch());
    }

    @Override
    public Boolean visit(ForStmt forStmt) {
        for (Statement initializer : forStmt.getInitializers()) {
            if (statementInitializesReceiver(initializer)) {
                return true;
            }
        }
        for (AssignStmt updater : forStmt.getUpdaters()) {
            if (statementInitializesReceiver(updater)) {
                return true;
            }
        }
        return statementInitializesReceiver(forStmt.getBody());
    }

    @Override
    public Boolean visit(WhileStmt whileStmt) {
        return statementInitializesReceiver(whileStmt.getBody());
    }
}
// end: Phase 3 initialization and mutability error analyzer
