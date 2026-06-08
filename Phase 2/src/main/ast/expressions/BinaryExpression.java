package main.ast.expressions;

import main.ast.expressions.operators.BinaryOperator;
import main.visitor.IVisitor;

public class BinaryExpression extends Expression {
    private Expression leftOperand;
    private BinaryOperator operator;
    private Expression rightOperand;

    public BinaryExpression(Expression leftOperand, BinaryOperator operator, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.operator = operator;
        this.rightOperand = rightOperand;
    }

    public BinaryExpression(Expression leftOperand, String operator, Expression rightOperand) {
        this(leftOperand, BinaryOperator.fromString(operator), rightOperand);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Expression getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(Expression leftOperand) {
        this.leftOperand = leftOperand;
    }

    public BinaryOperator getOperator() {
        return operator;
    }

    public void setOperator(BinaryOperator operator) {
        this.operator = operator;
    }

    public Expression getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(Expression rightOperand) {
        this.rightOperand = rightOperand;
    }
}
