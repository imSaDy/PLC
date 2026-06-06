// Generated from /home/sadegh/Desktop/PLC/Phase 2/template/src/main/grammar/SimpleLang.g4 by ANTLR 4.13.1

    import main.ast.core.*;

    import main.ast.declarations.*;
    import main.ast.declarations.Module;
    import main.ast.statements.*;


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
		RULE_thisLoc = 25, RULE_methodcall = 26, RULE_expr = 27, RULE_initexpr = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "topLevelDecl", "module", "structDef", "member", "accessModifier", 
			"method_decl", "arguments", "parameter", "type", "vardecl", "cons", "block", 
			"st", "jumpStmt", "ifStmt", "forStmt", "whileStmt", "assignStmt", "returnStmt", 
			"inputStmt", "outputStmt", "loc", "simpleLoc", "memberLoc", "thisLoc", 
			"methodcall", "expr", "initexpr"
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
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ProgramContext)_localctx).programRet =  new Program(); 
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_MODULE || _la==KW_STRUCT) {
				{
				{
				setState(59);
				((ProgramContext)_localctx).t = topLevelDecl();
				 _localctx.programRet.addTopLevelDeclaration(((ProgramContext)_localctx).t.topLevelDeclRet); 
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
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
	}

	public final TopLevelDeclContext topLevelDecl() throws RecognitionException {
		TopLevelDeclContext _localctx = new TopLevelDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevelDecl);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_MODULE:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				((TopLevelDeclContext)_localctx).m = module();
				 ((TopLevelDeclContext)_localctx).topLevelDeclRet = ((TopLevelDeclContext)_localctx).m.moduleRet;

				         
				}
				break;
			case KW_STRUCT:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
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
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			((ModuleContext)_localctx).k = match(KW_MODULE);
			setState(78);
			((ModuleContext)_localctx).i = match(ID);
			 ((ModuleContext)_localctx).moduleRet =  new Module(new Identifier((((ModuleContext)_localctx).i!=null?((ModuleContext)_localctx).i.getText():null)));
			        _localctx.moduleRet.setLine((((ModuleContext)_localctx).i!=null?((ModuleContext)_localctx).i.getLine():0)); 
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_INCLUDES) {
				{
				setState(80);
				match(KW_INCLUDES);
				setState(81);
				((ModuleContext)_localctx).i1 = match(ID);
				 _localctx.moduleRet.addInclude(new Identifier((((ModuleContext)_localctx).i1!=null?((ModuleContext)_localctx).i1.getText():null))); 
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(83);
					match(COMMA);
					setState(84);
					((ModuleContext)_localctx).i2 = match(ID);
					 _localctx.moduleRet.addInclude(new Identifier((((ModuleContext)_localctx).i2!=null?((ModuleContext)_localctx).i2.getText():null))); 
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(93);
			match(KW_BEGIN);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811480000L) != 0)) {
				{
				{
				setState(94);
				member();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
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
	}

	public final StructDefContext structDef() throws RecognitionException {
		StructDefContext _localctx = new StructDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			((StructDefContext)_localctx).k = match(KW_STRUCT);
			setState(103);
			((StructDefContext)_localctx).i = match(ID);
			setState(104);
			match(KW_BEGIN);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811480000L) != 0)) {
				{
				{
				setState(105);
				member();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
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
	}

	public final MemberContext member() throws RecognitionException {
		MemberContext _localctx = new MemberContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_member);
		int _la;
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_PUBLIC || _la==KW_PRIVATE) {
					{
					setState(113);
					accessModifier();
					}
				}

				setState(116);
				((MemberContext)_localctx).m = method_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_PUBLIC || _la==KW_PRIVATE) {
					{
					setState(117);
					accessModifier();
					}
				}

				setState(120);
				((MemberContext)_localctx).v = vardecl();
				setState(121);
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
	}

	public final AccessModifierContext accessModifier() throws RecognitionException {
		AccessModifierContext _localctx = new AccessModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_accessModifier);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_PRIVATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				((AccessModifierContext)_localctx).pr = match(KW_PRIVATE);
				 ((AccessModifierContext)_localctx).accessModifierRet =  AccessModifier.PRIVATE; 
				}
				break;
			case KW_PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
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
	}

	public final Method_declContext method_decl() throws RecognitionException {
		Method_declContext _localctx = new Method_declContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_method_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			((Method_declContext)_localctx).t = type();
			setState(132);
			((Method_declContext)_localctx).i = match(ID);
			setState(133);
			match(LPAREN);
			setState(134);
			((Method_declContext)_localctx).a = arguments();
			setState(135);
			match(RPAREN);
			setState(136);
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
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ArgumentsContext)_localctx).parametersRet =  new ArrayList<>(); 
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811479808L) != 0)) {
				{
				setState(141);
				((ArgumentsContext)_localctx).p1 = parameter();
				 _localctx.parametersRet.add(((ArgumentsContext)_localctx).p1.parameterRet); 
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(143);
					match(COMMA);
					setState(144);
					((ArgumentsContext)_localctx).p2 = parameter();
					 _localctx.parametersRet.add(((ArgumentsContext)_localctx).p2.parameterRet); 
					}
					}
					setState(151);
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
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 boolean isMut = false; 
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_MUT) {
				{
				setState(155);
				match(KW_MUT);
				 isMut = true; 
				}
			}

			setState(159);
			((ParameterContext)_localctx).t = type();
			setState(160);
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
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
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
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_vardecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 boolean isMut = false; 
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_MUT) {
				{
				setState(167);
				match(KW_MUT);
				 isMut = true; 
				}
			}

			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(171);
				((VardeclContext)_localctx).t = type();
				 ((VardeclContext)_localctx).varRet =  new Var(isMut, ((VardeclContext)_localctx).t.typeRet); 
				}
				break;
			case 2:
				{
				setState(174);
				((VardeclContext)_localctx).c = cons();
				 ((VardeclContext)_localctx).varRet =  new Var(isMut, ((VardeclContext)_localctx).c.constructorCallRet); 
				}
				break;
			}
			setState(179);
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
	}

	public final ConsContext cons() throws RecognitionException {
		ConsContext _localctx = new ConsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cons);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			((ConsContext)_localctx).i = match(ID);
			 ((ConsContext)_localctx).constructorCallRet =  new ConstructorCall(new Identifier((((ConsContext)_localctx).i!=null?((ConsContext)_localctx).i.getText():null))); 
			setState(185);
			match(LPAREN);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(186);
				((ConsContext)_localctx).e1 = expr(0);
				 _localctx.constructorCallRet.addArgument(((ConsContext)_localctx).e1.expressionRet); 
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(188);
					match(COMMA);
					setState(189);
					((ConsContext)_localctx).e2 = expr(0);
					 _localctx.constructorCallRet.addArgument(((ConsContext)_localctx).e2.expressionRet); 
					}
					}
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(199);
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
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((BlockContext)_localctx).blockRet =  new Block(); 
			setState(203);
			((BlockContext)_localctx).k = match(KW_BEGIN);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014399016845072L) != 0)) {
				{
				{
				setState(204);
				((BlockContext)_localctx).s = st();
				 _localctx.blockRet.addStatement(((BlockContext)_localctx).s.statementRet); 
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(212);
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
	}

	public final StContext st() throws RecognitionException {
		StContext _localctx = new StContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_st);
		try {
			setState(263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				((StContext)_localctx).b = block();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).b.blockRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).b.blockRet.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				((StContext)_localctx).vd = vardecl();
				 ((StContext)_localctx).statementRet =  new VarDeclStmt(((StContext)_localctx).vd.varRet); 
				setState(221);
				match(SEMI);
				 _localctx.statementRet.setLine(((StContext)_localctx).vd.varRet.getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				((StContext)_localctx).v = vardecl();
				 ((StContext)_localctx).statementRet =  new VarDeclStmt(((StContext)_localctx).v.varRet); 
				setState(226);
				match(ASSIGN);
				setState(227);
				((StContext)_localctx).e = expr(0);
				 ((VarDeclStmt)_localctx.statementRet).setInitial(((StContext)_localctx).e.expressionRet); 
				setState(229);
				match(SEMI);
				 _localctx.statementRet.setLine(((StContext)_localctx).e.expressionRet.getLine()); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(232);
				((StContext)_localctx).mc = methodcall();
				 ((StContext)_localctx).statementRet =  new MethodCallStmt(((StContext)_localctx).mc.methodCallRet); 
				setState(234);
				match(SEMI);
				 _localctx.statementRet.setLine(((StContext)_localctx).mc.methodCallRet.getLine()); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(237);
				((StContext)_localctx).ifs = ifStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).ifs.ifStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).ifs.ifStmtRet.getLine()); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(241);
				((StContext)_localctx).fs = forStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(242);
				((StContext)_localctx).ws = whileStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(243);
				((StContext)_localctx).as = assignStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).as.assignStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).as.assignStmtRet.getLine()); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(247);
				((StContext)_localctx).rs = returnStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).rs.returnStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).rs.returnStmtRet.getLine()); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(251);
				((StContext)_localctx).is = inputStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).is.inputStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).is.inputStmtRet.getLine()); 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(255);
				((StContext)_localctx).os = outputStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).os.outputStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).os.outputStmtRet.getLine()); 
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(259);
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
	}

	public final JumpStmtContext jumpStmt() throws RecognitionException {
		JumpStmtContext _localctx = new JumpStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_jumpStmt);
		try {
			setState(271);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_BREAK:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				((JumpStmtContext)_localctx).kb = match(KW_BREAK);
				 ((JumpStmtContext)_localctx).jumpStmtRet =  new BreakJump(); 
				 _localctx.jumpStmtRet.setLine((((JumpStmtContext)_localctx).kb!=null?((JumpStmtContext)_localctx).kb.getLine():0)); 
				}
				break;
			case KW_CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
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
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			((IfStmtContext)_localctx).k = match(KW_IF);
			setState(274);
			match(LPAREN);
			setState(275);
			((IfStmtContext)_localctx).e = expr(0);
			setState(276);
			match(RPAREN);
			setState(277);
			((IfStmtContext)_localctx).s1 = st();
			 ((IfStmtContext)_localctx).ifStmtRet =  new IfStmt(((IfStmtContext)_localctx).e.expressionRet, ((IfStmtContext)_localctx).s1.statementRet); 
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(279);
				match(KW_ELSE);
				setState(280);
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
		public TerminalNode KW_FOR() { return getToken(SimpleLangParser.KW_FOR, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(SimpleLangParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(SimpleLangParser.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public StContext st() {
			return getRuleContext(StContext.class,0);
		}
		public List<InitexprContext> initexpr() {
			return getRuleContexts(InitexprContext.class);
		}
		public InitexprContext initexpr(int i) {
			return getRuleContext(InitexprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<LocContext> loc() {
			return getRuleContexts(LocContext.class);
		}
		public LocContext loc(int i) {
			return getRuleContext(LocContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(SimpleLangParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SimpleLangParser.ASSIGN, i);
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
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(KW_FOR);
			setState(288);
			match(LPAREN);
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398813576960L) != 0)) {
				{
				setState(289);
				initexpr();
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(290);
					match(COMMA);
					setState(291);
					initexpr();
					}
					}
					setState(296);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(299);
			match(SEMI);
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(300);
				expr(0);
				}
			}

			setState(303);
			match(SEMI);
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_THIS || _la==ID) {
				{
				setState(304);
				loc();
				setState(305);
				match(ASSIGN);
				setState(306);
				expr(0);
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(307);
					match(COMMA);
					setState(308);
					loc();
					setState(309);
					match(ASSIGN);
					setState(310);
					expr(0);
					}
					}
					setState(316);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(319);
			match(RPAREN);
			setState(320);
			st();
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
		public TerminalNode KW_WHILE() { return getToken(SimpleLangParser.KW_WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
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
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(KW_WHILE);
			setState(323);
			match(LPAREN);
			setState(324);
			expr(0);
			setState(325);
			match(RPAREN);
			setState(326);
			st();
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
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			((AssignStmtContext)_localctx).l = loc();
			setState(329);
			((AssignStmtContext)_localctx).a = match(ASSIGN);
			setState(330);
			((AssignStmtContext)_localctx).e = expr(0);
			 ((AssignStmtContext)_localctx).assignStmtRet =  new AssignStmt(((AssignStmtContext)_localctx).l.locationRet, ((AssignStmtContext)_localctx).e.expressionRet); 
			setState(332);
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
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ReturnStmtContext)_localctx).returnStmtRet =  new ReturnStmt(); 
			setState(336);
			((ReturnStmtContext)_localctx).k = match(KW_RETURN);
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(337);
				((ReturnStmtContext)_localctx).e = expr(0);
				 _localctx.returnStmtRet.setValue(((ReturnStmtContext)_localctx).e.expressionRet); 
				}
			}

			setState(342);
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
	}

	public final InputStmtContext inputStmt() throws RecognitionException {
		InputStmtContext _localctx = new InputStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_inputStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			((InputStmtContext)_localctx).k = match(KW_INPUT);
			setState(346);
			((InputStmtContext)_localctx).l = loc();
			 ((InputStmtContext)_localctx).inputStmtRet =  new InputStmt(((InputStmtContext)_localctx).l.locationRet); 
			setState(348);
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
	}

	public final OutputStmtContext outputStmt() throws RecognitionException {
		OutputStmtContext _localctx = new OutputStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_outputStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			((OutputStmtContext)_localctx).k = match(KW_OUTPUT);
			setState(352);
			((OutputStmtContext)_localctx).e = expr(0);
			 ((OutputStmtContext)_localctx).outputStmtRet =  new OutputStmt(((OutputStmtContext)_localctx).e.expressionRet); 
			setState(354);
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
	}

	public final LocContext loc() throws RecognitionException {
		LocContext _localctx = new LocContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_loc);
		try {
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(357);
				((LocContext)_localctx).s = simpleLoc();
				 ((LocContext)_localctx).locationRet =  ((LocContext)_localctx).s.simpleLocRet; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(360);
				((LocContext)_localctx).m = memberLoc();
				 ((LocContext)_localctx).locationRet =  ((LocContext)_localctx).m.memberLocRet; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(363);
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
	}

	public final SimpleLocContext simpleLoc() throws RecognitionException {
		SimpleLocContext _localctx = new SimpleLocContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_simpleLoc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
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
	}

	public final MemberLocContext memberLoc() throws RecognitionException {
		MemberLocContext _localctx = new MemberLocContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_memberLoc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			((MemberLocContext)_localctx).i = match(ID);
			setState(374);
			match(DOT);
			setState(375);
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
	}

	public final ThisLocContext thisLoc() throws RecognitionException {
		ThisLocContext _localctx = new ThisLocContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_thisLoc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ThisLocContext)_localctx).thisLocRet =  new ThisLoc(); 
			setState(380);
			((ThisLocContext)_localctx).k = match(KW_THIS);
			setState(385);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(381);
				match(DOT);
				setState(382);
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
	}

	public final MethodcallContext methodcall() throws RecognitionException {
		MethodcallContext _localctx = new MethodcallContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_methodcall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((MethodcallContext)_localctx).methodCallRet =  new MethodCall(); 
			setState(394);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(390);
				((MethodcallContext)_localctx).l = loc();
				setState(391);
				match(DOT);
				_localctx.methodCallRet.setInstance(((MethodcallContext)_localctx).l.locationRet); 
				}
				break;
			}
			setState(396);
			((MethodcallContext)_localctx).i = match(ID);
			 _localctx.methodCallRet.setCallee(new Identifier((((MethodcallContext)_localctx).i!=null?((MethodcallContext)_localctx).i.getText():null))); 
			setState(398);
			match(LPAREN);
			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(399);
				((MethodcallContext)_localctx).e1 = expr(0);
				 _localctx.methodCallRet.addArgument(((MethodcallContext)_localctx).e1.expressionRet);
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(401);
					match(COMMA);
					setState(402);
					((MethodcallContext)_localctx).e2 = expr(0);
					 _localctx.methodCallRet.addArgument(((MethodcallContext)_localctx).e2.expressionRet); 
					}
					}
					setState(409);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(412);
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
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
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
			setState(431);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(416);
				loc();
				}
				break;
			case 2:
				{
				setState(417);
				match(KW_THIS);
				}
				break;
			case 3:
				{
				setState(418);
				methodcall();
				}
				break;
			case 4:
				{
				setState(419);
				cons();
				}
				break;
			case 5:
				{
				setState(420);
				match(LPAREN);
				setState(421);
				expr(0);
				setState(422);
				match(RPAREN);
				}
				break;
			case 6:
				{
				setState(424);
				match(CONSTINT);
				}
				break;
			case 7:
				{
				setState(425);
				match(CONSTFLOAT);
				}
				break;
			case 8:
				{
				setState(426);
				match(CONSTDOUBLE);
				}
				break;
			case 9:
				{
				setState(427);
				match(CONSTCHAR);
				}
				break;
			case 10:
				{
				setState(428);
				match(CONSTBOOL);
				}
				break;
			case 11:
				{
				setState(429);
				_la = _input.LA(1);
				if ( !(_la==KW_NOT || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(430);
				expr(7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(453);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(451);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(433);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(434);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==SLASH) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(435);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(436);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(437);
						_la = _input.LA(1);
						if ( !(_la==MINUS || _la==PLUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(438);
						expr(6);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(439);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(440);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 263882790666240L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(441);
						expr(5);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(442);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(443);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(444);
						expr(4);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(445);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(446);
						match(KW_AND);
						setState(447);
						expr(3);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(448);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(449);
						match(KW_OR);
						setState(450);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(455);
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
	}

	public final InitexprContext initexpr() throws RecognitionException {
		InitexprContext _localctx = new InitexprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_initexpr);
		try {
			setState(473);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(456);
				((InitexprContext)_localctx).v1 = vardecl();
				 ((InitexprContext)_localctx).initExprRet =  new VarDeclStmt(((InitexprContext)_localctx).v1.varRet); 
				 _localctx.initExprRet.setLine(((InitexprContext)_localctx).v1.varRet.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(460);
				((InitexprContext)_localctx).l1 = loc();
				setState(461);
				match(ASSIGN);
				setState(462);
				((InitexprContext)_localctx).e1 = expr(0);
				 ((InitexprContext)_localctx).initExprRet =  new AssignStmt(((InitexprContext)_localctx).l1.locationRet, ((InitexprContext)_localctx).e1.expressionRet); 
				 _localctx.initExprRet.setLine(((InitexprContext)_localctx).l1.locationRet.getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(466);
				((InitexprContext)_localctx).v2 = vardecl();
				 ((InitexprContext)_localctx).initExprRet =  new VarDeclStmt(((InitexprContext)_localctx).v2.varRet); 
				setState(468);
				match(ASSIGN);
				setState(469);
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
		"\u0004\u00019\u01dc\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000?\b\u0000\n\u0000\f\u0000B\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001L\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"W\b\u0002\n\u0002\f\u0002Z\t\u0002\u0003\u0002\\\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002`\b\u0002\n\u0002\f\u0002c\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003k\b"+
		"\u0003\n\u0003\f\u0003n\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0003"+
		"\u0004s\b\u0004\u0001\u0004\u0001\u0004\u0003\u0004w\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004|\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u0082\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007\u0094\b\u0007\n\u0007\f\u0007\u0097"+
		"\t\u0007\u0003\u0007\u0099\b\u0007\u0001\b\u0001\b\u0001\b\u0003\b\u009e"+
		"\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u00aa\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u00b2\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u00c1\b\u000b\n\u000b\f\u000b\u00c4\t\u000b"+
		"\u0003\u000b\u00c6\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00d0\b\f\n\f\f\f\u00d3\t\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0108\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u0110\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u011c\b\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u0125\b\u0010\n\u0010\f\u0010\u0128"+
		"\t\u0010\u0003\u0010\u012a\b\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u012e\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0139\b\u0010"+
		"\n\u0010\f\u0010\u013c\t\u0010\u0003\u0010\u013e\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u0155\b\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0170"+
		"\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0182"+
		"\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0003\u001a\u018b\b\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0005\u001a\u0196\b\u001a\n\u001a\f\u001a\u0199\t\u001a\u0003\u001a"+
		"\u019b\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0003\u001b\u01b0\b\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u01c4\b\u001b"+
		"\n\u001b\f\u001b\u01c7\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u01da\b\u001c\u0001\u001c\u0000\u00016"+
		"\u001d\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468\u0000\u0006\u0003\u0000\b\f\u001c\u001c"+
		"66\u0002\u0000\u0016\u0016\'\'\u0001\u0000)*\u0001\u0000\'(\u0001\u0000"+
		",/\u0001\u000001\u01fb\u0000:\u0001\u0000\u0000\u0000\u0002K\u0001\u0000"+
		"\u0000\u0000\u0004M\u0001\u0000\u0000\u0000\u0006f\u0001\u0000\u0000\u0000"+
		"\b{\u0001\u0000\u0000\u0000\n\u0081\u0001\u0000\u0000\u0000\f\u0083\u0001"+
		"\u0000\u0000\u0000\u000e\u008c\u0001\u0000\u0000\u0000\u0010\u009a\u0001"+
		"\u0000\u0000\u0000\u0012\u00a4\u0001\u0000\u0000\u0000\u0014\u00a6\u0001"+
		"\u0000\u0000\u0000\u0016\u00b7\u0001\u0000\u0000\u0000\u0018\u00ca\u0001"+
		"\u0000\u0000\u0000\u001a\u0107\u0001\u0000\u0000\u0000\u001c\u010f\u0001"+
		"\u0000\u0000\u0000\u001e\u0111\u0001\u0000\u0000\u0000 \u011f\u0001\u0000"+
		"\u0000\u0000\"\u0142\u0001\u0000\u0000\u0000$\u0148\u0001\u0000\u0000"+
		"\u0000&\u014f\u0001\u0000\u0000\u0000(\u0159\u0001\u0000\u0000\u0000*"+
		"\u015f\u0001\u0000\u0000\u0000,\u016f\u0001\u0000\u0000\u0000.\u0171\u0001"+
		"\u0000\u0000\u00000\u0175\u0001\u0000\u0000\u00002\u017b\u0001\u0000\u0000"+
		"\u00004\u0185\u0001\u0000\u0000\u00006\u01af\u0001\u0000\u0000\u00008"+
		"\u01d9\u0001\u0000\u0000\u0000:@\u0006\u0000\uffff\uffff\u0000;<\u0003"+
		"\u0002\u0001\u0000<=\u0006\u0000\uffff\uffff\u0000=?\u0001\u0000\u0000"+
		"\u0000>;\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000"+
		"\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000B@\u0001"+
		"\u0000\u0000\u0000CD\u0005\u0000\u0000\u0001D\u0001\u0001\u0000\u0000"+
		"\u0000EF\u0003\u0004\u0002\u0000FG\u0006\u0001\uffff\uffff\u0000GL\u0001"+
		"\u0000\u0000\u0000HI\u0003\u0006\u0003\u0000IJ\u0006\u0001\uffff\uffff"+
		"\u0000JL\u0001\u0000\u0000\u0000KE\u0001\u0000\u0000\u0000KH\u0001\u0000"+
		"\u0000\u0000L\u0003\u0001\u0000\u0000\u0000MN\u0005\u0001\u0000\u0000"+
		"NO\u00056\u0000\u0000O[\u0006\u0002\uffff\uffff\u0000PQ\u0005\u0003\u0000"+
		"\u0000QR\u00056\u0000\u0000RX\u0006\u0002\uffff\uffff\u0000ST\u0005\u001f"+
		"\u0000\u0000TU\u00056\u0000\u0000UW\u0006\u0002\uffff\uffff\u0000VS\u0001"+
		"\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000"+
		"XY\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000"+
		"\u0000[P\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000"+
		"\u0000\u0000]a\u0005\u0004\u0000\u0000^`\u0003\b\u0004\u0000_^\u0001\u0000"+
		"\u0000\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001"+
		"\u0000\u0000\u0000bd\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000"+
		"de\u0005\u0005\u0000\u0000e\u0005\u0001\u0000\u0000\u0000fg\u0005\u0002"+
		"\u0000\u0000gh\u00056\u0000\u0000hl\u0005\u0004\u0000\u0000ik\u0003\b"+
		"\u0004\u0000ji\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000\u0000lj\u0001"+
		"\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mo\u0001\u0000\u0000\u0000"+
		"nl\u0001\u0000\u0000\u0000op\u0005\u0005\u0000\u0000p\u0007\u0001\u0000"+
		"\u0000\u0000qs\u0003\n\u0005\u0000rq\u0001\u0000\u0000\u0000rs\u0001\u0000"+
		"\u0000\u0000st\u0001\u0000\u0000\u0000t|\u0003\f\u0006\u0000uw\u0003\n"+
		"\u0005\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000xy\u0003\u0014\n\u0000yz\u0005\u001e\u0000\u0000z|\u0001"+
		"\u0000\u0000\u0000{r\u0001\u0000\u0000\u0000{v\u0001\u0000\u0000\u0000"+
		"|\t\u0001\u0000\u0000\u0000}~\u0005\u0007\u0000\u0000~\u0082\u0006\u0005"+
		"\uffff\uffff\u0000\u007f\u0080\u0005\u0006\u0000\u0000\u0080\u0082\u0006"+
		"\u0005\uffff\uffff\u0000\u0081}\u0001\u0000\u0000\u0000\u0081\u007f\u0001"+
		"\u0000\u0000\u0000\u0082\u000b\u0001\u0000\u0000\u0000\u0083\u0084\u0003"+
		"\u0012\t\u0000\u0084\u0085\u00056\u0000\u0000\u0085\u0086\u0005 \u0000"+
		"\u0000\u0086\u0087\u0003\u000e\u0007\u0000\u0087\u0088\u0005!\u0000\u0000"+
		"\u0088\u0089\u0003\u0018\f\u0000\u0089\u008a\u0006\u0006\uffff\uffff\u0000"+
		"\u008a\u008b\u0006\u0006\uffff\uffff\u0000\u008b\r\u0001\u0000\u0000\u0000"+
		"\u008c\u0098\u0006\u0007\uffff\uffff\u0000\u008d\u008e\u0003\u0010\b\u0000"+
		"\u008e\u0095\u0006\u0007\uffff\uffff\u0000\u008f\u0090\u0005\u001f\u0000"+
		"\u0000\u0090\u0091\u0003\u0010\b\u0000\u0091\u0092\u0006\u0007\uffff\uffff"+
		"\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093\u008f\u0001\u0000\u0000"+
		"\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000"+
		"\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098\u008d\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u000f\u0001\u0000\u0000"+
		"\u0000\u009a\u009d\u0006\b\uffff\uffff\u0000\u009b\u009c\u0005\u0019\u0000"+
		"\u0000\u009c\u009e\u0006\b\uffff\uffff\u0000\u009d\u009b\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000"+
		"\u0000\u009f\u00a0\u0003\u0012\t\u0000\u00a0\u00a1\u00056\u0000\u0000"+
		"\u00a1\u00a2\u0006\b\uffff\uffff\u0000\u00a2\u00a3\u0006\b\uffff\uffff"+
		"\u0000\u00a3\u0011\u0001\u0000\u0000\u0000\u00a4\u00a5\u0007\u0000\u0000"+
		"\u0000\u00a5\u0013\u0001\u0000\u0000\u0000\u00a6\u00a9\u0006\n\uffff\uffff"+
		"\u0000\u00a7\u00a8\u0005\u0019\u0000\u0000\u00a8\u00aa\u0006\n\uffff\uffff"+
		"\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000"+
		"\u0000\u00aa\u00b1\u0001\u0000\u0000\u0000\u00ab\u00ac\u0003\u0012\t\u0000"+
		"\u00ac\u00ad\u0006\n\uffff\uffff\u0000\u00ad\u00b2\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0003\u0016\u000b\u0000\u00af\u00b0\u0006\n\uffff\uffff\u0000"+
		"\u00b0\u00b2\u0001\u0000\u0000\u0000\u00b1\u00ab\u0001\u0000\u0000\u0000"+
		"\u00b1\u00ae\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b4\u00056\u0000\u0000\u00b4\u00b5\u0006\n\uffff\uffff\u0000"+
		"\u00b5\u00b6\u0006\n\uffff\uffff\u0000\u00b6\u0015\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u00056\u0000\u0000\u00b8\u00b9\u0006\u000b\uffff\uffff\u0000"+
		"\u00b9\u00c5\u0005 \u0000\u0000\u00ba\u00bb\u00036\u001b\u0000\u00bb\u00c2"+
		"\u0006\u000b\uffff\uffff\u0000\u00bc\u00bd\u0005\u001f\u0000\u0000\u00bd"+
		"\u00be\u00036\u001b\u0000\u00be\u00bf\u0006\u000b\uffff\uffff\u0000\u00bf"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c0\u00bc\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c5\u00ba\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c8\u0005!\u0000\u0000\u00c8\u00c9\u0006\u000b\uffff\uffff\u0000\u00c9"+
		"\u0017\u0001\u0000\u0000\u0000\u00ca\u00cb\u0006\f\uffff\uffff\u0000\u00cb"+
		"\u00d1\u0005\u0004\u0000\u0000\u00cc\u00cd\u0003\u001a\r\u0000\u00cd\u00ce"+
		"\u0006\f\uffff\uffff\u0000\u00ce\u00d0\u0001\u0000\u0000\u0000\u00cf\u00cc"+
		"\u0001\u0000\u0000\u0000\u00d0\u00d3\u0001\u0000\u0000\u0000\u00d1\u00cf"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d5"+
		"\u0005\u0005\u0000\u0000\u00d5\u00d6\u0006\f\uffff\uffff\u0000\u00d6\u0019"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d8\u0003\u0018\f\u0000\u00d8\u00d9\u0006"+
		"\r\uffff\uffff\u0000\u00d9\u00da\u0006\r\uffff\uffff\u0000\u00da\u0108"+
		"\u0001\u0000\u0000\u0000\u00db\u00dc\u0003\u0014\n\u0000\u00dc\u00dd\u0006"+
		"\r\uffff\uffff\u0000\u00dd\u00de\u0005\u001e\u0000\u0000\u00de\u00df\u0006"+
		"\r\uffff\uffff\u0000\u00df\u0108\u0001\u0000\u0000\u0000\u00e0\u00e1\u0003"+
		"\u0014\n\u0000\u00e1\u00e2\u0006\r\uffff\uffff\u0000\u00e2\u00e3\u0005"+
		"$\u0000\u0000\u00e3\u00e4\u00036\u001b\u0000\u00e4\u00e5\u0006\r\uffff"+
		"\uffff\u0000\u00e5\u00e6\u0005\u001e\u0000\u0000\u00e6\u00e7\u0006\r\uffff"+
		"\uffff\u0000\u00e7\u0108\u0001\u0000\u0000\u0000\u00e8\u00e9\u00034\u001a"+
		"\u0000\u00e9\u00ea\u0006\r\uffff\uffff\u0000\u00ea\u00eb\u0005\u001e\u0000"+
		"\u0000\u00eb\u00ec\u0006\r\uffff\uffff\u0000\u00ec\u0108\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ee\u0003\u001e\u000f\u0000\u00ee\u00ef\u0006\r\uffff\uffff"+
		"\u0000\u00ef\u00f0\u0006\r\uffff\uffff\u0000\u00f0\u0108\u0001\u0000\u0000"+
		"\u0000\u00f1\u0108\u0003 \u0010\u0000\u00f2\u0108\u0003\"\u0011\u0000"+
		"\u00f3\u00f4\u0003$\u0012\u0000\u00f4\u00f5\u0006\r\uffff\uffff\u0000"+
		"\u00f5\u00f6\u0006\r\uffff\uffff\u0000\u00f6\u0108\u0001\u0000\u0000\u0000"+
		"\u00f7\u00f8\u0003&\u0013\u0000\u00f8\u00f9\u0006\r\uffff\uffff\u0000"+
		"\u00f9\u00fa\u0006\r\uffff\uffff\u0000\u00fa\u0108\u0001\u0000\u0000\u0000"+
		"\u00fb\u00fc\u0003(\u0014\u0000\u00fc\u00fd\u0006\r\uffff\uffff\u0000"+
		"\u00fd\u00fe\u0006\r\uffff\uffff\u0000\u00fe\u0108\u0001\u0000\u0000\u0000"+
		"\u00ff\u0100\u0003*\u0015\u0000\u0100\u0101\u0006\r\uffff\uffff\u0000"+
		"\u0101\u0102\u0006\r\uffff\uffff\u0000\u0102\u0108\u0001\u0000\u0000\u0000"+
		"\u0103\u0104\u0003\u001c\u000e\u0000\u0104\u0105\u0006\r\uffff\uffff\u0000"+
		"\u0105\u0106\u0006\r\uffff\uffff\u0000\u0106\u0108\u0001\u0000\u0000\u0000"+
		"\u0107\u00d7\u0001\u0000\u0000\u0000\u0107\u00db\u0001\u0000\u0000\u0000"+
		"\u0107\u00e0\u0001\u0000\u0000\u0000\u0107\u00e8\u0001\u0000\u0000\u0000"+
		"\u0107\u00ed\u0001\u0000\u0000\u0000\u0107\u00f1\u0001\u0000\u0000\u0000"+
		"\u0107\u00f2\u0001\u0000\u0000\u0000\u0107\u00f3\u0001\u0000\u0000\u0000"+
		"\u0107\u00f7\u0001\u0000\u0000\u0000\u0107\u00fb\u0001\u0000\u0000\u0000"+
		"\u0107\u00ff\u0001\u0000\u0000\u0000\u0107\u0103\u0001\u0000\u0000\u0000"+
		"\u0108\u001b\u0001\u0000\u0000\u0000\u0109\u010a\u0005\u001a\u0000\u0000"+
		"\u010a\u010b\u0006\u000e\uffff\uffff\u0000\u010b\u0110\u0006\u000e\uffff"+
		"\uffff\u0000\u010c\u010d\u0005\u001b\u0000\u0000\u010d\u010e\u0006\u000e"+
		"\uffff\uffff\u0000\u010e\u0110\u0006\u000e\uffff\uffff\u0000\u010f\u0109"+
		"\u0001\u0000\u0000\u0000\u010f\u010c\u0001\u0000\u0000\u0000\u0110\u001d"+
		"\u0001\u0000\u0000\u0000\u0111\u0112\u0005\r\u0000\u0000\u0112\u0113\u0005"+
		" \u0000\u0000\u0113\u0114\u00036\u001b\u0000\u0114\u0115\u0005!\u0000"+
		"\u0000\u0115\u0116\u0003\u001a\r\u0000\u0116\u011b\u0006\u000f\uffff\uffff"+
		"\u0000\u0117\u0118\u0005\u000e\u0000\u0000\u0118\u0119\u0003\u001a\r\u0000"+
		"\u0119\u011a\u0006\u000f\uffff\uffff\u0000\u011a\u011c\u0001\u0000\u0000"+
		"\u0000\u011b\u0117\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000"+
		"\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u011e\u0006\u000f\uffff"+
		"\uffff\u0000\u011e\u001f\u0001\u0000\u0000\u0000\u011f\u0120\u0005\u000f"+
		"\u0000\u0000\u0120\u0129\u0005 \u0000\u0000\u0121\u0126\u00038\u001c\u0000"+
		"\u0122\u0123\u0005\u001f\u0000\u0000\u0123\u0125\u00038\u001c\u0000\u0124"+
		"\u0122\u0001\u0000\u0000\u0000\u0125\u0128\u0001\u0000\u0000\u0000\u0126"+
		"\u0124\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127"+
		"\u012a\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0129"+
		"\u0121\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a"+
		"\u012b\u0001\u0000\u0000\u0000\u012b\u012d\u0005\u001e\u0000\u0000\u012c"+
		"\u012e\u00036\u001b\u0000\u012d\u012c\u0001\u0000\u0000\u0000\u012d\u012e"+
		"\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u013d"+
		"\u0005\u001e\u0000\u0000\u0130\u0131\u0003,\u0016\u0000\u0131\u0132\u0005"+
		"$\u0000\u0000\u0132\u013a\u00036\u001b\u0000\u0133\u0134\u0005\u001f\u0000"+
		"\u0000\u0134\u0135\u0003,\u0016\u0000\u0135\u0136\u0005$\u0000\u0000\u0136"+
		"\u0137\u00036\u001b\u0000\u0137\u0139\u0001\u0000\u0000\u0000\u0138\u0133"+
		"\u0001\u0000\u0000\u0000\u0139\u013c\u0001\u0000\u0000\u0000\u013a\u0138"+
		"\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013e"+
		"\u0001\u0000\u0000\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013d\u0130"+
		"\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e\u013f"+
		"\u0001\u0000\u0000\u0000\u013f\u0140\u0005!\u0000\u0000\u0140\u0141\u0003"+
		"\u001a\r\u0000\u0141!\u0001\u0000\u0000\u0000\u0142\u0143\u0005\u0010"+
		"\u0000\u0000\u0143\u0144\u0005 \u0000\u0000\u0144\u0145\u00036\u001b\u0000"+
		"\u0145\u0146\u0005!\u0000\u0000\u0146\u0147\u0003\u001a\r\u0000\u0147"+
		"#\u0001\u0000\u0000\u0000\u0148\u0149\u0003,\u0016\u0000\u0149\u014a\u0005"+
		"$\u0000\u0000\u014a\u014b\u00036\u001b\u0000\u014b\u014c\u0006\u0012\uffff"+
		"\uffff\u0000\u014c\u014d\u0005\u001e\u0000\u0000\u014d\u014e\u0006\u0012"+
		"\uffff\uffff\u0000\u014e%\u0001\u0000\u0000\u0000\u014f\u0150\u0006\u0013"+
		"\uffff\uffff\u0000\u0150\u0154\u0005\u0012\u0000\u0000\u0151\u0152\u0003"+
		"6\u001b\u0000\u0152\u0153\u0006\u0013\uffff\uffff\u0000\u0153\u0155\u0001"+
		"\u0000\u0000\u0000\u0154\u0151\u0001\u0000\u0000\u0000\u0154\u0155\u0001"+
		"\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000\u0156\u0157\u0005"+
		"\u001e\u0000\u0000\u0157\u0158\u0006\u0013\uffff\uffff\u0000\u0158\'\u0001"+
		"\u0000\u0000\u0000\u0159\u015a\u0005\u0013\u0000\u0000\u015a\u015b\u0003"+
		",\u0016\u0000\u015b\u015c\u0006\u0014\uffff\uffff\u0000\u015c\u015d\u0005"+
		"\u001e\u0000\u0000\u015d\u015e\u0006\u0014\uffff\uffff\u0000\u015e)\u0001"+
		"\u0000\u0000\u0000\u015f\u0160\u0005\u0014\u0000\u0000\u0160\u0161\u0003"+
		"6\u001b\u0000\u0161\u0162\u0006\u0015\uffff\uffff\u0000\u0162\u0163\u0005"+
		"\u001e\u0000\u0000\u0163\u0164\u0006\u0015\uffff\uffff\u0000\u0164+\u0001"+
		"\u0000\u0000\u0000\u0165\u0166\u0003.\u0017\u0000\u0166\u0167\u0006\u0016"+
		"\uffff\uffff\u0000\u0167\u0170\u0001\u0000\u0000\u0000\u0168\u0169\u0003"+
		"0\u0018\u0000\u0169\u016a\u0006\u0016\uffff\uffff\u0000\u016a\u0170\u0001"+
		"\u0000\u0000\u0000\u016b\u016c\u00032\u0019\u0000\u016c\u016d\u0006\u0016"+
		"\uffff\uffff\u0000\u016d\u016e\u0006\u0016\uffff\uffff\u0000\u016e\u0170"+
		"\u0001\u0000\u0000\u0000\u016f\u0165\u0001\u0000\u0000\u0000\u016f\u0168"+
		"\u0001\u0000\u0000\u0000\u016f\u016b\u0001\u0000\u0000\u0000\u0170-\u0001"+
		"\u0000\u0000\u0000\u0171\u0172\u00056\u0000\u0000\u0172\u0173\u0006\u0017"+
		"\uffff\uffff\u0000\u0173\u0174\u0006\u0017\uffff\uffff\u0000\u0174/\u0001"+
		"\u0000\u0000\u0000\u0175\u0176\u00056\u0000\u0000\u0176\u0177\u0005%\u0000"+
		"\u0000\u0177\u0178\u0003,\u0016\u0000\u0178\u0179\u0006\u0018\uffff\uffff"+
		"\u0000\u0179\u017a\u0006\u0018\uffff\uffff\u0000\u017a1\u0001\u0000\u0000"+
		"\u0000\u017b\u017c\u0006\u0019\uffff\uffff\u0000\u017c\u0181\u0005\u0015"+
		"\u0000\u0000\u017d\u017e\u0005%\u0000\u0000\u017e\u017f\u0003,\u0016\u0000"+
		"\u017f\u0180\u0006\u0019\uffff\uffff\u0000\u0180\u0182\u0001\u0000\u0000"+
		"\u0000\u0181\u017d\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000\u0000"+
		"\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0183\u0184\u0006\u0019\uffff"+
		"\uffff\u0000\u01843\u0001\u0000\u0000\u0000\u0185\u018a\u0006\u001a\uffff"+
		"\uffff\u0000\u0186\u0187\u0003,\u0016\u0000\u0187\u0188\u0005%\u0000\u0000"+
		"\u0188\u0189\u0006\u001a\uffff\uffff\u0000\u0189\u018b\u0001\u0000\u0000"+
		"\u0000\u018a\u0186\u0001\u0000\u0000\u0000\u018a\u018b\u0001\u0000\u0000"+
		"\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u018d\u00056\u0000\u0000"+
		"\u018d\u018e\u0006\u001a\uffff\uffff\u0000\u018e\u019a\u0005 \u0000\u0000"+
		"\u018f\u0190\u00036\u001b\u0000\u0190\u0197\u0006\u001a\uffff\uffff\u0000"+
		"\u0191\u0192\u0005\u001f\u0000\u0000\u0192\u0193\u00036\u001b\u0000\u0193"+
		"\u0194\u0006\u001a\uffff\uffff\u0000\u0194\u0196\u0001\u0000\u0000\u0000"+
		"\u0195\u0191\u0001\u0000\u0000\u0000\u0196\u0199\u0001\u0000\u0000\u0000"+
		"\u0197\u0195\u0001\u0000\u0000\u0000\u0197\u0198\u0001\u0000\u0000\u0000"+
		"\u0198\u019b\u0001\u0000\u0000\u0000\u0199\u0197\u0001\u0000\u0000\u0000"+
		"\u019a\u018f\u0001\u0000\u0000\u0000\u019a\u019b\u0001\u0000\u0000\u0000"+
		"\u019b\u019c\u0001\u0000\u0000\u0000\u019c\u019d\u0005!\u0000\u0000\u019d"+
		"\u019e\u0006\u001a\uffff\uffff\u0000\u019e5\u0001\u0000\u0000\u0000\u019f"+
		"\u01a0\u0006\u001b\uffff\uffff\u0000\u01a0\u01b0\u0003,\u0016\u0000\u01a1"+
		"\u01b0\u0005\u0015\u0000\u0000\u01a2\u01b0\u00034\u001a\u0000\u01a3\u01b0"+
		"\u0003\u0016\u000b\u0000\u01a4\u01a5\u0005 \u0000\u0000\u01a5\u01a6\u0003"+
		"6\u001b\u0000\u01a6\u01a7\u0005!\u0000\u0000\u01a7\u01b0\u0001\u0000\u0000"+
		"\u0000\u01a8\u01b0\u00052\u0000\u0000\u01a9\u01b0\u00053\u0000\u0000\u01aa"+
		"\u01b0\u00054\u0000\u0000\u01ab\u01b0\u00055\u0000\u0000\u01ac\u01b0\u0005"+
		"\u001d\u0000\u0000\u01ad\u01ae\u0007\u0001\u0000\u0000\u01ae\u01b0\u0003"+
		"6\u001b\u0007\u01af\u019f\u0001\u0000\u0000\u0000\u01af\u01a1\u0001\u0000"+
		"\u0000\u0000\u01af\u01a2\u0001\u0000\u0000\u0000\u01af\u01a3\u0001\u0000"+
		"\u0000\u0000\u01af\u01a4\u0001\u0000\u0000\u0000\u01af\u01a8\u0001\u0000"+
		"\u0000\u0000\u01af\u01a9\u0001\u0000\u0000\u0000\u01af\u01aa\u0001\u0000"+
		"\u0000\u0000\u01af\u01ab\u0001\u0000\u0000\u0000\u01af\u01ac\u0001\u0000"+
		"\u0000\u0000\u01af\u01ad\u0001\u0000\u0000\u0000\u01b0\u01c5\u0001\u0000"+
		"\u0000\u0000\u01b1\u01b2\n\u0006\u0000\u0000\u01b2\u01b3\u0007\u0002\u0000"+
		"\u0000\u01b3\u01c4\u00036\u001b\u0007\u01b4\u01b5\n\u0005\u0000\u0000"+
		"\u01b5\u01b6\u0007\u0003\u0000\u0000\u01b6\u01c4\u00036\u001b\u0006\u01b7"+
		"\u01b8\n\u0004\u0000\u0000\u01b8\u01b9\u0007\u0004\u0000\u0000\u01b9\u01c4"+
		"\u00036\u001b\u0005\u01ba\u01bb\n\u0003\u0000\u0000\u01bb\u01bc\u0007"+
		"\u0005\u0000\u0000\u01bc\u01c4\u00036\u001b\u0004\u01bd\u01be\n\u0002"+
		"\u0000\u0000\u01be\u01bf\u0005\u0017\u0000\u0000\u01bf\u01c4\u00036\u001b"+
		"\u0003\u01c0\u01c1\n\u0001\u0000\u0000\u01c1\u01c2\u0005\u0018\u0000\u0000"+
		"\u01c2\u01c4\u00036\u001b\u0002\u01c3\u01b1\u0001\u0000\u0000\u0000\u01c3"+
		"\u01b4\u0001\u0000\u0000\u0000\u01c3\u01b7\u0001\u0000\u0000\u0000\u01c3"+
		"\u01ba\u0001\u0000\u0000\u0000\u01c3\u01bd\u0001\u0000\u0000\u0000\u01c3"+
		"\u01c0\u0001\u0000\u0000\u0000\u01c4\u01c7\u0001\u0000\u0000\u0000\u01c5"+
		"\u01c3\u0001\u0000\u0000\u0000\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6"+
		"7\u0001\u0000\u0000\u0000\u01c7\u01c5\u0001\u0000\u0000\u0000\u01c8\u01c9"+
		"\u0003\u0014\n\u0000\u01c9\u01ca\u0006\u001c\uffff\uffff\u0000\u01ca\u01cb"+
		"\u0006\u001c\uffff\uffff\u0000\u01cb\u01da\u0001\u0000\u0000\u0000\u01cc"+
		"\u01cd\u0003,\u0016\u0000\u01cd\u01ce\u0005$\u0000\u0000\u01ce\u01cf\u0003"+
		"6\u001b\u0000\u01cf\u01d0\u0006\u001c\uffff\uffff\u0000\u01d0\u01d1\u0006"+
		"\u001c\uffff\uffff\u0000\u01d1\u01da\u0001\u0000\u0000\u0000\u01d2\u01d3"+
		"\u0003\u0014\n\u0000\u01d3\u01d4\u0006\u001c\uffff\uffff\u0000\u01d4\u01d5"+
		"\u0005$\u0000\u0000\u01d5\u01d6\u00036\u001b\u0000\u01d6\u01d7\u0006\u001c"+
		"\uffff\uffff\u0000\u01d7\u01d8\u0006\u001c\uffff\uffff\u0000\u01d8\u01da"+
		"\u0001\u0000\u0000\u0000\u01d9\u01c8\u0001\u0000\u0000\u0000\u01d9\u01cc"+
		"\u0001\u0000\u0000\u0000\u01d9\u01d2\u0001\u0000\u0000\u0000\u01da9\u0001"+
		"\u0000\u0000\u0000$@KX[alrv{\u0081\u0095\u0098\u009d\u00a9\u00b1\u00c2"+
		"\u00c5\u00d1\u0107\u010f\u011b\u0126\u0129\u012d\u013a\u013d\u0154\u016f"+
		"\u0181\u018a\u0197\u019a\u01af\u01c3\u01c5\u01d9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}