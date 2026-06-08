package main.visitor;

import main.ast.core.*;
import main.ast.declarations.Module;
import main.ast.types.*;
import main.ast.declarations.*;
import main.ast.statements.*;
import main.ast.expressions.*;
import main.ast.expressions.literals.*;

public interface IVisitor<T> {
    
    // Core & Declarations
    T visit(Program program);
    T visit(Module module);
    T visit(Struct struct);
    T visit(Method method);
    T visit(Var var);
    T visit(Parameter parameter);
    T visit(MethodDecl methodDecl);
    T visit(ModuleDecl moduleDecl);
    T visit(StructDecl structDecl);
    T visit(VarDecl varDecl);

    // Statements
    T visit(Block block);
    T visit(AssignStmt assignStmt);
    T visit(BreakJump breakJump);
    T visit(ContinueJump continueJump);
    T visit(ForStmt forStmt);
    T visit(IfStmt ifStmt);
    T visit(InputStmt inputStmt);
    T visit(MethodCallStmt methodCallStmt);
    T visit(OutputStmt outputStmt);
    T visit(ReturnStmt returnStmt);
    T visit(VarDeclStmt varDeclStmt);
    T visit(WhileStmt whileStmt);

    // Expressions
    T visit(BinaryExpression binaryExpression);
    T visit(ConstructorCall constructorCall);
    T visit(MethodCall methodCall);
    T visit(UnaryExpression unaryExpression);

    // Locations
    T visit(MemberLoc memberLoc);
    T visit(SimpleLoc simpleLoc);
    T visit(ThisLoc thisLoc);

    // Literals
    T visit(BoolLiteral boolLiteral);
    T visit(CharLiteral charLiteral);
    T visit(DoubleLiteral doubleLiteral);
    T visit(FloatLiteral floatLiteral);
    T visit(IntLiteral intLiteral);

    // Types
    T visit(Identifier identifier);
    T visit(PrimitiveType primitiveType);
    T visit(UserDefinedType userDefinedType);
}