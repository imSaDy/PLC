
    package main.grammar;
    import main.ast.core.*;
    import main.ast.types.*;
    import main.ast.declarations.*;
    import main.ast.declarations.Module;
    import main.ast.statements.*;
    import main.ast.expressions.*;
    import main.ast.expressions.literals.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

public interface SimpleLangVisitor<T> extends ParseTreeVisitor<T> {
	T visitProgram(SimpleLangParser.ProgramContext ctx);
	T visitTopLevelDecl(SimpleLangParser.TopLevelDeclContext ctx);
	T visitModule(SimpleLangParser.ModuleContext ctx);
	T visitStructDef(SimpleLangParser.StructDefContext ctx);
	T visitMember(SimpleLangParser.MemberContext ctx);
	T visitAccessModifier(SimpleLangParser.AccessModifierContext ctx);
	T visitMethod_decl(SimpleLangParser.Method_declContext ctx);
	T visitArguments(SimpleLangParser.ArgumentsContext ctx);
	T visitParameter(SimpleLangParser.ParameterContext ctx);
	T visitType(SimpleLangParser.TypeContext ctx);
	T visitVardecl(SimpleLangParser.VardeclContext ctx);
	T visitCons(SimpleLangParser.ConsContext ctx);
	T visitBlock(SimpleLangParser.BlockContext ctx);
	T visitSt(SimpleLangParser.StContext ctx);
	T visitJumpStmt(SimpleLangParser.JumpStmtContext ctx);
	T visitIfStmt(SimpleLangParser.IfStmtContext ctx);
	T visitForStmt(SimpleLangParser.ForStmtContext ctx);
	T visitWhileStmt(SimpleLangParser.WhileStmtContext ctx);
	T visitAssignStmt(SimpleLangParser.AssignStmtContext ctx);
	T visitReturnStmt(SimpleLangParser.ReturnStmtContext ctx);
	T visitInputStmt(SimpleLangParser.InputStmtContext ctx);
	T visitOutputStmt(SimpleLangParser.OutputStmtContext ctx);
	T visitLoc(SimpleLangParser.LocContext ctx);
	T visitSimpleLoc(SimpleLangParser.SimpleLocContext ctx);
	T visitMemberLoc(SimpleLangParser.MemberLocContext ctx);
	T visitThisLoc(SimpleLangParser.ThisLocContext ctx);
	T visitMethodcall(SimpleLangParser.MethodcallContext ctx);
	T visitExpr(SimpleLangParser.ExprContext ctx);
	T visitInitexpr(SimpleLangParser.InitexprContext ctx);
}
