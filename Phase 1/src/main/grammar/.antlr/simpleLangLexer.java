// Generated from /home/sadegh/Desktop/Compiler/Template/src/main/grammar/simpleLang.g4 by ANTLR 4.13.1

    package main.grammar;
    import main.ast.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class simpleLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MAIN=1, INT=2, BOOL=3, IF=4, ELSE=5, TRUE=6, FALSE=7, LBRACE=8, RBRACE=9, 
		SEMI=10, ASSIGN=11, PLUS=12, LPAR=13, RPAR=14, ID=15, INT_VAL=16, WHITE_SPACE=17, 
		LINE_COMMENT=18, BLOCK_COMMENT=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"MAIN", "INT", "BOOL", "IF", "ELSE", "TRUE", "FALSE", "LBRACE", "RBRACE", 
			"SEMI", "ASSIGN", "PLUS", "LPAR", "RPAR", "ID", "INT_VAL", "WHITE_SPACE", 
			"LINE_COMMENT", "BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'int'", "'bool'", "'if'", "'else'", "'true'", "'false'", 
			"'{'", "'}'", "';'", "'='", "'+'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MAIN", "INT", "BOOL", "IF", "ELSE", "TRUE", "FALSE", "LBRACE", 
			"RBRACE", "SEMI", "ASSIGN", "PLUS", "LPAR", "RPAR", "ID", "INT_VAL", 
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


	public simpleLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "simpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0013\u0082\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0005"+
		"\u000eY\b\u000e\n\u000e\f\u000e\\\t\u000e\u0001\u000f\u0004\u000f_\b\u000f"+
		"\u000b\u000f\f\u000f`\u0001\u0010\u0004\u0010d\b\u0010\u000b\u0010\f\u0010"+
		"e\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0005\u0011n\b\u0011\n\u0011\f\u0011q\t\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012y\b\u0012"+
		"\n\u0012\f\u0012|\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001z\u0000\u0013\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013"+
		"\u0001\u0000\u0005\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u00000"+
		"9\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u0086\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0001\'\u0001"+
		"\u0000\u0000\u0000\u0003,\u0001\u0000\u0000\u0000\u00050\u0001\u0000\u0000"+
		"\u0000\u00075\u0001\u0000\u0000\u0000\t8\u0001\u0000\u0000\u0000\u000b"+
		"=\u0001\u0000\u0000\u0000\rB\u0001\u0000\u0000\u0000\u000fH\u0001\u0000"+
		"\u0000\u0000\u0011J\u0001\u0000\u0000\u0000\u0013L\u0001\u0000\u0000\u0000"+
		"\u0015N\u0001\u0000\u0000\u0000\u0017P\u0001\u0000\u0000\u0000\u0019R"+
		"\u0001\u0000\u0000\u0000\u001bT\u0001\u0000\u0000\u0000\u001dV\u0001\u0000"+
		"\u0000\u0000\u001f^\u0001\u0000\u0000\u0000!c\u0001\u0000\u0000\u0000"+
		"#i\u0001\u0000\u0000\u0000%t\u0001\u0000\u0000\u0000\'(\u0005m\u0000\u0000"+
		"()\u0005a\u0000\u0000)*\u0005i\u0000\u0000*+\u0005n\u0000\u0000+\u0002"+
		"\u0001\u0000\u0000\u0000,-\u0005i\u0000\u0000-.\u0005n\u0000\u0000./\u0005"+
		"t\u0000\u0000/\u0004\u0001\u0000\u0000\u000001\u0005b\u0000\u000012\u0005"+
		"o\u0000\u000023\u0005o\u0000\u000034\u0005l\u0000\u00004\u0006\u0001\u0000"+
		"\u0000\u000056\u0005i\u0000\u000067\u0005f\u0000\u00007\b\u0001\u0000"+
		"\u0000\u000089\u0005e\u0000\u00009:\u0005l\u0000\u0000:;\u0005s\u0000"+
		"\u0000;<\u0005e\u0000\u0000<\n\u0001\u0000\u0000\u0000=>\u0005t\u0000"+
		"\u0000>?\u0005r\u0000\u0000?@\u0005u\u0000\u0000@A\u0005e\u0000\u0000"+
		"A\f\u0001\u0000\u0000\u0000BC\u0005f\u0000\u0000CD\u0005a\u0000\u0000"+
		"DE\u0005l\u0000\u0000EF\u0005s\u0000\u0000FG\u0005e\u0000\u0000G\u000e"+
		"\u0001\u0000\u0000\u0000HI\u0005{\u0000\u0000I\u0010\u0001\u0000\u0000"+
		"\u0000JK\u0005}\u0000\u0000K\u0012\u0001\u0000\u0000\u0000LM\u0005;\u0000"+
		"\u0000M\u0014\u0001\u0000\u0000\u0000NO\u0005=\u0000\u0000O\u0016\u0001"+
		"\u0000\u0000\u0000PQ\u0005+\u0000\u0000Q\u0018\u0001\u0000\u0000\u0000"+
		"RS\u0005(\u0000\u0000S\u001a\u0001\u0000\u0000\u0000TU\u0005)\u0000\u0000"+
		"U\u001c\u0001\u0000\u0000\u0000VZ\u0007\u0000\u0000\u0000WY\u0007\u0001"+
		"\u0000\u0000XW\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001"+
		"\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\u001e\u0001\u0000\u0000"+
		"\u0000\\Z\u0001\u0000\u0000\u0000]_\u0007\u0002\u0000\u0000^]\u0001\u0000"+
		"\u0000\u0000_`\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001"+
		"\u0000\u0000\u0000a \u0001\u0000\u0000\u0000bd\u0007\u0003\u0000\u0000"+
		"cb\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000"+
		"\u0000ef\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0006\u0010"+
		"\u0000\u0000h\"\u0001\u0000\u0000\u0000ij\u0005/\u0000\u0000jk\u0005/"+
		"\u0000\u0000ko\u0001\u0000\u0000\u0000ln\b\u0004\u0000\u0000ml\u0001\u0000"+
		"\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000pr\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000"+
		"rs\u0006\u0011\u0000\u0000s$\u0001\u0000\u0000\u0000tu\u0005/\u0000\u0000"+
		"uv\u0005*\u0000\u0000vz\u0001\u0000\u0000\u0000wy\t\u0000\u0000\u0000"+
		"xw\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000zx\u0001\u0000\u0000\u0000{}\u0001\u0000\u0000\u0000|z\u0001\u0000"+
		"\u0000\u0000}~\u0005*\u0000\u0000~\u007f\u0005/\u0000\u0000\u007f\u0080"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0006\u0012\u0000\u0000\u0081&\u0001"+
		"\u0000\u0000\u0000\u0006\u0000Z`eoz\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}