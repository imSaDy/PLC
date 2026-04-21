// Generated from /home/sadegh/Desktop/PLC/Phase 1/src/main/grammar/simpleLang.g4 by ANTLR 4.13.1

    package main.grammar;
    import main.ast.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link simpleLangParser}.
 */
public interface simpleLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(simpleLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(simpleLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#top_dec}.
	 * @param ctx the parse tree
	 */
	void enterTop_dec(simpleLangParser.Top_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#top_dec}.
	 * @param ctx the parse tree
	 */
	void exitTop_dec(simpleLangParser.Top_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#struct_dec}.
	 * @param ctx the parse tree
	 */
	void enterStruct_dec(simpleLangParser.Struct_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#struct_dec}.
	 * @param ctx the parse tree
	 */
	void exitStruct_dec(simpleLangParser.Struct_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#field_dec}.
	 * @param ctx the parse tree
	 */
	void enterField_dec(simpleLangParser.Field_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#field_dec}.
	 * @param ctx the parse tree
	 */
	void exitField_dec(simpleLangParser.Field_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#access}.
	 * @param ctx the parse tree
	 */
	void enterAccess(simpleLangParser.AccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#access}.
	 * @param ctx the parse tree
	 */
	void exitAccess(simpleLangParser.AccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(simpleLangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(simpleLangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#module_dec}.
	 * @param ctx the parse tree
	 */
	void enterModule_dec(simpleLangParser.Module_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#module_dec}.
	 * @param ctx the parse tree
	 */
	void exitModule_dec(simpleLangParser.Module_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(simpleLangParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(simpleLangParser.Id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#module_body}.
	 * @param ctx the parse tree
	 */
	void enterModule_body(simpleLangParser.Module_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#module_body}.
	 * @param ctx the parse tree
	 */
	void exitModule_body(simpleLangParser.Module_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#method_dec}.
	 * @param ctx the parse tree
	 */
	void enterMethod_dec(simpleLangParser.Method_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#method_dec}.
	 * @param ctx the parse tree
	 */
	void exitMethod_dec(simpleLangParser.Method_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(simpleLangParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(simpleLangParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(simpleLangParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(simpleLangParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(simpleLangParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(simpleLangParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(simpleLangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(simpleLangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(simpleLangParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(simpleLangParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(simpleLangParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(simpleLangParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(simpleLangParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(simpleLangParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#assign_part}.
	 * @param ctx the parse tree
	 */
	void enterAssign_part(simpleLangParser.Assign_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#assign_part}.
	 * @param ctx the parse tree
	 */
	void exitAssign_part(simpleLangParser.Assign_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#cond_part}.
	 * @param ctx the parse tree
	 */
	void enterCond_part(simpleLangParser.Cond_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#cond_part}.
	 * @param ctx the parse tree
	 */
	void exitCond_part(simpleLangParser.Cond_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#update_part}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_part(simpleLangParser.Update_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#update_part}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_part(simpleLangParser.Update_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(simpleLangParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(simpleLangParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#output_stmt}.
	 * @param ctx the parse tree
	 */
	void enterOutput_stmt(simpleLangParser.Output_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#output_stmt}.
	 * @param ctx the parse tree
	 */
	void exitOutput_stmt(simpleLangParser.Output_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBreak_stmt(simpleLangParser.Break_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#break_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBreak_stmt(simpleLangParser.Break_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#continue_stmt}.
	 * @param ctx the parse tree
	 */
	void enterContinue_stmt(simpleLangParser.Continue_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#continue_stmt}.
	 * @param ctx the parse tree
	 */
	void exitContinue_stmt(simpleLangParser.Continue_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#var_dec}.
	 * @param ctx the parse tree
	 */
	void enterVar_dec(simpleLangParser.Var_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#var_dec}.
	 * @param ctx the parse tree
	 */
	void exitVar_dec(simpleLangParser.Var_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(simpleLangParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(simpleLangParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(simpleLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(simpleLangParser.ExprContext ctx);
}