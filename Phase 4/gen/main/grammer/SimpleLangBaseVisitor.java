
    package main.grammar;
    import main.ast.core.*;
    import main.ast.types.*;
    import main.ast.declarations.*;
    import main.ast.declarations.Module;
    import main.ast.statements.*;
    import main.ast.expressions.*;
    import main.ast.expressions.literals.*;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

@SuppressWarnings("CheckReturnValue")
public class SimpleLangBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements SimpleLangVisitor<T> {
	@Override public T visitProgram(SimpleLangParser.ProgramContext ctx) { return visitChildren(ctx); }
	@Override public T visitTopLevelDecl(SimpleLangParser.TopLevelDeclContext ctx) { return visitChildren(ctx); }
	@Override public T visitModule(SimpleLangParser.ModuleContext ctx) { return visitChildren(ctx); }
	@Override public T visitStructDef(SimpleLangParser.StructDefContext ctx) { return visitChildren(ctx); }
	@Override public T visitMember(SimpleLangParser.MemberContext ctx) { return visitChildren(ctx); }
	@Override public T visitAccessModifier(SimpleLangParser.AccessModifierContext ctx) { return visitChildren(ctx); }
	@Override public T visitMethod_decl(SimpleLangParser.Method_declContext ctx) { return visitChildren(ctx); }
	@Override public T visitArguments(SimpleLangParser.ArgumentsContext ctx) { return visitChildren(ctx); }
	@Override public T visitParameter(SimpleLangParser.ParameterContext ctx) { return visitChildren(ctx); }
	@Override public T visitType(SimpleLangParser.TypeContext ctx) { return visitChildren(ctx); }
	@Override public T visitVardecl(SimpleLangParser.VardeclContext ctx) { return visitChildren(ctx); }
	@Override public T visitCons(SimpleLangParser.ConsContext ctx) { return visitChildren(ctx); }
	@Override public T visitBlock(SimpleLangParser.BlockContext ctx) { return visitChildren(ctx); }
	@Override public T visitSt(SimpleLangParser.StContext ctx) { return visitChildren(ctx); }
	@Override public T visitJumpStmt(SimpleLangParser.JumpStmtContext ctx) { return visitChildren(ctx); }
	@Override public T visitIfStmt(SimpleLangParser.IfStmtContext ctx) { return visitChildren(ctx); }
	@Override public T visitForStmt(SimpleLangParser.ForStmtContext ctx) { return visitChildren(ctx); }
	@Override public T visitWhileStmt(SimpleLangParser.WhileStmtContext ctx) { return visitChildren(ctx); }
	@Override public T visitAssignStmt(SimpleLangParser.AssignStmtContext ctx) { return visitChildren(ctx); }
	@Override public T visitReturnStmt(SimpleLangParser.ReturnStmtContext ctx) { return visitChildren(ctx); }
	@Override public T visitInputStmt(SimpleLangParser.InputStmtContext ctx) { return visitChildren(ctx); }
	@Override public T visitOutputStmt(SimpleLangParser.OutputStmtContext ctx) { return visitChildren(ctx); }
	@Override public T visitLoc(SimpleLangParser.LocContext ctx) { return visitChildren(ctx); }
	@Override public T visitSimpleLoc(SimpleLangParser.SimpleLocContext ctx) { return visitChildren(ctx); }
	@Override public T visitMemberLoc(SimpleLangParser.MemberLocContext ctx) { return visitChildren(ctx); }
	@Override public T visitThisLoc(SimpleLangParser.ThisLocContext ctx) { return visitChildren(ctx); }
	@Override public T visitMethodcall(SimpleLangParser.MethodcallContext ctx) { return visitChildren(ctx); }
	@Override public T visitExpr(SimpleLangParser.ExprContext ctx) { return visitChildren(ctx); }
	@Override public T visitInitexpr(SimpleLangParser.InitexprContext ctx) { return visitChildren(ctx); }
}
