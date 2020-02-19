package javacookbook.chapter2.listings.l7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleTextTokenizer {
    private static Pattern end = Pattern.compile("\\G\\z");
    private static Pattern word = Pattern.compile("\\G\\w+");
    private static Pattern punctuation = Pattern.compile("\\G\\p{Punct}");
    private static Pattern space = Pattern.compile("\\G\\s+");
    private static Pattern number = Pattern.compile("\\G\\d+\\.\\d*");

    public static void main(String[] args) {
        String token;
        Matcher matcher = end.matcher("The first item, - is a \t hammer, with a cost of $132.99.");
        do {
            token = getTextToken(matcher);
            if (token == null) {
                System.out.println("Incorrect token");
                break;
            }
            if (token.length() > 0) {
                System.out.println("Token: " + token);
            } else {
                System.out.println("End of string");
            }
        } while (token.length() != 0);
    }

    private static String getTextToken(Matcher matcher) {
        matcher.usePattern(space).find();
        if (matcher.usePattern(number).find()) {
            return matcher.group();
        }
        if (matcher.usePattern(word).find()) {
            return matcher.group();
        }
        if (matcher.usePattern(punctuation).find()) {
            return matcher.group();
        }
        if (matcher.usePattern(end).find()) {
            return "";
        }
        return null;
    }
}
/*
 * output:
 * Token: The
 * Token: first
 * Token: item
 * Token: ,
 * Token: -
 * Token: is
 * Token: a
 * Token: hammer
 * Token: ,
 * Token: with
 * Token: a
 * Token: cost
 * Token: of
 * Token: $
 * Token: 132.99
 * Token: .
 * End of string
 * */