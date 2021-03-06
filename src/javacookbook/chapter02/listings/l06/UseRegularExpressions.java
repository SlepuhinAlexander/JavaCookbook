package javacookbook.chapter02.listings.l06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseRegularExpressions {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\b\\w+@XYZ\\.com\\b", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher("Company\tContact\tInfo\n" +
                "Tom\t555-1111\ttom@XYZ.com\n" +
                "Mary\t555-2222\tMary@XYZ.com\n" +
                "Don\t555-3333\tDon@xyz.com");
        while (m.find()) {
            System.out.println("Got a match: " + m.group());
        }
    }
}
/*
 * output:
 * Got a match: tom@XYZ.com
 * Got a match: Mary@XYZ.com
 * Got a match: Don@XYZ.com
 * */