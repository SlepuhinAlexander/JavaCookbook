package javacookbook.chapter04.listings.l05;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

public class TimeAndDate {
    public static void main(String[] args) {
        Formatter formatter = new Formatter(Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();
        formatter.format("Time in 12-hour format: %tr\n", calendar);
        formatter.format("Time in 24-hour format: %tT\n", calendar);
        formatter.format("Shortened date format: %tD\n", calendar);
        formatter.format("Extended date format: %tA %<tB %<td, %<tY\n", calendar);
        formatter.format("Date and time in lower case: %tc\n", calendar);
        formatter.format("Date and time in upper case: %Tc\n", calendar);
        formatter.format("Hours and minutes: %tl:%<tM %<Tp", calendar);
        System.out.println(formatter);
    }
}
/*
 * output:
 * Time in 12-hour format: 09:58:30 PM
 * Time in 24-hour format: 21:58:30
 * Shortened date format: 02/24/20
 * Extended date format: Monday February 24, 2020
 * Date and time in lower case: Mon Feb 24 21:58:30 MSK 2020
 * Date and time in upper case: MON FEB 24 21:58:30 MSK 2020
 * Hours and minutes: 9:58 PM
 * */
