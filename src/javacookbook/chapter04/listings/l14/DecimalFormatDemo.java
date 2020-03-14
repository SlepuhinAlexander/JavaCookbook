package javacookbook.chapter04.listings.l14;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

public class DecimalFormatDemo {
    public static void main(String[] args) {
        System.out.println("Use group separator, display tailing zeros, display negatives in brackets:");
        DecimalFormat df = new DecimalFormat("#,###.00;(-#,###.00)");
        System.out.println(df.format(7123.00));
        System.out.println(df.format(-7123.00));

        System.out.println("Do not display tailing zeros:");
        df = new DecimalFormat("#,###.##;(-#,###.##)");
        System.out.println(df.format(7123.00));
        System.out.println(df.format(-7123.00));

        System.out.println("Display as percents:");
        df = new DecimalFormat("#%");
        System.out.println(df.format(0.19));
        System.out.println(df.format(-0.19));

        System.out.println("Display as currency:");
        df = new DecimalFormat("\u00a4#,##0.00");
        df.setCurrency(Currency.getInstance(Locale.US));
        System.out.println(df.format(4232.19));
        System.out.println(df.format(-4232.19));
    }
}
/*
 * output:
 * Use group separator, display tailing zeros, display negatives in brackets:
 * 7 123,00
 * (-7 123,00)
 * Do not display tailing zeros:
 * 7 123
 * (-7 123)
 * Display as percents:
 * 19%
 * -19%
 * Display as currency:
 * $4 232,19
 * -$4 232,19
 * */
