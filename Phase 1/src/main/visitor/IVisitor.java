package main.visitor;

import main.ast.Program;

public interface IVisitor<T> {

    T visit(Program program);

}
