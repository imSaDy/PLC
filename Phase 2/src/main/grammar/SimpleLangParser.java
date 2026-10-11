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
		public MemberContext m;
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
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811480000L) != 0)) {
				{
				{
				setState(96);
				((ModuleContext)_localctx).m = member();
				 _localctx.moduleRet.addMember(((ModuleContext)_localctx).m.memberRet); 
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
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
		public MemberContext m;
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
			setState(106);
			((StructDefContext)_localctx).k = match(KW_STRUCT);
			setState(107);
			((StructDefContext)_localctx).i = match(ID);
			setState(108);
			match(KW_BEGIN);

			            ((StructDefContext)_localctx).structRet =  new Struct(new Identifier((((StructDefContext)_localctx).i!=null?((StructDefContext)_localctx).i.getText():null)));
			            _localctx.structRet.setLine((((StructDefContext)_localctx).k!=null?((StructDefContext)_localctx).k.getLine():0));
			        
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811480000L) != 0)) {
				{
				{
				setState(110);
				((StructDefContext)_localctx).m = member();
				 _localctx.structRet.addMember(((StructDefContext)_localctx).m.memberRet); 
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
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
		public Member memberRet;
		public AccessModifierContext a;
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
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_PUBLIC || _la==KW_PRIVATE) {
					{
					setState(120);
					((MemberContext)_localctx).a = accessModifier();
					}
				}

				setState(123);
				((MemberContext)_localctx).m = method_decl();

				            MethodDecl methodDecl = new MethodDecl();
				            methodDecl.setMethod(((MemberContext)_localctx).m.methodRet);
				            if (((MemberContext)_localctx).a != null) {
				                methodDecl.setAccessModifier(((MemberContext)_localctx).a.accessModifierRet);
				            }
				            ((MemberContext)_localctx).memberRet =  methodDecl;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_PUBLIC || _la==KW_PRIVATE) {
					{
					setState(126);
					((MemberContext)_localctx).a = accessModifier();
					}
				}

				setState(129);
				((MemberContext)_localctx).v = vardecl();
				setState(130);
				match(SEMI);

				            VarDecl varDecl = new VarDecl();
				            varDecl.setVar(((MemberContext)_localctx).v.varRet);
				            if (((MemberContext)_localctx).a != null) {
				                varDecl.setAccessModifier(((MemberContext)_localctx).a.accessModifierRet);
				            }
				            ((MemberContext)_localctx).memberRet =  varDecl;
				        
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
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_PRIVATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				((AccessModifierContext)_localctx).pr = match(KW_PRIVATE);
				 ((AccessModifierContext)_localctx).accessModifierRet =  AccessModifier.PRIVATE; 
				}
				break;
			case KW_PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
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
			setState(141);
			((Method_declContext)_localctx).t = type();
			setState(142);
			((Method_declContext)_localctx).i = match(ID);
			setState(143);
			match(LPAREN);
			setState(144);
			((Method_declContext)_localctx).a = arguments();
			setState(145);
			match(RPAREN);
			setState(146);
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
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811479808L) != 0)) {
				{
				setState(151);
				((ArgumentsContext)_localctx).p1 = parameter();
				 _localctx.parametersRet.add(((ArgumentsContext)_localctx).p1.parameterRet); 
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(153);
					match(COMMA);
					setState(154);
					((ArgumentsContext)_localctx).p2 = parameter();
					 _localctx.parametersRet.add(((ArgumentsContext)_localctx).p2.parameterRet); 
					}
					}
					setState(161);
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
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_MUT) {
				{
				setState(165);
				match(KW_MUT);
				 isMut = true; 
				}
			}

			setState(169);
			((ParameterContext)_localctx).t = type();
			setState(170);
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
		public Token i;
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
		try {
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				((TypeContext)_localctx).i = match(ID);
				 ((TypeContext)_localctx).typeRet =  new UserDefinedType(new Identifier((((TypeContext)_localctx).i!=null?((TypeContext)_localctx).i.getText():null))); 
				}
				break;
			case KW_INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(KW_INT);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType(PrimitiveType.Primitive.INT); 
				}
				break;
			case KW_FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				match(KW_FLOAT);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType(PrimitiveType.Primitive.FLOAT); 
				}
				break;
			case KW_DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(180);
				match(KW_DOUBLE);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType(PrimitiveType.Primitive.DOUBLE); 
				}
				break;
			case KW_CHAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(182);
				match(KW_CHAR);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType(PrimitiveType.Primitive.CHAR); 
				}
				break;
			case KW_VOID:
				enterOuterAlt(_localctx, 6);
				{
				setState(184);
				match(KW_VOID);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType(PrimitiveType.Primitive.VOID); 
				}
				break;
			case KW_BOOL:
				enterOuterAlt(_localctx, 7);
				{
				setState(186);
				match(KW_BOOL);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType(PrimitiveType.Primitive.BOOL); 
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
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_MUT) {
				{
				setState(191);
				match(KW_MUT);
				 isMut = true; 
				}
			}

			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(195);
				((VardeclContext)_localctx).t = type();
				 ((VardeclContext)_localctx).varRet =  new Var(isMut, ((VardeclContext)_localctx).t.typeRet); 
				}
				break;
			case 2:
				{
				setState(198);
				((VardeclContext)_localctx).c = cons();
				 ((VardeclContext)_localctx).varRet =  new Var(isMut, ((VardeclContext)_localctx).c.constructorCallRet); 
				}
				break;
			}
			setState(203);
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
			setState(207);
			((ConsContext)_localctx).i = match(ID);
			 ((ConsContext)_localctx).constructorCallRet =  new ConstructorCall(new Identifier((((ConsContext)_localctx).i!=null?((ConsContext)_localctx).i.getText():null))); 
			setState(209);
			match(LPAREN);
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(210);
				((ConsContext)_localctx).e1 = expr(0);
				 _localctx.constructorCallRet.addArgument(((ConsContext)_localctx).e1.expressionRet); 
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(212);
					match(COMMA);
					setState(213);
					((ConsContext)_localctx).e2 = expr(0);
					 _localctx.constructorCallRet.addArgument(((ConsContext)_localctx).e2.expressionRet); 
					}
					}
					setState(220);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(223);
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
			setState(227);
			((BlockContext)_localctx).k = match(KW_BEGIN);
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014399016845072L) != 0)) {
				{
				{
				setState(228);
				((BlockContext)_localctx).s = st();
				 _localctx.blockRet.addStatement(((BlockContext)_localctx).s.statementRet); 
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(236);
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
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				((StContext)_localctx).b = block();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).b.blockRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).b.blockRet.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				((StContext)_localctx).vd = vardecl();
				 ((StContext)_localctx).statementRet =  new VarDeclStmt(((StContext)_localctx).vd.varRet); 
				setState(245);
				match(SEMI);
				 _localctx.statementRet.setLine(((StContext)_localctx).vd.varRet.getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				((StContext)_localctx).v = vardecl();
				 ((StContext)_localctx).statementRet =  new VarDeclStmt(((StContext)_localctx).v.varRet); 
				setState(250);
				match(ASSIGN);
				setState(251);
				((StContext)_localctx).e = expr(0);
				 ((VarDeclStmt)_localctx.statementRet).setInitial(((StContext)_localctx).e.expressionRet); 
				setState(253);
				match(SEMI);
				 _localctx.statementRet.setLine(((StContext)_localctx).e.expressionRet.getLine()); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(256);
				((StContext)_localctx).mc = methodcall();
				 ((StContext)_localctx).statementRet =  new MethodCallStmt(((StContext)_localctx).mc.methodCallRet); 
				setState(258);
				match(SEMI);
				 _localctx.statementRet.setLine(((StContext)_localctx).mc.methodCallRet.getLine()); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(261);
				((StContext)_localctx).ifs = ifStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).ifs.ifStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).ifs.ifStmtRet.getLine()); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(265);
				((StContext)_localctx).fs = forStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(266);
				((StContext)_localctx).ws = whileStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(267);
				((StContext)_localctx).as = assignStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).as.assignStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).as.assignStmtRet.getLine()); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(271);
				((StContext)_localctx).rs = returnStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).rs.returnStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).rs.returnStmtRet.getLine()); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(275);
				((StContext)_localctx).is = inputStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).is.inputStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).is.inputStmtRet.getLine()); 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(279);
				((StContext)_localctx).os = outputStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).os.outputStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).os.outputStmtRet.getLine()); 
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(283);
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
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_BREAK:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				((JumpStmtContext)_localctx).kb = match(KW_BREAK);
				 ((JumpStmtContext)_localctx).jumpStmtRet =  new BreakJump(); 
				 _localctx.jumpStmtRet.setLine((((JumpStmtContext)_localctx).kb!=null?((JumpStmtContext)_localctx).kb.getLine():0)); 
				}
				break;
			case KW_CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
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
			setState(297);
			((IfStmtContext)_localctx).k = match(KW_IF);
			setState(298);
			match(LPAREN);
			setState(299);
			((IfStmtContext)_localctx).e = expr(0);
			setState(300);
			match(RPAREN);
			setState(301);
			((IfStmtContext)_localctx).s1 = st();
			 ((IfStmtContext)_localctx).ifStmtRet =  new IfStmt(((IfStmtContext)_localctx).e.expressionRet, ((IfStmtContext)_localctx).s1.statementRet); 
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(303);
				match(KW_ELSE);
				setState(304);
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
			setState(311);
			((ForStmtContext)_localctx).k = match(KW_FOR);

			            ((ForStmtContext)_localctx).forStmtRet =  new ForStmt();
			            _localctx.forStmtRet.setLine((((ForStmtContext)_localctx).k!=null?((ForStmtContext)_localctx).k.getLine():0));
			        
			setState(313);
			match(LPAREN);
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398813576960L) != 0)) {
				{
				setState(314);
				((ForStmtContext)_localctx).i1 = initexpr();
				 _localctx.forStmtRet.addInitializer(((ForStmtContext)_localctx).i1.initExprRet); 
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(316);
					match(COMMA);
					setState(317);
					((ForStmtContext)_localctx).i2 = initexpr();
					 _localctx.forStmtRet.addInitializer(((ForStmtContext)_localctx).i2.initExprRet); 
					}
					}
					setState(324);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(327);
			match(SEMI);
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(328);
				((ForStmtContext)_localctx).c = expr(0);
				 _localctx.forStmtRet.setCondition(((ForStmtContext)_localctx).c.expressionRet); 
				}
			}

			setState(333);
			match(SEMI);
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_THIS || _la==ID) {
				{
				setState(334);
				((ForStmtContext)_localctx).u1 = updateExpr();
				 _localctx.forStmtRet.addUpdater(((ForStmtContext)_localctx).u1.updateExprRet); 
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(336);
					match(COMMA);
					setState(337);
					((ForStmtContext)_localctx).u2 = updateExpr();
					 _localctx.forStmtRet.addUpdater(((ForStmtContext)_localctx).u2.updateExprRet); 
					}
					}
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(347);
			match(RPAREN);
			setState(348);
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
			setState(351);
			((WhileStmtContext)_localctx).k = match(KW_WHILE);
			setState(352);
			match(LPAREN);
			setState(353);
			((WhileStmtContext)_localctx).e = expr(0);
			setState(354);
			match(RPAREN);
			setState(355);
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
			setState(358);
			((AssignStmtContext)_localctx).l = loc();
			setState(359);
			((AssignStmtContext)_localctx).a = match(ASSIGN);
			setState(360);
			((AssignStmtContext)_localctx).e = expr(0);
			 ((AssignStmtContext)_localctx).assignStmtRet =  new AssignStmt(((AssignStmtContext)_localctx).l.locationRet, ((AssignStmtContext)_localctx).e.expressionRet); 
			setState(362);
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
			setState(366);
			((ReturnStmtContext)_localctx).k = match(KW_RETURN);
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(367);
				((ReturnStmtContext)_localctx).e = expr(0);
				 _localctx.returnStmtRet.setValue(((ReturnStmtContext)_localctx).e.expressionRet); 
				}
			}

			setState(372);
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
			setState(375);
			((InputStmtContext)_localctx).k = match(KW_INPUT);
			setState(376);
			((InputStmtContext)_localctx).l = loc();
			 ((InputStmtContext)_localctx).inputStmtRet =  new InputStmt(((InputStmtContext)_localctx).l.locationRet); 
			setState(378);
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
			setState(381);
			((OutputStmtContext)_localctx).k = match(KW_OUTPUT);
			setState(382);
			((OutputStmtContext)_localctx).e = expr(0);
			 ((OutputStmtContext)_localctx).outputStmtRet =  new OutputStmt(((OutputStmtContext)_localctx).e.expressionRet); 
			setState(384);
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
			setState(397);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				((LocContext)_localctx).s = simpleLoc();
				 ((LocContext)_localctx).locationRet =  ((LocContext)_localctx).s.simpleLocRet; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(390);
				((LocContext)_localctx).m = memberLoc();
				 ((LocContext)_localctx).locationRet =  ((LocContext)_localctx).m.memberLocRet; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(393);
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
			setState(399);
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
			setState(403);
			((MemberLocContext)_localctx).i = match(ID);
			setState(404);
			match(DOT);
			setState(405);
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
			setState(410);
			((ThisLocContext)_localctx).k = match(KW_THIS);
			setState(415);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(411);
				match(DOT);
				setState(412);
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
			setState(424);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(420);
				((MethodcallContext)_localctx).l = loc();
				setState(421);
				match(DOT);
				_localctx.methodCallRet.setInstance(((MethodcallContext)_localctx).l.locationRet); 
				}
				break;
			}
			setState(426);
			((MethodcallContext)_localctx).i = match(ID);
			 _localctx.methodCallRet.setCallee(new Identifier((((MethodcallContext)_localctx).i!=null?((MethodcallContext)_localctx).i.getText():null))); 
			setState(428);
			match(LPAREN);
			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(429);
				((MethodcallContext)_localctx).e1 = expr(0);
				 _localctx.methodCallRet.addArgument(((MethodcallContext)_localctx).e1.expressionRet);
				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(431);
					match(COMMA);
					setState(432);
					((MethodcallContext)_localctx).e2 = expr(0);
					 _localctx.methodCallRet.addArgument(((MethodcallContext)_localctx).e2.expressionRet); 
					}
					}
					setState(439);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(442);
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
			setState(476);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(446);
				((ExprContext)_localctx).l = loc();
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).l.locationRet; 
				}
				break;
			case 2:
				{
				setState(449);
				((ExprContext)_localctx).k = match(KW_THIS);

				            ThisLoc thisLoc = new ThisLoc();
				            thisLoc.setLine((((ExprContext)_localctx).k!=null?((ExprContext)_localctx).k.getLine():0));
				            ((ExprContext)_localctx).expressionRet =  thisLoc;
				        
				}
				break;
			case 3:
				{
				setState(451);
				((ExprContext)_localctx).m = methodcall();
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).m.methodCallRet; 
				}
				break;
			case 4:
				{
				setState(454);
				((ExprContext)_localctx).c = cons();
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).c.constructorCallRet; 
				}
				break;
			case 5:
				{
				setState(457);
				((ExprContext)_localctx).p = match(LPAREN);
				setState(458);
				((ExprContext)_localctx).e = expr(0);
				setState(459);
				match(RPAREN);
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).e.expressionRet; 
				}
				break;
			case 6:
				{
				setState(462);
				((ExprContext)_localctx).i = match(CONSTINT);

				            ((ExprContext)_localctx).expressionRet =  new IntLiteral(Integer.parseInt((((ExprContext)_localctx).i!=null?((ExprContext)_localctx).i.getText():null)));
				            _localctx.expressionRet.setLine((((ExprContext)_localctx).i!=null?((ExprContext)_localctx).i.getLine():0));
				        
				}
				break;
			case 7:
				{
				setState(464);
				((ExprContext)_localctx).f = match(CONSTFLOAT);

				            ((ExprContext)_localctx).expressionRet =  new FloatLiteral(Float.parseFloat((((ExprContext)_localctx).f!=null?((ExprContext)_localctx).f.getText():null)));
				            _localctx.expressionRet.setLine((((ExprContext)_localctx).f!=null?((ExprContext)_localctx).f.getLine():0));
				        
				}
				break;
			case 8:
				{
				setState(466);
				((ExprContext)_localctx).d = match(CONSTDOUBLE);

				            ((ExprContext)_localctx).expressionRet =  new DoubleLiteral(Double.parseDouble((((ExprContext)_localctx).d!=null?((ExprContext)_localctx).d.getText():null)));
				            _localctx.expressionRet.setLine((((ExprContext)_localctx).d!=null?((ExprContext)_localctx).d.getLine():0));
				        
				}
				break;
			case 9:
				{
				setState(468);
				((ExprContext)_localctx).ch = match(CONSTCHAR);

				            ((ExprContext)_localctx).expressionRet =  new CharLiteral((((ExprContext)_localctx).ch!=null?((ExprContext)_localctx).ch.getText():null).charAt(1));
				            _localctx.expressionRet.setLine((((ExprContext)_localctx).ch!=null?((ExprContext)_localctx).ch.getLine():0));
				        
				}
				break;
			case 10:
				{
				setState(470);
				((ExprContext)_localctx).b = match(CONSTBOOL);

				            ((ExprContext)_localctx).expressionRet =  new BoolLiteral(Boolean.parseBoolean((((ExprContext)_localctx).b!=null?((ExprContext)_localctx).b.getText():null)));
				            _localctx.expressionRet.setLine((((ExprContext)_localctx).b!=null?((ExprContext)_localctx).b.getLine():0));
				        
				}
				break;
			case 11:
				{
				setState(472);
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
				setState(473);
				((ExprContext)_localctx).e = expr(7);

				            ((ExprContext)_localctx).expressionRet =  new UnaryExpression((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).e.expressionRet);
				            _localctx.expressionRet.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0));
				        
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(510);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(508);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(478);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(479);
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
						setState(480);
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
						setState(483);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(484);
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
						setState(485);
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
						setState(488);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(489);
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
						setState(490);
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
						setState(493);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(494);
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
						setState(495);
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
						setState(498);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(499);
						((ExprContext)_localctx).op = match(KW_AND);
						setState(500);
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
						setState(503);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(504);
						((ExprContext)_localctx).op = match(KW_OR);
						setState(505);
						((ExprContext)_localctx).right = expr(2);

						                      ((ExprContext)_localctx).expressionRet =  new BinaryExpression(((ExprContext)_localctx).left.expressionRet, "or", ((ExprContext)_localctx).right.expressionRet);
						                      _localctx.expressionRet.setLine((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getLine():0));
						                  
						}
						break;
					}
					} 
				}
				setState(512);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
			setState(530);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(513);
				((InitexprContext)_localctx).v1 = vardecl();
				 ((InitexprContext)_localctx).initExprRet =  new VarDeclStmt(((InitexprContext)_localctx).v1.varRet); 
				 _localctx.initExprRet.setLine(((InitexprContext)_localctx).v1.varRet.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(517);
				((InitexprContext)_localctx).l1 = loc();
				setState(518);
				match(ASSIGN);
				setState(519);
				((InitexprContext)_localctx).e1 = expr(0);
				 ((InitexprContext)_localctx).initExprRet =  new AssignStmt(((InitexprContext)_localctx).l1.locationRet, ((InitexprContext)_localctx).e1.expressionRet); 
				 _localctx.initExprRet.setLine(((InitexprContext)_localctx).l1.locationRet.getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(523);
				((InitexprContext)_localctx).v2 = vardecl();
				 ((InitexprContext)_localctx).initExprRet =  new VarDeclStmt(((InitexprContext)_localctx).v2.varRet); 
				setState(525);
				match(ASSIGN);
				setState(526);
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
			setState(532);
			((UpdateExprContext)_localctx).l = loc();
			setState(533);
			((UpdateExprContext)_localctx).a = match(ASSIGN);
			setState(534);
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
		"\u0004\u00019\u021a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"^\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"d\b\u0002\n\u0002\f\u0002g\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003r\b\u0003\n\u0003\f\u0003u\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0003\u0004z\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u0080\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u0086\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u008c\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007\u009e\b\u0007\n\u0007\f\u0007\u00a1\t\u0007\u0003"+
		"\u0007\u00a3\b\u0007\u0001\b\u0001\b\u0001\b\u0003\b\u00a8\b\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00bd\b\t\u0001\n\u0001\n\u0001\n\u0003\n\u00c2\b\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00ca\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00d9"+
		"\b\u000b\n\u000b\f\u000b\u00dc\t\u000b\u0003\u000b\u00de\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0005\f\u00e8\b\f\n\f\f\f\u00eb\t\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u0120\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0128\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0134\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0141\b\u0010\n"+
		"\u0010\f\u0010\u0144\t\u0010\u0003\u0010\u0146\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u014c\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u0155\b\u0010\n\u0010\f\u0010\u0158\t\u0010\u0003\u0010\u015a\b"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u0173\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u018e\b\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u01a0\b\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003"+
		"\u001a\u01a9\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u01b4"+
		"\b\u001a\n\u001a\f\u001a\u01b7\t\u001a\u0003\u001a\u01b9\b\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01dd\b\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005"+
		"\u001b\u01fd\b\u001b\n\u001b\f\u001b\u0200\t\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0213\b\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0000\u0001"+
		"6\u001e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:\u0000\u0005\u0002\u0000\u0016\u0016"+
		"\'\'\u0001\u0000)*\u0001\u0000\'(\u0001\u0000,/\u0001\u000001\u023e\u0000"+
		"<\u0001\u0000\u0000\u0000\u0002M\u0001\u0000\u0000\u0000\u0004O\u0001"+
		"\u0000\u0000\u0000\u0006j\u0001\u0000\u0000\u0000\b\u0085\u0001\u0000"+
		"\u0000\u0000\n\u008b\u0001\u0000\u0000\u0000\f\u008d\u0001\u0000\u0000"+
		"\u0000\u000e\u0096\u0001\u0000\u0000\u0000\u0010\u00a4\u0001\u0000\u0000"+
		"\u0000\u0012\u00bc\u0001\u0000\u0000\u0000\u0014\u00be\u0001\u0000\u0000"+
		"\u0000\u0016\u00cf\u0001\u0000\u0000\u0000\u0018\u00e2\u0001\u0000\u0000"+
		"\u0000\u001a\u011f\u0001\u0000\u0000\u0000\u001c\u0127\u0001\u0000\u0000"+
		"\u0000\u001e\u0129\u0001\u0000\u0000\u0000 \u0137\u0001\u0000\u0000\u0000"+
		"\"\u015f\u0001\u0000\u0000\u0000$\u0166\u0001\u0000\u0000\u0000&\u016d"+
		"\u0001\u0000\u0000\u0000(\u0177\u0001\u0000\u0000\u0000*\u017d\u0001\u0000"+
		"\u0000\u0000,\u018d\u0001\u0000\u0000\u0000.\u018f\u0001\u0000\u0000\u0000"+
		"0\u0193\u0001\u0000\u0000\u00002\u0199\u0001\u0000\u0000\u00004\u01a3"+
		"\u0001\u0000\u0000\u00006\u01dc\u0001\u0000\u0000\u00008\u0212\u0001\u0000"+
		"\u0000\u0000:\u0214\u0001\u0000\u0000\u0000<B\u0006\u0000\uffff\uffff"+
		"\u0000=>\u0003\u0002\u0001\u0000>?\u0006\u0000\uffff\uffff\u0000?A\u0001"+
		"\u0000\u0000\u0000@=\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000\u0000"+
		"B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CE\u0001\u0000\u0000"+
		"\u0000DB\u0001\u0000\u0000\u0000EF\u0005\u0000\u0000\u0001F\u0001\u0001"+
		"\u0000\u0000\u0000GH\u0003\u0004\u0002\u0000HI\u0006\u0001\uffff\uffff"+
		"\u0000IN\u0001\u0000\u0000\u0000JK\u0003\u0006\u0003\u0000KL\u0006\u0001"+
		"\uffff\uffff\u0000LN\u0001\u0000\u0000\u0000MG\u0001\u0000\u0000\u0000"+
		"MJ\u0001\u0000\u0000\u0000N\u0003\u0001\u0000\u0000\u0000OP\u0005\u0001"+
		"\u0000\u0000PQ\u00056\u0000\u0000Q]\u0006\u0002\uffff\uffff\u0000RS\u0005"+
		"\u0003\u0000\u0000ST\u00056\u0000\u0000TZ\u0006\u0002\uffff\uffff\u0000"+
		"UV\u0005\u001f\u0000\u0000VW\u00056\u0000\u0000WY\u0006\u0002\uffff\uffff"+
		"\u0000XU\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000"+
		"\u0000\u0000Z[\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001"+
		"\u0000\u0000\u0000]R\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000"+
		"^_\u0001\u0000\u0000\u0000_e\u0005\u0004\u0000\u0000`a\u0003\b\u0004\u0000"+
		"ab\u0006\u0002\uffff\uffff\u0000bd\u0001\u0000\u0000\u0000c`\u0001\u0000"+
		"\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001"+
		"\u0000\u0000\u0000fh\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000"+
		"hi\u0005\u0005\u0000\u0000i\u0005\u0001\u0000\u0000\u0000jk\u0005\u0002"+
		"\u0000\u0000kl\u00056\u0000\u0000lm\u0005\u0004\u0000\u0000ms\u0006\u0003"+
		"\uffff\uffff\u0000no\u0003\b\u0004\u0000op\u0006\u0003\uffff\uffff\u0000"+
		"pr\u0001\u0000\u0000\u0000qn\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000"+
		"\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000"+
		"\u0000\u0000us\u0001\u0000\u0000\u0000vw\u0005\u0005\u0000\u0000w\u0007"+
		"\u0001\u0000\u0000\u0000xz\u0003\n\u0005\u0000yx\u0001\u0000\u0000\u0000"+
		"yz\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0003\f\u0006\u0000"+
		"|}\u0006\u0004\uffff\uffff\u0000}\u0086\u0001\u0000\u0000\u0000~\u0080"+
		"\u0003\n\u0005\u0000\u007f~\u0001\u0000\u0000\u0000\u007f\u0080\u0001"+
		"\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0003"+
		"\u0014\n\u0000\u0082\u0083\u0005\u001e\u0000\u0000\u0083\u0084\u0006\u0004"+
		"\uffff\uffff\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085y\u0001\u0000"+
		"\u0000\u0000\u0085\u007f\u0001\u0000\u0000\u0000\u0086\t\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0005\u0007\u0000\u0000\u0088\u008c\u0006\u0005\uffff"+
		"\uffff\u0000\u0089\u008a\u0005\u0006\u0000\u0000\u008a\u008c\u0006\u0005"+
		"\uffff\uffff\u0000\u008b\u0087\u0001\u0000\u0000\u0000\u008b\u0089\u0001"+
		"\u0000\u0000\u0000\u008c\u000b\u0001\u0000\u0000\u0000\u008d\u008e\u0003"+
		"\u0012\t\u0000\u008e\u008f\u00056\u0000\u0000\u008f\u0090\u0005 \u0000"+
		"\u0000\u0090\u0091\u0003\u000e\u0007\u0000\u0091\u0092\u0005!\u0000\u0000"+
		"\u0092\u0093\u0003\u0018\f\u0000\u0093\u0094\u0006\u0006\uffff\uffff\u0000"+
		"\u0094\u0095\u0006\u0006\uffff\uffff\u0000\u0095\r\u0001\u0000\u0000\u0000"+
		"\u0096\u00a2\u0006\u0007\uffff\uffff\u0000\u0097\u0098\u0003\u0010\b\u0000"+
		"\u0098\u009f\u0006\u0007\uffff\uffff\u0000\u0099\u009a\u0005\u001f\u0000"+
		"\u0000\u009a\u009b\u0003\u0010\b\u0000\u009b\u009c\u0006\u0007\uffff\uffff"+
		"\u0000\u009c\u009e\u0001\u0000\u0000\u0000\u009d\u0099\u0001\u0000\u0000"+
		"\u0000\u009e\u00a1\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000"+
		"\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2\u0097\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u000f\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a7\u0006\b\uffff\uffff\u0000\u00a5\u00a6\u0005\u0019\u0000"+
		"\u0000\u00a6\u00a8\u0006\b\uffff\uffff\u0000\u00a7\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0003\u0012\t\u0000\u00aa\u00ab\u00056\u0000\u0000"+
		"\u00ab\u00ac\u0006\b\uffff\uffff\u0000\u00ac\u00ad\u0006\b\uffff\uffff"+
		"\u0000\u00ad\u0011\u0001\u0000\u0000\u0000\u00ae\u00af\u00056\u0000\u0000"+
		"\u00af\u00bd\u0006\t\uffff\uffff\u0000\u00b0\u00b1\u0005\b\u0000\u0000"+
		"\u00b1\u00bd\u0006\t\uffff\uffff\u0000\u00b2\u00b3\u0005\t\u0000\u0000"+
		"\u00b3\u00bd\u0006\t\uffff\uffff\u0000\u00b4\u00b5\u0005\n\u0000\u0000"+
		"\u00b5\u00bd\u0006\t\uffff\uffff\u0000\u00b6\u00b7\u0005\u000b\u0000\u0000"+
		"\u00b7\u00bd\u0006\t\uffff\uffff\u0000\u00b8\u00b9\u0005\f\u0000\u0000"+
		"\u00b9\u00bd\u0006\t\uffff\uffff\u0000\u00ba\u00bb\u0005\u001c\u0000\u0000"+
		"\u00bb\u00bd\u0006\t\uffff\uffff\u0000\u00bc\u00ae\u0001\u0000\u0000\u0000"+
		"\u00bc\u00b0\u0001\u0000\u0000\u0000\u00bc\u00b2\u0001\u0000\u0000\u0000"+
		"\u00bc\u00b4\u0001\u0000\u0000\u0000\u00bc\u00b6\u0001\u0000\u0000\u0000"+
		"\u00bc\u00b8\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000"+
		"\u00bd\u0013\u0001\u0000\u0000\u0000\u00be\u00c1\u0006\n\uffff\uffff\u0000"+
		"\u00bf\u00c0\u0005\u0019\u0000\u0000\u00c0\u00c2\u0006\n\uffff\uffff\u0000"+
		"\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c9\u0001\u0000\u0000\u0000\u00c3\u00c4\u0003\u0012\t\u0000\u00c4"+
		"\u00c5\u0006\n\uffff\uffff\u0000\u00c5\u00ca\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0003\u0016\u000b\u0000\u00c7\u00c8\u0006\n\uffff\uffff\u0000\u00c8"+
		"\u00ca\u0001\u0000\u0000\u0000\u00c9\u00c3\u0001\u0000\u0000\u0000\u00c9"+
		"\u00c6\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb"+
		"\u00cc\u00056\u0000\u0000\u00cc\u00cd\u0006\n\uffff\uffff\u0000\u00cd"+
		"\u00ce\u0006\n\uffff\uffff\u0000\u00ce\u0015\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u00056\u0000\u0000\u00d0\u00d1\u0006\u000b\uffff\uffff\u0000\u00d1"+
		"\u00dd\u0005 \u0000\u0000\u00d2\u00d3\u00036\u001b\u0000\u00d3\u00da\u0006"+
		"\u000b\uffff\uffff\u0000\u00d4\u00d5\u0005\u001f\u0000\u0000\u00d5\u00d6"+
		"\u00036\u001b\u0000\u00d6\u00d7\u0006\u000b\uffff\uffff\u0000\u00d7\u00d9"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d4\u0001\u0000\u0000\u0000\u00d9\u00dc"+
		"\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db"+
		"\u0001\u0000\u0000\u0000\u00db\u00de\u0001\u0000\u0000\u0000\u00dc\u00da"+
		"\u0001\u0000\u0000\u0000\u00dd\u00d2\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df\u00e0"+
		"\u0005!\u0000\u0000\u00e0\u00e1\u0006\u000b\uffff\uffff\u0000\u00e1\u0017"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0006\f\uffff\uffff\u0000\u00e3\u00e9"+
		"\u0005\u0004\u0000\u0000\u00e4\u00e5\u0003\u001a\r\u0000\u00e5\u00e6\u0006"+
		"\f\uffff\uffff\u0000\u00e6\u00e8\u0001\u0000\u0000\u0000\u00e7\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00ec\u0001"+
		"\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005"+
		"\u0005\u0000\u0000\u00ed\u00ee\u0006\f\uffff\uffff\u0000\u00ee\u0019\u0001"+
		"\u0000\u0000\u0000\u00ef\u00f0\u0003\u0018\f\u0000\u00f0\u00f1\u0006\r"+
		"\uffff\uffff\u0000\u00f1\u00f2\u0006\r\uffff\uffff\u0000\u00f2\u0120\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f4\u0003\u0014\n\u0000\u00f4\u00f5\u0006\r"+
		"\uffff\uffff\u0000\u00f5\u00f6\u0005\u001e\u0000\u0000\u00f6\u00f7\u0006"+
		"\r\uffff\uffff\u0000\u00f7\u0120\u0001\u0000\u0000\u0000\u00f8\u00f9\u0003"+
		"\u0014\n\u0000\u00f9\u00fa\u0006\r\uffff\uffff\u0000\u00fa\u00fb\u0005"+
		"$\u0000\u0000\u00fb\u00fc\u00036\u001b\u0000\u00fc\u00fd\u0006\r\uffff"+
		"\uffff\u0000\u00fd\u00fe\u0005\u001e\u0000\u0000\u00fe\u00ff\u0006\r\uffff"+
		"\uffff\u0000\u00ff\u0120\u0001\u0000\u0000\u0000\u0100\u0101\u00034\u001a"+
		"\u0000\u0101\u0102\u0006\r\uffff\uffff\u0000\u0102\u0103\u0005\u001e\u0000"+
		"\u0000\u0103\u0104\u0006\r\uffff\uffff\u0000\u0104\u0120\u0001\u0000\u0000"+
		"\u0000\u0105\u0106\u0003\u001e\u000f\u0000\u0106\u0107\u0006\r\uffff\uffff"+
		"\u0000\u0107\u0108\u0006\r\uffff\uffff\u0000\u0108\u0120\u0001\u0000\u0000"+
		"\u0000\u0109\u0120\u0003 \u0010\u0000\u010a\u0120\u0003\"\u0011\u0000"+
		"\u010b\u010c\u0003$\u0012\u0000\u010c\u010d\u0006\r\uffff\uffff\u0000"+
		"\u010d\u010e\u0006\r\uffff\uffff\u0000\u010e\u0120\u0001\u0000\u0000\u0000"+
		"\u010f\u0110\u0003&\u0013\u0000\u0110\u0111\u0006\r\uffff\uffff\u0000"+
		"\u0111\u0112\u0006\r\uffff\uffff\u0000\u0112\u0120\u0001\u0000\u0000\u0000"+
		"\u0113\u0114\u0003(\u0014\u0000\u0114\u0115\u0006\r\uffff\uffff\u0000"+
		"\u0115\u0116\u0006\r\uffff\uffff\u0000\u0116\u0120\u0001\u0000\u0000\u0000"+
		"\u0117\u0118\u0003*\u0015\u0000\u0118\u0119\u0006\r\uffff\uffff\u0000"+
		"\u0119\u011a\u0006\r\uffff\uffff\u0000\u011a\u0120\u0001\u0000\u0000\u0000"+
		"\u011b\u011c\u0003\u001c\u000e\u0000\u011c\u011d\u0006\r\uffff\uffff\u0000"+
		"\u011d\u011e\u0006\r\uffff\uffff\u0000\u011e\u0120\u0001\u0000\u0000\u0000"+
		"\u011f\u00ef\u0001\u0000\u0000\u0000\u011f\u00f3\u0001\u0000\u0000\u0000"+
		"\u011f\u00f8\u0001\u0000\u0000\u0000\u011f\u0100\u0001\u0000\u0000\u0000"+
		"\u011f\u0105\u0001\u0000\u0000\u0000\u011f\u0109\u0001\u0000\u0000\u0000"+
		"\u011f\u010a\u0001\u0000\u0000\u0000\u011f\u010b\u0001\u0000\u0000\u0000"+
		"\u011f\u010f\u0001\u0000\u0000\u0000\u011f\u0113\u0001\u0000\u0000\u0000"+
		"\u011f\u0117\u0001\u0000\u0000\u0000\u011f\u011b\u0001\u0000\u0000\u0000"+
		"\u0120\u001b\u0001\u0000\u0000\u0000\u0121\u0122\u0005\u001a\u0000\u0000"+
		"\u0122\u0123\u0006\u000e\uffff\uffff\u0000\u0123\u0128\u0006\u000e\uffff"+
		"\uffff\u0000\u0124\u0125\u0005\u001b\u0000\u0000\u0125\u0126\u0006\u000e"+
		"\uffff\uffff\u0000\u0126\u0128\u0006\u000e\uffff\uffff\u0000\u0127\u0121"+
		"\u0001\u0000\u0000\u0000\u0127\u0124\u0001\u0000\u0000\u0000\u0128\u001d"+
		"\u0001\u0000\u0000\u0000\u0129\u012a\u0005\r\u0000\u0000\u012a\u012b\u0005"+
		" \u0000\u0000\u012b\u012c\u00036\u001b\u0000\u012c\u012d\u0005!\u0000"+
		"\u0000\u012d\u012e\u0003\u001a\r\u0000\u012e\u0133\u0006\u000f\uffff\uffff"+
		"\u0000\u012f\u0130\u0005\u000e\u0000\u0000\u0130\u0131\u0003\u001a\r\u0000"+
		"\u0131\u0132\u0006\u000f\uffff\uffff\u0000\u0132\u0134\u0001\u0000\u0000"+
		"\u0000\u0133\u012f\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000\u0000"+
		"\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135\u0136\u0006\u000f\uffff"+
		"\uffff\u0000\u0136\u001f\u0001\u0000\u0000\u0000\u0137\u0138\u0005\u000f"+
		"\u0000\u0000\u0138\u0139\u0006\u0010\uffff\uffff\u0000\u0139\u0145\u0005"+
		" \u0000\u0000\u013a\u013b\u00038\u001c\u0000\u013b\u0142\u0006\u0010\uffff"+
		"\uffff\u0000\u013c\u013d\u0005\u001f\u0000\u0000\u013d\u013e\u00038\u001c"+
		"\u0000\u013e\u013f\u0006\u0010\uffff\uffff\u0000\u013f\u0141\u0001\u0000"+
		"\u0000\u0000\u0140\u013c\u0001\u0000\u0000\u0000\u0141\u0144\u0001\u0000"+
		"\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000\u0142\u0143\u0001\u0000"+
		"\u0000\u0000\u0143\u0146\u0001\u0000\u0000\u0000\u0144\u0142\u0001\u0000"+
		"\u0000\u0000\u0145\u013a\u0001\u0000\u0000\u0000\u0145\u0146\u0001\u0000"+
		"\u0000\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147\u014b\u0005\u001e"+
		"\u0000\u0000\u0148\u0149\u00036\u001b\u0000\u0149\u014a\u0006\u0010\uffff"+
		"\uffff\u0000\u014a\u014c\u0001\u0000\u0000\u0000\u014b\u0148\u0001\u0000"+
		"\u0000\u0000\u014b\u014c\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000"+
		"\u0000\u0000\u014d\u0159\u0005\u001e\u0000\u0000\u014e\u014f\u0003:\u001d"+
		"\u0000\u014f\u0156\u0006\u0010\uffff\uffff\u0000\u0150\u0151\u0005\u001f"+
		"\u0000\u0000\u0151\u0152\u0003:\u001d\u0000\u0152\u0153\u0006\u0010\uffff"+
		"\uffff\u0000\u0153\u0155\u0001\u0000\u0000\u0000\u0154\u0150\u0001\u0000"+
		"\u0000\u0000\u0155\u0158\u0001\u0000\u0000\u0000\u0156\u0154\u0001\u0000"+
		"\u0000\u0000\u0156\u0157\u0001\u0000\u0000\u0000\u0157\u015a\u0001\u0000"+
		"\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0159\u014e\u0001\u0000"+
		"\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000"+
		"\u0000\u0000\u015b\u015c\u0005!\u0000\u0000\u015c\u015d\u0003\u001a\r"+
		"\u0000\u015d\u015e\u0006\u0010\uffff\uffff\u0000\u015e!\u0001\u0000\u0000"+
		"\u0000\u015f\u0160\u0005\u0010\u0000\u0000\u0160\u0161\u0005 \u0000\u0000"+
		"\u0161\u0162\u00036\u001b\u0000\u0162\u0163\u0005!\u0000\u0000\u0163\u0164"+
		"\u0003\u001a\r\u0000\u0164\u0165\u0006\u0011\uffff\uffff\u0000\u0165#"+
		"\u0001\u0000\u0000\u0000\u0166\u0167\u0003,\u0016\u0000\u0167\u0168\u0005"+
		"$\u0000\u0000\u0168\u0169\u00036\u001b\u0000\u0169\u016a\u0006\u0012\uffff"+
		"\uffff\u0000\u016a\u016b\u0005\u001e\u0000\u0000\u016b\u016c\u0006\u0012"+
		"\uffff\uffff\u0000\u016c%\u0001\u0000\u0000\u0000\u016d\u016e\u0006\u0013"+
		"\uffff\uffff\u0000\u016e\u0172\u0005\u0012\u0000\u0000\u016f\u0170\u0003"+
		"6\u001b\u0000\u0170\u0171\u0006\u0013\uffff\uffff\u0000\u0171\u0173\u0001"+
		"\u0000\u0000\u0000\u0172\u016f\u0001\u0000\u0000\u0000\u0172\u0173\u0001"+
		"\u0000\u0000\u0000\u0173\u0174\u0001\u0000\u0000\u0000\u0174\u0175\u0005"+
		"\u001e\u0000\u0000\u0175\u0176\u0006\u0013\uffff\uffff\u0000\u0176\'\u0001"+
		"\u0000\u0000\u0000\u0177\u0178\u0005\u0013\u0000\u0000\u0178\u0179\u0003"+
		",\u0016\u0000\u0179\u017a\u0006\u0014\uffff\uffff\u0000\u017a\u017b\u0005"+
		"\u001e\u0000\u0000\u017b\u017c\u0006\u0014\uffff\uffff\u0000\u017c)\u0001"+
		"\u0000\u0000\u0000\u017d\u017e\u0005\u0014\u0000\u0000\u017e\u017f\u0003"+
		"6\u001b\u0000\u017f\u0180\u0006\u0015\uffff\uffff\u0000\u0180\u0181\u0005"+
		"\u001e\u0000\u0000\u0181\u0182\u0006\u0015\uffff\uffff\u0000\u0182+\u0001"+
		"\u0000\u0000\u0000\u0183\u0184\u0003.\u0017\u0000\u0184\u0185\u0006\u0016"+
		"\uffff\uffff\u0000\u0185\u018e\u0001\u0000\u0000\u0000\u0186\u0187\u0003"+
		"0\u0018\u0000\u0187\u0188\u0006\u0016\uffff\uffff\u0000\u0188\u018e\u0001"+
		"\u0000\u0000\u0000\u0189\u018a\u00032\u0019\u0000\u018a\u018b\u0006\u0016"+
		"\uffff\uffff\u0000\u018b\u018c\u0006\u0016\uffff\uffff\u0000\u018c\u018e"+
		"\u0001\u0000\u0000\u0000\u018d\u0183\u0001\u0000\u0000\u0000\u018d\u0186"+
		"\u0001\u0000\u0000\u0000\u018d\u0189\u0001\u0000\u0000\u0000\u018e-\u0001"+
		"\u0000\u0000\u0000\u018f\u0190\u00056\u0000\u0000\u0190\u0191\u0006\u0017"+
		"\uffff\uffff\u0000\u0191\u0192\u0006\u0017\uffff\uffff\u0000\u0192/\u0001"+
		"\u0000\u0000\u0000\u0193\u0194\u00056\u0000\u0000\u0194\u0195\u0005%\u0000"+
		"\u0000\u0195\u0196\u0003,\u0016\u0000\u0196\u0197\u0006\u0018\uffff\uffff"+
		"\u0000\u0197\u0198\u0006\u0018\uffff\uffff\u0000\u01981\u0001\u0000\u0000"+
		"\u0000\u0199\u019a\u0006\u0019\uffff\uffff\u0000\u019a\u019f\u0005\u0015"+
		"\u0000\u0000\u019b\u019c\u0005%\u0000\u0000\u019c\u019d\u0003,\u0016\u0000"+
		"\u019d\u019e\u0006\u0019\uffff\uffff\u0000\u019e\u01a0\u0001\u0000\u0000"+
		"\u0000\u019f\u019b\u0001\u0000\u0000\u0000\u019f\u01a0\u0001\u0000\u0000"+
		"\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000\u01a1\u01a2\u0006\u0019\uffff"+
		"\uffff\u0000\u01a23\u0001\u0000\u0000\u0000\u01a3\u01a8\u0006\u001a\uffff"+
		"\uffff\u0000\u01a4\u01a5\u0003,\u0016\u0000\u01a5\u01a6\u0005%\u0000\u0000"+
		"\u01a6\u01a7\u0006\u001a\uffff\uffff\u0000\u01a7\u01a9\u0001\u0000\u0000"+
		"\u0000\u01a8\u01a4\u0001\u0000\u0000\u0000\u01a8\u01a9\u0001\u0000\u0000"+
		"\u0000\u01a9\u01aa\u0001\u0000\u0000\u0000\u01aa\u01ab\u00056\u0000\u0000"+
		"\u01ab\u01ac\u0006\u001a\uffff\uffff\u0000\u01ac\u01b8\u0005 \u0000\u0000"+
		"\u01ad\u01ae\u00036\u001b\u0000\u01ae\u01b5\u0006\u001a\uffff\uffff\u0000"+
		"\u01af\u01b0\u0005\u001f\u0000\u0000\u01b0\u01b1\u00036\u001b\u0000\u01b1"+
		"\u01b2\u0006\u001a\uffff\uffff\u0000\u01b2\u01b4\u0001\u0000\u0000\u0000"+
		"\u01b3\u01af\u0001\u0000\u0000\u0000\u01b4\u01b7\u0001\u0000\u0000\u0000"+
		"\u01b5\u01b3\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000"+
		"\u01b6\u01b9\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000"+
		"\u01b8\u01ad\u0001\u0000\u0000\u0000\u01b8\u01b9\u0001\u0000\u0000\u0000"+
		"\u01b9\u01ba\u0001\u0000\u0000\u0000\u01ba\u01bb\u0005!\u0000\u0000\u01bb"+
		"\u01bc\u0006\u001a\uffff\uffff\u0000\u01bc5\u0001\u0000\u0000\u0000\u01bd"+
		"\u01be\u0006\u001b\uffff\uffff\u0000\u01be\u01bf\u0003,\u0016\u0000\u01bf"+
		"\u01c0\u0006\u001b\uffff\uffff\u0000\u01c0\u01dd\u0001\u0000\u0000\u0000"+
		"\u01c1\u01c2\u0005\u0015\u0000\u0000\u01c2\u01dd\u0006\u001b\uffff\uffff"+
		"\u0000\u01c3\u01c4\u00034\u001a\u0000\u01c4\u01c5\u0006\u001b\uffff\uffff"+
		"\u0000\u01c5\u01dd\u0001\u0000\u0000\u0000\u01c6\u01c7\u0003\u0016\u000b"+
		"\u0000\u01c7\u01c8\u0006\u001b\uffff\uffff\u0000\u01c8\u01dd\u0001\u0000"+
		"\u0000\u0000\u01c9\u01ca\u0005 \u0000\u0000\u01ca\u01cb\u00036\u001b\u0000"+
		"\u01cb\u01cc\u0005!\u0000\u0000\u01cc\u01cd\u0006\u001b\uffff\uffff\u0000"+
		"\u01cd\u01dd\u0001\u0000\u0000\u0000\u01ce\u01cf\u00052\u0000\u0000\u01cf"+
		"\u01dd\u0006\u001b\uffff\uffff\u0000\u01d0\u01d1\u00053\u0000\u0000\u01d1"+
		"\u01dd\u0006\u001b\uffff\uffff\u0000\u01d2\u01d3\u00054\u0000\u0000\u01d3"+
		"\u01dd\u0006\u001b\uffff\uffff\u0000\u01d4\u01d5\u00055\u0000\u0000\u01d5"+
		"\u01dd\u0006\u001b\uffff\uffff\u0000\u01d6\u01d7\u0005\u001d\u0000\u0000"+
		"\u01d7\u01dd\u0006\u001b\uffff\uffff\u0000\u01d8\u01d9\u0007\u0000\u0000"+
		"\u0000\u01d9\u01da\u00036\u001b\u0007\u01da\u01db\u0006\u001b\uffff\uffff"+
		"\u0000\u01db\u01dd\u0001\u0000\u0000\u0000\u01dc\u01bd\u0001\u0000\u0000"+
		"\u0000\u01dc\u01c1\u0001\u0000\u0000\u0000\u01dc\u01c3\u0001\u0000\u0000"+
		"\u0000\u01dc\u01c6\u0001\u0000\u0000\u0000\u01dc\u01c9\u0001\u0000\u0000"+
		"\u0000\u01dc\u01ce\u0001\u0000\u0000\u0000\u01dc\u01d0\u0001\u0000\u0000"+
		"\u0000\u01dc\u01d2\u0001\u0000\u0000\u0000\u01dc\u01d4\u0001\u0000\u0000"+
		"\u0000\u01dc\u01d6\u0001\u0000\u0000\u0000\u01dc\u01d8\u0001\u0000\u0000"+
		"\u0000\u01dd\u01fe\u0001\u0000\u0000\u0000\u01de\u01df\n\u0006\u0000\u0000"+
		"\u01df\u01e0\u0007\u0001\u0000\u0000\u01e0\u01e1\u00036\u001b\u0007\u01e1"+
		"\u01e2\u0006\u001b\uffff\uffff\u0000\u01e2\u01fd\u0001\u0000\u0000\u0000"+
		"\u01e3\u01e4\n\u0005\u0000\u0000\u01e4\u01e5\u0007\u0002\u0000\u0000\u01e5"+
		"\u01e6\u00036\u001b\u0006\u01e6\u01e7\u0006\u001b\uffff\uffff\u0000\u01e7"+
		"\u01fd\u0001\u0000\u0000\u0000\u01e8\u01e9\n\u0004\u0000\u0000\u01e9\u01ea"+
		"\u0007\u0003\u0000\u0000\u01ea\u01eb\u00036\u001b\u0005\u01eb\u01ec\u0006"+
		"\u001b\uffff\uffff\u0000\u01ec\u01fd\u0001\u0000\u0000\u0000\u01ed\u01ee"+
		"\n\u0003\u0000\u0000\u01ee\u01ef\u0007\u0004\u0000\u0000\u01ef\u01f0\u0003"+
		"6\u001b\u0004\u01f0\u01f1\u0006\u001b\uffff\uffff\u0000\u01f1\u01fd\u0001"+
		"\u0000\u0000\u0000\u01f2\u01f3\n\u0002\u0000\u0000\u01f3\u01f4\u0005\u0017"+
		"\u0000\u0000\u01f4\u01f5\u00036\u001b\u0003\u01f5\u01f6\u0006\u001b\uffff"+
		"\uffff\u0000\u01f6\u01fd\u0001\u0000\u0000\u0000\u01f7\u01f8\n\u0001\u0000"+
		"\u0000\u01f8\u01f9\u0005\u0018\u0000\u0000\u01f9\u01fa\u00036\u001b\u0002"+
		"\u01fa\u01fb\u0006\u001b\uffff\uffff\u0000\u01fb\u01fd\u0001\u0000\u0000"+
		"\u0000\u01fc\u01de\u0001\u0000\u0000\u0000\u01fc\u01e3\u0001\u0000\u0000"+
		"\u0000\u01fc\u01e8\u0001\u0000\u0000\u0000\u01fc\u01ed\u0001\u0000\u0000"+
		"\u0000\u01fc\u01f2\u0001\u0000\u0000\u0000\u01fc\u01f7\u0001\u0000\u0000"+
		"\u0000\u01fd\u0200\u0001\u0000\u0000\u0000\u01fe\u01fc\u0001\u0000\u0000"+
		"\u0000\u01fe\u01ff\u0001\u0000\u0000\u0000\u01ff7\u0001\u0000\u0000\u0000"+
		"\u0200\u01fe\u0001\u0000\u0000\u0000\u0201\u0202\u0003\u0014\n\u0000\u0202"+
		"\u0203\u0006\u001c\uffff\uffff\u0000\u0203\u0204\u0006\u001c\uffff\uffff"+
		"\u0000\u0204\u0213\u0001\u0000\u0000\u0000\u0205\u0206\u0003,\u0016\u0000"+
		"\u0206\u0207\u0005$\u0000\u0000\u0207\u0208\u00036\u001b\u0000\u0208\u0209"+
		"\u0006\u001c\uffff\uffff\u0000\u0209\u020a\u0006\u001c\uffff\uffff\u0000"+
		"\u020a\u0213\u0001\u0000\u0000\u0000\u020b\u020c\u0003\u0014\n\u0000\u020c"+
		"\u020d\u0006\u001c\uffff\uffff\u0000\u020d\u020e\u0005$\u0000\u0000\u020e"+
		"\u020f\u00036\u001b\u0000\u020f\u0210\u0006\u001c\uffff\uffff\u0000\u0210"+
		"\u0211\u0006\u001c\uffff\uffff\u0000\u0211\u0213\u0001\u0000\u0000\u0000"+
		"\u0212\u0201\u0001\u0000\u0000\u0000\u0212\u0205\u0001\u0000\u0000\u0000"+
		"\u0212\u020b\u0001\u0000\u0000\u0000\u02139\u0001\u0000\u0000\u0000\u0214"+
		"\u0215\u0003,\u0016\u0000\u0215\u0216\u0005$\u0000\u0000\u0216\u0217\u0003"+
		"6\u001b\u0000\u0217\u0218\u0006\u001d\uffff\uffff\u0000\u0218;\u0001\u0000"+
		"\u0000\u0000%BMZ]esy\u007f\u0085\u008b\u009f\u00a2\u00a7\u00bc\u00c1\u00c9"+
		"\u00da\u00dd\u00e9\u011f\u0127\u0133\u0142\u0145\u014b\u0156\u0159\u0172"+
		"\u018d\u019f\u01a8\u01b5\u01b8\u01dc\u01fc\u01fe\u0212";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}