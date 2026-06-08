package main.ast.expressions;

import main.ast.types.Identifier;
import main.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class MethodCall extends Expression {
    private Identifier callee;
    private Location instance;
    private List<Expression> arguments;

    public MethodCall() {
        this.arguments = new ArrayList<>();
    }

    public MethodCall(Identifier callee) {
        this();
        this.callee = callee;
    }

    public void addArgument(Expression argument) {
        arguments.add(argument);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Identifier getCallee() {
        return callee;
    }

    public void setCallee(Identifier callee) {
        this.callee = callee;
    }

    public Location getInstance() {
        return instance;
    }

    public void setInstance(Location instance) {
        this.instance = instance;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    public void setArguments(List<Expression> arguments) {
        this.arguments = arguments;
    }
}
