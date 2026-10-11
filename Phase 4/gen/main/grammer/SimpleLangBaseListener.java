
    package main.grammar;
    import main.ast.core.*;
    import main.ast.types.*;
    import main.ast.declarations.*;
    import main.ast.declarations.Module;
    import main.ast.statements.*;
    import main.ast.expressions.*;
    import main.ast.expressions.literals.*;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings("CheckReturnValue")
public class SimpleLangBaseListener implements SimpleLangListener {
	@Override public void enterProgram(SimpleLangParser.ProgramContext ctx) { }
	@Override public void exitProgram(SimpleLangParser.ProgramContext ctx) { }
	@Override public void enterTopLevelDecl(SimpleLangParser.TopLevelDeclContext ctx) { }
	@Override public void exitTopLevelDecl(SimpleLangParser.TopLevelDeclContext ctx) { }
	@Override public void enterModule(SimpleLangParser.ModuleContext ctx) { }
	@Override public void exitModule(SimpleLangParser.ModuleContext ctx) { }
	@Override public void enterStructDef(SimpleLangParser.StructDefContext ctx) { }
	@Override public void exitStructDef(SimpleLangParser.StructDefContext ctx) { }
	@Override public void enterMember(SimpleLangParser.MemberContext ctx) { }
	@Override public void exitMember(SimpleLangParser.MemberContext ctx) { }
	@Override public void enterAccessModifier(SimpleLangParser.AccessModifierContext ctx) { }
	@Override public void exitAccessModifier(SimpleLangParser.AccessModifierContext ctx) { }
	@Override public void enterMethod_decl(SimpleLangParser.Method_declContext ctx) { }
	@Override public void exitMethod_decl(SimpleLangParser.Method_declContext ctx) { }
	@Override public void enterArguments(SimpleLangParser.ArgumentsContext ctx) { }
	@Override public void exitArguments(SimpleLangParser.ArgumentsContext ctx) { }
	@Override public void enterParameter(SimpleLangParser.ParameterContext ctx) { }
	@Override public void exitParameter(SimpleLangParser.ParameterContext ctx) { }
	@Override public void enterType(SimpleLangParser.TypeContext ctx) { }
	@Override public void exitType(SimpleLangParser.TypeContext ctx) { }
	@Override public void enterVardecl(SimpleLangParser.VardeclContext ctx) { }
	@Override public void exitVardecl(SimpleLangParser.VardeclContext ctx) { }
	@Override public void enterCons(SimpleLangParser.ConsContext ctx) { }
	@Override public void exitCons(SimpleLangParser.ConsContext ctx) { }
	@Override public void enterBlock(SimpleLangParser.BlockContext ctx) { }
	@Override public void exitBlock(SimpleLangParser.BlockContext ctx) { }
	@Override public void enterSt(SimpleLangParser.StContext ctx) { }
	@Override public void exitSt(SimpleLangParser.StContext ctx) { }
	@Override public void enterJumpStmt(SimpleLangParser.JumpStmtContext ctx) { }
	@Override public void exitJumpStmt(SimpleLangParser.JumpStmtContext ctx) { }
	@Override public void enterIfStmt(SimpleLangParser.IfStmtContext ctx) { }
	@Override public void exitIfStmt(SimpleLangParser.IfStmtContext ctx) { }
	@Override public void enterForStmt(SimpleLangParser.ForStmtContext ctx) { }
	@Override public void exitForStmt(SimpleLangParser.ForStmtContext ctx) { }
	@Override public void enterWhileStmt(SimpleLangParser.WhileStmtContext ctx) { }
	@Override public void exitWhileStmt(SimpleLangParser.WhileStmtContext ctx) { }
	@Override public void enterAssignStmt(SimpleLangParser.AssignStmtContext ctx) { }
	@Override public void exitAssignStmt(SimpleLangParser.AssignStmtContext ctx) { }
	@Override public void enterReturnStmt(SimpleLangParser.ReturnStmtContext ctx) { }
	@Override public void exitReturnStmt(SimpleLangParser.ReturnStmtContext ctx) { }
	@Override public void enterInputStmt(SimpleLangParser.InputStmtContext ctx) { }
	@Override public void exitInputStmt(SimpleLangParser.InputStmtContext ctx) { }
	@Override public void enterOutputStmt(SimpleLangParser.OutputStmtContext ctx) { }
	@Override public void exitOutputStmt(SimpleLangParser.OutputStmtContext ctx) { }
	@Override public void enterLoc(SimpleLangParser.LocContext ctx) { }
	@Override public void exitLoc(SimpleLangParser.LocContext ctx) { }
	@Override public void enterSimpleLoc(SimpleLangParser.SimpleLocContext ctx) { }
	@Override public void exitSimpleLoc(SimpleLangParser.SimpleLocContext ctx) { }
	@Override public void enterMemberLoc(SimpleLangParser.MemberLocContext ctx) { }
	@Override public void exitMemberLoc(SimpleLangParser.MemberLocContext ctx) { }
	@Override public void enterThisLoc(SimpleLangParser.ThisLocContext ctx) { }
	@Override public void exitThisLoc(SimpleLangParser.ThisLocContext ctx) { }
	@Override public void enterMethodcall(SimpleLangParser.MethodcallContext ctx) { }
	@Override public void exitMethodcall(SimpleLangParser.MethodcallContext ctx) { }
	@Override public void enterExpr(SimpleLangParser.ExprContext ctx) { }
	@Override public void exitExpr(SimpleLangParser.ExprContext ctx) { }
	@Override public void enterInitexpr(SimpleLangParser.InitexprContext ctx) { }
	@Override public void exitInitexpr(SimpleLangParser.InitexprContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}
