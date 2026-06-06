package main.visitor;

import main.ast.core.*;
import main.ast.declarations.Module;
import main.ast.types.*;
import main.ast.declarations.*;
import main.ast.statements.*;
import main.ast.expressions.*;
import main.ast.expressions.literals.*;

public interface IVisitor<T> {
    T visit(Program program);

    T visit(Module module);

    T visit(ModuleDecl moduleDecl);

    T visit(Struct struct);

    T visit(StructDecl structDecl);


}