package javacookbook.chapter4.listings.l13;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatDemo {
    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("\"1989.989\" in currency format: " + nf.format(1899.989));
        System.out.println("\"-210.5\" in currency format: " + nf.format(-210.5));
    }
}
/*
 * output:
 * 1989.989" in currency format: $1,899.99
 * -210.5" in currency format: -$210.50
 * */
