// Generated from /home/sadegh/Desktop/PLC/Phase 1/src/main/grammar/simpleLang.g4 by ANTLR 4.13.1

    package main.grammar;
    import main.ast.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link simpleLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface simpleLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(simpleLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#top_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTop_dec(simpleLangParser.Top_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#struct_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_dec(simpleLangParser.Struct_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#field_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_dec(simpleLangParser.Field_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#access}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccess(simpleLangParser.AccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(simpleLangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#module_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule_dec(simpleLangParser.Module_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#id_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId_list(simpleLangParser.Id_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#module_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule_body(simpleLangParser.Module_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#method_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_dec(simpleLangParser.Method_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(simpleLangParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(simpleLangParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(simpleLangParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(simpleLangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(simpleLangParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(simpleLangParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(simpleLangParser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#assign_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_part(simpleLangParser.Assign_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#cond_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_part(simpleLangParser.Cond_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#update_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_part(simpleLangParser.Update_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#return_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stmt(simpleLangParser.Return_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#output_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput_stmt(simpleLangParser.Output_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#break_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_stmt(simpleLangParser.Break_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#continue_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue_stmt(simpleLangParser.Continue_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#var_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_dec(simpleLangParser.Var_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(simpleLangParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link simpleLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(simpleLangParser.ExprContext ctx);
}