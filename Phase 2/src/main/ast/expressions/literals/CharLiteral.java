package main.ast.expressions.literals;

import main.visitor.IVisitor;

public class CharLiteral extends Literal<Character> {
    public CharLiteral(char value) {
        super(value);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
