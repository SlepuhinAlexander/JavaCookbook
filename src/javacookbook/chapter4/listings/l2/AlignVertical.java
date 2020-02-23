package javacookbook.chapter4.listings.l2;

import java.util.Formatter;
import java.util.Locale;

public class AlignVertical {
    public static void main(String[] args) {
        double[] data = {12.3, 45.5764, -0.09, -18d, 1232.01};
        Formatter formatter = new Formatter(Locale.ENGLISH);
        formatter.format("%12s%12s\n", "Value", "Cubic root");
        for (double v : data) {
            formatter.format("%12.4f%12.4f\n", v, Math.cbrt(v));
        }
        System.out.println(formatter);
    }
}
/*
 * output:
 *        Value  Cubic root
 *      12.3000      2.3084
 *      45.5764      3.5720
 *      -0.0900     -0.4481
 *     -18.0000     -2.6207
 *    1232.0100     10.7202
 * */
