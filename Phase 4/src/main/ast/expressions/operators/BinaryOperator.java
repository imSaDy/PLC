package main.ast.expressions.operators;

public enum BinaryOperator {
    MULTIPLICATION("*"),
    DIVISION("/"),
    ADDITION("+"),
    SUBTRACTION("-"),
    LESS_THAN("<"),
    GREATER_THAN(">"),
    LESS_THAN_OR_EQUAL_TO("<="),
    GREATER_THAN_OR_EQUAL_TO(">="),
    EQUALITY("=="),
    INEQUALITY("!="),
    AND("and"),
    OR("or");

    private final String symbol;

    BinaryOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public static BinaryOperator fromString(String symbol) {
        for (BinaryOperator operator : BinaryOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Unknown operator: " + symbol);
    }
}
