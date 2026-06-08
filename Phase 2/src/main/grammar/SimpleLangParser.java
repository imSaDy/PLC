// Generated from /home/sadegh/Desktop/PLC/Phase 2/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.1

    package main.grammar;
    
    import main.ast.core.*;
    import main.ast.declarations.*;
    import main.ast.declarations.Module;
    import main.ast.statements.*;
    
    import main.ast.types.*;
    import main.ast.expressions.*;
    import main.ast.expressions.literals.*;
    import java.util.ArrayList;
    import java.util.List;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimpleLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KW_MODULE=1, KW_STRUCT=2, KW_INCLUDES=3, KW_BEGIN=4, KW_END=5, KW_PUBLIC=6, 
		KW_PRIVATE=7, KW_INT=8, KW_FLOAT=9, KW_DOUBLE=10, KW_CHAR=11, KW_VOID=12, 
		KW_IF=13, KW_ELSE=14, KW_FOR=15, KW_WHILE=16, KW_DO=17, KW_RETURN=18, 
		KW_INPUT=19, KW_OUTPUT=20, KW_THIS=21, KW_NOT=22, KW_AND=23, KW_OR=24, 
		KW_MUT=25, KW_BREAK=26, KW_CONTINUE=27, KW_BOOL=28, CONSTBOOL=29, SEMI=30, 
		COMMA=31, LPAREN=32, RPAREN=33, LBRACK=34, RBRACK=35, ASSIGN=36, DOT=37, 
		ARROW=38, MINUS=39, PLUS=40, STAR=41, SLASH=42, AMPERSAND=43, LESS=44, 
		GREATER=45, LESS_EQ=46, GREATER_EQ=47, EQUAL=48, NOT_EQUAL=49, CONSTINT=50, 
		CONSTFLOAT=51, CONSTDOUBLE=52, CONSTCHAR=53, ID=54, WS=55, COMMENT=56, 
		MULTICOMMENT=57;
	public static final int
		RULE_program = 0, RULE_topLevelDecl = 1, RULE_module = 2, RULE_structDef = 3, 
		RULE_member = 4, RULE_accessModifier = 5, RULE_method_decl = 6, RULE_arguments = 7, 
		RULE_parameter = 8, RULE_type = 9, RULE_vardecl = 10, RULE_cons = 11, 
		RULE_block = 12, RULE_st = 13, RULE_jumpStmt = 14, RULE_ifStmt = 15, RULE_forStmt = 16, 
		RULE_whileStmt = 17, RULE_assignStmt = 18, RULE_returnStmt = 19, RULE_inputStmt = 20, 
		RULE_outputStmt = 21, RULE_loc = 22, RULE_simpleLoc = 23, RULE_memberLoc = 24, 
		RULE_thisLoc = 25, RULE_methodcall = 26, RULE_expr = 27, RULE_initexpr = 28, 
		RULE_updateExpr = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "topLevelDecl", "module", "structDef", "member", "accessModifier", 
			"method_decl", "arguments", "parameter", "type", "vardecl", "cons", "block", 
			"st", "jumpStmt", "ifStmt", "forStmt", "whileStmt", "assignStmt", "returnStmt", 
			"inputStmt", "outputStmt", "loc", "simpleLoc", "memberLoc", "thisLoc", 
			"methodcall", "expr", "initexpr", "updateExpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'module'", "'struct'", "'includes'", "'begin'", "'end'", "'public'", 
			"'private'", "'int'", "'float'", "'double'", "'char'", "'void'", "'if'", 
			"'else'", "'for'", "'while'", "'do'", "'return'", "'input'", "'output'", 
			"'this'", "'not'", "'and'", "'or'", "'mut'", "'break'", "'continue'", 
			"'bool'", null, "';'", "','", "'('", "')'", "'['", "']'", "'='", "'.'", 
			"'->'", "'-'", "'+'", "'*'", "'/'", "'&'", "'<'", "'>'", "'<='", "'>='", 
			"'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KW_MODULE", "KW_STRUCT", "KW_INCLUDES", "KW_BEGIN", "KW_END", 
			"KW_PUBLIC", "KW_PRIVATE", "KW_INT", "KW_FLOAT", "KW_DOUBLE", "KW_CHAR", 
			"KW_VOID", "KW_IF", "KW_ELSE", "KW_FOR", "KW_WHILE", "KW_DO", "KW_RETURN", 
			"KW_INPUT", "KW_OUTPUT", "KW_THIS", "KW_NOT", "KW_AND", "KW_OR", "KW_MUT", 
			"KW_BREAK", "KW_CONTINUE", "KW_BOOL", "CONSTBOOL", "SEMI", "COMMA", "LPAREN", 
			"RPAREN", "LBRACK", "RBRACK", "ASSIGN", "DOT", "ARROW", "MINUS", "PLUS", 
			"STAR", "SLASH", "AMPERSAND", "LESS", "GREATER", "LESS_EQ", "GREATER_EQ", 
			"EQUAL", "NOT_EQUAL", "CONSTINT", "CONSTFLOAT", "CONSTDOUBLE", "CONSTCHAR", 
			"ID", "WS", "COMMENT", "MULTICOMMENT"
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
	public String getGrammarFileName() { return "SimpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program programRet;
		public TopLevelDeclContext t;
		public TerminalNode EOF() { return getToken(SimpleLangParser.EOF, 0); }
		public List<TopLevelDeclContext> topLevelDecl() {
			return getRuleContexts(TopLevelDeclContext.class);
		}
		public TopLevelDeclContext topLevelDecl(int i) {
			return getRuleContext(TopLevelDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ProgramContext)_localctx).programRet =  new Program(); 
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_MODULE || _la==KW_STRUCT) {
				{
				{
				setState(61);
				((ProgramContext)_localctx).t = topLevelDecl();
				 _localctx.programRet.addTopLevelDeclaration(((ProgramContext)_localctx).t.topLevelDeclRet); 
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
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
	public static class TopLevelDeclContext extends ParserRuleContext {
		public TopLevelDecl topLevelDeclRet;
		public ModuleContext m;
		public StructDefContext s;
		public ModuleContext module() {
			return getRuleContext(ModuleContext.class,0);
		}
		public StructDefContext structDef() {
			return getRuleContext(StructDefContext.class,0);
		}
		public TopLevelDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevelDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterTopLevelDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitTopLevelDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTopLevelDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopLevelDeclContext topLevelDecl() throws RecognitionException {
		TopLevelDeclContext _localctx = new TopLevelDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevelDecl);
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_MODULE:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				((TopLevelDeclContext)_localctx).m = module();
				 ((TopLevelDeclContext)_localctx).topLevelDeclRet = ((TopLevelDeclContext)_localctx).m.moduleRet;

				        
				}
				break;
			case KW_STRUCT:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				((TopLevelDeclContext)_localctx).s = structDef();
				 ((TopLevelDeclContext)_localctx).topLevelDeclRet =  ((TopLevelDeclContext)_localctx).s.structRet;
				    
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
	public static class ModuleContext extends ParserRuleContext {
		public Module moduleRet;
		public Token k;
		public Token i;
		public Token i1;
		public Token i2;
		public TerminalNode KW_BEGIN() { return getToken(SimpleLangParser.KW_BEGIN, 0); }
		public TerminalNode KW_END() { return getToken(SimpleLangParser.KW_END, 0); }
		public TerminalNode KW_MODULE() { return getToken(SimpleLangParser.KW_MODULE, 0); }
		public List<TerminalNode> ID() { return getTokens(SimpleLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleLangParser.ID, i);
		}
		public TerminalNode KW_INCLUDES() { return getToken(SimpleLangParser.KW_INCLUDES, 0); }
		public List<MemberContext> member() {
			return getRuleContexts(MemberContext.class);
		}
		public MemberContext member(int i) {
			return getRuleContext(MemberContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitModule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitModule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			((ModuleContext)_localctx).k = match(KW_MODULE);
			setState(80);
			((ModuleContext)_localctx).i = match(ID);
			 ((ModuleContext)_localctx).moduleRet =  new Module(new Identifier((((ModuleContext)_localctx).i!=null?((ModuleContext)_localctx).i.getText():null)));
			        _localctx.moduleRet.setLine((((ModuleContext)_localctx).i!=null?((ModuleContext)_localctx).i.getLine():0)); 
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_INCLUDES) {
				{
				setState(82);
				match(KW_INCLUDES);
				setState(83);
				((ModuleContext)_localctx).i1 = match(ID);
				 _localctx.moduleRet.addInclude(new Identifier((((ModuleContext)_localctx).i1!=null?((ModuleContext)_localctx).i1.getText():null))); 
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(85);
					match(COMMA);
					setState(86);
					((ModuleContext)_localctx).i2 = match(ID);
					 _localctx.moduleRet.addInclude(new Identifier((((ModuleContext)_localctx).i2!=null?((ModuleContext)_localctx).i2.getText():null))); 
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(95);
			match(KW_BEGIN);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811480000L) != 0)) {
				{
				{
				setState(96);
				member();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(KW_END);
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
	public static class StructDefContext extends ParserRuleContext {
		public Struct structRet;
		public Token k;
		public Token i;
		public TerminalNode KW_BEGIN() { return getToken(SimpleLangParser.KW_BEGIN, 0); }
		public TerminalNode KW_END() { return getToken(SimpleLangParser.KW_END, 0); }
		public TerminalNode KW_STRUCT() { return getToken(SimpleLangParser.KW_STRUCT, 0); }
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public List<MemberContext> member() {
			return getRuleContexts(MemberContext.class);
		}
		public MemberContext member(int i) {
			return getRuleContext(MemberContext.class,i);
		}
		public StructDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterStructDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitStructDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitStructDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDefContext structDef() throws RecognitionException {
		StructDefContext _localctx = new StructDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			((StructDefContext)_localctx).k = match(KW_STRUCT);
			setState(105);
			((StructDefContext)_localctx).i = match(ID);
			setState(106);
			match(KW_BEGIN);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811480000L) != 0)) {
				{
				{
				setState(107);
				member();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			match(KW_END);
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
	public static class MemberContext extends ParserRuleContext {
		public Method_declContext m;
		public VardeclContext v;
		public Method_declContext method_decl() {
			return getRuleContext(Method_declContext.class,0);
		}
		public AccessModifierContext accessModifier() {
			return getRuleContext(AccessModifierContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public MemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberContext member() throws RecognitionException {
		MemberContext _localctx = new MemberContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_member);
		int _la;
		try {
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_PUBLIC || _la==KW_PRIVATE) {
					{
					setState(115);
					accessModifier();
					}
				}

				setState(118);
				((MemberContext)_localctx).m = method_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_PUBLIC || _la==KW_PRIVATE) {
					{
					setState(119);
					accessModifier();
					}
				}

				setState(122);
				((MemberContext)_localctx).v = vardecl();
				setState(123);
				match(SEMI);
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
	public static class AccessModifierContext extends ParserRuleContext {
		public AccessModifier accessModifierRet;
		public Token pr;
		public Token pu;
		public TerminalNode KW_PRIVATE() { return getToken(SimpleLangParser.KW_PRIVATE, 0); }
		public TerminalNode KW_PUBLIC() { return getToken(SimpleLangParser.KW_PUBLIC, 0); }
		public AccessModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAccessModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAccessModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAccessModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessModifierContext accessModifier() throws RecognitionException {
		AccessModifierContext _localctx = new AccessModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_accessModifier);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_PRIVATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				((AccessModifierContext)_localctx).pr = match(KW_PRIVATE);
				 ((AccessModifierContext)_localctx).accessModifierRet =  AccessModifier.PRIVATE; 
				}
				break;
			case KW_PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				((AccessModifierContext)_localctx).pu = match(KW_PUBLIC);
				 ((AccessModifierContext)_localctx).accessModifierRet =  AccessModifier.PUBLIC; 
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
	public static class Method_declContext extends ParserRuleContext {
		public Method methodRet;
		public TypeContext t;
		public Token i;
		public ArgumentsContext a;
		public BlockContext b;
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Method_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterMethod_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitMethod_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMethod_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_declContext method_decl() throws RecognitionException {
		Method_declContext _localctx = new Method_declContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_method_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			((Method_declContext)_localctx).t = type();
			setState(134);
			((Method_declContext)_localctx).i = match(ID);
			setState(135);
			match(LPAREN);
			setState(136);
			((Method_declContext)_localctx).a = arguments();
			setState(137);
			match(RPAREN);
			setState(138);
			((Method_declContext)_localctx).b = block();
			 ((Method_declContext)_localctx).methodRet =  new Method(((Method_declContext)_localctx).t.typeRet, new Identifier((((Method_declContext)_localctx).i!=null?((Method_declContext)_localctx).i.getText():null)), ((Method_declContext)_localctx).a.parametersRet, ((Method_declContext)_localctx).b.blockRet); 
			 _localctx.methodRet.setLine((((Method_declContext)_localctx).i!=null?((Method_declContext)_localctx).i.getLine():0)); 
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
	public static class ArgumentsContext extends ParserRuleContext {
		public List<Parameter> parametersRet;
		public ParameterContext p1;
		public ParameterContext p2;
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ArgumentsContext)_localctx).parametersRet =  new ArrayList<>(); 
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811479808L) != 0)) {
				{
				setState(143);
				((ArgumentsContext)_localctx).p1 = parameter();
				 _localctx.parametersRet.add(((ArgumentsContext)_localctx).p1.parameterRet); 
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(145);
					match(COMMA);
					setState(146);
					((ArgumentsContext)_localctx).p2 = parameter();
					 _localctx.parametersRet.add(((ArgumentsContext)_localctx).p2.parameterRet); 
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
	public static class ParameterContext extends ParserRuleContext {
		public Parameter parameterRet;
		public TypeContext t;
		public Token i;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode KW_MUT() { return getToken(SimpleLangParser.KW_MUT, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 boolean isMut = false; 
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_MUT) {
				{
				setState(157);
				match(KW_MUT);
				 isMut = true; 
				}
			}

			setState(161);
			((ParameterContext)_localctx).t = type();
			setState(162);
			((ParameterContext)_localctx).i = match(ID);
			 ((ParameterContext)_localctx).parameterRet =  new Parameter(isMut, ((ParameterContext)_localctx).t.typeRet, new Identifier((((ParameterContext)_localctx).i!=null?((ParameterContext)_localctx).i.getText():null))); 
			 _localctx.parameterRet.setLine((((ParameterContext)_localctx).i!=null?((ParameterContext)_localctx).i.getLine():0)); 
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
		public Type typeRet;
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode KW_INT() { return getToken(SimpleLangParser.KW_INT, 0); }
		public TerminalNode KW_FLOAT() { return getToken(SimpleLangParser.KW_FLOAT, 0); }
		public TerminalNode KW_DOUBLE() { return getToken(SimpleLangParser.KW_DOUBLE, 0); }
		public TerminalNode KW_CHAR() { return getToken(SimpleLangParser.KW_CHAR, 0); }
		public TerminalNode KW_VOID() { return getToken(SimpleLangParser.KW_VOID, 0); }
		public TerminalNode KW_BOOL() { return getToken(SimpleLangParser.KW_BOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398777925376L) != 0)) ) {
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
	public static class VardeclContext extends ParserRuleContext {
		public Var varRet;
		public TypeContext t;
		public ConsContext c;
		public Token i;
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode KW_MUT() { return getToken(SimpleLangParser.KW_MUT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ConsContext cons() {
			return getRuleContext(ConsContext.class,0);
		}
		public VardeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterVardecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitVardecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitVardecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_vardecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 boolean isMut = false; 
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_MUT) {
				{
				setState(169);
				match(KW_MUT);
				 isMut = true; 
				}
			}

			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(173);
				((VardeclContext)_localctx).t = type();
				 ((VardeclContext)_localctx).varRet =  new Var(isMut, ((VardeclContext)_localctx).t.typeRet); 
				}
				break;
			case 2:
				{
				setState(176);
				((VardeclContext)_localctx).c = cons();
				 ((VardeclContext)_localctx).varRet =  new Var(isMut, ((VardeclContext)_localctx).c.constructorCallRet); 
				}
				break;
			}
			setState(181);
			((VardeclContext)_localctx).i = match(ID);
			 _localctx.varRet.setName(new Identifier((((VardeclContext)_localctx).i!=null?((VardeclContext)_localctx).i.getText():null))); 
			 _localctx.varRet.setLine((((VardeclContext)_localctx).i!=null?((VardeclContext)_localctx).i.getLine():0)); 
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
	public static class ConsContext extends ParserRuleContext {
		public ConstructorCall constructorCallRet;
		public Token i;
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public ConsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cons; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCons(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCons(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCons(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConsContext cons() throws RecognitionException {
		ConsContext _localctx = new ConsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cons);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			((ConsContext)_localctx).i = match(ID);
			 ((ConsContext)_localctx).constructorCallRet =  new ConstructorCall(new Identifier((((ConsContext)_localctx).i!=null?((ConsContext)_localctx).i.getText():null))); 
			setState(187);
			match(LPAREN);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(188);
				((ConsContext)_localctx).e1 = expr(0);
				 _localctx.constructorCallRet.addArgument(((ConsContext)_localctx).e1.expressionRet); 
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(190);
					match(COMMA);
					setState(191);
					((ConsContext)_localctx).e2 = expr(0);
					 _localctx.constructorCallRet.addArgument(((ConsContext)_localctx).e2.expressionRet); 
					}
					}
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(201);
			match(RPAREN);
			 _localctx.constructorCallRet.setLine((((ConsContext)_localctx).i!=null?((ConsContext)_localctx).i.getLine():0)); 
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
	public static class BlockContext extends ParserRuleContext {
		public Block blockRet;
		public Token k;
		public StContext s;
		public TerminalNode KW_END() { return getToken(SimpleLangParser.KW_END, 0); }
		public TerminalNode KW_BEGIN() { return getToken(SimpleLangParser.KW_BEGIN, 0); }
		public List<StContext> st() {
			return getRuleContexts(StContext.class);
		}
		public StContext st(int i) {
			return getRuleContext(StContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((BlockContext)_localctx).blockRet =  new Block(); 
			setState(205);
			((BlockContext)_localctx).k = match(KW_BEGIN);
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014399016845072L) != 0)) {
				{
				{
				setState(206);
				((BlockContext)_localctx).s = st();
				 _localctx.blockRet.addStatement(((BlockContext)_localctx).s.statementRet); 
				}
				}
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(214);
			match(KW_END);
			 _localctx.blockRet.setLine((((BlockContext)_localctx).k!=null?((BlockContext)_localctx).k.getLine():0)); 
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
	public static class StContext extends ParserRuleContext {
		public Statement statementRet;
		public BlockContext b;
		public VardeclContext vd;
		public VardeclContext v;
		public ExprContext e;
		public MethodcallContext mc;
		public IfStmtContext ifs;
		public ForStmtContext fs;
		public WhileStmtContext ws;
		public AssignStmtContext as;
		public ReturnStmtContext rs;
		public InputStmtContext is;
		public OutputStmtContext os;
		public JumpStmtContext js;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SimpleLangParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MethodcallContext methodcall() {
			return getRuleContext(MethodcallContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public InputStmtContext inputStmt() {
			return getRuleContext(InputStmtContext.class,0);
		}
		public OutputStmtContext outputStmt() {
			return getRuleContext(OutputStmtContext.class,0);
		}
		public JumpStmtContext jumpStmt() {
			return getRuleContext(JumpStmtContext.class,0);
		}
		public StContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_st; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StContext st() throws RecognitionException {
		StContext _localctx = new StContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_st);
		try {
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				((StContext)_localctx).b = block();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).b.blockRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).b.blockRet.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				((StContext)_localctx).vd = vardecl();
				 ((StContext)_localctx).statementRet =  new VarDeclStmt(((StContext)_localctx).vd.varRet); 
				setState(223);
				match(SEMI);
				 _localctx.statementRet.setLine(((StContext)_localctx).vd.varRet.getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				((StContext)_localctx).v = vardecl();
				 ((StContext)_localctx).statementRet =  new VarDeclStmt(((StContext)_localctx).v.varRet); 
				setState(228);
				match(ASSIGN);
				setState(229);
				((StContext)_localctx).e = expr(0);
				 ((VarDeclStmt)_localctx.statementRet).setInitial(((StContext)_localctx).e.expressionRet); 
				setState(231);
				match(SEMI);
				 _localctx.statementRet.setLine(((StContext)_localctx).e.expressionRet.getLine()); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(234);
				((StContext)_localctx).mc = methodcall();
				 ((StContext)_localctx).statementRet =  new MethodCallStmt(((StContext)_localctx).mc.methodCallRet); 
				setState(236);
				match(SEMI);
				 _localctx.statementRet.setLine(((StContext)_localctx).mc.methodCallRet.getLine()); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(239);
				((StContext)_localctx).ifs = ifStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).ifs.ifStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).ifs.ifStmtRet.getLine()); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(243);
				((StContext)_localctx).fs = forStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(244);
				((StContext)_localctx).ws = whileStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(245);
				((StContext)_localctx).as = assignStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).as.assignStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).as.assignStmtRet.getLine()); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(249);
				((StContext)_localctx).rs = returnStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).rs.returnStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).rs.returnStmtRet.getLine()); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(253);
				((StContext)_localctx).is = inputStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).is.inputStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).is.inputStmtRet.getLine()); 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(257);
				((StContext)_localctx).os = outputStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).os.outputStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).os.outputStmtRet.getLine()); 
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(261);
				((StContext)_localctx).js = jumpStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).js.jumpStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).js.jumpStmtRet.getLine()); 
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
	public static class JumpStmtContext extends ParserRuleContext {
		public JumpStmt jumpStmtRet;
		public Token kb;
		public Token kc;
		public TerminalNode KW_BREAK() { return getToken(SimpleLangParser.KW_BREAK, 0); }
		public TerminalNode KW_CONTINUE() { return getToken(SimpleLangParser.KW_CONTINUE, 0); }
		public JumpStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterJumpStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitJumpStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitJumpStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStmtContext jumpStmt() throws RecognitionException {
		JumpStmtContext _localctx = new JumpStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_jumpStmt);
		try {
			setState(273);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_BREAK:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				((JumpStmtContext)_localctx).kb = match(KW_BREAK);
				 ((JumpStmtContext)_localctx).jumpStmtRet =  new BreakJump(); 
				 _localctx.jumpStmtRet.setLine((((JumpStmtContext)_localctx).kb!=null?((JumpStmtContext)_localctx).kb.getLine():0)); 
				}
				break;
			case KW_CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				((JumpStmtContext)_localctx).kc = match(KW_CONTINUE);
				 ((JumpStmtContext)_localctx).jumpStmtRet =  new ContinueJump(); 
				 _localctx.jumpStmtRet.setLine((((JumpStmtContext)_localctx).kc!=null?((JumpStmtContext)_localctx).kc.getLine():0)); 
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
	public static class IfStmtContext extends ParserRuleContext {
		public IfStmt ifStmtRet;
		public Token k;
		public ExprContext e;
		public StContext s1;
		public StContext s2;
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public TerminalNode KW_IF() { return getToken(SimpleLangParser.KW_IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StContext> st() {
			return getRuleContexts(StContext.class);
		}
		public StContext st(int i) {
			return getRuleContext(StContext.class,i);
		}
		public TerminalNode KW_ELSE() { return getToken(SimpleLangParser.KW_ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			((IfStmtContext)_localctx).k = match(KW_IF);
			setState(276);
			match(LPAREN);
			setState(277);
			((IfStmtContext)_localctx).e = expr(0);
			setState(278);
			match(RPAREN);
			setState(279);
			((IfStmtContext)_localctx).s1 = st();
			 ((IfStmtContext)_localctx).ifStmtRet =  new IfStmt(((IfStmtContext)_localctx).e.expressionRet, ((IfStmtContext)_localctx).s1.statementRet); 
			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(281);
				match(KW_ELSE);
				setState(282);
				((IfStmtContext)_localctx).s2 = st();
				 _localctx.ifStmtRet.setElseBranch(((IfStmtContext)_localctx).s2.statementRet); 
				}
				break;
			}
			 _localctx.ifStmtRet.setLine((((IfStmtContext)_localctx).k!=null?((IfStmtContext)_localctx).k.getLine():0)); 
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
	public static class ForStmtContext extends ParserRuleContext {
		public ForStmt forStmtRet;
		public Token k;
		public InitexprContext i1;
		public InitexprContext i2;
		public ExprContext c;
		public UpdateExprContext u1;
		public UpdateExprContext u2;
		public StContext b;
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(SimpleLangParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(SimpleLangParser.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public TerminalNode KW_FOR() { return getToken(SimpleLangParser.KW_FOR, 0); }
		public StContext st() {
			return getRuleContext(StContext.class,0);
		}
		public List<InitexprContext> initexpr() {
			return getRuleContexts(InitexprContext.class);
		}
		public InitexprContext initexpr(int i) {
			return getRuleContext(InitexprContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<UpdateExprContext> updateExpr() {
			return getRuleContexts(UpdateExprContext.class);
		}
		public UpdateExprContext updateExpr(int i) {
			return getRuleContext(UpdateExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			((ForStmtContext)_localctx).k = match(KW_FOR);

			            ((ForStmtContext)_localctx).forStmtRet =  new ForStmt();
			            _localctx.forStmtRet.setLine((((ForStmtContext)_localctx).k!=null?((ForStmtContext)_localctx).k.getLine():0));
			        
			setState(291);
			match(LPAREN);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398813576960L) != 0)) {
				{
				setState(292);
				((ForStmtContext)_localctx).i1 = initexpr();
				 _localctx.forStmtRet.addInitializer(((ForStmtContext)_localctx).i1.initExprRet); 
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(294);
					match(COMMA);
					setState(295);
					((ForStmtContext)_localctx).i2 = initexpr();
					 _localctx.forStmtRet.addInitializer(((ForStmtContext)_localctx).i2.initExprRet); 
					}
					}
					setState(302);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(305);
			match(SEMI);
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(306);
				((ForStmtContext)_localctx).c = expr(0);
				 _localctx.forStmtRet.setCondition(((ForStmtContext)_localctx).c.expressionRet); 
				}
			}

			setState(311);
			match(SEMI);
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_THIS || _la==ID) {
				{
				setState(312);
				((ForStmtContext)_localctx).u1 = updateExpr();
				 _localctx.forStmtRet.addUpdater(((ForStmtContext)_localctx).u1.updateExprRet); 
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(314);
					match(COMMA);
					setState(315);
					((ForStmtContext)_localctx).u2 = updateExpr();
					 _localctx.forStmtRet.addUpdater(((ForStmtContext)_localctx).u2.updateExprRet); 
					}
					}
					setState(322);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(325);
			match(RPAREN);
			setState(326);
			((ForStmtContext)_localctx).b = st();
			 _localctx.forStmtRet.setBody(((ForStmtContext)_localctx).b.statementRet); 
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
	public static class WhileStmtContext extends ParserRuleContext {
		public WhileStmt whileStmtRet;
		public Token k;
		public ExprContext e;
		public StContext s;
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public TerminalNode KW_WHILE() { return getToken(SimpleLangParser.KW_WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StContext st() {
			return getRuleContext(StContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			((WhileStmtContext)_localctx).k = match(KW_WHILE);
			setState(330);
			match(LPAREN);
			setState(331);
			((WhileStmtContext)_localctx).e = expr(0);
			setState(332);
			match(RPAREN);
			setState(333);
			((WhileStmtContext)_localctx).s = st();

			            ((WhileStmtContext)_localctx).whileStmtRet =  new WhileStmt(((WhileStmtContext)_localctx).e.expressionRet, ((WhileStmtContext)_localctx).s.statementRet);
			            _localctx.whileStmtRet.setLine((((WhileStmtContext)_localctx).k!=null?((WhileStmtContext)_localctx).k.getLine():0));
			        
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
	public static class AssignStmtContext extends ParserRuleContext {
		public AssignStmt assignStmtRet;
		public LocContext l;
		public Token a;
		public ExprContext e;
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SimpleLangParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAssignStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			((AssignStmtContext)_localctx).l = loc();
			setState(337);
			((AssignStmtContext)_localctx).a = match(ASSIGN);
			setState(338);
			((AssignStmtContext)_localctx).e = expr(0);
			 ((AssignStmtContext)_localctx).assignStmtRet =  new AssignStmt(((AssignStmtContext)_localctx).l.locationRet, ((AssignStmtContext)_localctx).e.expressionRet); 
			setState(340);
			match(SEMI);
			 _localctx.assignStmtRet.setLine((((AssignStmtContext)_localctx).a!=null?((AssignStmtContext)_localctx).a.getLine():0)); 
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
	public static class ReturnStmtContext extends ParserRuleContext {
		public ReturnStmt returnStmtRet;
		public Token k;
		public ExprContext e;
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public TerminalNode KW_RETURN() { return getToken(SimpleLangParser.KW_RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ReturnStmtContext)_localctx).returnStmtRet =  new ReturnStmt(); 
			setState(344);
			((ReturnStmtContext)_localctx).k = match(KW_RETURN);
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(345);
				((ReturnStmtContext)_localctx).e = expr(0);
				 _localctx.returnStmtRet.setValue(((ReturnStmtContext)_localctx).e.expressionRet); 
				}
			}

			setState(350);
			match(SEMI);
			 _localctx.returnStmtRet.setLine((((ReturnStmtContext)_localctx).k!=null?((ReturnStmtContext)_localctx).k.getLine():0)); 
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
	public static class InputStmtContext extends ParserRuleContext {
		public InputStmt inputStmtRet;
		public Token k;
		public LocContext l;
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public TerminalNode KW_INPUT() { return getToken(SimpleLangParser.KW_INPUT, 0); }
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public InputStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInputStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInputStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInputStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputStmtContext inputStmt() throws RecognitionException {
		InputStmtContext _localctx = new InputStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_inputStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			((InputStmtContext)_localctx).k = match(KW_INPUT);
			setState(354);
			((InputStmtContext)_localctx).l = loc();
			 ((InputStmtContext)_localctx).inputStmtRet =  new InputStmt(((InputStmtContext)_localctx).l.locationRet); 
			setState(356);
			match(SEMI);
			 _localctx.inputStmtRet.setLine((((InputStmtContext)_localctx).k!=null?((InputStmtContext)_localctx).k.getLine():0)); 
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
	public static class OutputStmtContext extends ParserRuleContext {
		public OutputStmt outputStmtRet;
		public Token k;
		public ExprContext e;
		public TerminalNode SEMI() { return getToken(SimpleLangParser.SEMI, 0); }
		public TerminalNode KW_OUTPUT() { return getToken(SimpleLangParser.KW_OUTPUT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OutputStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterOutputStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitOutputStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitOutputStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputStmtContext outputStmt() throws RecognitionException {
		OutputStmtContext _localctx = new OutputStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_outputStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			((OutputStmtContext)_localctx).k = match(KW_OUTPUT);
			setState(360);
			((OutputStmtContext)_localctx).e = expr(0);
			 ((OutputStmtContext)_localctx).outputStmtRet =  new OutputStmt(((OutputStmtContext)_localctx).e.expressionRet); 
			setState(362);
			match(SEMI);
			 _localctx.outputStmtRet.setLine((((OutputStmtContext)_localctx).k!=null?((OutputStmtContext)_localctx).k.getLine():0)); 
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
	public static class LocContext extends ParserRuleContext {
		public Location locationRet;
		public SimpleLocContext s;
		public MemberLocContext m;
		public ThisLocContext t;
		public SimpleLocContext simpleLoc() {
			return getRuleContext(SimpleLocContext.class,0);
		}
		public MemberLocContext memberLoc() {
			return getRuleContext(MemberLocContext.class,0);
		}
		public ThisLocContext thisLoc() {
			return getRuleContext(ThisLocContext.class,0);
		}
		public LocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterLoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitLoc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitLoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocContext loc() throws RecognitionException {
		LocContext _localctx = new LocContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_loc);
		try {
			setState(375);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(365);
				((LocContext)_localctx).s = simpleLoc();
				 ((LocContext)_localctx).locationRet =  ((LocContext)_localctx).s.simpleLocRet; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(368);
				((LocContext)_localctx).m = memberLoc();
				 ((LocContext)_localctx).locationRet =  ((LocContext)_localctx).m.memberLocRet; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(371);
				((LocContext)_localctx).t = thisLoc();
				 ((LocContext)_localctx).locationRet =  ((LocContext)_localctx).t.thisLocRet; 
				 _localctx.locationRet.setLine(((LocContext)_localctx).t.thisLocRet.getLine()); 
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
	public static class SimpleLocContext extends ParserRuleContext {
		public SimpleLoc simpleLocRet;
		public Token i;
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public SimpleLocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleLoc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterSimpleLoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitSimpleLoc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSimpleLoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleLocContext simpleLoc() throws RecognitionException {
		SimpleLocContext _localctx = new SimpleLocContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_simpleLoc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			((SimpleLocContext)_localctx).i = match(ID);
			 ((SimpleLocContext)_localctx).simpleLocRet =  new SimpleLoc(new Identifier((((SimpleLocContext)_localctx).i!=null?((SimpleLocContext)_localctx).i.getText():null))); 
			 _localctx.simpleLocRet.setLine((((SimpleLocContext)_localctx).i!=null?((SimpleLocContext)_localctx).i.getLine():0)); 
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
	public static class MemberLocContext extends ParserRuleContext {
		public MemberLoc memberLocRet;
		public Token i;
		public LocContext l;
		public TerminalNode DOT() { return getToken(SimpleLangParser.DOT, 0); }
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public MemberLocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberLoc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterMemberLoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitMemberLoc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMemberLoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberLocContext memberLoc() throws RecognitionException {
		MemberLocContext _localctx = new MemberLocContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_memberLoc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			((MemberLocContext)_localctx).i = match(ID);
			setState(382);
			match(DOT);
			setState(383);
			((MemberLocContext)_localctx).l = loc();
			 ((MemberLocContext)_localctx).memberLocRet =  new MemberLoc(new Identifier((((MemberLocContext)_localctx).i!=null?((MemberLocContext)_localctx).i.getText():null)), ((MemberLocContext)_localctx).l.locationRet); 
			 _localctx.memberLocRet.setLine((((MemberLocContext)_localctx).i!=null?((MemberLocContext)_localctx).i.getLine():0)); 
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
	public static class ThisLocContext extends ParserRuleContext {
		public ThisLoc thisLocRet;
		public Token k;
		public LocContext l;
		public TerminalNode KW_THIS() { return getToken(SimpleLangParser.KW_THIS, 0); }
		public TerminalNode DOT() { return getToken(SimpleLangParser.DOT, 0); }
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public ThisLocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thisLoc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterThisLoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitThisLoc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitThisLoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThisLocContext thisLoc() throws RecognitionException {
		ThisLocContext _localctx = new ThisLocContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_thisLoc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ThisLocContext)_localctx).thisLocRet =  new ThisLoc(); 
			setState(388);
			((ThisLocContext)_localctx).k = match(KW_THIS);
			setState(393);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(389);
				match(DOT);
				setState(390);
				((ThisLocContext)_localctx).l = loc();
				 _localctx.thisLocRet.setLoc(((ThisLocContext)_localctx).l.locationRet); 
				}
				break;
			}
			 _localctx.thisLocRet.setLine((((ThisLocContext)_localctx).k!=null?((ThisLocContext)_localctx).k.getLine():0)); 
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
	public static class MethodcallContext extends ParserRuleContext {
		public MethodCall methodCallRet;
		public LocContext l;
		public Token i;
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode DOT() { return getToken(SimpleLangParser.DOT, 0); }
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public MethodcallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodcall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterMethodcall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitMethodcall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMethodcall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodcallContext methodcall() throws RecognitionException {
		MethodcallContext _localctx = new MethodcallContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_methodcall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((MethodcallContext)_localctx).methodCallRet =  new MethodCall(); 
			setState(402);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(398);
				((MethodcallContext)_localctx).l = loc();
				setState(399);
				match(DOT);
				_localctx.methodCallRet.setInstance(((MethodcallContext)_localctx).l.locationRet); 
				}
				break;
			}
			setState(404);
			((MethodcallContext)_localctx).i = match(ID);
			 _localctx.methodCallRet.setCallee(new Identifier((((MethodcallContext)_localctx).i!=null?((MethodcallContext)_localctx).i.getText():null))); 
			setState(406);
			match(LPAREN);
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(407);
				((MethodcallContext)_localctx).e1 = expr(0);
				 _localctx.methodCallRet.addArgument(((MethodcallContext)_localctx).e1.expressionRet);
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(409);
					match(COMMA);
					setState(410);
					((MethodcallContext)_localctx).e2 = expr(0);
					 _localctx.methodCallRet.addArgument(((MethodcallContext)_localctx).e2.expressionRet); 
					}
					}
					setState(417);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(420);
			match(RPAREN);
			 _localctx.methodCallRet.setLine((((MethodcallContext)_localctx).i!=null?((MethodcallContext)_localctx).i.getLine():0)); 
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
		public Expression expressionRet;
		public ExprContext left;
		public LocContext l;
		public Token k;
		public MethodcallContext m;
		public ConsContext c;
		public Token p;
		public ExprContext e;
		public Token i;
		public Token f;
		public Token d;
		public Token ch;
		public Token b;
		public Token op;
		public ExprContext right;
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public TerminalNode KW_THIS() { return getToken(SimpleLangParser.KW_THIS, 0); }
		public MethodcallContext methodcall() {
			return getRuleContext(MethodcallContext.class,0);
		}
		public ConsContext cons() {
			return getRuleContext(ConsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CONSTINT() { return getToken(SimpleLangParser.CONSTINT, 0); }
		public TerminalNode CONSTFLOAT() { return getToken(SimpleLangParser.CONSTFLOAT, 0); }
		public TerminalNode CONSTDOUBLE() { return getToken(SimpleLangParser.CONSTDOUBLE, 0); }
		public TerminalNode CONSTCHAR() { return getToken(SimpleLangParser.CONSTCHAR, 0); }
		public TerminalNode CONSTBOOL() { return getToken(SimpleLangParser.CONSTBOOL, 0); }
		public TerminalNode MINUS() { return getToken(SimpleLangParser.MINUS, 0); }
		public TerminalNode KW_NOT() { return getToken(SimpleLangParser.KW_NOT, 0); }
		public TerminalNode STAR() { return getToken(SimpleLangParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(SimpleLangParser.SLASH, 0); }
		public TerminalNode PLUS() { return getToken(SimpleLangParser.PLUS, 0); }
		public TerminalNode LESS() { return getToken(SimpleLangParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(SimpleLangParser.GREATER, 0); }
		public TerminalNode LESS_EQ() { return getToken(SimpleLangParser.LESS_EQ, 0); }
		public TerminalNode GREATER_EQ() { return getToken(SimpleLangParser.GREATER_EQ, 0); }
		public TerminalNode EQUAL() { return getToken(SimpleLangParser.EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(SimpleLangParser.NOT_EQUAL, 0); }
		public TerminalNode KW_AND() { return getToken(SimpleLangParser.KW_AND, 0); }
		public TerminalNode KW_OR() { return getToken(SimpleLangParser.KW_OR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(424);
				((ExprContext)_localctx).l = loc();
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).l.locationRet; 
				}
				break;
			case 2:
				{
				setState(427);
				((ExprContext)_localctx).k = match(KW_THIS);

				            ThisLoc thisLoc = new ThisLoc();
				            thisLoc.setLine((((ExprContext)_localctx).k!=null?((ExprContext)_localctx).k.getLine():0));
				            ((ExprContext)_localctx).expressionRet =  thisLoc;
				        
				}
				break;
			case 3:
				{
				setState(429);
				((ExprContext)_localctx).m = methodcall();
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).m.methodCallRet; 
				}
				break;
			case 4:
				{
				setState(432);
				((ExprContext)_localctx).c = cons();
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).c.constructorCallRet; 
				}
				break;
			case 5:
				{
				setState(435);
				((ExprContext)_localctx).p = match(LPAREN);
				setState(436);
				((ExprContext)_localctx).e = expr(0);
				setState(437);
				match(RPAREN);
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).e.expressionRet; 
				}
				break;
			case 6:
				{
				setState(440);
				((ExprContext)_localctx).i = match(CONSTINT);

				            ((ExprContext)_localctx).expressionRet =  new IntLiteral(Integer.parseInt((((ExprContext)_localctx).i!=null?((ExprContext)_localctx).i.getText():null)));
				            _localctx.expressionRet.setLine((((ExprContext)_localctx).i!=null?((ExprContext)_localctx).i.getLine():0));
				        
				}
				break;
			case 7:
				{
				setState(442);
				((ExprContext)_localctx).f = match(CONSTFLOAT);

				            ((ExprContext)_localctx).expressionRet =  new FloatLiteral(Float.parseFloat((((ExprContext)_localctx).f!=null?((ExprContext)_localctx).f.getText():null)));
				            _localctx.expressionRet.setLine((((ExprContext)_localctx).f!=null?((ExprContext)_localctx).f.getLine():0));
				        
				}
				break;
			case 8:
				{
				setState(444);
				((ExprContext)_localctx).d = match(CONSTDOUBLE);

				            ((ExprContext)_localctx).expressionRet =  new DoubleLiteral(Double.parseDouble((((ExprContext)_localctx).d!=null?((ExprContext)_localctx).d.getText():null)));
				            _localctx.expressionRet.setLine((((ExprContext)_localctx).d!=null?((ExprContext)_localctx).d.getLine():0));
				        
				}
				break;
			case 9:
				{
				setState(446);
				((ExprContext)_localctx).ch = match(CONSTCHAR);

				            ((ExprContext)_localctx).expressionRet =  new CharLiteral((((ExprContext)_localctx).ch!=null?((ExprContext)_localctx).ch.getText():null).charAt(1));
				            _localctx.expressionRet.setLine((((ExprContext)_localctx).ch!=null?((ExprContext)_localctx).ch.getLine():0));
				        
				}
				break;
			case 10:
				{
				setState(448);
				((ExprContext)_localctx).b = match(CONSTBOOL);

				            ((ExprContext)_localctx).expressionRet =  new BoolLiteral(Boolean.parseBoolean((((ExprContext)_localctx).b!=null?((ExprContext)_localctx).b.getText():null)));
				            _localctx.expressionRet.setLine((((ExprContext)_localctx).b!=null?((ExprContext)_localctx).b.getLine():0));
				        
				}
				break;
			case 11:
				{
				setState(450);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==KW_NOT || _la==MINUS) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(451);
				((ExprContext)_localctx).e = expr(7);

				            ((ExprContext)_localctx).expressionRet =  new UnaryExpression((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).e.expressionRet);
				            _localctx.expressionRet.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0));
				        
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(488);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(486);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(456);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(457);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==SLASH) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(458);
						((ExprContext)_localctx).right = expr(7);

						                      ((ExprContext)_localctx).expressionRet =  new BinaryExpression(((ExprContext)_localctx).left.expressionRet, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).right.expressionRet);
						                      _localctx.expressionRet.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0));
						                  
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(461);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(462);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MINUS || _la==PLUS) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(463);
						((ExprContext)_localctx).right = expr(6);

						                      ((ExprContext)_localctx).expressionRet =  new BinaryExpression(((ExprContext)_localctx).left.expressionRet, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).right.expressionRet);
						                      _localctx.expressionRet.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0));
						                  
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(466);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(467);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 263882790666240L) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(468);
						((ExprContext)_localctx).right = expr(5);

						                      ((ExprContext)_localctx).expressionRet =  new BinaryExpression(((ExprContext)_localctx).left.expressionRet, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).right.expressionRet);
						                      _localctx.expressionRet.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0));
						                  
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(471);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(472);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(473);
						((ExprContext)_localctx).right = expr(4);

						                      ((ExprContext)_localctx).expressionRet =  new BinaryExpression(((ExprContext)_localctx).left.expressionRet, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).right.expressionRet);
						                      _localctx.expressionRet.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0));
						                  
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(476);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(477);
						((ExprContext)_localctx).op = match(KW_AND);
						setState(478);
						((ExprContext)_localctx).right = expr(3);

						                      ((ExprContext)_localctx).expressionRet =  new BinaryExpression(((ExprContext)_localctx).left.expressionRet, "and", ((ExprContext)_localctx).right.expressionRet);
						                      _localctx.expressionRet.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0));
						                  
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(481);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(482);
						((ExprContext)_localctx).op = match(KW_OR);
						setState(483);
						((ExprContext)_localctx).right = expr(2);

						                      ((ExprContext)_localctx).expressionRet =  new BinaryExpression(((ExprContext)_localctx).left.expressionRet, "or", ((ExprContext)_localctx).right.expressionRet);
						                      _localctx.expressionRet.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0));
						                  
						}
						break;
					}
					} 
				}
				setState(490);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InitexprContext extends ParserRuleContext {
		public Statement initExprRet;
		public VardeclContext v1;
		public LocContext l1;
		public ExprContext e1;
		public VardeclContext v2;
		public ExprContext e2;
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SimpleLangParser.ASSIGN, 0); }
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InitexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInitexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInitexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInitexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitexprContext initexpr() throws RecognitionException {
		InitexprContext _localctx = new InitexprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_initexpr);
		try {
			setState(508);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(491);
				((InitexprContext)_localctx).v1 = vardecl();
				 ((InitexprContext)_localctx).initExprRet =  new VarDeclStmt(((InitexprContext)_localctx).v1.varRet); 
				 _localctx.initExprRet.setLine(((InitexprContext)_localctx).v1.varRet.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(495);
				((InitexprContext)_localctx).l1 = loc();
				setState(496);
				match(ASSIGN);
				setState(497);
				((InitexprContext)_localctx).e1 = expr(0);
				 ((InitexprContext)_localctx).initExprRet =  new AssignStmt(((InitexprContext)_localctx).l1.locationRet, ((InitexprContext)_localctx).e1.expressionRet); 
				 _localctx.initExprRet.setLine(((InitexprContext)_localctx).l1.locationRet.getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(501);
				((InitexprContext)_localctx).v2 = vardecl();
				 ((InitexprContext)_localctx).initExprRet =  new VarDeclStmt(((InitexprContext)_localctx).v2.varRet); 
				setState(503);
				match(ASSIGN);
				setState(504);
				((InitexprContext)_localctx).e2 = expr(0);
				 ((VarDeclStmt)_localctx.initExprRet).setInitial(((InitexprContext)_localctx).e2.expressionRet); 
				 _localctx.initExprRet.setLine(((InitexprContext)_localctx).v2.varRet.getLine()); 
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
	public static class UpdateExprContext extends ParserRuleContext {
		public AssignStmt updateExprRet;
		public LocContext l;
		public Token a;
		public ExprContext e;
		public LocContext loc() {
			return getRuleContext(LocContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SimpleLangParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UpdateExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterUpdateExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitUpdateExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitUpdateExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateExprContext updateExpr() throws RecognitionException {
		UpdateExprContext _localctx = new UpdateExprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_updateExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			((UpdateExprContext)_localctx).l = loc();
			setState(511);
			((UpdateExprContext)_localctx).a = match(ASSIGN);
			setState(512);
			((UpdateExprContext)_localctx).e = expr(0);

			            ((UpdateExprContext)_localctx).updateExprRet =  new AssignStmt(((UpdateExprContext)_localctx).l.locationRet, ((UpdateExprContext)_localctx).e.expressionRet);
			            _localctx.updateExprRet.setLine((((UpdateExprContext)_localctx).a!=null?((UpdateExprContext)_localctx).a.getLine():0));
			        
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 27:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00019\u0204\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000A\b\u0000\n\u0000\f\u0000D\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001N\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002Y\b\u0002\n\u0002\f\u0002\\\t\u0002\u0003\u0002"+
		"^\b\u0002\u0001\u0002\u0001\u0002\u0005\u0002b\b\u0002\n\u0002\f\u0002"+
		"e\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003m\b\u0003\n\u0003\f\u0003p\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0003\u0004u\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004y\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"~\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u0084\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"\u0096\b\u0007\n\u0007\f\u0007\u0099\t\u0007\u0003\u0007\u009b\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0003\b\u00a0\b\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003\n\u00ac\b\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00b4\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00c3"+
		"\b\u000b\n\u000b\f\u000b\u00c6\t\u000b\u0003\u000b\u00c8\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0005\f\u00d2\b\f\n\f\f\f\u00d5\t\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u010a\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0112\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u011e\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u012b\b\u0010\n"+
		"\u0010\f\u0010\u012e\t\u0010\u0003\u0010\u0130\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0136\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u013f\b\u0010\n\u0010\f\u0010\u0142\t\u0010\u0003\u0010\u0144\b"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u015d\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0178\b\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u018a\b\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003"+
		"\u001a\u0193\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u019e"+
		"\b\u001a\n\u001a\f\u001a\u01a1\t\u001a\u0003\u001a\u01a3\b\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01c7\b\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005"+
		"\u001b\u01e7\b\u001b\n\u001b\f\u001b\u01ea\t\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u01fd\b\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0000\u0001"+
		"6\u001e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:\u0000\u0006\u0003\u0000\b\f\u001c\u001c"+
		"66\u0002\u0000\u0016\u0016\'\'\u0001\u0000)*\u0001\u0000\'(\u0001\u0000"+
		",/\u0001\u000001\u0222\u0000<\u0001\u0000\u0000\u0000\u0002M\u0001\u0000"+
		"\u0000\u0000\u0004O\u0001\u0000\u0000\u0000\u0006h\u0001\u0000\u0000\u0000"+
		"\b}\u0001\u0000\u0000\u0000\n\u0083\u0001\u0000\u0000\u0000\f\u0085\u0001"+
		"\u0000\u0000\u0000\u000e\u008e\u0001\u0000\u0000\u0000\u0010\u009c\u0001"+
		"\u0000\u0000\u0000\u0012\u00a6\u0001\u0000\u0000\u0000\u0014\u00a8\u0001"+
		"\u0000\u0000\u0000\u0016\u00b9\u0001\u0000\u0000\u0000\u0018\u00cc\u0001"+
		"\u0000\u0000\u0000\u001a\u0109\u0001\u0000\u0000\u0000\u001c\u0111\u0001"+
		"\u0000\u0000\u0000\u001e\u0113\u0001\u0000\u0000\u0000 \u0121\u0001\u0000"+
		"\u0000\u0000\"\u0149\u0001\u0000\u0000\u0000$\u0150\u0001\u0000\u0000"+
		"\u0000&\u0157\u0001\u0000\u0000\u0000(\u0161\u0001\u0000\u0000\u0000*"+
		"\u0167\u0001\u0000\u0000\u0000,\u0177\u0001\u0000\u0000\u0000.\u0179\u0001"+
		"\u0000\u0000\u00000\u017d\u0001\u0000\u0000\u00002\u0183\u0001\u0000\u0000"+
		"\u00004\u018d\u0001\u0000\u0000\u00006\u01c6\u0001\u0000\u0000\u00008"+
		"\u01fc\u0001\u0000\u0000\u0000:\u01fe\u0001\u0000\u0000\u0000<B\u0006"+
		"\u0000\uffff\uffff\u0000=>\u0003\u0002\u0001\u0000>?\u0006\u0000\uffff"+
		"\uffff\u0000?A\u0001\u0000\u0000\u0000@=\u0001\u0000\u0000\u0000AD\u0001"+
		"\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000"+
		"CE\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000EF\u0005\u0000\u0000"+
		"\u0001F\u0001\u0001\u0000\u0000\u0000GH\u0003\u0004\u0002\u0000HI\u0006"+
		"\u0001\uffff\uffff\u0000IN\u0001\u0000\u0000\u0000JK\u0003\u0006\u0003"+
		"\u0000KL\u0006\u0001\uffff\uffff\u0000LN\u0001\u0000\u0000\u0000MG\u0001"+
		"\u0000\u0000\u0000MJ\u0001\u0000\u0000\u0000N\u0003\u0001\u0000\u0000"+
		"\u0000OP\u0005\u0001\u0000\u0000PQ\u00056\u0000\u0000Q]\u0006\u0002\uffff"+
		"\uffff\u0000RS\u0005\u0003\u0000\u0000ST\u00056\u0000\u0000TZ\u0006\u0002"+
		"\uffff\uffff\u0000UV\u0005\u001f\u0000\u0000VW\u00056\u0000\u0000WY\u0006"+
		"\u0002\uffff\uffff\u0000XU\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000"+
		"\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[^\u0001\u0000"+
		"\u0000\u0000\\Z\u0001\u0000\u0000\u0000]R\u0001\u0000\u0000\u0000]^\u0001"+
		"\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_c\u0005\u0004\u0000\u0000"+
		"`b\u0003\b\u0004\u0000a`\u0001\u0000\u0000\u0000be\u0001\u0000\u0000\u0000"+
		"ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000df\u0001\u0000\u0000"+
		"\u0000ec\u0001\u0000\u0000\u0000fg\u0005\u0005\u0000\u0000g\u0005\u0001"+
		"\u0000\u0000\u0000hi\u0005\u0002\u0000\u0000ij\u00056\u0000\u0000jn\u0005"+
		"\u0004\u0000\u0000km\u0003\b\u0004\u0000lk\u0001\u0000\u0000\u0000mp\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"oq\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0005\u0005\u0000"+
		"\u0000r\u0007\u0001\u0000\u0000\u0000su\u0003\n\u0005\u0000ts\u0001\u0000"+
		"\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000v~\u0003"+
		"\f\u0006\u0000wy\u0003\n\u0005\u0000xw\u0001\u0000\u0000\u0000xy\u0001"+
		"\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0003\u0014\n\u0000{|\u0005"+
		"\u001e\u0000\u0000|~\u0001\u0000\u0000\u0000}t\u0001\u0000\u0000\u0000"+
		"}x\u0001\u0000\u0000\u0000~\t\u0001\u0000\u0000\u0000\u007f\u0080\u0005"+
		"\u0007\u0000\u0000\u0080\u0084\u0006\u0005\uffff\uffff\u0000\u0081\u0082"+
		"\u0005\u0006\u0000\u0000\u0082\u0084\u0006\u0005\uffff\uffff\u0000\u0083"+
		"\u007f\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084"+
		"\u000b\u0001\u0000\u0000\u0000\u0085\u0086\u0003\u0012\t\u0000\u0086\u0087"+
		"\u00056\u0000\u0000\u0087\u0088\u0005 \u0000\u0000\u0088\u0089\u0003\u000e"+
		"\u0007\u0000\u0089\u008a\u0005!\u0000\u0000\u008a\u008b\u0003\u0018\f"+
		"\u0000\u008b\u008c\u0006\u0006\uffff\uffff\u0000\u008c\u008d\u0006\u0006"+
		"\uffff\uffff\u0000\u008d\r\u0001\u0000\u0000\u0000\u008e\u009a\u0006\u0007"+
		"\uffff\uffff\u0000\u008f\u0090\u0003\u0010\b\u0000\u0090\u0097\u0006\u0007"+
		"\uffff\uffff\u0000\u0091\u0092\u0005\u001f\u0000\u0000\u0092\u0093\u0003"+
		"\u0010\b\u0000\u0093\u0094\u0006\u0007\uffff\uffff\u0000\u0094\u0096\u0001"+
		"\u0000\u0000\u0000\u0095\u0091\u0001\u0000\u0000\u0000\u0096\u0099\u0001"+
		"\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001"+
		"\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099\u0097\u0001"+
		"\u0000\u0000\u0000\u009a\u008f\u0001\u0000\u0000\u0000\u009a\u009b\u0001"+
		"\u0000\u0000\u0000\u009b\u000f\u0001\u0000\u0000\u0000\u009c\u009f\u0006"+
		"\b\uffff\uffff\u0000\u009d\u009e\u0005\u0019\u0000\u0000\u009e\u00a0\u0006"+
		"\b\uffff\uffff\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0003"+
		"\u0012\t\u0000\u00a2\u00a3\u00056\u0000\u0000\u00a3\u00a4\u0006\b\uffff"+
		"\uffff\u0000\u00a4\u00a5\u0006\b\uffff\uffff\u0000\u00a5\u0011\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0007\u0000\u0000\u0000\u00a7\u0013\u0001\u0000"+
		"\u0000\u0000\u00a8\u00ab\u0006\n\uffff\uffff\u0000\u00a9\u00aa\u0005\u0019"+
		"\u0000\u0000\u00aa\u00ac\u0006\n\uffff\uffff\u0000\u00ab\u00a9\u0001\u0000"+
		"\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00b3\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0003\u0012\t\u0000\u00ae\u00af\u0006\n\uffff"+
		"\uffff\u0000\u00af\u00b4\u0001\u0000\u0000\u0000\u00b0\u00b1\u0003\u0016"+
		"\u000b\u0000\u00b1\u00b2\u0006\n\uffff\uffff\u0000\u00b2\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b3\u00ad\u0001\u0000\u0000\u0000\u00b3\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6\u00056\u0000"+
		"\u0000\u00b6\u00b7\u0006\n\uffff\uffff\u0000\u00b7\u00b8\u0006\n\uffff"+
		"\uffff\u0000\u00b8\u0015\u0001\u0000\u0000\u0000\u00b9\u00ba\u00056\u0000"+
		"\u0000\u00ba\u00bb\u0006\u000b\uffff\uffff\u0000\u00bb\u00c7\u0005 \u0000"+
		"\u0000\u00bc\u00bd\u00036\u001b\u0000\u00bd\u00c4\u0006\u000b\uffff\uffff"+
		"\u0000\u00be\u00bf\u0005\u001f\u0000\u0000\u00bf\u00c0\u00036\u001b\u0000"+
		"\u00c0\u00c1\u0006\u000b\uffff\uffff\u0000\u00c1\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c2\u00be\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c7\u00bc\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000"+
		"\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005!\u0000\u0000"+
		"\u00ca\u00cb\u0006\u000b\uffff\uffff\u0000\u00cb\u0017\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cd\u0006\f\uffff\uffff\u0000\u00cd\u00d3\u0005\u0004\u0000"+
		"\u0000\u00ce\u00cf\u0003\u001a\r\u0000\u00cf\u00d0\u0006\f\uffff\uffff"+
		"\u0000\u00d0\u00d2\u0001\u0000\u0000\u0000\u00d1\u00ce\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005\u0005\u0000"+
		"\u0000\u00d7\u00d8\u0006\f\uffff\uffff\u0000\u00d8\u0019\u0001\u0000\u0000"+
		"\u0000\u00d9\u00da\u0003\u0018\f\u0000\u00da\u00db\u0006\r\uffff\uffff"+
		"\u0000\u00db\u00dc\u0006\r\uffff\uffff\u0000\u00dc\u010a\u0001\u0000\u0000"+
		"\u0000\u00dd\u00de\u0003\u0014\n\u0000\u00de\u00df\u0006\r\uffff\uffff"+
		"\u0000\u00df\u00e0\u0005\u001e\u0000\u0000\u00e0\u00e1\u0006\r\uffff\uffff"+
		"\u0000\u00e1\u010a\u0001\u0000\u0000\u0000\u00e2\u00e3\u0003\u0014\n\u0000"+
		"\u00e3\u00e4\u0006\r\uffff\uffff\u0000\u00e4\u00e5\u0005$\u0000\u0000"+
		"\u00e5\u00e6\u00036\u001b\u0000\u00e6\u00e7\u0006\r\uffff\uffff\u0000"+
		"\u00e7\u00e8\u0005\u001e\u0000\u0000\u00e8\u00e9\u0006\r\uffff\uffff\u0000"+
		"\u00e9\u010a\u0001\u0000\u0000\u0000\u00ea\u00eb\u00034\u001a\u0000\u00eb"+
		"\u00ec\u0006\r\uffff\uffff\u0000\u00ec\u00ed\u0005\u001e\u0000\u0000\u00ed"+
		"\u00ee\u0006\r\uffff\uffff\u0000\u00ee\u010a\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f0\u0003\u001e\u000f\u0000\u00f0\u00f1\u0006\r\uffff\uffff\u0000\u00f1"+
		"\u00f2\u0006\r\uffff\uffff\u0000\u00f2\u010a\u0001\u0000\u0000\u0000\u00f3"+
		"\u010a\u0003 \u0010\u0000\u00f4\u010a\u0003\"\u0011\u0000\u00f5\u00f6"+
		"\u0003$\u0012\u0000\u00f6\u00f7\u0006\r\uffff\uffff\u0000\u00f7\u00f8"+
		"\u0006\r\uffff\uffff\u0000\u00f8\u010a\u0001\u0000\u0000\u0000\u00f9\u00fa"+
		"\u0003&\u0013\u0000\u00fa\u00fb\u0006\r\uffff\uffff\u0000\u00fb\u00fc"+
		"\u0006\r\uffff\uffff\u0000\u00fc\u010a\u0001\u0000\u0000\u0000\u00fd\u00fe"+
		"\u0003(\u0014\u0000\u00fe\u00ff\u0006\r\uffff\uffff\u0000\u00ff\u0100"+
		"\u0006\r\uffff\uffff\u0000\u0100\u010a\u0001\u0000\u0000\u0000\u0101\u0102"+
		"\u0003*\u0015\u0000\u0102\u0103\u0006\r\uffff\uffff\u0000\u0103\u0104"+
		"\u0006\r\uffff\uffff\u0000\u0104\u010a\u0001\u0000\u0000\u0000\u0105\u0106"+
		"\u0003\u001c\u000e\u0000\u0106\u0107\u0006\r\uffff\uffff\u0000\u0107\u0108"+
		"\u0006\r\uffff\uffff\u0000\u0108\u010a\u0001\u0000\u0000\u0000\u0109\u00d9"+
		"\u0001\u0000\u0000\u0000\u0109\u00dd\u0001\u0000\u0000\u0000\u0109\u00e2"+
		"\u0001\u0000\u0000\u0000\u0109\u00ea\u0001\u0000\u0000\u0000\u0109\u00ef"+
		"\u0001\u0000\u0000\u0000\u0109\u00f3\u0001\u0000\u0000\u0000\u0109\u00f4"+
		"\u0001\u0000\u0000\u0000\u0109\u00f5\u0001\u0000\u0000\u0000\u0109\u00f9"+
		"\u0001\u0000\u0000\u0000\u0109\u00fd\u0001\u0000\u0000\u0000\u0109\u0101"+
		"\u0001\u0000\u0000\u0000\u0109\u0105\u0001\u0000\u0000\u0000\u010a\u001b"+
		"\u0001\u0000\u0000\u0000\u010b\u010c\u0005\u001a\u0000\u0000\u010c\u010d"+
		"\u0006\u000e\uffff\uffff\u0000\u010d\u0112\u0006\u000e\uffff\uffff\u0000"+
		"\u010e\u010f\u0005\u001b\u0000\u0000\u010f\u0110\u0006\u000e\uffff\uffff"+
		"\u0000\u0110\u0112\u0006\u000e\uffff\uffff\u0000\u0111\u010b\u0001\u0000"+
		"\u0000\u0000\u0111\u010e\u0001\u0000\u0000\u0000\u0112\u001d\u0001\u0000"+
		"\u0000\u0000\u0113\u0114\u0005\r\u0000\u0000\u0114\u0115\u0005 \u0000"+
		"\u0000\u0115\u0116\u00036\u001b\u0000\u0116\u0117\u0005!\u0000\u0000\u0117"+
		"\u0118\u0003\u001a\r\u0000\u0118\u011d\u0006\u000f\uffff\uffff\u0000\u0119"+
		"\u011a\u0005\u000e\u0000\u0000\u011a\u011b\u0003\u001a\r\u0000\u011b\u011c"+
		"\u0006\u000f\uffff\uffff\u0000\u011c\u011e\u0001\u0000\u0000\u0000\u011d"+
		"\u0119\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e"+
		"\u011f\u0001\u0000\u0000\u0000\u011f\u0120\u0006\u000f\uffff\uffff\u0000"+
		"\u0120\u001f\u0001\u0000\u0000\u0000\u0121\u0122\u0005\u000f\u0000\u0000"+
		"\u0122\u0123\u0006\u0010\uffff\uffff\u0000\u0123\u012f\u0005 \u0000\u0000"+
		"\u0124\u0125\u00038\u001c\u0000\u0125\u012c\u0006\u0010\uffff\uffff\u0000"+
		"\u0126\u0127\u0005\u001f\u0000\u0000\u0127\u0128\u00038\u001c\u0000\u0128"+
		"\u0129\u0006\u0010\uffff\uffff\u0000\u0129\u012b\u0001\u0000\u0000\u0000"+
		"\u012a\u0126\u0001\u0000\u0000\u0000\u012b\u012e\u0001\u0000\u0000\u0000"+
		"\u012c\u012a\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000"+
		"\u012d\u0130\u0001\u0000\u0000\u0000\u012e\u012c\u0001\u0000\u0000\u0000"+
		"\u012f\u0124\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000"+
		"\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0135\u0005\u001e\u0000\u0000"+
		"\u0132\u0133\u00036\u001b\u0000\u0133\u0134\u0006\u0010\uffff\uffff\u0000"+
		"\u0134\u0136\u0001\u0000\u0000\u0000\u0135\u0132\u0001\u0000\u0000\u0000"+
		"\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000"+
		"\u0137\u0143\u0005\u001e\u0000\u0000\u0138\u0139\u0003:\u001d\u0000\u0139"+
		"\u0140\u0006\u0010\uffff\uffff\u0000\u013a\u013b\u0005\u001f\u0000\u0000"+
		"\u013b\u013c\u0003:\u001d\u0000\u013c\u013d\u0006\u0010\uffff\uffff\u0000"+
		"\u013d\u013f\u0001\u0000\u0000\u0000\u013e\u013a\u0001\u0000\u0000\u0000"+
		"\u013f\u0142\u0001\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000"+
		"\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u0144\u0001\u0000\u0000\u0000"+
		"\u0142\u0140\u0001\u0000\u0000\u0000\u0143\u0138\u0001\u0000\u0000\u0000"+
		"\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000"+
		"\u0145\u0146\u0005!\u0000\u0000\u0146\u0147\u0003\u001a\r\u0000\u0147"+
		"\u0148\u0006\u0010\uffff\uffff\u0000\u0148!\u0001\u0000\u0000\u0000\u0149"+
		"\u014a\u0005\u0010\u0000\u0000\u014a\u014b\u0005 \u0000\u0000\u014b\u014c"+
		"\u00036\u001b\u0000\u014c\u014d\u0005!\u0000\u0000\u014d\u014e\u0003\u001a"+
		"\r\u0000\u014e\u014f\u0006\u0011\uffff\uffff\u0000\u014f#\u0001\u0000"+
		"\u0000\u0000\u0150\u0151\u0003,\u0016\u0000\u0151\u0152\u0005$\u0000\u0000"+
		"\u0152\u0153\u00036\u001b\u0000\u0153\u0154\u0006\u0012\uffff\uffff\u0000"+
		"\u0154\u0155\u0005\u001e\u0000\u0000\u0155\u0156\u0006\u0012\uffff\uffff"+
		"\u0000\u0156%\u0001\u0000\u0000\u0000\u0157\u0158\u0006\u0013\uffff\uffff"+
		"\u0000\u0158\u015c\u0005\u0012\u0000\u0000\u0159\u015a\u00036\u001b\u0000"+
		"\u015a\u015b\u0006\u0013\uffff\uffff\u0000\u015b\u015d\u0001\u0000\u0000"+
		"\u0000\u015c\u0159\u0001\u0000\u0000\u0000\u015c\u015d\u0001\u0000\u0000"+
		"\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015e\u015f\u0005\u001e\u0000"+
		"\u0000\u015f\u0160\u0006\u0013\uffff\uffff\u0000\u0160\'\u0001\u0000\u0000"+
		"\u0000\u0161\u0162\u0005\u0013\u0000\u0000\u0162\u0163\u0003,\u0016\u0000"+
		"\u0163\u0164\u0006\u0014\uffff\uffff\u0000\u0164\u0165\u0005\u001e\u0000"+
		"\u0000\u0165\u0166\u0006\u0014\uffff\uffff\u0000\u0166)\u0001\u0000\u0000"+
		"\u0000\u0167\u0168\u0005\u0014\u0000\u0000\u0168\u0169\u00036\u001b\u0000"+
		"\u0169\u016a\u0006\u0015\uffff\uffff\u0000\u016a\u016b\u0005\u001e\u0000"+
		"\u0000\u016b\u016c\u0006\u0015\uffff\uffff\u0000\u016c+\u0001\u0000\u0000"+
		"\u0000\u016d\u016e\u0003.\u0017\u0000\u016e\u016f\u0006\u0016\uffff\uffff"+
		"\u0000\u016f\u0178\u0001\u0000\u0000\u0000\u0170\u0171\u00030\u0018\u0000"+
		"\u0171\u0172\u0006\u0016\uffff\uffff\u0000\u0172\u0178\u0001\u0000\u0000"+
		"\u0000\u0173\u0174\u00032\u0019\u0000\u0174\u0175\u0006\u0016\uffff\uffff"+
		"\u0000\u0175\u0176\u0006\u0016\uffff\uffff\u0000\u0176\u0178\u0001\u0000"+
		"\u0000\u0000\u0177\u016d\u0001\u0000\u0000\u0000\u0177\u0170\u0001\u0000"+
		"\u0000\u0000\u0177\u0173\u0001\u0000\u0000\u0000\u0178-\u0001\u0000\u0000"+
		"\u0000\u0179\u017a\u00056\u0000\u0000\u017a\u017b\u0006\u0017\uffff\uffff"+
		"\u0000\u017b\u017c\u0006\u0017\uffff\uffff\u0000\u017c/\u0001\u0000\u0000"+
		"\u0000\u017d\u017e\u00056\u0000\u0000\u017e\u017f\u0005%\u0000\u0000\u017f"+
		"\u0180\u0003,\u0016\u0000\u0180\u0181\u0006\u0018\uffff\uffff\u0000\u0181"+
		"\u0182\u0006\u0018\uffff\uffff\u0000\u01821\u0001\u0000\u0000\u0000\u0183"+
		"\u0184\u0006\u0019\uffff\uffff\u0000\u0184\u0189\u0005\u0015\u0000\u0000"+
		"\u0185\u0186\u0005%\u0000\u0000\u0186\u0187\u0003,\u0016\u0000\u0187\u0188"+
		"\u0006\u0019\uffff\uffff\u0000\u0188\u018a\u0001\u0000\u0000\u0000\u0189"+
		"\u0185\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000\u0000\u018a"+
		"\u018b\u0001\u0000\u0000\u0000\u018b\u018c\u0006\u0019\uffff\uffff\u0000"+
		"\u018c3\u0001\u0000\u0000\u0000\u018d\u0192\u0006\u001a\uffff\uffff\u0000"+
		"\u018e\u018f\u0003,\u0016\u0000\u018f\u0190\u0005%\u0000\u0000\u0190\u0191"+
		"\u0006\u001a\uffff\uffff\u0000\u0191\u0193\u0001\u0000\u0000\u0000\u0192"+
		"\u018e\u0001\u0000\u0000\u0000\u0192\u0193\u0001\u0000\u0000\u0000\u0193"+
		"\u0194\u0001\u0000\u0000\u0000\u0194\u0195\u00056\u0000\u0000\u0195\u0196"+
		"\u0006\u001a\uffff\uffff\u0000\u0196\u01a2\u0005 \u0000\u0000\u0197\u0198"+
		"\u00036\u001b\u0000\u0198\u019f\u0006\u001a\uffff\uffff\u0000\u0199\u019a"+
		"\u0005\u001f\u0000\u0000\u019a\u019b\u00036\u001b\u0000\u019b\u019c\u0006"+
		"\u001a\uffff\uffff\u0000\u019c\u019e\u0001\u0000\u0000\u0000\u019d\u0199"+
		"\u0001\u0000\u0000\u0000\u019e\u01a1\u0001\u0000\u0000\u0000\u019f\u019d"+
		"\u0001\u0000\u0000\u0000\u019f\u01a0\u0001\u0000\u0000\u0000\u01a0\u01a3"+
		"\u0001\u0000\u0000\u0000\u01a1\u019f\u0001\u0000\u0000\u0000\u01a2\u0197"+
		"\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000\u0000\u01a3\u01a4"+
		"\u0001\u0000\u0000\u0000\u01a4\u01a5\u0005!\u0000\u0000\u01a5\u01a6\u0006"+
		"\u001a\uffff\uffff\u0000\u01a65\u0001\u0000\u0000\u0000\u01a7\u01a8\u0006"+
		"\u001b\uffff\uffff\u0000\u01a8\u01a9\u0003,\u0016\u0000\u01a9\u01aa\u0006"+
		"\u001b\uffff\uffff\u0000\u01aa\u01c7\u0001\u0000\u0000\u0000\u01ab\u01ac"+
		"\u0005\u0015\u0000\u0000\u01ac\u01c7\u0006\u001b\uffff\uffff\u0000\u01ad"+
		"\u01ae\u00034\u001a\u0000\u01ae\u01af\u0006\u001b\uffff\uffff\u0000\u01af"+
		"\u01c7\u0001\u0000\u0000\u0000\u01b0\u01b1\u0003\u0016\u000b\u0000\u01b1"+
		"\u01b2\u0006\u001b\uffff\uffff\u0000\u01b2\u01c7\u0001\u0000\u0000\u0000"+
		"\u01b3\u01b4\u0005 \u0000\u0000\u01b4\u01b5\u00036\u001b\u0000\u01b5\u01b6"+
		"\u0005!\u0000\u0000\u01b6\u01b7\u0006\u001b\uffff\uffff\u0000\u01b7\u01c7"+
		"\u0001\u0000\u0000\u0000\u01b8\u01b9\u00052\u0000\u0000\u01b9\u01c7\u0006"+
		"\u001b\uffff\uffff\u0000\u01ba\u01bb\u00053\u0000\u0000\u01bb\u01c7\u0006"+
		"\u001b\uffff\uffff\u0000\u01bc\u01bd\u00054\u0000\u0000\u01bd\u01c7\u0006"+
		"\u001b\uffff\uffff\u0000\u01be\u01bf\u00055\u0000\u0000\u01bf\u01c7\u0006"+
		"\u001b\uffff\uffff\u0000\u01c0\u01c1\u0005\u001d\u0000\u0000\u01c1\u01c7"+
		"\u0006\u001b\uffff\uffff\u0000\u01c2\u01c3\u0007\u0001\u0000\u0000\u01c3"+
		"\u01c4\u00036\u001b\u0007\u01c4\u01c5\u0006\u001b\uffff\uffff\u0000\u01c5"+
		"\u01c7\u0001\u0000\u0000\u0000\u01c6\u01a7\u0001\u0000\u0000\u0000\u01c6"+
		"\u01ab\u0001\u0000\u0000\u0000\u01c6\u01ad\u0001\u0000\u0000\u0000\u01c6"+
		"\u01b0\u0001\u0000\u0000\u0000\u01c6\u01b3\u0001\u0000\u0000\u0000\u01c6"+
		"\u01b8\u0001\u0000\u0000\u0000\u01c6\u01ba\u0001\u0000\u0000\u0000\u01c6"+
		"\u01bc\u0001\u0000\u0000\u0000\u01c6\u01be\u0001\u0000\u0000\u0000\u01c6"+
		"\u01c0\u0001\u0000\u0000\u0000\u01c6\u01c2\u0001\u0000\u0000\u0000\u01c7"+
		"\u01e8\u0001\u0000\u0000\u0000\u01c8\u01c9\n\u0006\u0000\u0000\u01c9\u01ca"+
		"\u0007\u0002\u0000\u0000\u01ca\u01cb\u00036\u001b\u0007\u01cb\u01cc\u0006"+
		"\u001b\uffff\uffff\u0000\u01cc\u01e7\u0001\u0000\u0000\u0000\u01cd\u01ce"+
		"\n\u0005\u0000\u0000\u01ce\u01cf\u0007\u0003\u0000\u0000\u01cf\u01d0\u0003"+
		"6\u001b\u0006\u01d0\u01d1\u0006\u001b\uffff\uffff\u0000\u01d1\u01e7\u0001"+
		"\u0000\u0000\u0000\u01d2\u01d3\n\u0004\u0000\u0000\u01d3\u01d4\u0007\u0004"+
		"\u0000\u0000\u01d4\u01d5\u00036\u001b\u0005\u01d5\u01d6\u0006\u001b\uffff"+
		"\uffff\u0000\u01d6\u01e7\u0001\u0000\u0000\u0000\u01d7\u01d8\n\u0003\u0000"+
		"\u0000\u01d8\u01d9\u0007\u0005\u0000\u0000\u01d9\u01da\u00036\u001b\u0004"+
		"\u01da\u01db\u0006\u001b\uffff\uffff\u0000\u01db\u01e7\u0001\u0000\u0000"+
		"\u0000\u01dc\u01dd\n\u0002\u0000\u0000\u01dd\u01de\u0005\u0017\u0000\u0000"+
		"\u01de\u01df\u00036\u001b\u0003\u01df\u01e0\u0006\u001b\uffff\uffff\u0000"+
		"\u01e0\u01e7\u0001\u0000\u0000\u0000\u01e1\u01e2\n\u0001\u0000\u0000\u01e2"+
		"\u01e3\u0005\u0018\u0000\u0000\u01e3\u01e4\u00036\u001b\u0002\u01e4\u01e5"+
		"\u0006\u001b\uffff\uffff\u0000\u01e5\u01e7\u0001\u0000\u0000\u0000\u01e6"+
		"\u01c8\u0001\u0000\u0000\u0000\u01e6\u01cd\u0001\u0000\u0000\u0000\u01e6"+
		"\u01d2\u0001\u0000\u0000\u0000\u01e6\u01d7\u0001\u0000\u0000\u0000\u01e6"+
		"\u01dc\u0001\u0000\u0000\u0000\u01e6\u01e1\u0001\u0000\u0000\u0000\u01e7"+
		"\u01ea\u0001\u0000\u0000\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000\u01e8"+
		"\u01e9\u0001\u0000\u0000\u0000\u01e97\u0001\u0000\u0000\u0000\u01ea\u01e8"+
		"\u0001\u0000\u0000\u0000\u01eb\u01ec\u0003\u0014\n\u0000\u01ec\u01ed\u0006"+
		"\u001c\uffff\uffff\u0000\u01ed\u01ee\u0006\u001c\uffff\uffff\u0000\u01ee"+
		"\u01fd\u0001\u0000\u0000\u0000\u01ef\u01f0\u0003,\u0016\u0000\u01f0\u01f1"+
		"\u0005$\u0000\u0000\u01f1\u01f2\u00036\u001b\u0000\u01f2\u01f3\u0006\u001c"+
		"\uffff\uffff\u0000\u01f3\u01f4\u0006\u001c\uffff\uffff\u0000\u01f4\u01fd"+
		"\u0001\u0000\u0000\u0000\u01f5\u01f6\u0003\u0014\n\u0000\u01f6\u01f7\u0006"+
		"\u001c\uffff\uffff\u0000\u01f7\u01f8\u0005$\u0000\u0000\u01f8\u01f9\u0003"+
		"6\u001b\u0000\u01f9\u01fa\u0006\u001c\uffff\uffff\u0000\u01fa\u01fb\u0006"+
		"\u001c\uffff\uffff\u0000\u01fb\u01fd\u0001\u0000\u0000\u0000\u01fc\u01eb"+
		"\u0001\u0000\u0000\u0000\u01fc\u01ef\u0001\u0000\u0000\u0000\u01fc\u01f5"+
		"\u0001\u0000\u0000\u0000\u01fd9\u0001\u0000\u0000\u0000\u01fe\u01ff\u0003"+
		",\u0016\u0000\u01ff\u0200\u0005$\u0000\u0000\u0200\u0201\u00036\u001b"+
		"\u0000\u0201\u0202\u0006\u001d\uffff\uffff\u0000\u0202;\u0001\u0000\u0000"+
		"\u0000$BMZ]cntx}\u0083\u0097\u009a\u009f\u00ab\u00b3\u00c4\u00c7\u00d3"+
		"\u0109\u0111\u011d\u012c\u012f\u0135\u0140\u0143\u015c\u0177\u0189\u0192"+
		"\u019f\u01a2\u01c6\u01e6\u01e8\u01fc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}