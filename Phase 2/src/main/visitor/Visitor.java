package main.visitor;

import main.ast.core.*;
import main.ast.declarations.Module;
import main.ast.types.*;
import main.ast.declarations.*;
import main.ast.statements.*;
import main.ast.expressions.*;
import main.ast.expressions.literals.*;

public abstract class Visitor<T> implements IVisitor<T> {
    @Override
    public T visit(Program program) { return null; }

    @Override
    public T visit(Module module) { return null; }

    @Override
    public T visit(ModuleDecl moduleDecl) { return null; }

    @Override
    public T visit(Struct struct) { return null; }

    @Override
    public T visit(StructDecl structDecl) { return null; }


}