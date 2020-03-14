package javacookbook.chapter02.listings.l08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private static Pattern word = Pattern.compile("\\G\\p{Alpha}+");
    private static Pattern punctuation = Pattern.compile("\\G\\p{Punct}");
    private static Pattern space = Pattern.compile("\\G\\s+");
    private static Pattern number = Pattern.compile("\\G\\d+\\.?\\d*");
    private static Pattern keywordOrIdentifier = Pattern.compile("\\G[\\w&&\\D]\\w*");
    private static Pattern separator = Pattern.compile("\\G[(){}\\[\\];,\\.]");
    private static Pattern singleOperator = Pattern.compile("\\G[=><!~?:+\\-*/&|\\^%@]");
    private static Pattern doubleOperator = Pattern.compile("\\G((<=)|(>=)|(==)|(!=)|" +
            "(\\|\\|)|(\\&\\&)|(<<)|(>>)|(--)|(\\+\\+))");
    private static Pattern tripleOperator = Pattern.compile("\\G>>>");
    private static Pattern assignOperator = Pattern.compile("\\G((\\+=)|(-=)|(/=)|(\\*=)|" +
            "(>>=)|(<<=)|(&=)|(\\^=)|(>>>=))");
    private static Pattern stringLiteral = Pattern.compile("\\G\".*?\"");
    private static Pattern comment = Pattern.compile("\\G((\\/\\/.*(?m)$)|(\\/\\*(?s).*?\\*\\/))");
    private static Pattern endOfString = Pattern.compile("\\G\\z");
    private static Pattern unknown = Pattern.compile("\\G\\.");
    private Matcher matcher;
    private TokenType[] patterns;
    private Token currentToken;

    public Tokenizer(String s) {
        matcher = unknown.matcher(s);
        patterns = new TokenType[]{TokenType.NUMBER, TokenType.WORD, TokenType.PUNCTUATION, TokenType.END_OF_STRING,
                TokenType.UNKNOWN};
        currentToken = new Token();
    }

    public Tokenizer(String s, TokenType[] p) {
        matcher = unknown.matcher(s);
        TokenType[] tmp = new TokenType[p.length + 2];
        System.arraycopy(p, 0, tmp, 0, p.length);
        tmp[p.length] = TokenType.END_OF_STRING;
        tmp[p.length + 1] = TokenType.UNKNOWN;
        patterns = tmp;
        currentToken = new Token();
    }

    public Token getToken() {
        matcher.usePattern(TokenType.SPACE.pattern).find();
        for (TokenType pattern : patterns) {
            matcher.usePattern(pattern.pattern);
            if (matcher.find()) {
                currentToken.type = pattern;
                currentToken.token = matcher.group().replaceAll("\n", "");
                break;
            }
        }
        return currentToken;
    }

    enum TokenType {
        WORD(word), PUNCTUATION(punctuation), SPACE(space), NUMBER(number), KEYWORD_OR_IDENTIFIER(keywordOrIdentifier),
        SEPARATOR(separator), SINGLE_OPERATOR(singleOperator), DOUBLE_OPERATOR(doubleOperator),
        TRIPLE_OPERATOR(tripleOperator), ASSIGN_OPERATOR(assignOperator), STRING_LITERAL(stringLiteral),
        COMMENT(comment), END_OF_STRING(endOfString), UNKNOWN(unknown);

        private Pattern pattern;

        TokenType(Pattern p) {
            pattern = p;
        }
    }

    class Token {
        String token;
        TokenType type;
    }
}
