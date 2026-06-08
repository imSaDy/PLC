package main.ast.expressions.literals;

import main.ast.expressions.Expression;

public abstract class Literal<T> extends Expression {
    private T value;

    protected Literal(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
