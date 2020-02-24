package javacookbook.chapter4.listings.l12;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatDemo {
    public static void main(String[] args) {
        double data = 1234567.678;
        NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
        System.out.println("Default format: " + nf.format(data));
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        System.out.println("Format with exactly 2 decimal places: " + nf.format(data));
        nf.setGroupingUsed(false);
        System.out.println("Grouping disabled: " + nf.format(data));
        System.out.println("Pay attention to decimal places: " +
                nf.format(10d) + ", " + nf.format(-1.8));
    }
}
/*
 * output:
 * Default format: 1,234,567.678
 * Format with exactly 2 decimal places: 1,234,567.68
 * Grouping disabled: 1234567.68
 * Pay attention to decimal places: 10.00, -1.80
 * */
