// Generated from /home/sadegh/Desktop/PLC/Phase 2/template/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.1

    import main.ast.core.*;

    import main.ast.declarations.*;
    import main.ast.declarations.Module;
    import main.ast.statements.*;


import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleLangParser}.
 */
public interface SimpleLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SimpleLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SimpleLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#topLevelDecl}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelDecl(SimpleLangParser.TopLevelDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#topLevelDecl}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelDecl(SimpleLangParser.TopLevelDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(SimpleLangParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(SimpleLangParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#structDef}.
	 * @param ctx the parse tree
	 */
	void enterStructDef(SimpleLangParser.StructDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#structDef}.
	 * @param ctx the parse tree
	 */
	void exitStructDef(SimpleLangParser.StructDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#member}.
	 * @param ctx the parse tree
	 */
	void enterMember(SimpleLangParser.MemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#member}.
	 * @param ctx the parse tree
	 */
	void exitMember(SimpleLangParser.MemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessModifier(SimpleLangParser.AccessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#accessModifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessModifier(SimpleLangParser.AccessModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#method_decl}.
	 * @param ctx the parse tree
	 */
	void enterMethod_decl(SimpleLangParser.Method_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#method_decl}.
	 * @param ctx the parse tree
	 */
	void exitMethod_decl(SimpleLangParser.Method_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(SimpleLangParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(SimpleLangParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(SimpleLangParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(SimpleLangParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SimpleLangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SimpleLangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void enterVardecl(SimpleLangParser.VardeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void exitVardecl(SimpleLangParser.VardeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#cons}.
	 * @param ctx the parse tree
	 */
	void enterCons(SimpleLangParser.ConsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#cons}.
	 * @param ctx the parse tree
	 */
	void exitCons(SimpleLangParser.ConsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimpleLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimpleLangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#st}.
	 * @param ctx the parse tree
	 */
	void enterSt(SimpleLangParser.StContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#st}.
	 * @param ctx the parse tree
	 */
	void exitSt(SimpleLangParser.StContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#jumpStmt}.
	 * @param ctx the parse tree
	 */
	void enterJumpStmt(SimpleLangParser.JumpStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#jumpStmt}.
	 * @param ctx the parse tree
	 */
	void exitJumpStmt(SimpleLangParser.JumpStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(SimpleLangParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(SimpleLangParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(SimpleLangParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(SimpleLangParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(SimpleLangParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(SimpleLangParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(SimpleLangParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(SimpleLangParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(SimpleLangParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(SimpleLangParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#inputStmt}.
	 * @param ctx the parse tree
	 */
	void enterInputStmt(SimpleLangParser.InputStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#inputStmt}.
	 * @param ctx the parse tree
	 */
	void exitInputStmt(SimpleLangParser.InputStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#outputStmt}.
	 * @param ctx the parse tree
	 */
	void enterOutputStmt(SimpleLangParser.OutputStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#outputStmt}.
	 * @param ctx the parse tree
	 */
	void exitOutputStmt(SimpleLangParser.OutputStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#loc}.
	 * @param ctx the parse tree
	 */
	void enterLoc(SimpleLangParser.LocContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#loc}.
	 * @param ctx the parse tree
	 */
	void exitLoc(SimpleLangParser.LocContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#simpleLoc}.
	 * @param ctx the parse tree
	 */
	void enterSimpleLoc(SimpleLangParser.SimpleLocContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#simpleLoc}.
	 * @param ctx the parse tree
	 */
	void exitSimpleLoc(SimpleLangParser.SimpleLocContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#memberLoc}.
	 * @param ctx the parse tree
	 */
	void enterMemberLoc(SimpleLangParser.MemberLocContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#memberLoc}.
	 * @param ctx the parse tree
	 */
	void exitMemberLoc(SimpleLangParser.MemberLocContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#thisLoc}.
	 * @param ctx the parse tree
	 */
	void enterThisLoc(SimpleLangParser.ThisLocContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#thisLoc}.
	 * @param ctx the parse tree
	 */
	void exitThisLoc(SimpleLangParser.ThisLocContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#methodcall}.
	 * @param ctx the parse tree
	 */
	void enterMethodcall(SimpleLangParser.MethodcallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#methodcall}.
	 * @param ctx the parse tree
	 */
	void exitMethodcall(SimpleLangParser.MethodcallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SimpleLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SimpleLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#initexpr}.
	 * @param ctx the parse tree
	 */
	void enterInitexpr(SimpleLangParser.InitexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#initexpr}.
	 * @param ctx the parse tree
	 */
	void exitInitexpr(SimpleLangParser.InitexprContext ctx);
}