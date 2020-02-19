package javacookbook.chapter2.listings.l8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TokenizerDemo {
    public static void main(String[] args) {
        Tokenizer.Token token;
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("Tokinizing text:");
        String testString = "This is some sample text. Is today " + now + "?";
        System.out.println(testString);
        Tokenizer tokenizer = new Tokenizer(testString);
        do {
            token = tokenizer.getToken();
            System.out.println(String.format("Token: %-32s\tType: %s", token.token, token.type));
        } while (token.type != Tokenizer.TokenType.END_OF_STRING);

        Tokenizer.TokenType[] programmingTokens = {Tokenizer.TokenType.NUMBER,
                Tokenizer.TokenType.KEYWORD_OR_IDENTIFIER, Tokenizer.TokenType.STRING_LITERAL,
                Tokenizer.TokenType.COMMENT, Tokenizer.TokenType.ASSIGN_OPERATOR, Tokenizer.TokenType.TRIPLE_OPERATOR,
                Tokenizer.TokenType.DOUBLE_OPERATOR, Tokenizer.TokenType.SINGLE_OPERATOR,
                Tokenizer.TokenType.SEPARATOR};

        System.out.println("\nTokenizing a block of code:");
        testString = "// sample code block\n" +
                "int count=10;\n" +
                "if (a<=b) count--;\n" +
                "a = b >>> c;\n" +
                "a = b >> d;\n" +
                "result = meth(3);\n" +
                "w = a<0 ? b*4 : c/2;\n" +
                "done != done;\n" +
                "for(int i=0; i<10; i++) sum += i;\n" +
                "String str = \"Some string literal\"\n" +
                "class Test { /* ... */ }";
        System.out.println(testString);
        tokenizer = new Tokenizer(testString, programmingTokens);
        do {
            token = tokenizer.getToken();
            System.out.println(String.format("Token: %-32s\tType: %s", token.token, token.type));
        } while (token.type != Tokenizer.TokenType.END_OF_STRING);
    }
}
/*
 * output
 * Tokinizing text:
 * This is some sample text. Is today 2020-02-19?
 * Token: This                            	Type: WORD
 * Token: is                              	Type: WORD
 * Token: some                            	Type: WORD
 * Token: sample                          	Type: WORD
 * Token: text                            	Type: WORD
 * Token: .                               	Type: PUNCTUATION
 * Token: Is                              	Type: WORD
 * Token: today                           	Type: WORD
 * Token: 2020                            	Type: NUMBER
 * Token: -                               	Type: PUNCTUATION
 * Token: 02                              	Type: NUMBER
 * Token: -                               	Type: PUNCTUATION
 * Token: 19                              	Type: NUMBER
 * Token: ?                               	Type: PUNCTUATION
 * Token:                                 	Type: END_OF_STRING
 * Tokenizing a block of code:
 * // sample code block
 * int count=10;
 * if (a<=b) count--;
 * a = b >>> c;
 * a = b >> d;
 * result = meth(3);
 * w = a<0 ? b*4 : c/2;
 * done != done;
 * for(int i=0; i<10; i++) sum += i;
 * String str = "Some string literal"
 * class Test { /* ... *&#47; }
 * Token: // sample code block            	Type: COMMENT
 * Token: int                             	Type: KEYWORD_OR_IDENTIFIER
 * Token: count                           	Type: KEYWORD_OR_IDENTIFIER
 * Token: =                               	Type: SINGLE_OPERATOR
 * Token: 10                              	Type: NUMBER
 * Token: ;                               	Type: SEPARATOR
 * Token: if                              	Type: KEYWORD_OR_IDENTIFIER
 * Token: (                               	Type: SEPARATOR
 * Token: a                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: <=                              	Type: DOUBLE_OPERATOR
 * Token: b                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: )                               	Type: SEPARATOR
 * Token: count                           	Type: KEYWORD_OR_IDENTIFIER
 * Token: --                              	Type: DOUBLE_OPERATOR
 * Token: ;                               	Type: SEPARATOR
 * Token: a                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: =                               	Type: SINGLE_OPERATOR
 * Token: b                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: >>>                             	Type: TRIPLE_OPERATOR
 * Token: c                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: ;                               	Type: SEPARATOR
 * Token: a                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: =                               	Type: SINGLE_OPERATOR
 * Token: b                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: >>                              	Type: DOUBLE_OPERATOR
 * Token: d                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: ;                               	Type: SEPARATOR
 * Token: result                          	Type: KEYWORD_OR_IDENTIFIER
 * Token: =                               	Type: SINGLE_OPERATOR
 * Token: meth                            	Type: KEYWORD_OR_IDENTIFIER
 * Token: (                               	Type: SEPARATOR
 * Token: 3                               	Type: NUMBER
 * Token: )                               	Type: SEPARATOR
 * Token: ;                               	Type: SEPARATOR
 * Token: w                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: =                               	Type: SINGLE_OPERATOR
 * Token: a                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: <                               	Type: SINGLE_OPERATOR
 * Token: 0                               	Type: NUMBER
 * Token: ?                               	Type: SINGLE_OPERATOR
 * Token: b                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: *                               	Type: SINGLE_OPERATOR
 * Token: 4                               	Type: NUMBER
 * Token: :                               	Type: SINGLE_OPERATOR
 * Token: c                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: /                               	Type: SINGLE_OPERATOR
 * Token: 2                               	Type: NUMBER
 * Token: ;                               	Type: SEPARATOR
 * Token: done                            	Type: KEYWORD_OR_IDENTIFIER
 * Token: !=                              	Type: DOUBLE_OPERATOR
 * Token: done                            	Type: KEYWORD_OR_IDENTIFIER
 * Token: ;                               	Type: SEPARATOR
 * Token: for                             	Type: KEYWORD_OR_IDENTIFIER
 * Token: (                               	Type: SEPARATOR
 * Token: int                             	Type: KEYWORD_OR_IDENTIFIER
 * Token: i                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: =                               	Type: SINGLE_OPERATOR
 * Token: 0                               	Type: NUMBER
 * Token: ;                               	Type: SEPARATOR
 * Token: i                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: <                               	Type: SINGLE_OPERATOR
 * Token: 10                              	Type: NUMBER
 * Token: ;                               	Type: SEPARATOR
 * Token: i                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: ++                              	Type: DOUBLE_OPERATOR
 * Token: )                               	Type: SEPARATOR
 * Token: sum                             	Type: KEYWORD_OR_IDENTIFIER
 * Token: +=                              	Type: ASSIGN_OPERATOR
 * Token: i                               	Type: KEYWORD_OR_IDENTIFIER
 * Token: ;                               	Type: SEPARATOR
 * Token: String                          	Type: KEYWORD_OR_IDENTIFIER
 * Token: str                             	Type: KEYWORD_OR_IDENTIFIER
 * Token: =                               	Type: SINGLE_OPERATOR
 * Token: "Some string literal"           	Type: STRING_LITERAL
 * Token: class                           	Type: KEYWORD_OR_IDENTIFIER
 * Token: Test                            	Type: KEYWORD_OR_IDENTIFIER
 * Token: {                               	Type: SEPARATOR
 * Token: /* ... *&#47;                     Type: COMMENT
 * Token: }                               	Type: SEPARATOR
 * Token:                                 	Type: END_OF_STRING
 * */