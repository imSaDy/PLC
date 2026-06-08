package main.ast.expressions.operators;

public enum UnaryOperator {
    MINUS("-"),
    NOT("not");

    private final String symbol;

    UnaryOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static UnaryOperator fromString(String symbol) {
        for (UnaryOperator operator : values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Unknown unary operator: " + symbol);
    }
}
