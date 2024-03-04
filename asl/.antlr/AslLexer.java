// Generated from /home2/users/alumnes/1275312/dades/CL/Project/practica/asl/Asl.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AslLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, ASSIGN=5, EQUAL=6, NEQ=7, G=8, L=9, GE=10, 
		LE=11, PLUS=12, MINUS=13, MUL=14, DIV=15, AND=16, OR=17, VAR=18, INT=19, 
		FLOAT=20, CHAR=21, BOOL=22, IF=23, THEN=24, ELSE=25, ENDIF=26, FUNC=27, 
		ENDFUNC=28, READ=29, WRITE=30, INTVAL=31, FLOATVAL=32, CHARVAL=33, BOOLVAL=34, 
		ID=35, STRING=36, COMMENT=37, WS=38;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "ASSIGN", "EQUAL", "NEQ", "G", "L", "GE", 
			"LE", "PLUS", "MINUS", "MUL", "DIV", "AND", "OR", "VAR", "INT", "FLOAT", 
			"CHAR", "BOOL", "IF", "THEN", "ELSE", "ENDIF", "FUNC", "ENDFUNC", "READ", 
			"WRITE", "INTVAL", "FLOATVAL", "CHARVAL", "BOOLVAL", "ID", "STRING", 
			"ESC_SEQ", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "':'", "';'", "'='", "'=='", "'!='", "'>'", "'<'", 
			"'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'and'", "'or'", "'var'", 
			"'int'", "'float'", "'char'", "'bool'", "'if'", "'then'", "'else'", "'endif'", 
			"'func'", "'endfunc'", "'read'", "'write'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "ASSIGN", "EQUAL", "NEQ", "G", "L", "GE", 
			"LE", "PLUS", "MINUS", "MUL", "DIV", "AND", "OR", "VAR", "INT", "FLOAT", 
			"CHAR", "BOOL", "IF", "THEN", "ELSE", "ENDIF", "FUNC", "ENDFUNC", "READ", 
			"WRITE", "INTVAL", "FLOATVAL", "CHARVAL", "BOOLVAL", "ID", "STRING", 
			"COMMENT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u0107\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3 \6 \u00bf\n \r \16 \u00c0\3!\6!\u00c4\n!\r!\16!\u00c5\3!\3!\6"+
		"!\u00ca\n!\r!\16!\u00cb\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#"+
		"\u00db\n#\3$\3$\7$\u00df\n$\f$\16$\u00e2\13$\3%\3%\3%\7%\u00e7\n%\f%\16"+
		"%\u00ea\13%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\7\'\u00f5\n\'\f\'\16\'\u00f8"+
		"\13\'\3\'\5\'\u00fb\n\'\3\'\3\'\3\'\3\'\3(\6(\u0102\n(\r(\16(\u0103\3"+
		"(\3(\2\2)\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\2M\'O(\3\2\t\3\2))\6\2\62;C\\aac|\4\2C\\c"+
		"|\4\2$$^^\n\2$$))^^ddhhppttvv\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u010f"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5S\3\2\2\2\7U\3\2\2\2\t"+
		"W\3\2\2\2\13Y\3\2\2\2\r[\3\2\2\2\17^\3\2\2\2\21a\3\2\2\2\23c\3\2\2\2\25"+
		"e\3\2\2\2\27h\3\2\2\2\31k\3\2\2\2\33m\3\2\2\2\35o\3\2\2\2\37q\3\2\2\2"+
		"!s\3\2\2\2#w\3\2\2\2%z\3\2\2\2\'~\3\2\2\2)\u0082\3\2\2\2+\u0088\3\2\2"+
		"\2-\u008d\3\2\2\2/\u0092\3\2\2\2\61\u0095\3\2\2\2\63\u009a\3\2\2\2\65"+
		"\u009f\3\2\2\2\67\u00a5\3\2\2\29\u00aa\3\2\2\2;\u00b2\3\2\2\2=\u00b7\3"+
		"\2\2\2?\u00be\3\2\2\2A\u00c3\3\2\2\2C\u00cd\3\2\2\2E\u00da\3\2\2\2G\u00dc"+
		"\3\2\2\2I\u00e3\3\2\2\2K\u00ed\3\2\2\2M\u00f0\3\2\2\2O\u0101\3\2\2\2Q"+
		"R\7*\2\2R\4\3\2\2\2ST\7+\2\2T\6\3\2\2\2UV\7<\2\2V\b\3\2\2\2WX\7=\2\2X"+
		"\n\3\2\2\2YZ\7?\2\2Z\f\3\2\2\2[\\\7?\2\2\\]\7?\2\2]\16\3\2\2\2^_\7#\2"+
		"\2_`\7?\2\2`\20\3\2\2\2ab\7@\2\2b\22\3\2\2\2cd\7>\2\2d\24\3\2\2\2ef\7"+
		"@\2\2fg\7?\2\2g\26\3\2\2\2hi\7>\2\2ij\7?\2\2j\30\3\2\2\2kl\7-\2\2l\32"+
		"\3\2\2\2mn\7/\2\2n\34\3\2\2\2op\7,\2\2p\36\3\2\2\2qr\7\61\2\2r \3\2\2"+
		"\2st\7c\2\2tu\7p\2\2uv\7f\2\2v\"\3\2\2\2wx\7q\2\2xy\7t\2\2y$\3\2\2\2z"+
		"{\7x\2\2{|\7c\2\2|}\7t\2\2}&\3\2\2\2~\177\7k\2\2\177\u0080\7p\2\2\u0080"+
		"\u0081\7v\2\2\u0081(\3\2\2\2\u0082\u0083\7h\2\2\u0083\u0084\7n\2\2\u0084"+
		"\u0085\7q\2\2\u0085\u0086\7c\2\2\u0086\u0087\7v\2\2\u0087*\3\2\2\2\u0088"+
		"\u0089\7e\2\2\u0089\u008a\7j\2\2\u008a\u008b\7c\2\2\u008b\u008c\7t\2\2"+
		"\u008c,\3\2\2\2\u008d\u008e\7d\2\2\u008e\u008f\7q\2\2\u008f\u0090\7q\2"+
		"\2\u0090\u0091\7n\2\2\u0091.\3\2\2\2\u0092\u0093\7k\2\2\u0093\u0094\7"+
		"h\2\2\u0094\60\3\2\2\2\u0095\u0096\7v\2\2\u0096\u0097\7j\2\2\u0097\u0098"+
		"\7g\2\2\u0098\u0099\7p\2\2\u0099\62\3\2\2\2\u009a\u009b\7g\2\2\u009b\u009c"+
		"\7n\2\2\u009c\u009d\7u\2\2\u009d\u009e\7g\2\2\u009e\64\3\2\2\2\u009f\u00a0"+
		"\7g\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7f\2\2\u00a2\u00a3\7k\2\2\u00a3"+
		"\u00a4\7h\2\2\u00a4\66\3\2\2\2\u00a5\u00a6\7h\2\2\u00a6\u00a7\7w\2\2\u00a7"+
		"\u00a8\7p\2\2\u00a8\u00a9\7e\2\2\u00a98\3\2\2\2\u00aa\u00ab\7g\2\2\u00ab"+
		"\u00ac\7p\2\2\u00ac\u00ad\7f\2\2\u00ad\u00ae\7h\2\2\u00ae\u00af\7w\2\2"+
		"\u00af\u00b0\7p\2\2\u00b0\u00b1\7e\2\2\u00b1:\3\2\2\2\u00b2\u00b3\7t\2"+
		"\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7c\2\2\u00b5\u00b6\7f\2\2\u00b6<\3\2"+
		"\2\2\u00b7\u00b8\7y\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba\7k\2\2\u00ba\u00bb"+
		"\7v\2\2\u00bb\u00bc\7g\2\2\u00bc>\3\2\2\2\u00bd\u00bf\4\62;\2\u00be\u00bd"+
		"\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"@\3\2\2\2\u00c2\u00c4\4\62;\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2"+
		"\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9"+
		"\7\60\2\2\u00c8\u00ca\4\62;\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2"+
		"\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00ccB\3\2\2\2\u00cd\u00ce\t"+
		"\2\2\2\u00ce\u00cf\t\3\2\2\u00cf\u00d0\t\2\2\2\u00d0D\3\2\2\2\u00d1\u00d2"+
		"\7v\2\2\u00d2\u00d3\7t\2\2\u00d3\u00d4\7w\2\2\u00d4\u00db\7g\2\2\u00d5"+
		"\u00d6\7h\2\2\u00d6\u00d7\7c\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9\7u\2\2"+
		"\u00d9\u00db\7g\2\2\u00da\u00d1\3\2\2\2\u00da\u00d5\3\2\2\2\u00dbF\3\2"+
		"\2\2\u00dc\u00e0\t\4\2\2\u00dd\u00df\t\3\2\2\u00de\u00dd\3\2\2\2\u00df"+
		"\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1H\3\2\2\2"+
		"\u00e2\u00e0\3\2\2\2\u00e3\u00e8\7$\2\2\u00e4\u00e7\5K&\2\u00e5\u00e7"+
		"\n\5\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2"+
		"\2\2\u00eb\u00ec\7$\2\2\u00ecJ\3\2\2\2\u00ed\u00ee\7^\2\2\u00ee\u00ef"+
		"\t\6\2\2\u00efL\3\2\2\2\u00f0\u00f1\7\61\2\2\u00f1\u00f2\7\61\2\2\u00f2"+
		"\u00f6\3\2\2\2\u00f3\u00f5\n\7\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8\3\2"+
		"\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8"+
		"\u00f6\3\2\2\2\u00f9\u00fb\7\17\2\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3"+
		"\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\7\f\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"\u00ff\b\'\2\2\u00ffN\3\2\2\2\u0100\u0102\t\b\2\2\u0101\u0100\3\2\2\2"+
		"\u0102\u0103\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105"+
		"\3\2\2\2\u0105\u0106\b(\2\2\u0106P\3\2\2\2\r\2\u00c0\u00c5\u00cb\u00da"+
		"\u00e0\u00e6\u00e8\u00f6\u00fa\u0103\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}