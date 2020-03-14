package javacookbook.chapter04.listings.l03;

import java.util.Arrays;
import java.util.Formatter;
import java.util.IllegalFormatException;
import java.util.Locale;

public class CenterAlignment {
    public static void main(String[] args) {
        Formatter f = new Formatter(Locale.ENGLISH);
        f.format("|");
        center(f, "%s", 12, "Source");
        f.format("|");
        center(f, "%10s", 16, "Profit/Loss");
        f.format("|\n\n");

        f.format("|");
        center(f, "%s", 12, "Retail");
        f.format("|");
        center(f, "%,10d", 16, 1232675);
        f.format("|\n");

        f.format("|");
        center(f, "%s", 12, "Wholesale");
        f.format("|");
        center(f, "%,10d", 16, 23232482);
        f.format("|\n");

        f.format("|");
        center(f, "%s", 12, "Rent");
        f.format("|");
        center(f, "%,10d", 16, 3052238);
        f.format("|\n");

        f.format("|");
        center(f, "%s", 12, "Royalty");
        f.format("|");
        center(f, "%,10d", 16, 329845);
        f.format("|\n");

        f.format("|");
        center(f, "%s", 12, "Interest");
        f.format("|");
        center(f, "%,10d", 16, 8657);
        f.format("|\n");

        f.format("|");
        center(f, "%s", 12, "Investments");
        f.format("|");
        center(f, "%,10d", 16, 1675832);
        f.format("|\n");

        f.format("|");
        center(f, "%s", 12, "Licences");
        f.format("|");
        center(f, "%,10d", 16, -765);
        f.format("|\n");

        f.format("|");
        center(f, "%s", 12, "Patents");
        f.format("|");
        center(f, "%,10d", 16, -2011);
        f.format("|");

        System.out.println(f);
    }

    static void center(Formatter f, String format, int width, Object... args) {
        center(Locale.getDefault(), f, format, width, args);
    }

    static void center(Locale locale, Formatter f, String format, int width, Object... args) {
        String s;
        try {
            Formatter tmp = new Formatter(locale);
            tmp.format(format, args);
            s = tmp.toString();
        } catch (IllegalFormatException e) {
            System.out.println("Incorrect format usage");
            f.format("");
            return;
        }
        if (width - s.length() <= 0) {
            f.format(s);
            return;
        }
        char[] prefix = new char[(width - s.length()) / 2];
        Arrays.fill(prefix, ' ');
        char[] suffix = new char[width - prefix.length - s.length()];
        Arrays.fill(suffix, ' ');
        f.format(new String(prefix));
        f.format(s);
        f.format(new String(suffix));
    }
}
/*
 * output:
 * |   Source   |  Profit/Loss   |
 *
 * |   Retail   |    1 232 675   |
 * | Wholesale  |   23 232 482   |
 * |    Rent    |    3 052 238   |
 * |  Royalty   |      329 845   |
 * |  Interest  |        8 657   |
 * |Investments |    1 675 832   |
 * |  Licences  |         -765   |
 * |  Patents   |       -2 011   |
 * */