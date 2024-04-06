// Generated from /home/aleix/albertjr/CL/CL-Practica/asl/Asl.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class AslLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, EQUAL=3, NEQ=4, G=5, L=6, GE=7, LE=8, ASSIGN=9, PLUS=10, 
		MINUS=11, MUL=12, DIV=13, MOD=14, AND=15, OR=16, NOT=17, VAR=18, INT=19, 
		FLOAT=20, CHAR=21, BOOL=22, IF=23, THEN=24, ELSE=25, ENDIF=26, WHILE=27, 
		DO=28, ENDWHILE=29, FUNC=30, ENDFUNC=31, READ=32, WRITE=33, ARRAY=34, 
		RETURN=35, LSBRACKET=36, RSBRACKET=37, LPAR=38, RPAR=39, OF=40, INTVAL=41, 
		FLOATVAL=42, CHARVAL=43, BOOLVAL=44, COMMA=45, ID=46, STRING=47, COMMENT=48, 
		WS=49;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "EQUAL", "NEQ", "G", "L", "GE", "LE", "ASSIGN", "PLUS", 
			"MINUS", "MUL", "DIV", "MOD", "AND", "OR", "NOT", "VAR", "INT", "FLOAT", 
			"CHAR", "BOOL", "IF", "THEN", "ELSE", "ENDIF", "WHILE", "DO", "ENDWHILE", 
			"FUNC", "ENDFUNC", "READ", "WRITE", "ARRAY", "RETURN", "LSBRACKET", "RSBRACKET", 
			"LPAR", "RPAR", "OF", "INTVAL", "FLOATVAL", "CHARVAL", "BOOLVAL", "COMMA", 
			"ID", "STRING", "ESC_SEQ", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "';'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'='", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'and'", "'or'", "'not'", "'var'", 
			"'int'", "'float'", "'char'", "'bool'", "'if'", "'then'", "'else'", "'endif'", 
			"'while'", "'do'", "'endwhile'", "'func'", "'endfunc'", "'read'", "'write'", 
			"'array'", "'return'", "'['", "']'", "'('", "')'", "'of'", null, null, 
			null, null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "EQUAL", "NEQ", "G", "L", "GE", "LE", "ASSIGN", "PLUS", 
			"MINUS", "MUL", "DIV", "MOD", "AND", "OR", "NOT", "VAR", "INT", "FLOAT", 
			"CHAR", "BOOL", "IF", "THEN", "ELSE", "ENDIF", "WHILE", "DO", "ENDWHILE", 
			"FUNC", "ENDFUNC", "READ", "WRITE", "ARRAY", "RETURN", "LSBRACKET", "RSBRACKET", 
			"LPAR", "RPAR", "OF", "INTVAL", "FLOATVAL", "CHARVAL", "BOOLVAL", "COMMA", 
			"ID", "STRING", "COMMENT", "WS"
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


	public AslLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Asl.g4"; }

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
		"\u0004\u00001\u0149\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001"+
		"\'\u0001\'\u0001(\u0004(\u00ff\b(\u000b(\f(\u0100\u0001)\u0004)\u0104"+
		"\b)\u000b)\f)\u0105\u0001)\u0001)\u0004)\u010a\b)\u000b)\f)\u010b\u0001"+
		"*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0003+\u011b\b+\u0001,\u0001,\u0001-\u0001-\u0005-\u0121"+
		"\b-\n-\f-\u0124\t-\u0001.\u0001.\u0001.\u0005.\u0129\b.\n.\f.\u012c\t"+
		".\u0001.\u0001.\u0001/\u0001/\u0001/\u00010\u00010\u00010\u00010\u0005"+
		"0\u0137\b0\n0\f0\u013a\t0\u00010\u00030\u013d\b0\u00010\u00010\u00010"+
		"\u00010\u00011\u00041\u0144\b1\u000b1\f1\u0145\u00011\u00011\u0000\u0000"+
		"2\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%"+
		"K&M\'O(Q)S*U+W,Y-[.]/_\u0000a0c1\u0001\u0000\u0007\u0001\u0000\'\'\u0004"+
		"\u000009AZ__az\u0002\u0000AZaz\u0002\u0000\"\"\\\\\b\u0000\"\"\'\'\\\\"+
		"bbffnnrrtt\u0002\u0000\n\n\r\r\u0003\u0000\t\n\r\r  \u0151\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001"+
		"\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000"+
		"\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u0000"+
		"5\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001"+
		"\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000"+
		"\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000"+
		"C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001"+
		"\u0000\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000"+
		"\u0000\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000"+
		"Q\u0001\u0000\u0000\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001"+
		"\u0000\u0000\u0000\u0000W\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000"+
		"\u0000\u0000[\u0001\u0000\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0000"+
		"a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0001e\u0001"+
		"\u0000\u0000\u0000\u0003g\u0001\u0000\u0000\u0000\u0005i\u0001\u0000\u0000"+
		"\u0000\u0007l\u0001\u0000\u0000\u0000\to\u0001\u0000\u0000\u0000\u000b"+
		"q\u0001\u0000\u0000\u0000\rs\u0001\u0000\u0000\u0000\u000fv\u0001\u0000"+
		"\u0000\u0000\u0011y\u0001\u0000\u0000\u0000\u0013{\u0001\u0000\u0000\u0000"+
		"\u0015}\u0001\u0000\u0000\u0000\u0017\u007f\u0001\u0000\u0000\u0000\u0019"+
		"\u0081\u0001\u0000\u0000\u0000\u001b\u0083\u0001\u0000\u0000\u0000\u001d"+
		"\u0085\u0001\u0000\u0000\u0000\u001f\u0089\u0001\u0000\u0000\u0000!\u008c"+
		"\u0001\u0000\u0000\u0000#\u0090\u0001\u0000\u0000\u0000%\u0094\u0001\u0000"+
		"\u0000\u0000\'\u0098\u0001\u0000\u0000\u0000)\u009e\u0001\u0000\u0000"+
		"\u0000+\u00a3\u0001\u0000\u0000\u0000-\u00a8\u0001\u0000\u0000\u0000/"+
		"\u00ab\u0001\u0000\u0000\u00001\u00b0\u0001\u0000\u0000\u00003\u00b5\u0001"+
		"\u0000\u0000\u00005\u00bb\u0001\u0000\u0000\u00007\u00c1\u0001\u0000\u0000"+
		"\u00009\u00c4\u0001\u0000\u0000\u0000;\u00cd\u0001\u0000\u0000\u0000="+
		"\u00d2\u0001\u0000\u0000\u0000?\u00da\u0001\u0000\u0000\u0000A\u00df\u0001"+
		"\u0000\u0000\u0000C\u00e5\u0001\u0000\u0000\u0000E\u00eb\u0001\u0000\u0000"+
		"\u0000G\u00f2\u0001\u0000\u0000\u0000I\u00f4\u0001\u0000\u0000\u0000K"+
		"\u00f6\u0001\u0000\u0000\u0000M\u00f8\u0001\u0000\u0000\u0000O\u00fa\u0001"+
		"\u0000\u0000\u0000Q\u00fe\u0001\u0000\u0000\u0000S\u0103\u0001\u0000\u0000"+
		"\u0000U\u010d\u0001\u0000\u0000\u0000W\u011a\u0001\u0000\u0000\u0000Y"+
		"\u011c\u0001\u0000\u0000\u0000[\u011e\u0001\u0000\u0000\u0000]\u0125\u0001"+
		"\u0000\u0000\u0000_\u012f\u0001\u0000\u0000\u0000a\u0132\u0001\u0000\u0000"+
		"\u0000c\u0143\u0001\u0000\u0000\u0000ef\u0005:\u0000\u0000f\u0002\u0001"+
		"\u0000\u0000\u0000gh\u0005;\u0000\u0000h\u0004\u0001\u0000\u0000\u0000"+
		"ij\u0005=\u0000\u0000jk\u0005=\u0000\u0000k\u0006\u0001\u0000\u0000\u0000"+
		"lm\u0005!\u0000\u0000mn\u0005=\u0000\u0000n\b\u0001\u0000\u0000\u0000"+
		"op\u0005>\u0000\u0000p\n\u0001\u0000\u0000\u0000qr\u0005<\u0000\u0000"+
		"r\f\u0001\u0000\u0000\u0000st\u0005>\u0000\u0000tu\u0005=\u0000\u0000"+
		"u\u000e\u0001\u0000\u0000\u0000vw\u0005<\u0000\u0000wx\u0005=\u0000\u0000"+
		"x\u0010\u0001\u0000\u0000\u0000yz\u0005=\u0000\u0000z\u0012\u0001\u0000"+
		"\u0000\u0000{|\u0005+\u0000\u0000|\u0014\u0001\u0000\u0000\u0000}~\u0005"+
		"-\u0000\u0000~\u0016\u0001\u0000\u0000\u0000\u007f\u0080\u0005*\u0000"+
		"\u0000\u0080\u0018\u0001\u0000\u0000\u0000\u0081\u0082\u0005/\u0000\u0000"+
		"\u0082\u001a\u0001\u0000\u0000\u0000\u0083\u0084\u0005%\u0000\u0000\u0084"+
		"\u001c\u0001\u0000\u0000\u0000\u0085\u0086\u0005a\u0000\u0000\u0086\u0087"+
		"\u0005n\u0000\u0000\u0087\u0088\u0005d\u0000\u0000\u0088\u001e\u0001\u0000"+
		"\u0000\u0000\u0089\u008a\u0005o\u0000\u0000\u008a\u008b\u0005r\u0000\u0000"+
		"\u008b \u0001\u0000\u0000\u0000\u008c\u008d\u0005n\u0000\u0000\u008d\u008e"+
		"\u0005o\u0000\u0000\u008e\u008f\u0005t\u0000\u0000\u008f\"\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0005v\u0000\u0000\u0091\u0092\u0005a\u0000\u0000"+
		"\u0092\u0093\u0005r\u0000\u0000\u0093$\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0005i\u0000\u0000\u0095\u0096\u0005n\u0000\u0000\u0096\u0097\u0005t"+
		"\u0000\u0000\u0097&\u0001\u0000\u0000\u0000\u0098\u0099\u0005f\u0000\u0000"+
		"\u0099\u009a\u0005l\u0000\u0000\u009a\u009b\u0005o\u0000\u0000\u009b\u009c"+
		"\u0005a\u0000\u0000\u009c\u009d\u0005t\u0000\u0000\u009d(\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0005c\u0000\u0000\u009f\u00a0\u0005h\u0000\u0000"+
		"\u00a0\u00a1\u0005a\u0000\u0000\u00a1\u00a2\u0005r\u0000\u0000\u00a2*"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005b\u0000\u0000\u00a4\u00a5\u0005"+
		"o\u0000\u0000\u00a5\u00a6\u0005o\u0000\u0000\u00a6\u00a7\u0005l\u0000"+
		"\u0000\u00a7,\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005i\u0000\u0000\u00a9"+
		"\u00aa\u0005f\u0000\u0000\u00aa.\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005"+
		"t\u0000\u0000\u00ac\u00ad\u0005h\u0000\u0000\u00ad\u00ae\u0005e\u0000"+
		"\u0000\u00ae\u00af\u0005n\u0000\u0000\u00af0\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b1\u0005e\u0000\u0000\u00b1\u00b2\u0005l\u0000\u0000\u00b2\u00b3\u0005"+
		"s\u0000\u0000\u00b3\u00b4\u0005e\u0000\u0000\u00b42\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\u0005e\u0000\u0000\u00b6\u00b7\u0005n\u0000\u0000\u00b7"+
		"\u00b8\u0005d\u0000\u0000\u00b8\u00b9\u0005i\u0000\u0000\u00b9\u00ba\u0005"+
		"f\u0000\u0000\u00ba4\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005w\u0000"+
		"\u0000\u00bc\u00bd\u0005h\u0000\u0000\u00bd\u00be\u0005i\u0000\u0000\u00be"+
		"\u00bf\u0005l\u0000\u0000\u00bf\u00c0\u0005e\u0000\u0000\u00c06\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0005d\u0000\u0000\u00c2\u00c3\u0005o\u0000"+
		"\u0000\u00c38\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005e\u0000\u0000\u00c5"+
		"\u00c6\u0005n\u0000\u0000\u00c6\u00c7\u0005d\u0000\u0000\u00c7\u00c8\u0005"+
		"w\u0000\u0000\u00c8\u00c9\u0005h\u0000\u0000\u00c9\u00ca\u0005i\u0000"+
		"\u0000\u00ca\u00cb\u0005l\u0000\u0000\u00cb\u00cc\u0005e\u0000\u0000\u00cc"+
		":\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005f\u0000\u0000\u00ce\u00cf\u0005"+
		"u\u0000\u0000\u00cf\u00d0\u0005n\u0000\u0000\u00d0\u00d1\u0005c\u0000"+
		"\u0000\u00d1<\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005e\u0000\u0000\u00d3"+
		"\u00d4\u0005n\u0000\u0000\u00d4\u00d5\u0005d\u0000\u0000\u00d5\u00d6\u0005"+
		"f\u0000\u0000\u00d6\u00d7\u0005u\u0000\u0000\u00d7\u00d8\u0005n\u0000"+
		"\u0000\u00d8\u00d9\u0005c\u0000\u0000\u00d9>\u0001\u0000\u0000\u0000\u00da"+
		"\u00db\u0005r\u0000\u0000\u00db\u00dc\u0005e\u0000\u0000\u00dc\u00dd\u0005"+
		"a\u0000\u0000\u00dd\u00de\u0005d\u0000\u0000\u00de@\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0005w\u0000\u0000\u00e0\u00e1\u0005r\u0000\u0000\u00e1"+
		"\u00e2\u0005i\u0000\u0000\u00e2\u00e3\u0005t\u0000\u0000\u00e3\u00e4\u0005"+
		"e\u0000\u0000\u00e4B\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005a\u0000"+
		"\u0000\u00e6\u00e7\u0005r\u0000\u0000\u00e7\u00e8\u0005r\u0000\u0000\u00e8"+
		"\u00e9\u0005a\u0000\u0000\u00e9\u00ea\u0005y\u0000\u0000\u00eaD\u0001"+
		"\u0000\u0000\u0000\u00eb\u00ec\u0005r\u0000\u0000\u00ec\u00ed\u0005e\u0000"+
		"\u0000\u00ed\u00ee\u0005t\u0000\u0000\u00ee\u00ef\u0005u\u0000\u0000\u00ef"+
		"\u00f0\u0005r\u0000\u0000\u00f0\u00f1\u0005n\u0000\u0000\u00f1F\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f3\u0005[\u0000\u0000\u00f3H\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f5\u0005]\u0000\u0000\u00f5J\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f7\u0005(\u0000\u0000\u00f7L\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005"+
		")\u0000\u0000\u00f9N\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005o\u0000"+
		"\u0000\u00fb\u00fc\u0005f\u0000\u0000\u00fcP\u0001\u0000\u0000\u0000\u00fd"+
		"\u00ff\u000209\u0000\u00fe\u00fd\u0001\u0000\u0000\u0000\u00ff\u0100\u0001"+
		"\u0000\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0100\u0101\u0001"+
		"\u0000\u0000\u0000\u0101R\u0001\u0000\u0000\u0000\u0102\u0104\u000209"+
		"\u0000\u0103\u0102\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000"+
		"\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000"+
		"\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u0109\u0005.\u0000\u0000"+
		"\u0108\u010a\u000209\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u010a\u010b"+
		"\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010b\u010c"+
		"\u0001\u0000\u0000\u0000\u010cT\u0001\u0000\u0000\u0000\u010d\u010e\u0007"+
		"\u0000\u0000\u0000\u010e\u010f\u0007\u0001\u0000\u0000\u010f\u0110\u0007"+
		"\u0000\u0000\u0000\u0110V\u0001\u0000\u0000\u0000\u0111\u0112\u0005t\u0000"+
		"\u0000\u0112\u0113\u0005r\u0000\u0000\u0113\u0114\u0005u\u0000\u0000\u0114"+
		"\u011b\u0005e\u0000\u0000\u0115\u0116\u0005f\u0000\u0000\u0116\u0117\u0005"+
		"a\u0000\u0000\u0117\u0118\u0005l\u0000\u0000\u0118\u0119\u0005s\u0000"+
		"\u0000\u0119\u011b\u0005e\u0000\u0000\u011a\u0111\u0001\u0000\u0000\u0000"+
		"\u011a\u0115\u0001\u0000\u0000\u0000\u011bX\u0001\u0000\u0000\u0000\u011c"+
		"\u011d\u0005,\u0000\u0000\u011dZ\u0001\u0000\u0000\u0000\u011e\u0122\u0007"+
		"\u0002\u0000\u0000\u011f\u0121\u0007\u0001\u0000\u0000\u0120\u011f\u0001"+
		"\u0000\u0000\u0000\u0121\u0124\u0001\u0000\u0000\u0000\u0122\u0120\u0001"+
		"\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\\\u0001\u0000"+
		"\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0125\u012a\u0005\"\u0000"+
		"\u0000\u0126\u0129\u0003_/\u0000\u0127\u0129\b\u0003\u0000\u0000\u0128"+
		"\u0126\u0001\u0000\u0000\u0000\u0128\u0127\u0001\u0000\u0000\u0000\u0129"+
		"\u012c\u0001\u0000\u0000\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012a"+
		"\u012b\u0001\u0000\u0000\u0000\u012b\u012d\u0001\u0000\u0000\u0000\u012c"+
		"\u012a\u0001\u0000\u0000\u0000\u012d\u012e\u0005\"\u0000\u0000\u012e^"+
		"\u0001\u0000\u0000\u0000\u012f\u0130\u0005\\\u0000\u0000\u0130\u0131\u0007"+
		"\u0004\u0000\u0000\u0131`\u0001\u0000\u0000\u0000\u0132\u0133\u0005/\u0000"+
		"\u0000\u0133\u0134\u0005/\u0000\u0000\u0134\u0138\u0001\u0000\u0000\u0000"+
		"\u0135\u0137\b\u0005\u0000\u0000\u0136\u0135\u0001\u0000\u0000\u0000\u0137"+
		"\u013a\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138"+
		"\u0139\u0001\u0000\u0000\u0000\u0139\u013c\u0001\u0000\u0000\u0000\u013a"+
		"\u0138\u0001\u0000\u0000\u0000\u013b\u013d\u0005\r\u0000\u0000\u013c\u013b"+
		"\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u013e"+
		"\u0001\u0000\u0000\u0000\u013e\u013f\u0005\n\u0000\u0000\u013f\u0140\u0001"+
		"\u0000\u0000\u0000\u0140\u0141\u00060\u0000\u0000\u0141b\u0001\u0000\u0000"+
		"\u0000\u0142\u0144\u0007\u0006\u0000\u0000\u0143\u0142\u0001\u0000\u0000"+
		"\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0143\u0001\u0000\u0000"+
		"\u0000\u0145\u0146\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000\u0000"+
		"\u0000\u0147\u0148\u00061\u0000\u0000\u0148d\u0001\u0000\u0000\u0000\u000b"+
		"\u0000\u0100\u0105\u010b\u011a\u0122\u0128\u012a\u0138\u013c\u0145\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}