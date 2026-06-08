package main.ast.expressions.literals;

import main.visitor.IVisitor;

public class DoubleLiteral extends Literal<Double> {
    public DoubleLiteral(double value) {
        super(value);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
