package javacookbook.chapter4.listings.l4;

import java.util.Formatter;
import java.util.Locale;

public class Table {
    public static void main(String[] args) {
        Formatter formatter = new Formatter(Locale.ENGLISH);
        formatter.format("%-12s%12s\n\n", "Source", "Profit/Loss");
        formatter.format("%-12s%,12d\n", "Retail", 1232675);
        formatter.format("%-12s%,12d\n", "Wholesale", 23232482);
        formatter.format("%-12s%,12d\n", "Rent", 3052238);
        formatter.format("%-12s%,12d\n", "Royalty", 329845);
        formatter.format("%-12s%,12d\n", "Interest", 8657);
        formatter.format("%-12s%,12d\n", "Investments", 1675832);
        formatter.format("%-12s%,12d\n", "Licences", -765);
        formatter.format("%-12s%,12d\n", "Patents", -2011);
        System.out.println(formatter);
    }
}
/*
 * output:
 * Source       Profit/Loss
 *
 * Retail         1,232,675
 * Wholesale     23,232,482
 * Rent           3,052,238
 * Royalty          329,845
 * Interest           8,657
 * Investments    1,675,832
 * Licences            -765
 * Patents           -2,011
 * */
