package main.ast.expressions.literals;

import main.visitor.IVisitor;

public class BoolLiteral extends Literal<Boolean> {
    public BoolLiteral(boolean value) {
        super(value);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
