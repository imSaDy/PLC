// Generated from C:/Users/ASUS/Desktop/Phase 3/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.1

    package main.grammar;
    import main.ast.core.*;
    import main.ast.types.*;
    import main.ast.declarations.*;
    import main.ast.declarations.Module;
    import main.ast.statements.*;
    import main.ast.expressions.*;
    import main.ast.expressions.literals.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SimpleLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#topLevelDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelDecl(SimpleLangParser.TopLevelDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(SimpleLangParser.ModuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#structDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDef(SimpleLangParser.StructDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember(SimpleLangParser.MemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#accessModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessModifier(SimpleLangParser.AccessModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#method_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_decl(SimpleLangParser.Method_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(SimpleLangParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(SimpleLangParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SimpleLangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#vardecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardecl(SimpleLangParser.VardeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#cons}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCons(SimpleLangParser.ConsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#st}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSt(SimpleLangParser.StContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#jumpStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStmt(SimpleLangParser.JumpStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(SimpleLangParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(SimpleLangParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(SimpleLangParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(SimpleLangParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(SimpleLangParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#inputStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputStmt(SimpleLangParser.InputStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#outputStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputStmt(SimpleLangParser.OutputStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#loc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoc(SimpleLangParser.LocContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#simpleLoc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleLoc(SimpleLangParser.SimpleLocContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#memberLoc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberLoc(SimpleLangParser.MemberLocContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#thisLoc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisLoc(SimpleLangParser.ThisLocContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#methodcall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodcall(SimpleLangParser.MethodcallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SimpleLangParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#initexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitexpr(SimpleLangParser.InitexprContext ctx);
}