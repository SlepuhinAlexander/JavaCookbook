package javacookbook.chapter4.listings.l11;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleDateFormatDemo {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat("hh:mm:ss a", Locale.ENGLISH);
        System.out.println("\"hh:mm:ss a\"  :  " + dateFormat.format(date));
        dateFormat = new SimpleDateFormat("kk:mm:ss", Locale.ENGLISH);
        System.out.println("\"kk:mm:ss a\"  :  " + dateFormat.format(date));
        dateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm:ss a", Locale.ENGLISH);
        System.out.println("\"dd MMM yyyy hh:mm:ss a\"  :  " + dateFormat.format(date));
        dateFormat = new SimpleDateFormat("EEEE MMMMM dd yyyy HH:mm:ss", Locale.ENGLISH);
        System.out.println("\"EEEE MMMMM dd yyyy HH:mm:ss\"  :  " + dateFormat.format(date));
    }
}
/*
 * output:
 * "hh:mm:ss a"  :  11:56:35 PM
 * "kk:mm:ss a"  :  23:56:35
 * "dd MMM yyyy hh:mm:ss a"  :  24 Feb 2020 11:56:35 PM
 * "EEEE MMMMM dd yyyy HH:mm:ss"  :  Monday February 24 2020 23:56:35
 * */
