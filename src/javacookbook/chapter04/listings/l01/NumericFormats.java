package javacookbook.chapter04.listings.l01;

import java.util.Formatter;
import java.util.Locale;

public class NumericFormats {
    public static void main(String[] args) {
        Formatter formatter = new Formatter(Locale.ENGLISH);
        formatter.format("Default accuracy: %f\n", 10d / 3d);
        formatter.format("2 decimal places: %.2f\n\n", 10d / 3d);
        formatter.format("Without grouping separator: %d\n", 1234567890);
        formatter.format("With grouping separator: %,d\n\n", 1234567890);
        formatter.format("Positive and negative numbers default format: %.2f %.2f\n", 423.78, -505.09);
        formatter.format("Positives using \"+\" sign and negatives in parentheses: %+.2f %(.2f", 423.78, -505.09);
        System.out.println(formatter);
    }
}
/*
 * output:
 * Default accuracy: 3.333333
 * 2 decimal places: 3.33
 *
 * Without grouping separator: 1234567890
 * With grouping separator: 1,234,567,890
 *
 * Positive and negative numbers default format: 423.78 -505.09
 * Positives using "+" sign and negatives in parentheses: +423.78 (505.09)
 * */
