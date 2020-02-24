package javacookbook.chapter4.listings.l8;

import java.util.Calendar;
import java.util.Locale;

public class PrintfDemo {
    public static void main(String[] args) {
        System.out.printf(Locale.ENGLISH, "2 decimal places: %.2f\n", 10f / 3f);
        System.out.printf(Locale.ENGLISH, "Using group separators: %,.2f\n\n", 1546456.87f);
        System.out.printf(Locale.ENGLISH, "%10s%10s%10s\n", "Value", "Root", "Square");
        for (double i = 111d; i < 123d; i++) {
            System.out.printf(Locale.ENGLISH, "%10.2f%10.2f%10.2f\n", i, Math.sqrt(i), i * i);
        }
        System.out.print("\n");
        System.out.printf(Locale.ENGLISH, "Current datetime: %tc", Calendar.getInstance());
    }
}
/*
 * output:
 * 2 decimal places: 3.33
 * Using group separators: 1,546,456.88
 *
 *      Value      Root    Square
 *     111.00     10.54  12321.00
 *     112.00     10.58  12544.00
 *     113.00     10.63  12769.00
 *     114.00     10.68  12996.00
 *     115.00     10.72  13225.00
 *     116.00     10.77  13456.00
 *     117.00     10.82  13689.00
 *     118.00     10.86  13924.00
 *     119.00     10.91  14161.00
 *     120.00     10.95  14400.00
 *     121.00     11.00  14641.00
 *     122.00     11.05  14884.00
 *
 * Current datetime: Mon Feb 24 22:55:40 MSK 2020
 * */
