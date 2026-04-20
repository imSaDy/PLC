package main.visitor;

import main.ast.Program;


public class ASTPrinter implements IVisitor<Void> {

    @Override
    public Void visit(Program program) {
        System.out.println("Hello");

        return null;
    }
}
