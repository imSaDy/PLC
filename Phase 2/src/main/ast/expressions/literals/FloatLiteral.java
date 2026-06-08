package main.ast.expressions.literals;

import main.visitor.IVisitor;

public class FloatLiteral extends Literal<Float> {
    public FloatLiteral(float value) {
        super(value);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}