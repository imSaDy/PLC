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
}