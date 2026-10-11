
    package main.grammar;
    import main.ast.core.*;
    import main.ast.types.*;
    import main.ast.declarations.*;
    import main.ast.declarations.Module;
    import main.ast.statements.*;
    import main.ast.expressions.*;
    import main.ast.expressions.literals.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimpleLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

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
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_MODULE:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				((TopLevelDeclContext)_localctx).m = module();
				 ((TopLevelDeclContext)_localctx).topLevelDeclRet =  new ModuleDecl(((TopLevelDeclContext)_localctx).m.moduleRet); 
				}
				break;
			case KW_STRUCT:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				((TopLevelDeclContext)_localctx).s = structDef();
				 ((TopLevelDeclContext)_localctx).topLevelDeclRet =  new StructDecl(((TopLevelDeclContext)_localctx).s.structRet); 
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
			setState(77);
			((ModuleContext)_localctx).k = match(KW_MODULE);
			setState(78);
			((ModuleContext)_localctx).i = match(ID);
			 ((ModuleContext)_localctx).moduleRet =  new Module(new Identifier((((ModuleContext)_localctx).i!=null?((ModuleContext)_localctx).i.getText():null))); 
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
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811480000L) != 0)) {
				{
				{
				setState(94);
				((ModuleContext)_localctx).m = member();
				 _localctx.moduleRet.addMember(((ModuleContext)_localctx).m.memberRet); 
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(KW_END);
			 _localctx.moduleRet.setLine((((ModuleContext)_localctx).k!=null?((ModuleContext)_localctx).k.getLine():0)); 
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
			setState(105);
			((StructDefContext)_localctx).k = match(KW_STRUCT);
			setState(106);
			((StructDefContext)_localctx).i = match(ID);
			 ((StructDefContext)_localctx).structRet =  new Struct(new Identifier((((StructDefContext)_localctx).i!=null?((StructDefContext)_localctx).i.getText():null))); 
			setState(108);
			match(KW_BEGIN);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811480000L) != 0)) {
				{
				{
				setState(109);
				((StructDefContext)_localctx).m = member();
				 _localctx.structRet.addMember(((StructDefContext)_localctx).m.memberRet); 
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(KW_END);
			 _localctx.structRet.setLine((((StructDefContext)_localctx).k!=null?((StructDefContext)_localctx).k.getLine():0)); 
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
		public AccessModifierContext a1;
		public Method_declContext m;
		public AccessModifierContext a2;
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
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((MemberContext)_localctx).memberRet =  new MethodDecl(); 
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_PUBLIC || _la==KW_PRIVATE) {
					{
					setState(121);
					((MemberContext)_localctx).a1 = accessModifier();
					 _localctx.memberRet.setAccessModifier(((MemberContext)_localctx).a1.accessModifierRet); 
					}
				}

				setState(126);
				((MemberContext)_localctx).m = method_decl();
				 ((MethodDecl)_localctx.memberRet).setMethod(((MemberContext)_localctx).m.methodRet); 
				 _localctx.memberRet.setLine(((MemberContext)_localctx).m.methodRet.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				 ((MemberContext)_localctx).memberRet =  new VarDecl(); 
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_PUBLIC || _la==KW_PRIVATE) {
					{
					setState(131);
					((MemberContext)_localctx).a2 = accessModifier();
					 _localctx.memberRet.setAccessModifier(((MemberContext)_localctx).a2.accessModifierRet); 
					}
				}

				setState(136);
				((MemberContext)_localctx).v = vardecl();
				 ((VarDecl)_localctx.memberRet).setVar(((MemberContext)_localctx).v.varRet); 
				 _localctx.memberRet.setLine(((MemberContext)_localctx).v.varRet.getLine()); 
				setState(139);
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
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_PRIVATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				((AccessModifierContext)_localctx).pr = match(KW_PRIVATE);
				 ((AccessModifierContext)_localctx).accessModifierRet =  AccessModifier.PRIVATE; 
				}
				break;
			case KW_PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
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
			setState(149);
			((Method_declContext)_localctx).t = type();
			setState(150);
			((Method_declContext)_localctx).i = match(ID);
			setState(151);
			match(LPAREN);
			setState(152);
			((Method_declContext)_localctx).a = arguments();
			setState(153);
			match(RPAREN);
			setState(154);
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
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398811479808L) != 0)) {
				{
				setState(159);
				((ArgumentsContext)_localctx).p1 = parameter();
				 _localctx.parametersRet.add(((ArgumentsContext)_localctx).p1.parameterRet); 
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(161);
					match(COMMA);
					setState(162);
					((ArgumentsContext)_localctx).p2 = parameter();
					 _localctx.parametersRet.add(((ArgumentsContext)_localctx).p2.parameterRet); 
					}
					}
					setState(169);
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
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_MUT) {
				{
				setState(173);
				match(KW_MUT);
				 isMut = true; 
				}
			}

			setState(177);
			((ParameterContext)_localctx).t = type();
			setState(178);
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
		public Token ki;
		public Token kf;
		public Token kd;
		public Token kc;
		public Token kv;
		public Token kb;
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
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				((TypeContext)_localctx).i = match(ID);
				 ((TypeContext)_localctx).typeRet =  new UserDefinedType(new Identifier((((TypeContext)_localctx).i!=null?((TypeContext)_localctx).i.getText():null))); 
				 _localctx.typeRet.setLine((((TypeContext)_localctx).i!=null?((TypeContext)_localctx).i.getLine():0)); 
				}
				break;
			case KW_INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				((TypeContext)_localctx).ki = match(KW_INT);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType(PrimitiveType.Primitive.INT); 
				 _localctx.typeRet.setLine((((TypeContext)_localctx).ki!=null?((TypeContext)_localctx).ki.getLine():0)); 
				}
				break;
			case KW_FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(188);
				((TypeContext)_localctx).kf = match(KW_FLOAT);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType(PrimitiveType.Primitive.FLOAT); 
				 _localctx.typeRet.setLine((((TypeContext)_localctx).kf!=null?((TypeContext)_localctx).kf.getLine():0)); 
				}
				break;
			case KW_DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(191);
				((TypeContext)_localctx).kd = match(KW_DOUBLE);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType(PrimitiveType.Primitive.DOUBLE); 
				 _localctx.typeRet.setLine((((TypeContext)_localctx).kd!=null?((TypeContext)_localctx).kd.getLine():0)); 
				}
				break;
			case KW_CHAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(194);
				((TypeContext)_localctx).kc = match(KW_CHAR);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType(PrimitiveType.Primitive.CHAR); 
				 _localctx.typeRet.setLine((((TypeContext)_localctx).kc!=null?((TypeContext)_localctx).kc.getLine():0)); 
				}
				break;
			case KW_VOID:
				enterOuterAlt(_localctx, 6);
				{
				setState(197);
				((TypeContext)_localctx).kv = match(KW_VOID);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType(PrimitiveType.Primitive.VOID); 
				 _localctx.typeRet.setLine((((TypeContext)_localctx).kv!=null?((TypeContext)_localctx).kv.getLine():0)); 
				}
				break;
			case KW_BOOL:
				enterOuterAlt(_localctx, 7);
				{
				setState(200);
				((TypeContext)_localctx).kb = match(KW_BOOL);
				 ((TypeContext)_localctx).typeRet =  new PrimitiveType(PrimitiveType.Primitive.BOOL); 
				 _localctx.typeRet.setLine((((TypeContext)_localctx).kb!=null?((TypeContext)_localctx).kb.getLine():0)); 
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
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_MUT) {
				{
				setState(206);
				match(KW_MUT);
				 isMut = true; 
				}
			}

			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(210);
				((VardeclContext)_localctx).t = type();
				 ((VardeclContext)_localctx).varRet =  new Var(isMut, ((VardeclContext)_localctx).t.typeRet); 
				}
				break;
			case 2:
				{
				setState(213);
				((VardeclContext)_localctx).c = cons();
				 ((VardeclContext)_localctx).varRet =  new Var(isMut, ((VardeclContext)_localctx).c.constructorCallRet); 
				}
				break;
			}
			setState(218);
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
			setState(222);
			((ConsContext)_localctx).i = match(ID);
			 ((ConsContext)_localctx).constructorCallRet =  new ConstructorCall(new Identifier((((ConsContext)_localctx).i!=null?((ConsContext)_localctx).i.getText():null))); 
			setState(224);
			match(LPAREN);
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(225);
				((ConsContext)_localctx).e1 = expr(0);
				 _localctx.constructorCallRet.addArgument(((ConsContext)_localctx).e1.expressionRet); 
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(227);
					match(COMMA);
					setState(228);
					((ConsContext)_localctx).e2 = expr(0);
					 _localctx.constructorCallRet.addArgument(((ConsContext)_localctx).e2.expressionRet); 
					}
					}
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(238);
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
			setState(242);
			((BlockContext)_localctx).k = match(KW_BEGIN);
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014399016845072L) != 0)) {
				{
				{
				setState(243);
				((BlockContext)_localctx).s = st();
				 _localctx.blockRet.addStatement(((BlockContext)_localctx).s.statementRet); 
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(251);
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
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				((StContext)_localctx).b = block();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).b.blockRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).b.blockRet.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				((StContext)_localctx).vd = vardecl();
				 ((StContext)_localctx).statementRet =  new VarDeclStmt(((StContext)_localctx).vd.varRet); 
				setState(260);
				match(SEMI);
				 _localctx.statementRet.setLine(((StContext)_localctx).vd.varRet.getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(263);
				((StContext)_localctx).v = vardecl();
				 ((StContext)_localctx).statementRet =  new VarDeclStmt(((StContext)_localctx).v.varRet); 
				setState(265);
				match(ASSIGN);
				setState(266);
				((StContext)_localctx).e = expr(0);
				 ((VarDeclStmt)_localctx.statementRet).setInitial(((StContext)_localctx).e.expressionRet); 
				setState(268);
				match(SEMI);
				 _localctx.statementRet.setLine(((StContext)_localctx).e.expressionRet.getLine()); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(271);
				((StContext)_localctx).mc = methodcall();
				 ((StContext)_localctx).statementRet =  new MethodCallStmt(((StContext)_localctx).mc.methodCallRet); 
				setState(273);
				match(SEMI);
				 _localctx.statementRet.setLine(((StContext)_localctx).mc.methodCallRet.getLine()); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(276);
				((StContext)_localctx).ifs = ifStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).ifs.ifStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).ifs.ifStmtRet.getLine()); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(280);
				((StContext)_localctx).fs = forStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).fs.forStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).fs.forStmtRet.getLine()); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(284);
				((StContext)_localctx).ws = whileStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).ws.whileStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).ws.whileStmtRet.getLine()); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(288);
				((StContext)_localctx).as = assignStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).as.assignStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).as.assignStmtRet.getLine()); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(292);
				((StContext)_localctx).rs = returnStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).rs.returnStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).rs.returnStmtRet.getLine()); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(296);
				((StContext)_localctx).is = inputStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).is.inputStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).is.inputStmtRet.getLine()); 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(300);
				((StContext)_localctx).os = outputStmt();
				 ((StContext)_localctx).statementRet =  ((StContext)_localctx).os.outputStmtRet; 
				 _localctx.statementRet.setLine(((StContext)_localctx).os.outputStmtRet.getLine()); 
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(304);
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
			setState(316);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_BREAK:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				((JumpStmtContext)_localctx).kb = match(KW_BREAK);
				 ((JumpStmtContext)_localctx).jumpStmtRet =  new BreakJump(); 
				 _localctx.jumpStmtRet.setLine((((JumpStmtContext)_localctx).kb!=null?((JumpStmtContext)_localctx).kb.getLine():0)); 
				}
				break;
			case KW_CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
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
			setState(318);
			((IfStmtContext)_localctx).k = match(KW_IF);
			setState(319);
			match(LPAREN);
			setState(320);
			((IfStmtContext)_localctx).e = expr(0);
			setState(321);
			match(RPAREN);
			setState(322);
			((IfStmtContext)_localctx).s1 = st();
			 ((IfStmtContext)_localctx).ifStmtRet =  new IfStmt(((IfStmtContext)_localctx).e.expressionRet, ((IfStmtContext)_localctx).s1.statementRet); 
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(324);
				match(KW_ELSE);
				setState(325);
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
		public ExprContext e1;
		public LocContext l1;
		public ExprContext e2;
		public LocContext l2;
		public ExprContext e3;
		public StContext s;
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
		public List<TerminalNode> ASSIGN() { return getTokens(SimpleLangParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SimpleLangParser.ASSIGN, i);
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
			 ((ForStmtContext)_localctx).forStmtRet =  new ForStmt(); 
			setState(333);
			((ForStmtContext)_localctx).k = match(KW_FOR);
			setState(334);
			match(LPAREN);
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398813576960L) != 0)) {
				{
				setState(335);
				((ForStmtContext)_localctx).i1 = initexpr();
				 _localctx.forStmtRet.addInitializer(((ForStmtContext)_localctx).i1.initExprRet); 
				setState(343);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(337);
					match(COMMA);
					setState(338);
					((ForStmtContext)_localctx).i2 = initexpr();
					 _localctx.forStmtRet.addInitializer(((ForStmtContext)_localctx).i2.initExprRet); 
					}
					}
					setState(345);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(348);
			match(SEMI);
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(349);
				((ForStmtContext)_localctx).e1 = expr(0);
				 _localctx.forStmtRet.setCondition(((ForStmtContext)_localctx).e1.expressionRet); 
				}
			}

			setState(354);
			match(SEMI);
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_THIS || _la==ID) {
				{
				setState(355);
				((ForStmtContext)_localctx).l1 = loc();
				setState(356);
				match(ASSIGN);
				setState(357);
				((ForStmtContext)_localctx).e2 = expr(0);
				 _localctx.forStmtRet.addUpdater(new AssignStmt(((ForStmtContext)_localctx).l1.locationRet, ((ForStmtContext)_localctx).e2.expressionRet)); 
				setState(367);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(359);
					match(COMMA);
					setState(360);
					((ForStmtContext)_localctx).l2 = loc();
					setState(361);
					match(ASSIGN);
					setState(362);
					((ForStmtContext)_localctx).e3 = expr(0);
					 _localctx.forStmtRet.addUpdater(new AssignStmt(((ForStmtContext)_localctx).l2.locationRet, ((ForStmtContext)_localctx).e3.expressionRet)); 
					}
					}
					setState(369);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(372);
			match(RPAREN);
			setState(373);
			((ForStmtContext)_localctx).s = st();
			 _localctx.forStmtRet.setBody(((ForStmtContext)_localctx).s.statementRet); 
			 _localctx.forStmtRet.setLine((((ForStmtContext)_localctx).k!=null?((ForStmtContext)_localctx).k.getLine():0)); 
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
			setState(377);
			((WhileStmtContext)_localctx).k = match(KW_WHILE);
			setState(378);
			match(LPAREN);
			setState(379);
			((WhileStmtContext)_localctx).e = expr(0);
			setState(380);
			match(RPAREN);
			setState(381);
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
			setState(385);
			((AssignStmtContext)_localctx).l = loc();
			setState(386);
			((AssignStmtContext)_localctx).a = match(ASSIGN);
			setState(387);
			((AssignStmtContext)_localctx).e = expr(0);
			 ((AssignStmtContext)_localctx).assignStmtRet =  new AssignStmt(((AssignStmtContext)_localctx).l.locationRet, ((AssignStmtContext)_localctx).e.expressionRet); 
			setState(389);
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
			setState(393);
			((ReturnStmtContext)_localctx).k = match(KW_RETURN);
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(394);
				((ReturnStmtContext)_localctx).e = expr(0);
				 _localctx.returnStmtRet.setValue(((ReturnStmtContext)_localctx).e.expressionRet); 
				}
			}

			setState(399);
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
			setState(402);
			((InputStmtContext)_localctx).k = match(KW_INPUT);
			setState(403);
			((InputStmtContext)_localctx).l = loc();
			 ((InputStmtContext)_localctx).inputStmtRet =  new InputStmt(((InputStmtContext)_localctx).l.locationRet); 
			setState(405);
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
			setState(408);
			((OutputStmtContext)_localctx).k = match(KW_OUTPUT);
			setState(409);
			((OutputStmtContext)_localctx).e = expr(0);
			 ((OutputStmtContext)_localctx).outputStmtRet =  new OutputStmt(((OutputStmtContext)_localctx).e.expressionRet); 
			setState(411);
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
			setState(426);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(414);
				((LocContext)_localctx).s = simpleLoc();
				 ((LocContext)_localctx).locationRet =  ((LocContext)_localctx).s.simpleLocRet; 
				 _localctx.locationRet.setLine(((LocContext)_localctx).s.simpleLocRet.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(418);
				((LocContext)_localctx).m = memberLoc();
				 ((LocContext)_localctx).locationRet =  ((LocContext)_localctx).m.memberLocRet; 
				 _localctx.locationRet.setLine(((LocContext)_localctx).m.memberLocRet.getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(422);
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
			setState(428);
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
			setState(432);
			((MemberLocContext)_localctx).i = match(ID);
			setState(433);
			match(DOT);
			setState(434);
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
			setState(439);
			((ThisLocContext)_localctx).k = match(KW_THIS);
			setState(444);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(440);
				match(DOT);
				setState(441);
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
			setState(453);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(449);
				((MethodcallContext)_localctx).l = loc();
				setState(450);
				match(DOT);

				            _localctx.methodCallRet.setInstance(((MethodcallContext)_localctx).l.locationRet); 
				}
				break;
			}
			setState(455);
			((MethodcallContext)_localctx).i = match(ID);
			 _localctx.methodCallRet.setCallee(new Identifier((((MethodcallContext)_localctx).i!=null?((MethodcallContext)_localctx).i.getText():null))); 
			setState(457);
			match(LPAREN);
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34903451706064896L) != 0)) {
				{
				setState(458);
				((MethodcallContext)_localctx).e1 = expr(0);
				 _localctx.methodCallRet.addArgument(((MethodcallContext)_localctx).e1.expressionRet); 
				setState(466);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(460);
					match(COMMA);
					setState(461);
					((MethodcallContext)_localctx).e2 = expr(0);
					 _localctx.methodCallRet.addArgument(((MethodcallContext)_localctx).e2.expressionRet); 
					}
					}
					setState(468);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(471);
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
		public ExprContext e2;
		public ExprContext e4;
		public ExprContext e6;
		public ExprContext e8;
		public ExprContext e10;
		public ExprContext e12;
		public LocContext l;
		public Token k;
		public MethodcallContext mc;
		public ConsContext c;
		public ExprContext e;
		public Token ci;
		public Token cf;
		public Token cd;
		public Token cc;
		public Token cb;
		public Token op1;
		public ExprContext e1;
		public Token op2;
		public ExprContext e3;
		public Token op3;
		public ExprContext e5;
		public Token op4;
		public ExprContext e7;
		public Token op5;
		public ExprContext e9;
		public Token op6;
		public ExprContext e11;
		public Token op7;
		public ExprContext e13;
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
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
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
			setState(516);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(475);
				((ExprContext)_localctx).l = loc();
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).l.locationRet; 
				 _localctx.expressionRet.setLine(((ExprContext)_localctx).l.locationRet.getLine()); 
				}
				break;
			case 2:
				{
				setState(479);
				((ExprContext)_localctx).k = match(KW_THIS);
				 ((ExprContext)_localctx).expressionRet =  new ThisLoc(); 
				 _localctx.expressionRet.setLine((((ExprContext)_localctx).k!=null?((ExprContext)_localctx).k.getLine():0)); 
				}
				break;
			case 3:
				{
				setState(482);
				((ExprContext)_localctx).mc = methodcall();
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).mc.methodCallRet; 
				 _localctx.expressionRet.setLine(((ExprContext)_localctx).mc.methodCallRet.getLine()); 
				}
				break;
			case 4:
				{
				setState(486);
				((ExprContext)_localctx).c = cons();
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).c.constructorCallRet; 
				 _localctx.expressionRet.setLine(((ExprContext)_localctx).c.constructorCallRet.getLine()); 
				}
				break;
			case 5:
				{
				setState(490);
				match(LPAREN);
				setState(491);
				((ExprContext)_localctx).e = expr(0);
				setState(492);
				match(RPAREN);
				 ((ExprContext)_localctx).expressionRet =  ((ExprContext)_localctx).e.expressionRet; 
				 _localctx.expressionRet.setLine(((ExprContext)_localctx).e.expressionRet.getLine()); 
				}
				break;
			case 6:
				{
				setState(496);
				((ExprContext)_localctx).ci = match(CONSTINT);
				 ((ExprContext)_localctx).expressionRet =  new ConstantExpression(Integer.parseInt((((ExprContext)_localctx).ci!=null?((ExprContext)_localctx).ci.getText():null))); 
				 _localctx.expressionRet.setLine((((ExprContext)_localctx).ci!=null?((ExprContext)_localctx).ci.getLine():0)); 
				}
				break;
			case 7:
				{
				setState(499);
				((ExprContext)_localctx).cf = match(CONSTFLOAT);
				 ((ExprContext)_localctx).expressionRet =  new ConstantExpression(Float.parseFloat((((ExprContext)_localctx).cf!=null?((ExprContext)_localctx).cf.getText():null))); 
				 _localctx.expressionRet.setLine((((ExprContext)_localctx).cf!=null?((ExprContext)_localctx).cf.getLine():0)); 
				}
				break;
			case 8:
				{
				setState(502);
				((ExprContext)_localctx).cd = match(CONSTDOUBLE);
				 ((ExprContext)_localctx).expressionRet =  new ConstantExpression(Double.parseDouble((((ExprContext)_localctx).cd!=null?((ExprContext)_localctx).cd.getText():null))); 
				 _localctx.expressionRet.setLine((((ExprContext)_localctx).cd!=null?((ExprContext)_localctx).cd.getLine():0)); 
				}
				break;
			case 9:
				{
				setState(505);
				((ExprContext)_localctx).cc = match(CONSTCHAR);
				 ((ExprContext)_localctx).expressionRet =  new ConstantExpression((((ExprContext)_localctx).cc!=null?((ExprContext)_localctx).cc.getText():null).charAt(1)); 
				 _localctx.expressionRet.setLine((((ExprContext)_localctx).cc!=null?((ExprContext)_localctx).cc.getLine():0)); 
				}
				break;
			case 10:
				{
				setState(508);
				((ExprContext)_localctx).cb = match(CONSTBOOL);
				 ((ExprContext)_localctx).expressionRet =  new ConstantExpression(Boolean.parseBoolean((((ExprContext)_localctx).cb!=null?((ExprContext)_localctx).cb.getText():null))); 
				 _localctx.expressionRet.setLine((((ExprContext)_localctx).cb!=null?((ExprContext)_localctx).cb.getLine():0)); 
				}
				break;
			case 11:
				{
				setState(511);
				((ExprContext)_localctx).op1 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==KW_NOT || _la==MINUS) ) {
					((ExprContext)_localctx).op1 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(512);
				((ExprContext)_localctx).e1 = expr(7);
				 ((ExprContext)_localctx).expressionRet =  new UnaryExpression((((ExprContext)_localctx).op1!=null?((ExprContext)_localctx).op1.getText():null), ((ExprContext)_localctx).e1.expressionRet); 
				 _localctx.expressionRet.setLine((((ExprContext)_localctx).op1!=null?((ExprContext)_localctx).op1.getLine():0)); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(556);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(554);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e2 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(518);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(519);
						((ExprContext)_localctx).op2 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==SLASH) ) {
							((ExprContext)_localctx).op2 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(520);
						((ExprContext)_localctx).e3 = expr(7);
						 ((ExprContext)_localctx).expressionRet =  new BinaryExpression(((ExprContext)_localctx).e2.expressionRet, (((ExprContext)_localctx).op2!=null?((ExprContext)_localctx).op2.getText():null), ((ExprContext)_localctx).e3.expressionRet); 
						 _localctx.expressionRet.setLine((((ExprContext)_localctx).op2!=null?((ExprContext)_localctx).op2.getLine():0)); 
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e4 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(524);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(525);
						((ExprContext)_localctx).op3 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MINUS || _la==PLUS) ) {
							((ExprContext)_localctx).op3 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(526);
						((ExprContext)_localctx).e5 = expr(6);
						 ((ExprContext)_localctx).expressionRet =  new BinaryExpression(((ExprContext)_localctx).e4.expressionRet, (((ExprContext)_localctx).op3!=null?((ExprContext)_localctx).op3.getText():null), ((ExprContext)_localctx).e5.expressionRet); 
						 _localctx.expressionRet.setLine((((ExprContext)_localctx).op3!=null?((ExprContext)_localctx).op3.getLine():0)); 
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e6 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(530);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(531);
						((ExprContext)_localctx).op4 = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 263882790666240L) != 0)) ) {
							((ExprContext)_localctx).op4 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(532);
						((ExprContext)_localctx).e7 = expr(5);
						 ((ExprContext)_localctx).expressionRet =  new BinaryExpression(((ExprContext)_localctx).e6.expressionRet, (((ExprContext)_localctx).op4!=null?((ExprContext)_localctx).op4.getText():null), ((ExprContext)_localctx).e7.expressionRet); 
						 _localctx.expressionRet.setLine((((ExprContext)_localctx).op4!=null?((ExprContext)_localctx).op4.getLine():0)); 
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e8 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(536);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(537);
						((ExprContext)_localctx).op5 = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
							((ExprContext)_localctx).op5 = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(538);
						((ExprContext)_localctx).e9 = expr(4);
						 ((ExprContext)_localctx).expressionRet =  new BinaryExpression(((ExprContext)_localctx).e8.expressionRet, (((ExprContext)_localctx).op5!=null?((ExprContext)_localctx).op5.getText():null), ((ExprContext)_localctx).e9.expressionRet); 
						 _localctx.expressionRet.setLine((((ExprContext)_localctx).op5!=null?((ExprContext)_localctx).op5.getLine():0)); 
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e10 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(542);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(543);
						((ExprContext)_localctx).op6 = match(KW_AND);
						setState(544);
						((ExprContext)_localctx).e11 = expr(3);
						 ((ExprContext)_localctx).expressionRet =  new BinaryExpression(((ExprContext)_localctx).e10.expressionRet, (((ExprContext)_localctx).op6!=null?((ExprContext)_localctx).op6.getText():null), ((ExprContext)_localctx).e11.expressionRet); 
						 _localctx.expressionRet.setLine((((ExprContext)_localctx).op6!=null?((ExprContext)_localctx).op6.getLine():0)); 
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e12 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(548);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(549);
						((ExprContext)_localctx).op7 = match(KW_OR);
						setState(550);
						((ExprContext)_localctx).e13 = expr(2);
						 ((ExprContext)_localctx).expressionRet =  new BinaryExpression(((ExprContext)_localctx).e12.expressionRet, (((ExprContext)_localctx).op7!=null?((ExprContext)_localctx).op7.getText():null), ((ExprContext)_localctx).e13.expressionRet); 
						 _localctx.expressionRet.setLine((((ExprContext)_localctx).op7!=null?((ExprContext)_localctx).op7.getLine():0)); 
						}
						break;
					}
					} 
				}
				setState(558);
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
			setState(576);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(559);
				((InitexprContext)_localctx).v1 = vardecl();
				 ((InitexprContext)_localctx).initExprRet =  new VarDeclStmt(((InitexprContext)_localctx).v1.varRet); 
				 _localctx.initExprRet.setLine(((InitexprContext)_localctx).v1.varRet.getLine()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(563);
				((InitexprContext)_localctx).l1 = loc();
				setState(564);
				match(ASSIGN);
				setState(565);
				((InitexprContext)_localctx).e1 = expr(0);
				 ((InitexprContext)_localctx).initExprRet =  new AssignStmt(((InitexprContext)_localctx).l1.locationRet, ((InitexprContext)_localctx).e1.expressionRet); 
				 _localctx.initExprRet.setLine(((InitexprContext)_localctx).l1.locationRet.getLine()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(569);
				((InitexprContext)_localctx).v2 = vardecl();
				 ((InitexprContext)_localctx).initExprRet =  new VarDeclStmt(((InitexprContext)_localctx).v2.varRet); 
				setState(571);
				match(ASSIGN);
				setState(572);
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
		"\u0004\u00019\u0243\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002b\b\u0002\n\u0002\f\u0002e\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003q\b"+
		"\u0003\n\u0003\f\u0003t\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004}\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004\u0087\b\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u008e\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0094\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00a6\b\u0007\n\u0007\f\u0007"+
		"\u00a9\t\u0007\u0003\u0007\u00ab\b\u0007\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u00b0\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00cc\b\t\u0001\n\u0001\n\u0001\n\u0003\n\u00d1\b\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00d9\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00e8"+
		"\b\u000b\n\u000b\f\u000b\u00eb\t\u000b\u0003\u000b\u00ed\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0005\f\u00f7\b\f\n\f\f\f\u00fa\t\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0135"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u013d\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u0149\b\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u0156\b\u0010\n\u0010\f\u0010\u0159\t\u0010"+
		"\u0003\u0010\u015b\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u0161\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u016e\b\u0010\n\u0010\f\u0010\u0171\t\u0010\u0003"+
		"\u0010\u0173\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u018e\b\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u01ab\b\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u01bd\b\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u01c6"+
		"\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u01d1\b\u001a\n"+
		"\u001a\f\u001a\u01d4\t\u001a\u0003\u001a\u01d6\b\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0003\u001b\u0205\b\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u022b\b\u001b\n"+
		"\u001b\f\u001b\u022e\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u0241\b\u001c\u0001\u001c\u0000\u00016"+
		"\u001d\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468\u0000\u0005\u0002\u0000\u0016\u0016\'"+
		"\'\u0001\u0000)*\u0001\u0000\'(\u0001\u0000,/\u0001\u000001\u0268\u0000"+
		":\u0001\u0000\u0000\u0000\u0002K\u0001\u0000\u0000\u0000\u0004M\u0001"+
		"\u0000\u0000\u0000\u0006i\u0001\u0000\u0000\u0000\b\u008d\u0001\u0000"+
		"\u0000\u0000\n\u0093\u0001\u0000\u0000\u0000\f\u0095\u0001\u0000\u0000"+
		"\u0000\u000e\u009e\u0001\u0000\u0000\u0000\u0010\u00ac\u0001\u0000\u0000"+
		"\u0000\u0012\u00cb\u0001\u0000\u0000\u0000\u0014\u00cd\u0001\u0000\u0000"+
		"\u0000\u0016\u00de\u0001\u0000\u0000\u0000\u0018\u00f1\u0001\u0000\u0000"+
		"\u0000\u001a\u0134\u0001\u0000\u0000\u0000\u001c\u013c\u0001\u0000\u0000"+
		"\u0000\u001e\u013e\u0001\u0000\u0000\u0000 \u014c\u0001\u0000\u0000\u0000"+
		"\"\u0179\u0001\u0000\u0000\u0000$\u0181\u0001\u0000\u0000\u0000&\u0188"+
		"\u0001\u0000\u0000\u0000(\u0192\u0001\u0000\u0000\u0000*\u0198\u0001\u0000"+
		"\u0000\u0000,\u01aa\u0001\u0000\u0000\u0000.\u01ac\u0001\u0000\u0000\u0000"+
		"0\u01b0\u0001\u0000\u0000\u00002\u01b6\u0001\u0000\u0000\u00004\u01c0"+
		"\u0001\u0000\u0000\u00006\u0204\u0001\u0000\u0000\u00008\u0240\u0001\u0000"+
		"\u0000\u0000:@\u0006\u0000\uffff\uffff\u0000;<\u0003\u0002\u0001\u0000"+
		"<=\u0006\u0000\uffff\uffff\u0000=?\u0001\u0000\u0000\u0000>;\u0001\u0000"+
		"\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001"+
		"\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000"+
		"CD\u0005\u0000\u0000\u0001D\u0001\u0001\u0000\u0000\u0000EF\u0003\u0004"+
		"\u0002\u0000FG\u0006\u0001\uffff\uffff\u0000GL\u0001\u0000\u0000\u0000"+
		"HI\u0003\u0006\u0003\u0000IJ\u0006\u0001\uffff\uffff\u0000JL\u0001\u0000"+
		"\u0000\u0000KE\u0001\u0000\u0000\u0000KH\u0001\u0000\u0000\u0000L\u0003"+
		"\u0001\u0000\u0000\u0000MN\u0005\u0001\u0000\u0000NO\u00056\u0000\u0000"+
		"O[\u0006\u0002\uffff\uffff\u0000PQ\u0005\u0003\u0000\u0000QR\u00056\u0000"+
		"\u0000RX\u0006\u0002\uffff\uffff\u0000ST\u0005\u001f\u0000\u0000TU\u0005"+
		"6\u0000\u0000UW\u0006\u0002\uffff\uffff\u0000VS\u0001\u0000\u0000\u0000"+
		"WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000"+
		"\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000[P\u0001\u0000"+
		"\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]c\u0005"+
		"\u0004\u0000\u0000^_\u0003\b\u0004\u0000_`\u0006\u0002\uffff\uffff\u0000"+
		"`b\u0001\u0000\u0000\u0000a^\u0001\u0000\u0000\u0000be\u0001\u0000\u0000"+
		"\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000df\u0001\u0000"+
		"\u0000\u0000ec\u0001\u0000\u0000\u0000fg\u0005\u0005\u0000\u0000gh\u0006"+
		"\u0002\uffff\uffff\u0000h\u0005\u0001\u0000\u0000\u0000ij\u0005\u0002"+
		"\u0000\u0000jk\u00056\u0000\u0000kl\u0006\u0003\uffff\uffff\u0000lr\u0005"+
		"\u0004\u0000\u0000mn\u0003\b\u0004\u0000no\u0006\u0003\uffff\uffff\u0000"+
		"oq\u0001\u0000\u0000\u0000pm\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000"+
		"\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000su\u0001\u0000"+
		"\u0000\u0000tr\u0001\u0000\u0000\u0000uv\u0005\u0005\u0000\u0000vw\u0006"+
		"\u0003\uffff\uffff\u0000w\u0007\u0001\u0000\u0000\u0000x|\u0006\u0004"+
		"\uffff\uffff\u0000yz\u0003\n\u0005\u0000z{\u0006\u0004\uffff\uffff\u0000"+
		"{}\u0001\u0000\u0000\u0000|y\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000"+
		"\u0000}~\u0001\u0000\u0000\u0000~\u007f\u0003\f\u0006\u0000\u007f\u0080"+
		"\u0006\u0004\uffff\uffff\u0000\u0080\u0081\u0006\u0004\uffff\uffff\u0000"+
		"\u0081\u008e\u0001\u0000\u0000\u0000\u0082\u0086\u0006\u0004\uffff\uffff"+
		"\u0000\u0083\u0084\u0003\n\u0005\u0000\u0084\u0085\u0006\u0004\uffff\uffff"+
		"\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086\u0083\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0003\u0014\n\u0000\u0089\u008a\u0006\u0004\uffff\uffff"+
		"\u0000\u008a\u008b\u0006\u0004\uffff\uffff\u0000\u008b\u008c\u0005\u001e"+
		"\u0000\u0000\u008c\u008e\u0001\u0000\u0000\u0000\u008dx\u0001\u0000\u0000"+
		"\u0000\u008d\u0082\u0001\u0000\u0000\u0000\u008e\t\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0005\u0007\u0000\u0000\u0090\u0094\u0006\u0005\uffff\uffff"+
		"\u0000\u0091\u0092\u0005\u0006\u0000\u0000\u0092\u0094\u0006\u0005\uffff"+
		"\uffff\u0000\u0093\u008f\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000"+
		"\u0000\u0000\u0094\u000b\u0001\u0000\u0000\u0000\u0095\u0096\u0003\u0012"+
		"\t\u0000\u0096\u0097\u00056\u0000\u0000\u0097\u0098\u0005 \u0000\u0000"+
		"\u0098\u0099\u0003\u000e\u0007\u0000\u0099\u009a\u0005!\u0000\u0000\u009a"+
		"\u009b\u0003\u0018\f\u0000\u009b\u009c\u0006\u0006\uffff\uffff\u0000\u009c"+
		"\u009d\u0006\u0006\uffff\uffff\u0000\u009d\r\u0001\u0000\u0000\u0000\u009e"+
		"\u00aa\u0006\u0007\uffff\uffff\u0000\u009f\u00a0\u0003\u0010\b\u0000\u00a0"+
		"\u00a7\u0006\u0007\uffff\uffff\u0000\u00a1\u00a2\u0005\u001f\u0000\u0000"+
		"\u00a2\u00a3\u0003\u0010\b\u0000\u00a3\u00a4\u0006\u0007\uffff\uffff\u0000"+
		"\u00a4\u00a6\u0001\u0000\u0000\u0000\u00a5\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a9\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000"+
		"\u00a9\u00a7\u0001\u0000\u0000\u0000\u00aa\u009f\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u000f\u0001\u0000\u0000\u0000"+
		"\u00ac\u00af\u0006\b\uffff\uffff\u0000\u00ad\u00ae\u0005\u0019\u0000\u0000"+
		"\u00ae\u00b0\u0006\b\uffff\uffff\u0000\u00af\u00ad\u0001\u0000\u0000\u0000"+
		"\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b2\u0003\u0012\t\u0000\u00b2\u00b3\u00056\u0000\u0000\u00b3"+
		"\u00b4\u0006\b\uffff\uffff\u0000\u00b4\u00b5\u0006\b\uffff\uffff\u0000"+
		"\u00b5\u0011\u0001\u0000\u0000\u0000\u00b6\u00b7\u00056\u0000\u0000\u00b7"+
		"\u00b8\u0006\t\uffff\uffff\u0000\u00b8\u00cc\u0006\t\uffff\uffff\u0000"+
		"\u00b9\u00ba\u0005\b\u0000\u0000\u00ba\u00bb\u0006\t\uffff\uffff\u0000"+
		"\u00bb\u00cc\u0006\t\uffff\uffff\u0000\u00bc\u00bd\u0005\t\u0000\u0000"+
		"\u00bd\u00be\u0006\t\uffff\uffff\u0000\u00be\u00cc\u0006\t\uffff\uffff"+
		"\u0000\u00bf\u00c0\u0005\n\u0000\u0000\u00c0\u00c1\u0006\t\uffff\uffff"+
		"\u0000\u00c1\u00cc\u0006\t\uffff\uffff\u0000\u00c2\u00c3\u0005\u000b\u0000"+
		"\u0000\u00c3\u00c4\u0006\t\uffff\uffff\u0000\u00c4\u00cc\u0006\t\uffff"+
		"\uffff\u0000\u00c5\u00c6\u0005\f\u0000\u0000\u00c6\u00c7\u0006\t\uffff"+
		"\uffff\u0000\u00c7\u00cc\u0006\t\uffff\uffff\u0000\u00c8\u00c9\u0005\u001c"+
		"\u0000\u0000\u00c9\u00ca\u0006\t\uffff\uffff\u0000\u00ca\u00cc\u0006\t"+
		"\uffff\uffff\u0000\u00cb\u00b6\u0001\u0000\u0000\u0000\u00cb\u00b9\u0001"+
		"\u0000\u0000\u0000\u00cb\u00bc\u0001\u0000\u0000\u0000\u00cb\u00bf\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c2\u0001\u0000\u0000\u0000\u00cb\u00c5\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c8\u0001\u0000\u0000\u0000\u00cc\u0013\u0001"+
		"\u0000\u0000\u0000\u00cd\u00d0\u0006\n\uffff\uffff\u0000\u00ce\u00cf\u0005"+
		"\u0019\u0000\u0000\u00cf\u00d1\u0006\n\uffff\uffff\u0000\u00d0\u00ce\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d8\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d3\u0003\u0012\t\u0000\u00d3\u00d4\u0006\n"+
		"\uffff\uffff\u0000\u00d4\u00d9\u0001\u0000\u0000\u0000\u00d5\u00d6\u0003"+
		"\u0016\u000b\u0000\u00d6\u00d7\u0006\n\uffff\uffff\u0000\u00d7\u00d9\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d2\u0001\u0000\u0000\u0000\u00d8\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00db\u0005"+
		"6\u0000\u0000\u00db\u00dc\u0006\n\uffff\uffff\u0000\u00dc\u00dd\u0006"+
		"\n\uffff\uffff\u0000\u00dd\u0015\u0001\u0000\u0000\u0000\u00de\u00df\u0005"+
		"6\u0000\u0000\u00df\u00e0\u0006\u000b\uffff\uffff\u0000\u00e0\u00ec\u0005"+
		" \u0000\u0000\u00e1\u00e2\u00036\u001b\u0000\u00e2\u00e9\u0006\u000b\uffff"+
		"\uffff\u0000\u00e3\u00e4\u0005\u001f\u0000\u0000\u00e4\u00e5\u00036\u001b"+
		"\u0000\u00e5\u00e6\u0006\u000b\uffff\uffff\u0000\u00e6\u00e8\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e3\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000"+
		"\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000"+
		"\u0000\u0000\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000"+
		"\u0000\u0000\u00ec\u00e1\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000"+
		"\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005!\u0000"+
		"\u0000\u00ef\u00f0\u0006\u000b\uffff\uffff\u0000\u00f0\u0017\u0001\u0000"+
		"\u0000\u0000\u00f1\u00f2\u0006\f\uffff\uffff\u0000\u00f2\u00f8\u0005\u0004"+
		"\u0000\u0000\u00f3\u00f4\u0003\u001a\r\u0000\u00f4\u00f5\u0006\f\uffff"+
		"\uffff\u0000\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fb\u0001\u0000"+
		"\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005\u0005"+
		"\u0000\u0000\u00fc\u00fd\u0006\f\uffff\uffff\u0000\u00fd\u0019\u0001\u0000"+
		"\u0000\u0000\u00fe\u00ff\u0003\u0018\f\u0000\u00ff\u0100\u0006\r\uffff"+
		"\uffff\u0000\u0100\u0101\u0006\r\uffff\uffff\u0000\u0101\u0135\u0001\u0000"+
		"\u0000\u0000\u0102\u0103\u0003\u0014\n\u0000\u0103\u0104\u0006\r\uffff"+
		"\uffff\u0000\u0104\u0105\u0005\u001e\u0000\u0000\u0105\u0106\u0006\r\uffff"+
		"\uffff\u0000\u0106\u0135\u0001\u0000\u0000\u0000\u0107\u0108\u0003\u0014"+
		"\n\u0000\u0108\u0109\u0006\r\uffff\uffff\u0000\u0109\u010a\u0005$\u0000"+
		"\u0000\u010a\u010b\u00036\u001b\u0000\u010b\u010c\u0006\r\uffff\uffff"+
		"\u0000\u010c\u010d\u0005\u001e\u0000\u0000\u010d\u010e\u0006\r\uffff\uffff"+
		"\u0000\u010e\u0135\u0001\u0000\u0000\u0000\u010f\u0110\u00034\u001a\u0000"+
		"\u0110\u0111\u0006\r\uffff\uffff\u0000\u0111\u0112\u0005\u001e\u0000\u0000"+
		"\u0112\u0113\u0006\r\uffff\uffff\u0000\u0113\u0135\u0001\u0000\u0000\u0000"+
		"\u0114\u0115\u0003\u001e\u000f\u0000\u0115\u0116\u0006\r\uffff\uffff\u0000"+
		"\u0116\u0117\u0006\r\uffff\uffff\u0000\u0117\u0135\u0001\u0000\u0000\u0000"+
		"\u0118\u0119\u0003 \u0010\u0000\u0119\u011a\u0006\r\uffff\uffff\u0000"+
		"\u011a\u011b\u0006\r\uffff\uffff\u0000\u011b\u0135\u0001\u0000\u0000\u0000"+
		"\u011c\u011d\u0003\"\u0011\u0000\u011d\u011e\u0006\r\uffff\uffff\u0000"+
		"\u011e\u011f\u0006\r\uffff\uffff\u0000\u011f\u0135\u0001\u0000\u0000\u0000"+
		"\u0120\u0121\u0003$\u0012\u0000\u0121\u0122\u0006\r\uffff\uffff\u0000"+
		"\u0122\u0123\u0006\r\uffff\uffff\u0000\u0123\u0135\u0001\u0000\u0000\u0000"+
		"\u0124\u0125\u0003&\u0013\u0000\u0125\u0126\u0006\r\uffff\uffff\u0000"+
		"\u0126\u0127\u0006\r\uffff\uffff\u0000\u0127\u0135\u0001\u0000\u0000\u0000"+
		"\u0128\u0129\u0003(\u0014\u0000\u0129\u012a\u0006\r\uffff\uffff\u0000"+
		"\u012a\u012b\u0006\r\uffff\uffff\u0000\u012b\u0135\u0001\u0000\u0000\u0000"+
		"\u012c\u012d\u0003*\u0015\u0000\u012d\u012e\u0006\r\uffff\uffff\u0000"+
		"\u012e\u012f\u0006\r\uffff\uffff\u0000\u012f\u0135\u0001\u0000\u0000\u0000"+
		"\u0130\u0131\u0003\u001c\u000e\u0000\u0131\u0132\u0006\r\uffff\uffff\u0000"+
		"\u0132\u0133\u0006\r\uffff\uffff\u0000\u0133\u0135\u0001\u0000\u0000\u0000"+
		"\u0134\u00fe\u0001\u0000\u0000\u0000\u0134\u0102\u0001\u0000\u0000\u0000"+
		"\u0134\u0107\u0001\u0000\u0000\u0000\u0134\u010f\u0001\u0000\u0000\u0000"+
		"\u0134\u0114\u0001\u0000\u0000\u0000\u0134\u0118\u0001\u0000\u0000\u0000"+
		"\u0134\u011c\u0001\u0000\u0000\u0000\u0134\u0120\u0001\u0000\u0000\u0000"+
		"\u0134\u0124\u0001\u0000\u0000\u0000\u0134\u0128\u0001\u0000\u0000\u0000"+
		"\u0134\u012c\u0001\u0000\u0000\u0000\u0134\u0130\u0001\u0000\u0000\u0000"+
		"\u0135\u001b\u0001\u0000\u0000\u0000\u0136\u0137\u0005\u001a\u0000\u0000"+
		"\u0137\u0138\u0006\u000e\uffff\uffff\u0000\u0138\u013d\u0006\u000e\uffff"+
		"\uffff\u0000\u0139\u013a\u0005\u001b\u0000\u0000\u013a\u013b\u0006\u000e"+
		"\uffff\uffff\u0000\u013b\u013d\u0006\u000e\uffff\uffff\u0000\u013c\u0136"+
		"\u0001\u0000\u0000\u0000\u013c\u0139\u0001\u0000\u0000\u0000\u013d\u001d"+
		"\u0001\u0000\u0000\u0000\u013e\u013f\u0005\r\u0000\u0000\u013f\u0140\u0005"+
		" \u0000\u0000\u0140\u0141\u00036\u001b\u0000\u0141\u0142\u0005!\u0000"+
		"\u0000\u0142\u0143\u0003\u001a\r\u0000\u0143\u0148\u0006\u000f\uffff\uffff"+
		"\u0000\u0144\u0145\u0005\u000e\u0000\u0000\u0145\u0146\u0003\u001a\r\u0000"+
		"\u0146\u0147\u0006\u000f\uffff\uffff\u0000\u0147\u0149\u0001\u0000\u0000"+
		"\u0000\u0148\u0144\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000"+
		"\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u014b\u0006\u000f\uffff"+
		"\uffff\u0000\u014b\u001f\u0001\u0000\u0000\u0000\u014c\u014d\u0006\u0010"+
		"\uffff\uffff\u0000\u014d\u014e\u0005\u000f\u0000\u0000\u014e\u015a\u0005"+
		" \u0000\u0000\u014f\u0150\u00038\u001c\u0000\u0150\u0157\u0006\u0010\uffff"+
		"\uffff\u0000\u0151\u0152\u0005\u001f\u0000\u0000\u0152\u0153\u00038\u001c"+
		"\u0000\u0153\u0154\u0006\u0010\uffff\uffff\u0000\u0154\u0156\u0001\u0000"+
		"\u0000\u0000\u0155\u0151\u0001\u0000\u0000\u0000\u0156\u0159\u0001\u0000"+
		"\u0000\u0000\u0157\u0155\u0001\u0000\u0000\u0000\u0157\u0158\u0001\u0000"+
		"\u0000\u0000\u0158\u015b\u0001\u0000\u0000\u0000\u0159\u0157\u0001\u0000"+
		"\u0000\u0000\u015a\u014f\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000"+
		"\u0000\u0000\u015b\u015c\u0001\u0000\u0000\u0000\u015c\u0160\u0005\u001e"+
		"\u0000\u0000\u015d\u015e\u00036\u001b\u0000\u015e\u015f\u0006\u0010\uffff"+
		"\uffff\u0000\u015f\u0161\u0001\u0000\u0000\u0000\u0160\u015d\u0001\u0000"+
		"\u0000\u0000\u0160\u0161\u0001\u0000\u0000\u0000\u0161\u0162\u0001\u0000"+
		"\u0000\u0000\u0162\u0172\u0005\u001e\u0000\u0000\u0163\u0164\u0003,\u0016"+
		"\u0000\u0164\u0165\u0005$\u0000\u0000\u0165\u0166\u00036\u001b\u0000\u0166"+
		"\u016f\u0006\u0010\uffff\uffff\u0000\u0167\u0168\u0005\u001f\u0000\u0000"+
		"\u0168\u0169\u0003,\u0016\u0000\u0169\u016a\u0005$\u0000\u0000\u016a\u016b"+
		"\u00036\u001b\u0000\u016b\u016c\u0006\u0010\uffff\uffff\u0000\u016c\u016e"+
		"\u0001\u0000\u0000\u0000\u016d\u0167\u0001\u0000\u0000\u0000\u016e\u0171"+
		"\u0001\u0000\u0000\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u016f\u0170"+
		"\u0001\u0000\u0000\u0000\u0170\u0173\u0001\u0000\u0000\u0000\u0171\u016f"+
		"\u0001\u0000\u0000\u0000\u0172\u0163\u0001\u0000\u0000\u0000\u0172\u0173"+
		"\u0001\u0000\u0000\u0000\u0173\u0174\u0001\u0000\u0000\u0000\u0174\u0175"+
		"\u0005!\u0000\u0000\u0175\u0176\u0003\u001a\r\u0000\u0176\u0177\u0006"+
		"\u0010\uffff\uffff\u0000\u0177\u0178\u0006\u0010\uffff\uffff\u0000\u0178"+
		"!\u0001\u0000\u0000\u0000\u0179\u017a\u0005\u0010\u0000\u0000\u017a\u017b"+
		"\u0005 \u0000\u0000\u017b\u017c\u00036\u001b\u0000\u017c\u017d\u0005!"+
		"\u0000\u0000\u017d\u017e\u0003\u001a\r\u0000\u017e\u017f\u0006\u0011\uffff"+
		"\uffff\u0000\u017f\u0180\u0006\u0011\uffff\uffff\u0000\u0180#\u0001\u0000"+
		"\u0000\u0000\u0181\u0182\u0003,\u0016\u0000\u0182\u0183\u0005$\u0000\u0000"+
		"\u0183\u0184\u00036\u001b\u0000\u0184\u0185\u0006\u0012\uffff\uffff\u0000"+
		"\u0185\u0186\u0005\u001e\u0000\u0000\u0186\u0187\u0006\u0012\uffff\uffff"+
		"\u0000\u0187%\u0001\u0000\u0000\u0000\u0188\u0189\u0006\u0013\uffff\uffff"+
		"\u0000\u0189\u018d\u0005\u0012\u0000\u0000\u018a\u018b\u00036\u001b\u0000"+
		"\u018b\u018c\u0006\u0013\uffff\uffff\u0000\u018c\u018e\u0001\u0000\u0000"+
		"\u0000\u018d\u018a\u0001\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000"+
		"\u0000\u018e\u018f\u0001\u0000\u0000\u0000\u018f\u0190\u0005\u001e\u0000"+
		"\u0000\u0190\u0191\u0006\u0013\uffff\uffff\u0000\u0191\'\u0001\u0000\u0000"+
		"\u0000\u0192\u0193\u0005\u0013\u0000\u0000\u0193\u0194\u0003,\u0016\u0000"+
		"\u0194\u0195\u0006\u0014\uffff\uffff\u0000\u0195\u0196\u0005\u001e\u0000"+
		"\u0000\u0196\u0197\u0006\u0014\uffff\uffff\u0000\u0197)\u0001\u0000\u0000"+
		"\u0000\u0198\u0199\u0005\u0014\u0000\u0000\u0199\u019a\u00036\u001b\u0000"+
		"\u019a\u019b\u0006\u0015\uffff\uffff\u0000\u019b\u019c\u0005\u001e\u0000"+
		"\u0000\u019c\u019d\u0006\u0015\uffff\uffff\u0000\u019d+\u0001\u0000\u0000"+
		"\u0000\u019e\u019f\u0003.\u0017\u0000\u019f\u01a0\u0006\u0016\uffff\uffff"+
		"\u0000\u01a0\u01a1\u0006\u0016\uffff\uffff\u0000\u01a1\u01ab\u0001\u0000"+
		"\u0000\u0000\u01a2\u01a3\u00030\u0018\u0000\u01a3\u01a4\u0006\u0016\uffff"+
		"\uffff\u0000\u01a4\u01a5\u0006\u0016\uffff\uffff\u0000\u01a5\u01ab\u0001"+
		"\u0000\u0000\u0000\u01a6\u01a7\u00032\u0019\u0000\u01a7\u01a8\u0006\u0016"+
		"\uffff\uffff\u0000\u01a8\u01a9\u0006\u0016\uffff\uffff\u0000\u01a9\u01ab"+
		"\u0001\u0000\u0000\u0000\u01aa\u019e\u0001\u0000\u0000\u0000\u01aa\u01a2"+
		"\u0001\u0000\u0000\u0000\u01aa\u01a6\u0001\u0000\u0000\u0000\u01ab-\u0001"+
		"\u0000\u0000\u0000\u01ac\u01ad\u00056\u0000\u0000\u01ad\u01ae\u0006\u0017"+
		"\uffff\uffff\u0000\u01ae\u01af\u0006\u0017\uffff\uffff\u0000\u01af/\u0001"+
		"\u0000\u0000\u0000\u01b0\u01b1\u00056\u0000\u0000\u01b1\u01b2\u0005%\u0000"+
		"\u0000\u01b2\u01b3\u0003,\u0016\u0000\u01b3\u01b4\u0006\u0018\uffff\uffff"+
		"\u0000\u01b4\u01b5\u0006\u0018\uffff\uffff\u0000\u01b51\u0001\u0000\u0000"+
		"\u0000\u01b6\u01b7\u0006\u0019\uffff\uffff\u0000\u01b7\u01bc\u0005\u0015"+
		"\u0000\u0000\u01b8\u01b9\u0005%\u0000\u0000\u01b9\u01ba\u0003,\u0016\u0000"+
		"\u01ba\u01bb\u0006\u0019\uffff\uffff\u0000\u01bb\u01bd\u0001\u0000\u0000"+
		"\u0000\u01bc\u01b8\u0001\u0000\u0000\u0000\u01bc\u01bd\u0001\u0000\u0000"+
		"\u0000\u01bd\u01be\u0001\u0000\u0000\u0000\u01be\u01bf\u0006\u0019\uffff"+
		"\uffff\u0000\u01bf3\u0001\u0000\u0000\u0000\u01c0\u01c5\u0006\u001a\uffff"+
		"\uffff\u0000\u01c1\u01c2\u0003,\u0016\u0000\u01c2\u01c3\u0005%\u0000\u0000"+
		"\u01c3\u01c4\u0006\u001a\uffff\uffff\u0000\u01c4\u01c6\u0001\u0000\u0000"+
		"\u0000\u01c5\u01c1\u0001\u0000\u0000\u0000\u01c5\u01c6\u0001\u0000\u0000"+
		"\u0000\u01c6\u01c7\u0001\u0000\u0000\u0000\u01c7\u01c8\u00056\u0000\u0000"+
		"\u01c8\u01c9\u0006\u001a\uffff\uffff\u0000\u01c9\u01d5\u0005 \u0000\u0000"+
		"\u01ca\u01cb\u00036\u001b\u0000\u01cb\u01d2\u0006\u001a\uffff\uffff\u0000"+
		"\u01cc\u01cd\u0005\u001f\u0000\u0000\u01cd\u01ce\u00036\u001b\u0000\u01ce"+
		"\u01cf\u0006\u001a\uffff\uffff\u0000\u01cf\u01d1\u0001\u0000\u0000\u0000"+
		"\u01d0\u01cc\u0001\u0000\u0000\u0000\u01d1\u01d4\u0001\u0000\u0000\u0000"+
		"\u01d2\u01d0\u0001\u0000\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000"+
		"\u01d3\u01d6\u0001\u0000\u0000\u0000\u01d4\u01d2\u0001\u0000\u0000\u0000"+
		"\u01d5\u01ca\u0001\u0000\u0000\u0000\u01d5\u01d6\u0001\u0000\u0000\u0000"+
		"\u01d6\u01d7\u0001\u0000\u0000\u0000\u01d7\u01d8\u0005!\u0000\u0000\u01d8"+
		"\u01d9\u0006\u001a\uffff\uffff\u0000\u01d95\u0001\u0000\u0000\u0000\u01da"+
		"\u01db\u0006\u001b\uffff\uffff\u0000\u01db\u01dc\u0003,\u0016\u0000\u01dc"+
		"\u01dd\u0006\u001b\uffff\uffff\u0000\u01dd\u01de\u0006\u001b\uffff\uffff"+
		"\u0000\u01de\u0205\u0001\u0000\u0000\u0000\u01df\u01e0\u0005\u0015\u0000"+
		"\u0000\u01e0\u01e1\u0006\u001b\uffff\uffff\u0000\u01e1\u0205\u0006\u001b"+
		"\uffff\uffff\u0000\u01e2\u01e3\u00034\u001a\u0000\u01e3\u01e4\u0006\u001b"+
		"\uffff\uffff\u0000\u01e4\u01e5\u0006\u001b\uffff\uffff\u0000\u01e5\u0205"+
		"\u0001\u0000\u0000\u0000\u01e6\u01e7\u0003\u0016\u000b\u0000\u01e7\u01e8"+
		"\u0006\u001b\uffff\uffff\u0000\u01e8\u01e9\u0006\u001b\uffff\uffff\u0000"+
		"\u01e9\u0205\u0001\u0000\u0000\u0000\u01ea\u01eb\u0005 \u0000\u0000\u01eb"+
		"\u01ec\u00036\u001b\u0000\u01ec\u01ed\u0005!\u0000\u0000\u01ed\u01ee\u0006"+
		"\u001b\uffff\uffff\u0000\u01ee\u01ef\u0006\u001b\uffff\uffff\u0000\u01ef"+
		"\u0205\u0001\u0000\u0000\u0000\u01f0\u01f1\u00052\u0000\u0000\u01f1\u01f2"+
		"\u0006\u001b\uffff\uffff\u0000\u01f2\u0205\u0006\u001b\uffff\uffff\u0000"+
		"\u01f3\u01f4\u00053\u0000\u0000\u01f4\u01f5\u0006\u001b\uffff\uffff\u0000"+
		"\u01f5\u0205\u0006\u001b\uffff\uffff\u0000\u01f6\u01f7\u00054\u0000\u0000"+
		"\u01f7\u01f8\u0006\u001b\uffff\uffff\u0000\u01f8\u0205\u0006\u001b\uffff"+
		"\uffff\u0000\u01f9\u01fa\u00055\u0000\u0000\u01fa\u01fb\u0006\u001b\uffff"+
		"\uffff\u0000\u01fb\u0205\u0006\u001b\uffff\uffff\u0000\u01fc\u01fd\u0005"+
		"\u001d\u0000\u0000\u01fd\u01fe\u0006\u001b\uffff\uffff\u0000\u01fe\u0205"+
		"\u0006\u001b\uffff\uffff\u0000\u01ff\u0200\u0007\u0000\u0000\u0000\u0200"+
		"\u0201\u00036\u001b\u0007\u0201\u0202\u0006\u001b\uffff\uffff\u0000\u0202"+
		"\u0203\u0006\u001b\uffff\uffff\u0000\u0203\u0205\u0001\u0000\u0000\u0000"+
		"\u0204\u01da\u0001\u0000\u0000\u0000\u0204\u01df\u0001\u0000\u0000\u0000"+
		"\u0204\u01e2\u0001\u0000\u0000\u0000\u0204\u01e6\u0001\u0000\u0000\u0000"+
		"\u0204\u01ea\u0001\u0000\u0000\u0000\u0204\u01f0\u0001\u0000\u0000\u0000"+
		"\u0204\u01f3\u0001\u0000\u0000\u0000\u0204\u01f6\u0001\u0000\u0000\u0000"+
		"\u0204\u01f9\u0001\u0000\u0000\u0000\u0204\u01fc\u0001\u0000\u0000\u0000"+
		"\u0204\u01ff\u0001\u0000\u0000\u0000\u0205\u022c\u0001\u0000\u0000\u0000"+
		"\u0206\u0207\n\u0006\u0000\u0000\u0207\u0208\u0007\u0001\u0000\u0000\u0208"+
		"\u0209\u00036\u001b\u0007\u0209\u020a\u0006\u001b\uffff\uffff\u0000\u020a"+
		"\u020b\u0006\u001b\uffff\uffff\u0000\u020b\u022b\u0001\u0000\u0000\u0000"+
		"\u020c\u020d\n\u0005\u0000\u0000\u020d\u020e\u0007\u0002\u0000\u0000\u020e"+
		"\u020f\u00036\u001b\u0006\u020f\u0210\u0006\u001b\uffff\uffff\u0000\u0210"+
		"\u0211\u0006\u001b\uffff\uffff\u0000\u0211\u022b\u0001\u0000\u0000\u0000"+
		"\u0212\u0213\n\u0004\u0000\u0000\u0213\u0214\u0007\u0003\u0000\u0000\u0214"+
		"\u0215\u00036\u001b\u0005\u0215\u0216\u0006\u001b\uffff\uffff\u0000\u0216"+
		"\u0217\u0006\u001b\uffff\uffff\u0000\u0217\u022b\u0001\u0000\u0000\u0000"+
		"\u0218\u0219\n\u0003\u0000\u0000\u0219\u021a\u0007\u0004\u0000\u0000\u021a"+
		"\u021b\u00036\u001b\u0004\u021b\u021c\u0006\u001b\uffff\uffff\u0000\u021c"+
		"\u021d\u0006\u001b\uffff\uffff\u0000\u021d\u022b\u0001\u0000\u0000\u0000"+
		"\u021e\u021f\n\u0002\u0000\u0000\u021f\u0220\u0005\u0017\u0000\u0000\u0220"+
		"\u0221\u00036\u001b\u0003\u0221\u0222\u0006\u001b\uffff\uffff\u0000\u0222"+
		"\u0223\u0006\u001b\uffff\uffff\u0000\u0223\u022b\u0001\u0000\u0000\u0000"+
		"\u0224\u0225\n\u0001\u0000\u0000\u0225\u0226\u0005\u0018\u0000\u0000\u0226"+
		"\u0227\u00036\u001b\u0002\u0227\u0228\u0006\u001b\uffff\uffff\u0000\u0228"+
		"\u0229\u0006\u001b\uffff\uffff\u0000\u0229\u022b\u0001\u0000\u0000\u0000"+
		"\u022a\u0206\u0001\u0000\u0000\u0000\u022a\u020c\u0001\u0000\u0000\u0000"+
		"\u022a\u0212\u0001\u0000\u0000\u0000\u022a\u0218\u0001\u0000\u0000\u0000"+
		"\u022a\u021e\u0001\u0000\u0000\u0000\u022a\u0224\u0001\u0000\u0000\u0000"+
		"\u022b\u022e\u0001\u0000\u0000\u0000\u022c\u022a\u0001\u0000\u0000\u0000"+
		"\u022c\u022d\u0001\u0000\u0000\u0000\u022d7\u0001\u0000\u0000\u0000\u022e"+
		"\u022c\u0001\u0000\u0000\u0000\u022f\u0230\u0003\u0014\n\u0000\u0230\u0231"+
		"\u0006\u001c\uffff\uffff\u0000\u0231\u0232\u0006\u001c\uffff\uffff\u0000"+
		"\u0232\u0241\u0001\u0000\u0000\u0000\u0233\u0234\u0003,\u0016\u0000\u0234"+
		"\u0235\u0005$\u0000\u0000\u0235\u0236\u00036\u001b\u0000\u0236\u0237\u0006"+
		"\u001c\uffff\uffff\u0000\u0237\u0238\u0006\u001c\uffff\uffff\u0000\u0238"+
		"\u0241\u0001\u0000\u0000\u0000\u0239\u023a\u0003\u0014\n\u0000\u023a\u023b"+
		"\u0006\u001c\uffff\uffff\u0000\u023b\u023c\u0005$\u0000\u0000\u023c\u023d"+
		"\u00036\u001b\u0000\u023d\u023e\u0006\u001c\uffff\uffff\u0000\u023e\u023f"+
		"\u0006\u001c\uffff\uffff\u0000\u023f\u0241\u0001\u0000\u0000\u0000\u0240"+
		"\u022f\u0001\u0000\u0000\u0000\u0240\u0233\u0001\u0000\u0000\u0000\u0240"+
		"\u0239\u0001\u0000\u0000\u0000\u02419\u0001\u0000\u0000\u0000%@KX[cr|"+
		"\u0086\u008d\u0093\u00a7\u00aa\u00af\u00cb\u00d0\u00d8\u00e9\u00ec\u00f8"+
		"\u0134\u013c\u0148\u0157\u015a\u0160\u016f\u0172\u018d\u01aa\u01bc\u01c5"+
		"\u01d2\u01d5\u0204\u022a\u022c\u0240";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
