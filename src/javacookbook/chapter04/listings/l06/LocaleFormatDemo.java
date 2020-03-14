package javacookbook.chapter04.listings.l06;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

public class LocaleFormatDemo {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        Calendar calendar = Calendar.getInstance();
        formatter.format("Default locale: %tc\n", calendar);
        formatter.format(Locale.ENGLISH, "Locale.ENGLISH: %tc\n", calendar);
        formatter.format(Locale.GERMAN, "Locale.GERMAN: %tc\n", calendar);
        formatter.format(Locale.ITALY, "Locale.ITALY: %tc\n", calendar);
        formatter.format(Locale.FRANCE, "Locale.FRANCE: %tc\n", calendar);
        System.out.println(formatter);
    }
}
/*
 * output:
 * Default locale: пн февр. 24 22:09:26 MSK 2020
 * Locale.ENGLISH: Mon Feb 24 22:09:26 MSK 2020
 * Locale.GERMAN: Mo. Feb. 24 22:09:26 MSK 2020
 * Locale.ITALY: lun feb 24 22:09:26 MSK 2020
 * Locale.FRANCE: lun. févr. 24 22:09:26 MSK 2020
 * */
