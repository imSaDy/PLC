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
		RULE_program = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"program"
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
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof simpleLangListener ) ((simpleLangListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof simpleLangVisitor ) return ((simpleLangVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	public static final String _serializedATN =
		"\u0004\u00015\u0005\u0002\u0000\u0007\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0000\u0000\u0001\u0000\u0000\u0000\u0003\u0000\u0002\u0001\u0000"+
		"\u0000\u0000\u0002\u0003\u0001\u0000\u0000\u0000\u0003\u0001\u0001\u0000"+
		"\u0000\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}