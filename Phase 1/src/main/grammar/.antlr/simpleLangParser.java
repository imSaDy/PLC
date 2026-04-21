// Generated from /home/sadegh/Desktop/PLC/Phase 1/src/main/grammar/simpleLang.g4 by ANTLR 4.13.1

    package main.grammar;
    import main.ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class simpleLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MAIN=1, INT=2, BOOL=3, IF=4, ELSE=5, TRUE=6, FALSE=7, MODULE=8, BEGIN=9, 
		END=10, INCLUDES=11, STRUCT=12, PUBLIC=13, PRIVATE=14, MUT=15, VOID=16, 
		ELIF=17, WHILE=18, FOR=19, BREAK=20, CONTINUE=21, RETURN=22, THIS=23, 
		OUTPUT=24, FLOAT=25, DOUBLE=26, CHAR=27, LBRACE=28, RBRACE=29, SEMI=30, 
		ASSIGN=31, PLUS=32, LPAR=33, RPAR=34, MINUS=35, MULT=36, DIV=37, GT=38, 
		LT=39, GE=40, LE=41, EQ=42, NEQ=43, DOT=44, COMMA=45, MOD=46, ID=47, INT_VAL=48, 
		FLOAT_VAL=49, CHAR_VAL=50, WHITE_SPACE=51, LINE_COMMENT=52, BLOCK_COMMENT=53;
	public static final int
		RULE_program = 0, RULE_top_dec = 1, RULE_struct_dec = 2, RULE_field_dec = 3, 
		RULE_access = 4, RULE_type = 5, RULE_module_dec = 6, RULE_id_list = 7, 
		RULE_module_body = 8, RULE_method_dec = 9, RULE_parameters = 10, RULE_parameter = 11, 
		RULE_stmt = 12, RULE_assignment = 13, RULE_if_stmt = 14, RULE_while_stmt = 15, 
		RULE_for_stmt = 16, RULE_assign_part = 17, RULE_cond_part = 18, RULE_update_part = 19, 
		RULE_return_stmt = 20, RULE_output_stmt = 21, RULE_break_stmt = 22, RULE_continue_stmt = 23, 
		RULE_var_dec = 24, RULE_args = 25, RULE_expr = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "top_dec", "struct_dec", "field_dec", "access", "type", "module_dec", 
			"id_list", "module_body", "method_dec", "parameters", "parameter", "stmt", 
			"assignment", "if_stmt", "while_stmt", "for_stmt", "assign_part", "cond_part", 
			"update_part", "return_stmt", "output_stmt", "break_stmt", "continue_stmt", 
			"var_dec", "args", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'int'", "'bool'", "'if'", "'else'", "'true'", "'false'", 
			"'module'", "'begin'", "'end'", "'includes'", "'struct'", "'public'", 
			"'private'", "'mut'", "'void'", "'elif'", "'while'", "'for'", "'break'", 
			"'continue'", "'return'", "'this'", "'output'", "'float'", "'double'", 
			"'char'", "'{'", "'}'", "';'", "'='", "'+'", "'('", "')'", "'-'", "'*'", 
			"'/'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'.'", "','", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MAIN", "INT", "BOOL", "IF", "ELSE", "TRUE", "FALSE", "MODULE", 
			"BEGIN", "END", "INCLUDES", "STRUCT", "PUBLIC", "PRIVATE", "MUT", "VOID", 
			"ELIF", "WHILE", "FOR", "BREAK", "CONTINUE", "RETURN", "THIS", "OUTPUT", 
			"FLOAT", "DOUBLE", "CHAR", "LBRACE", "RBRACE", "SEMI", "ASSIGN", "PLUS", 
			"LPAR", "RPAR", "MINUS", "MULT", "DIV", "GT", "LT", "GE", "LE", "EQ", 
			"NEQ", "DOT", "COMMA", "MOD", "ID", "INT_VAL", "FLOAT_VAL", "CHAR_VAL", 
			"WHITE_SPACE", "LINE_COMMENT", "BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "simpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public simpleLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program programRet;
		public TerminalNode EOF() { return getToken(simpleLangParser.EOF, 0); }
		public List<Top_decContext> top_dec() {
			return getRuleContexts(Top_decContext.class);
		}
		public Top_decContext top_dec(int i) {
			return getRuleContext(Top_decContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(54);
				top_dec();
				}
				}
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MODULE || _la==STRUCT );
			setState(59);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Top_decContext extends ParserRuleContext {
		public Module_decContext module_dec() {
			return getRuleContext(Module_decContext.class,0);
		}
		public Struct_decContext struct_dec() {
			return getRuleContext(Struct_decContext.class,0);
		}
		public Top_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_top_dec; }
	}

	public final Top_decContext top_dec() throws RecognitionException {
		Top_decContext _localctx = new Top_decContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_top_dec);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MODULE:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				module_dec();
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				struct_dec();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_decContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(simpleLangParser.STRUCT, 0); }
		public TerminalNode ID() { return getToken(simpleLangParser.ID, 0); }
		public TerminalNode BEGIN() { return getToken(simpleLangParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(simpleLangParser.END, 0); }
		public List<Field_decContext> field_dec() {
			return getRuleContexts(Field_decContext.class);
		}
		public Field_decContext field_dec(int i) {
			return getRuleContext(Field_decContext.class,i);
		}
		public Struct_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_dec; }
	}

	public final Struct_decContext struct_dec() throws RecognitionException {
		Struct_decContext _localctx = new Struct_decContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_struct_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(STRUCT);
			setState(66);
			match(ID);
			setState(67);
			match(BEGIN);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 140737723293708L) != 0)) {
				{
				{
				setState(68);
				field_dec();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_decContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(simpleLangParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(simpleLangParser.SEMI, 0); }
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
		}
		public TerminalNode MUT() { return getToken(simpleLangParser.MUT, 0); }
		public Field_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_dec; }
	}

	public final Field_decContext field_dec() throws RecognitionException {
		Field_decContext _localctx = new Field_decContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_field_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUBLIC || _la==PRIVATE) {
				{
				setState(76);
				access();
				}
			}

			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT) {
				{
				setState(79);
				match(MUT);
				}
			}

			setState(82);
			type();
			setState(83);
			match(ID);
			setState(84);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccessContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(simpleLangParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(simpleLangParser.PRIVATE, 0); }
		public AccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access; }
	}

	public final AccessContext access() throws RecognitionException {
		AccessContext _localctx = new AccessContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_access);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_la = _input.LA(1);
			if ( !(_la==PUBLIC || _la==PRIVATE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(simpleLangParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(simpleLangParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(simpleLangParser.DOUBLE, 0); }
		public TerminalNode CHAR() { return getToken(simpleLangParser.CHAR, 0); }
		public TerminalNode BOOL() { return getToken(simpleLangParser.BOOL, 0); }
		public TerminalNode ID() { return getToken(simpleLangParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 140737723236364L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Module_decContext extends ParserRuleContext {
		public TerminalNode MODULE() { return getToken(simpleLangParser.MODULE, 0); }
		public TerminalNode ID() { return getToken(simpleLangParser.ID, 0); }
		public TerminalNode BEGIN() { return getToken(simpleLangParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(simpleLangParser.END, 0); }
		public TerminalNode INCLUDES() { return getToken(simpleLangParser.INCLUDES, 0); }
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public List<Module_bodyContext> module_body() {
			return getRuleContexts(Module_bodyContext.class);
		}
		public Module_bodyContext module_body(int i) {
			return getRuleContext(Module_bodyContext.class,i);
		}
		public Module_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_dec; }
	}

	public final Module_decContext module_dec() throws RecognitionException {
		Module_decContext _localctx = new Module_decContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_module_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(MODULE);
			setState(91);
			match(ID);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INCLUDES) {
				{
				setState(92);
				match(INCLUDES);
				setState(93);
				id_list();
				}
			}

			setState(96);
			match(BEGIN);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 140737723359244L) != 0)) {
				{
				{
				setState(97);
				module_body();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Id_listContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(simpleLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(simpleLangParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(simpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(simpleLangParser.COMMA, i);
		}
		public Id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_list; }
	}

	public final Id_listContext id_list() throws RecognitionException {
		Id_listContext _localctx = new Id_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(ID);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(106);
				match(COMMA);
				setState(107);
				match(ID);
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Module_bodyContext extends ParserRuleContext {
		public Field_decContext field_dec() {
			return getRuleContext(Field_decContext.class,0);
		}
		public Method_decContext method_dec() {
			return getRuleContext(Method_decContext.class,0);
		}
		public Module_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_body; }
	}

	public final Module_bodyContext module_body() throws RecognitionException {
		Module_bodyContext _localctx = new Module_bodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_module_body);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				field_dec();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				method_dec();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Method_decContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(simpleLangParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(simpleLangParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(simpleLangParser.RPAR, 0); }
		public TerminalNode BEGIN() { return getToken(simpleLangParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(simpleLangParser.END, 0); }
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
		}
		public TerminalNode VOID() { return getToken(simpleLangParser.VOID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Method_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_dec; }
	}

	public final Method_decContext method_dec() throws RecognitionException {
		Method_decContext _localctx = new Method_decContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_method_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUBLIC || _la==PRIVATE) {
				{
				setState(117);
				access();
				}
			}

			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(120);
				match(VOID);
				}
				break;
			case 2:
				{
				setState(121);
				type();
				}
				break;
			}
			setState(124);
			match(ID);
			setState(125);
			match(LPAR);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 140737723269132L) != 0)) {
				{
				setState(126);
				parameters();
				}
			}

			setState(129);
			match(RPAR);
			setState(130);
			match(BEGIN);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2111071183470812L) != 0)) {
				{
				{
				setState(131);
				stmt();
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(137);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(simpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(simpleLangParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			parameter();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(140);
				match(COMMA);
				setState(141);
				parameter();
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(simpleLangParser.ID, 0); }
		public TerminalNode MUT() { return getToken(simpleLangParser.MUT, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT) {
				{
				setState(147);
				match(MUT);
				}
			}

			setState(150);
			type();
			setState(151);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(simpleLangParser.SEMI, 0); }
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Output_stmtContext output_stmt() {
			return getRuleContext(Output_stmtContext.class,0);
		}
		public Break_stmtContext break_stmt() {
			return getRuleContext(Break_stmtContext.class,0);
		}
		public Continue_stmtContext continue_stmt() {
			return getRuleContext(Continue_stmtContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Var_decContext var_dec() {
			return getRuleContext(Var_decContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stmt);
		try {
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				assignment();
				setState(154);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				if_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				while_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(158);
				for_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(159);
				return_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(160);
				output_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(161);
				break_stmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(162);
				continue_stmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(163);
				expr(0);
				setState(164);
				match(SEMI);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(166);
				var_dec();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(simpleLangParser.ASSIGN, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			expr(0);
			setState(170);
			match(ASSIGN);
			setState(171);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(simpleLangParser.IF, 0); }
		public List<TerminalNode> LPAR() { return getTokens(simpleLangParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(simpleLangParser.LPAR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RPAR() { return getTokens(simpleLangParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(simpleLangParser.RPAR, i);
		}
		public List<TerminalNode> BEGIN() { return getTokens(simpleLangParser.BEGIN); }
		public TerminalNode BEGIN(int i) {
			return getToken(simpleLangParser.BEGIN, i);
		}
		public List<TerminalNode> END() { return getTokens(simpleLangParser.END); }
		public TerminalNode END(int i) {
			return getToken(simpleLangParser.END, i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(simpleLangParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(simpleLangParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(simpleLangParser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(IF);
			setState(174);
			match(LPAR);
			setState(175);
			expr(0);
			setState(176);
			match(RPAR);
			setState(177);
			match(BEGIN);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2111071183470812L) != 0)) {
				{
				{
				setState(178);
				stmt();
				}
				}
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(184);
			match(END);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(185);
				match(ELIF);
				setState(186);
				match(LPAR);
				setState(187);
				expr(0);
				setState(188);
				match(RPAR);
				setState(189);
				match(BEGIN);
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2111071183470812L) != 0)) {
					{
					{
					setState(190);
					stmt();
					}
					}
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(196);
				match(END);
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(203);
				match(ELSE);
				setState(204);
				match(BEGIN);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2111071183470812L) != 0)) {
					{
					{
					setState(205);
					stmt();
					}
					}
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(211);
				match(END);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(simpleLangParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(simpleLangParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(simpleLangParser.RPAR, 0); }
		public TerminalNode BEGIN() { return getToken(simpleLangParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(simpleLangParser.END, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_while_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(WHILE);
			setState(215);
			match(LPAR);
			setState(216);
			expr(0);
			setState(217);
			match(RPAR);
			setState(218);
			match(BEGIN);
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2111071183470812L) != 0)) {
				{
				{
				setState(219);
				stmt();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(225);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(simpleLangParser.FOR, 0); }
		public TerminalNode LPAR() { return getToken(simpleLangParser.LPAR, 0); }
		public List<TerminalNode> SEMI() { return getTokens(simpleLangParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(simpleLangParser.SEMI, i);
		}
		public TerminalNode RPAR() { return getToken(simpleLangParser.RPAR, 0); }
		public TerminalNode BEGIN() { return getToken(simpleLangParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(simpleLangParser.END, 0); }
		public Assign_partContext assign_part() {
			return getRuleContext(Assign_partContext.class,0);
		}
		public Cond_partContext cond_part() {
			return getRuleContext(Cond_partContext.class,0);
		}
		public Update_partContext update_part() {
			return getRuleContext(Update_partContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(FOR);
			setState(228);
			match(LPAR);
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2111070923653312L) != 0)) {
				{
				setState(229);
				assign_part();
				}
			}

			setState(232);
			match(SEMI);
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2111070923653312L) != 0)) {
				{
				setState(233);
				cond_part();
				}
			}

			setState(236);
			match(SEMI);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2111070923653312L) != 0)) {
				{
				setState(237);
				update_part();
				}
			}

			setState(240);
			match(RPAR);
			setState(241);
			match(BEGIN);
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2111071183470812L) != 0)) {
				{
				{
				setState(242);
				stmt();
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(248);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Assign_partContext extends ParserRuleContext {
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(simpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(simpleLangParser.COMMA, i);
		}
		public Assign_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_part; }
	}

	public final Assign_partContext assign_part() throws RecognitionException {
		Assign_partContext _localctx = new Assign_partContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_assign_part);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			assignment();
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(251);
				match(COMMA);
				setState(252);
				assignment();
				}
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cond_partContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(simpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(simpleLangParser.COMMA, i);
		}
		public Cond_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_part; }
	}

	public final Cond_partContext cond_part() throws RecognitionException {
		Cond_partContext _localctx = new Cond_partContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_cond_part);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			expr(0);
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(259);
				match(COMMA);
				setState(260);
				expr(0);
				}
				}
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Update_partContext extends ParserRuleContext {
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(simpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(simpleLangParser.COMMA, i);
		}
		public Update_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_part; }
	}

	public final Update_partContext update_part() throws RecognitionException {
		Update_partContext _localctx = new Update_partContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_update_part);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			assignment();
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(267);
				match(COMMA);
				setState(268);
				assignment();
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(simpleLangParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(simpleLangParser.SEMI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_return_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(RETURN);
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2111070923653312L) != 0)) {
				{
				setState(275);
				expr(0);
				}
			}

			setState(278);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Output_stmtContext extends ParserRuleContext {
		public TerminalNode OUTPUT() { return getToken(simpleLangParser.OUTPUT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(simpleLangParser.SEMI, 0); }
		public Output_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output_stmt; }
	}

	public final Output_stmtContext output_stmt() throws RecognitionException {
		Output_stmtContext _localctx = new Output_stmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_output_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(OUTPUT);
			setState(281);
			expr(0);
			setState(282);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Break_stmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(simpleLangParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(simpleLangParser.SEMI, 0); }
		public Break_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_stmt; }
	}

	public final Break_stmtContext break_stmt() throws RecognitionException {
		Break_stmtContext _localctx = new Break_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_break_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(BREAK);
			setState(285);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Continue_stmtContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(simpleLangParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(simpleLangParser.SEMI, 0); }
		public Continue_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continue_stmt; }
	}

	public final Continue_stmtContext continue_stmt() throws RecognitionException {
		Continue_stmtContext _localctx = new Continue_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_continue_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(CONTINUE);
			setState(288);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_decContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(simpleLangParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(simpleLangParser.SEMI, 0); }
		public TerminalNode MUT() { return getToken(simpleLangParser.MUT, 0); }
		public TerminalNode LPAR() { return getToken(simpleLangParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(simpleLangParser.RPAR, 0); }
		public TerminalNode ASSIGN() { return getToken(simpleLangParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public Var_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_dec; }
	}

	public final Var_decContext var_dec() throws RecognitionException {
		Var_decContext _localctx = new Var_decContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_var_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT) {
				{
				setState(290);
				match(MUT);
				}
			}

			setState(293);
			type();
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(294);
				match(LPAR);
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2111070923653312L) != 0)) {
					{
					setState(295);
					args();
					}
				}

				setState(298);
				match(RPAR);
				}
			}

			setState(301);
			match(ID);
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(302);
				match(ASSIGN);
				setState(303);
				expr(0);
				}
			}

			setState(306);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(simpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(simpleLangParser.COMMA, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			expr(0);
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(309);
				match(COMMA);
				setState(310);
				expr(0);
				}
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(simpleLangParser.LPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(simpleLangParser.RPAR, 0); }
		public TerminalNode THIS() { return getToken(simpleLangParser.THIS, 0); }
		public TerminalNode INT_VAL() { return getToken(simpleLangParser.INT_VAL, 0); }
		public TerminalNode FLOAT_VAL() { return getToken(simpleLangParser.FLOAT_VAL, 0); }
		public TerminalNode CHAR_VAL() { return getToken(simpleLangParser.CHAR_VAL, 0); }
		public TerminalNode TRUE() { return getToken(simpleLangParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(simpleLangParser.FALSE, 0); }
		public TerminalNode ID() { return getToken(simpleLangParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode MULT() { return getToken(simpleLangParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(simpleLangParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(simpleLangParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(simpleLangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(simpleLangParser.MINUS, 0); }
		public TerminalNode GT() { return getToken(simpleLangParser.GT, 0); }
		public TerminalNode LT() { return getToken(simpleLangParser.LT, 0); }
		public TerminalNode GE() { return getToken(simpleLangParser.GE, 0); }
		public TerminalNode LE() { return getToken(simpleLangParser.LE, 0); }
		public TerminalNode EQ() { return getToken(simpleLangParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(simpleLangParser.NEQ, 0); }
		public TerminalNode DOT() { return getToken(simpleLangParser.DOT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(317);
				match(LPAR);
				setState(318);
				expr(0);
				setState(319);
				match(RPAR);
				}
				break;
			case 2:
				{
				setState(321);
				match(THIS);
				}
				break;
			case 3:
				{
				setState(322);
				match(INT_VAL);
				}
				break;
			case 4:
				{
				setState(323);
				match(FLOAT_VAL);
				}
				break;
			case 5:
				{
				setState(324);
				match(CHAR_VAL);
				}
				break;
			case 6:
				{
				setState(325);
				match(TRUE);
				}
				break;
			case 7:
				{
				setState(326);
				match(FALSE);
				}
				break;
			case 8:
				{
				setState(327);
				match(ID);
				}
				break;
			case 9:
				{
				setState(328);
				match(ID);
				setState(329);
				match(LPAR);
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2111070923653312L) != 0)) {
					{
					setState(330);
					args();
					}
				}

				setState(333);
				match(RPAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(360);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(358);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(336);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(337);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 70574902607872L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(338);
						expr(5);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(339);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(340);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(341);
						expr(4);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(342);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(343);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4123168604160L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(344);
						expr(3);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(345);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(346);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(347);
						expr(2);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(348);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(349);
						match(DOT);
						setState(350);
						match(ID);
						setState(356);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
						case 1:
							{
							setState(351);
							match(LPAR);
							setState(353);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2111070923653312L) != 0)) {
								{
								setState(352);
								args();
								}
							}

							setState(355);
							match(RPAR);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(362);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 26:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		case 4:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00015\u016c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0004\u0000"+
		"8\b\u0000\u000b\u0000\f\u00009\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0003\u0001@\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002F\b\u0002\n\u0002\f\u0002I\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0003\u0003N\b\u0003\u0001\u0003\u0003\u0003Q\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006_\b\u0006\u0001\u0006\u0001\u0006\u0005\u0006c\b\u0006\n\u0006"+
		"\f\u0006f\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007m\b\u0007\n\u0007\f\u0007p\t\u0007\u0001\b\u0001\b\u0003"+
		"\bt\b\b\u0001\t\u0003\tw\b\t\u0001\t\u0001\t\u0003\t{\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u0080\b\t\u0001\t\u0001\t\u0001\t\u0005\t\u0085\b\t"+
		"\n\t\f\t\u0088\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0005\n\u008f"+
		"\b\n\n\n\f\n\u0092\t\n\u0001\u000b\u0003\u000b\u0095\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00a8\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00b4\b\u000e\n"+
		"\u000e\f\u000e\u00b7\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00c0\b\u000e\n"+
		"\u000e\f\u000e\u00c3\t\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00c7"+
		"\b\u000e\n\u000e\f\u000e\u00ca\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u00cf\b\u000e\n\u000e\f\u000e\u00d2\t\u000e\u0001\u000e\u0003"+
		"\u000e\u00d5\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u00dd\b\u000f\n\u000f\f\u000f\u00e0\t\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u00e7\b\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00eb\b\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u00ef\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010\u00f4\b\u0010\n\u0010\f\u0010\u00f7\t\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00fe\b\u0011"+
		"\n\u0011\f\u0011\u0101\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005"+
		"\u0012\u0106\b\u0012\n\u0012\f\u0012\u0109\t\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u010e\b\u0013\n\u0013\f\u0013\u0111\t\u0013\u0001"+
		"\u0014\u0001\u0014\u0003\u0014\u0115\b\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0003\u0018\u0124"+
		"\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0129\b\u0018"+
		"\u0001\u0018\u0003\u0018\u012c\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u0131\b\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u0138\b\u0019\n\u0019\f\u0019\u013b\t\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u014c\b\u001a\u0001\u001a\u0003"+
		"\u001a\u014f\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0003\u001a\u0162\b\u001a\u0001\u001a\u0003\u001a\u0165\b\u001a"+
		"\u0005\u001a\u0167\b\u001a\n\u001a\f\u001a\u016a\t\u001a\u0001\u001a\u0000"+
		"\u00014\u001b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.024\u0000\u0006\u0001\u0000\r\u000e\u0003"+
		"\u0000\u0002\u0003\u0019\u001b//\u0002\u0000$%..\u0002\u0000  ##\u0001"+
		"\u0000&)\u0001\u0000*+\u018c\u00007\u0001\u0000\u0000\u0000\u0002?\u0001"+
		"\u0000\u0000\u0000\u0004A\u0001\u0000\u0000\u0000\u0006M\u0001\u0000\u0000"+
		"\u0000\bV\u0001\u0000\u0000\u0000\nX\u0001\u0000\u0000\u0000\fZ\u0001"+
		"\u0000\u0000\u0000\u000ei\u0001\u0000\u0000\u0000\u0010s\u0001\u0000\u0000"+
		"\u0000\u0012v\u0001\u0000\u0000\u0000\u0014\u008b\u0001\u0000\u0000\u0000"+
		"\u0016\u0094\u0001\u0000\u0000\u0000\u0018\u00a7\u0001\u0000\u0000\u0000"+
		"\u001a\u00a9\u0001\u0000\u0000\u0000\u001c\u00ad\u0001\u0000\u0000\u0000"+
		"\u001e\u00d6\u0001\u0000\u0000\u0000 \u00e3\u0001\u0000\u0000\u0000\""+
		"\u00fa\u0001\u0000\u0000\u0000$\u0102\u0001\u0000\u0000\u0000&\u010a\u0001"+
		"\u0000\u0000\u0000(\u0112\u0001\u0000\u0000\u0000*\u0118\u0001\u0000\u0000"+
		"\u0000,\u011c\u0001\u0000\u0000\u0000.\u011f\u0001\u0000\u0000\u00000"+
		"\u0123\u0001\u0000\u0000\u00002\u0134\u0001\u0000\u0000\u00004\u014e\u0001"+
		"\u0000\u0000\u000068\u0003\u0002\u0001\u000076\u0001\u0000\u0000\u0000"+
		"89\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000"+
		"\u0000:;\u0001\u0000\u0000\u0000;<\u0005\u0000\u0000\u0001<\u0001\u0001"+
		"\u0000\u0000\u0000=@\u0003\f\u0006\u0000>@\u0003\u0004\u0002\u0000?=\u0001"+
		"\u0000\u0000\u0000?>\u0001\u0000\u0000\u0000@\u0003\u0001\u0000\u0000"+
		"\u0000AB\u0005\f\u0000\u0000BC\u0005/\u0000\u0000CG\u0005\t\u0000\u0000"+
		"DF\u0003\u0006\u0003\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000"+
		"\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0001\u0000"+
		"\u0000\u0000IG\u0001\u0000\u0000\u0000JK\u0005\n\u0000\u0000K\u0005\u0001"+
		"\u0000\u0000\u0000LN\u0003\b\u0004\u0000ML\u0001\u0000\u0000\u0000MN\u0001"+
		"\u0000\u0000\u0000NP\u0001\u0000\u0000\u0000OQ\u0005\u000f\u0000\u0000"+
		"PO\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000"+
		"\u0000RS\u0003\n\u0005\u0000ST\u0005/\u0000\u0000TU\u0005\u001e\u0000"+
		"\u0000U\u0007\u0001\u0000\u0000\u0000VW\u0007\u0000\u0000\u0000W\t\u0001"+
		"\u0000\u0000\u0000XY\u0007\u0001\u0000\u0000Y\u000b\u0001\u0000\u0000"+
		"\u0000Z[\u0005\b\u0000\u0000[^\u0005/\u0000\u0000\\]\u0005\u000b\u0000"+
		"\u0000]_\u0003\u000e\u0007\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000"+
		"\u0000\u0000_`\u0001\u0000\u0000\u0000`d\u0005\t\u0000\u0000ac\u0003\u0010"+
		"\b\u0000ba\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000\u0000db\u0001\u0000"+
		"\u0000\u0000de\u0001\u0000\u0000\u0000eg\u0001\u0000\u0000\u0000fd\u0001"+
		"\u0000\u0000\u0000gh\u0005\n\u0000\u0000h\r\u0001\u0000\u0000\u0000in"+
		"\u0005/\u0000\u0000jk\u0005-\u0000\u0000km\u0005/\u0000\u0000lj\u0001"+
		"\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000"+
		"no\u0001\u0000\u0000\u0000o\u000f\u0001\u0000\u0000\u0000pn\u0001\u0000"+
		"\u0000\u0000qt\u0003\u0006\u0003\u0000rt\u0003\u0012\t\u0000sq\u0001\u0000"+
		"\u0000\u0000sr\u0001\u0000\u0000\u0000t\u0011\u0001\u0000\u0000\u0000"+
		"uw\u0003\b\u0004\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wz\u0001\u0000\u0000\u0000x{\u0005\u0010\u0000\u0000y{\u0003\n\u0005\u0000"+
		"zx\u0001\u0000\u0000\u0000zy\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{|\u0001\u0000\u0000\u0000|}\u0005/\u0000\u0000}\u007f\u0005!\u0000"+
		"\u0000~\u0080\u0003\u0014\n\u0000\u007f~\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0005\"\u0000\u0000\u0082\u0086\u0005\t\u0000\u0000\u0083\u0085"+
		"\u0003\u0018\f\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0088\u0001"+
		"\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001"+
		"\u0000\u0000\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088\u0086\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0005\n\u0000\u0000\u008a\u0013\u0001\u0000"+
		"\u0000\u0000\u008b\u0090\u0003\u0016\u000b\u0000\u008c\u008d\u0005-\u0000"+
		"\u0000\u008d\u008f\u0003\u0016\u000b\u0000\u008e\u008c\u0001\u0000\u0000"+
		"\u0000\u008f\u0092\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0015\u0001\u0000\u0000"+
		"\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0095\u0005\u000f\u0000"+
		"\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0097\u0003\n\u0005\u0000"+
		"\u0097\u0098\u0005/\u0000\u0000\u0098\u0017\u0001\u0000\u0000\u0000\u0099"+
		"\u009a\u0003\u001a\r\u0000\u009a\u009b\u0005\u001e\u0000\u0000\u009b\u00a8"+
		"\u0001\u0000\u0000\u0000\u009c\u00a8\u0003\u001c\u000e\u0000\u009d\u00a8"+
		"\u0003\u001e\u000f\u0000\u009e\u00a8\u0003 \u0010\u0000\u009f\u00a8\u0003"+
		"(\u0014\u0000\u00a0\u00a8\u0003*\u0015\u0000\u00a1\u00a8\u0003,\u0016"+
		"\u0000\u00a2\u00a8\u0003.\u0017\u0000\u00a3\u00a4\u00034\u001a\u0000\u00a4"+
		"\u00a5\u0005\u001e\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a8\u00030\u0018\u0000\u00a7\u0099\u0001\u0000\u0000\u0000\u00a7\u009c"+
		"\u0001\u0000\u0000\u0000\u00a7\u009d\u0001\u0000\u0000\u0000\u00a7\u009e"+
		"\u0001\u0000\u0000\u0000\u00a7\u009f\u0001\u0000\u0000\u0000\u00a7\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a1\u0001\u0000\u0000\u0000\u00a7\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a3\u0001\u0000\u0000\u0000\u00a7\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a8\u0019\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u00034\u001a\u0000\u00aa\u00ab\u0005\u001f\u0000\u0000\u00ab\u00ac\u0003"+
		"4\u001a\u0000\u00ac\u001b\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0004"+
		"\u0000\u0000\u00ae\u00af\u0005!\u0000\u0000\u00af\u00b0\u00034\u001a\u0000"+
		"\u00b0\u00b1\u0005\"\u0000\u0000\u00b1\u00b5\u0005\t\u0000\u0000\u00b2"+
		"\u00b4\u0003\u0018\f\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000\u00b7\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b8\u00c8\u0005\n\u0000\u0000\u00b9\u00ba\u0005"+
		"\u0011\u0000\u0000\u00ba\u00bb\u0005!\u0000\u0000\u00bb\u00bc\u00034\u001a"+
		"\u0000\u00bc\u00bd\u0005\"\u0000\u0000\u00bd\u00c1\u0005\t\u0000\u0000"+
		"\u00be\u00c0\u0003\u0018\f\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c4\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\n\u0000\u0000\u00c5\u00c7"+
		"\u0001\u0000\u0000\u0000\u00c6\u00b9\u0001\u0000\u0000\u0000\u00c7\u00ca"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9"+
		"\u0001\u0000\u0000\u0000\u00c9\u00d4\u0001\u0000\u0000\u0000\u00ca\u00c8"+
		"\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\u0005\u0000\u0000\u00cc\u00d0"+
		"\u0005\t\u0000\u0000\u00cd\u00cf\u0003\u0018\f\u0000\u00ce\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d2\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d5\u0005"+
		"\n\u0000\u0000\u00d4\u00cb\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d5\u001d\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005\u0012"+
		"\u0000\u0000\u00d7\u00d8\u0005!\u0000\u0000\u00d8\u00d9\u00034\u001a\u0000"+
		"\u00d9\u00da\u0005\"\u0000\u0000\u00da\u00de\u0005\t\u0000\u0000\u00db"+
		"\u00dd\u0003\u0018\f\u0000\u00dc\u00db\u0001\u0000\u0000\u0000\u00dd\u00e0"+
		"\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00df"+
		"\u0001\u0000\u0000\u0000\u00df\u00e1\u0001\u0000\u0000\u0000\u00e0\u00de"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005\n\u0000\u0000\u00e2\u001f\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e4\u0005\u0013\u0000\u0000\u00e4\u00e6\u0005"+
		"!\u0000\u0000\u00e5\u00e7\u0003\"\u0011\u0000\u00e6\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000"+
		"\u0000\u0000\u00e8\u00ea\u0005\u001e\u0000\u0000\u00e9\u00eb\u0003$\u0012"+
		"\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ee\u0005\u001e\u0000"+
		"\u0000\u00ed\u00ef\u0003&\u0013\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000"+
		"\u00f0\u00f1\u0005\"\u0000\u0000\u00f1\u00f5\u0005\t\u0000\u0000\u00f2"+
		"\u00f4\u0003\u0018\f\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f7"+
		"\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f6"+
		"\u0001\u0000\u0000\u0000\u00f6\u00f8\u0001\u0000\u0000\u0000\u00f7\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005\n\u0000\u0000\u00f9!\u0001"+
		"\u0000\u0000\u0000\u00fa\u00ff\u0003\u001a\r\u0000\u00fb\u00fc\u0005-"+
		"\u0000\u0000\u00fc\u00fe\u0003\u001a\r\u0000\u00fd\u00fb\u0001\u0000\u0000"+
		"\u0000\u00fe\u0101\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000"+
		"\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100#\u0001\u0000\u0000\u0000"+
		"\u0101\u00ff\u0001\u0000\u0000\u0000\u0102\u0107\u00034\u001a\u0000\u0103"+
		"\u0104\u0005-\u0000\u0000\u0104\u0106\u00034\u001a\u0000\u0105\u0103\u0001"+
		"\u0000\u0000\u0000\u0106\u0109\u0001\u0000\u0000\u0000\u0107\u0105\u0001"+
		"\u0000\u0000\u0000\u0107\u0108\u0001\u0000\u0000\u0000\u0108%\u0001\u0000"+
		"\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u010a\u010f\u0003\u001a"+
		"\r\u0000\u010b\u010c\u0005-\u0000\u0000\u010c\u010e\u0003\u001a\r\u0000"+
		"\u010d\u010b\u0001\u0000\u0000\u0000\u010e\u0111\u0001\u0000\u0000\u0000"+
		"\u010f\u010d\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000"+
		"\u0110\'\u0001\u0000\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0112"+
		"\u0114\u0005\u0016\u0000\u0000\u0113\u0115\u00034\u001a\u0000\u0114\u0113"+
		"\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0116"+
		"\u0001\u0000\u0000\u0000\u0116\u0117\u0005\u001e\u0000\u0000\u0117)\u0001"+
		"\u0000\u0000\u0000\u0118\u0119\u0005\u0018\u0000\u0000\u0119\u011a\u0003"+
		"4\u001a\u0000\u011a\u011b\u0005\u001e\u0000\u0000\u011b+\u0001\u0000\u0000"+
		"\u0000\u011c\u011d\u0005\u0014\u0000\u0000\u011d\u011e\u0005\u001e\u0000"+
		"\u0000\u011e-\u0001\u0000\u0000\u0000\u011f\u0120\u0005\u0015\u0000\u0000"+
		"\u0120\u0121\u0005\u001e\u0000\u0000\u0121/\u0001\u0000\u0000\u0000\u0122"+
		"\u0124\u0005\u000f\u0000\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0123"+
		"\u0124\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u0125"+
		"\u012b\u0003\n\u0005\u0000\u0126\u0128\u0005!\u0000\u0000\u0127\u0129"+
		"\u00032\u0019\u0000\u0128\u0127\u0001\u0000\u0000\u0000\u0128\u0129\u0001"+
		"\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u012c\u0005"+
		"\"\u0000\u0000\u012b\u0126\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000"+
		"\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u0130\u0005/\u0000"+
		"\u0000\u012e\u012f\u0005\u001f\u0000\u0000\u012f\u0131\u00034\u001a\u0000"+
		"\u0130\u012e\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000"+
		"\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0133\u0005\u001e\u0000\u0000"+
		"\u01331\u0001\u0000\u0000\u0000\u0134\u0139\u00034\u001a\u0000\u0135\u0136"+
		"\u0005-\u0000\u0000\u0136\u0138\u00034\u001a\u0000\u0137\u0135\u0001\u0000"+
		"\u0000\u0000\u0138\u013b\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000"+
		"\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a3\u0001\u0000\u0000"+
		"\u0000\u013b\u0139\u0001\u0000\u0000\u0000\u013c\u013d\u0006\u001a\uffff"+
		"\uffff\u0000\u013d\u013e\u0005!\u0000\u0000\u013e\u013f\u00034\u001a\u0000"+
		"\u013f\u0140\u0005\"\u0000\u0000\u0140\u014f\u0001\u0000\u0000\u0000\u0141"+
		"\u014f\u0005\u0017\u0000\u0000\u0142\u014f\u00050\u0000\u0000\u0143\u014f"+
		"\u00051\u0000\u0000\u0144\u014f\u00052\u0000\u0000\u0145\u014f\u0005\u0006"+
		"\u0000\u0000\u0146\u014f\u0005\u0007\u0000\u0000\u0147\u014f\u0005/\u0000"+
		"\u0000\u0148\u0149\u0005/\u0000\u0000\u0149\u014b\u0005!\u0000\u0000\u014a"+
		"\u014c\u00032\u0019\u0000\u014b\u014a\u0001\u0000\u0000\u0000\u014b\u014c"+
		"\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014d\u014f"+
		"\u0005\"\u0000\u0000\u014e\u013c\u0001\u0000\u0000\u0000\u014e\u0141\u0001"+
		"\u0000\u0000\u0000\u014e\u0142\u0001\u0000\u0000\u0000\u014e\u0143\u0001"+
		"\u0000\u0000\u0000\u014e\u0144\u0001\u0000\u0000\u0000\u014e\u0145\u0001"+
		"\u0000\u0000\u0000\u014e\u0146\u0001\u0000\u0000\u0000\u014e\u0147\u0001"+
		"\u0000\u0000\u0000\u014e\u0148\u0001\u0000\u0000\u0000\u014f\u0168\u0001"+
		"\u0000\u0000\u0000\u0150\u0151\n\u0004\u0000\u0000\u0151\u0152\u0007\u0002"+
		"\u0000\u0000\u0152\u0167\u00034\u001a\u0005\u0153\u0154\n\u0003\u0000"+
		"\u0000\u0154\u0155\u0007\u0003\u0000\u0000\u0155\u0167\u00034\u001a\u0004"+
		"\u0156\u0157\n\u0002\u0000\u0000\u0157\u0158\u0007\u0004\u0000\u0000\u0158"+
		"\u0167\u00034\u001a\u0003\u0159\u015a\n\u0001\u0000\u0000\u015a\u015b"+
		"\u0007\u0005\u0000\u0000\u015b\u0167\u00034\u001a\u0002\u015c\u015d\n"+
		"\u0006\u0000\u0000\u015d\u015e\u0005,\u0000\u0000\u015e\u0164\u0005/\u0000"+
		"\u0000\u015f\u0161\u0005!\u0000\u0000\u0160\u0162\u00032\u0019\u0000\u0161"+
		"\u0160\u0001\u0000\u0000\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162"+
		"\u0163\u0001\u0000\u0000\u0000\u0163\u0165\u0005\"\u0000\u0000\u0164\u015f"+
		"\u0001\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u0167"+
		"\u0001\u0000\u0000\u0000\u0166\u0150\u0001\u0000\u0000\u0000\u0166\u0153"+
		"\u0001\u0000\u0000\u0000\u0166\u0156\u0001\u0000\u0000\u0000\u0166\u0159"+
		"\u0001\u0000\u0000\u0000\u0166\u015c\u0001\u0000\u0000\u0000\u0167\u016a"+
		"\u0001\u0000\u0000\u0000\u0168\u0166\u0001\u0000\u0000\u0000\u0168\u0169"+
		"\u0001\u0000\u0000\u0000\u01695\u0001\u0000\u0000\u0000\u016a\u0168\u0001"+
		"\u0000\u0000\u0000)9?GMP^dnsvz\u007f\u0086\u0090\u0094\u00a7\u00b5\u00c1"+
		"\u00c8\u00d0\u00d4\u00de\u00e6\u00ea\u00ee\u00f5\u00ff\u0107\u010f\u0114"+
		"\u0123\u0128\u012b\u0130\u0139\u014b\u014e\u0161\u0164\u0166\u0168";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}