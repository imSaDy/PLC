package main.ast.expressions;

import main.ast.expressions.operators.UnaryOperator;
import main.visitor.IVisitor;

public class UnaryExpression extends Expression {
    private UnaryOperator operator;
    private Expression operand;

    public UnaryExpression(UnaryOperator operator, Expression operand) {
        this.operator = operator;
        this.operand = operand;
    }

    public UnaryExpression(String operator, Expression operand) {
        this(UnaryOperator.fromString(operator), operand);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    
    public UnaryOperator getOperator() {
        return operator;
    }
    public void setOperator(UnaryOperator operator) {
        this.operator = operator;
    }
    public Expression getOperand() {
        return operand;
    }
    public void setOperand(Expression operand) {
        this.operand = operand;
    }
}