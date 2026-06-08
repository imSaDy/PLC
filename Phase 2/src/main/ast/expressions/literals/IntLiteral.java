package main.ast.expressions.literals;

import main.visitor.IVisitor;

public class IntLiteral extends Literal<Integer> {
    public IntLiteral(int value) {
        super(value);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
