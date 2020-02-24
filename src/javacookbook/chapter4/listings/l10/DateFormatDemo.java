package javacookbook.chapter4.listings.l10;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatDemo {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat df;
        df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ENGLISH);
        System.out.println("Date in short from: " + df.format(date));
        df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ENGLISH);
        System.out.println("Date in medium from: " + df.format(date));
        df = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH);
        System.out.println("Date in long from: " + df.format(date));
        df = DateFormat.getDateInstance(DateFormat.FULL, Locale.ENGLISH);
        System.out.println("Date in full from: " + df.format(date));
        System.out.println();
        df = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.ENGLISH);
        System.out.println("Time in short from: " + df.format(date));
        df = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.ENGLISH);
        System.out.println("Time in medium from: " + df.format(date));
        df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.ENGLISH);
        System.out.println("Time in long from: " + df.format(date));
        df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.ENGLISH);
        System.out.println("Time in full from: " + df.format(date));
    }
}
/*
 * output:
 * Date in short from: 2/24/20
 * Date in medium from: Feb 24, 2020
 * Date in long from: February 24, 2020
 * Date in full from: Monday, February 24, 2020
 *
 * Time in short from: 11:38 PM
 * Time in medium from: 11:38:43 PM
 * Time in long from: 11:38:43 PM MSK
 * Time in full from: 11:38:43 PM Moscow Standard Time
 * */
