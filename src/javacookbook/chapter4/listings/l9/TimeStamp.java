package javacookbook.chapter4.listings.l9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Locale;

public class TimeStamp {
    public static void main(String[] args) {
        String path = System.getProperty("java.class.path") + File.separator;
        path += TimeStamp.class.getPackageName().replace(".", File.separator) + File.separator;
        File log = new File(path + "TimeStamp.log");
        PrintWriter writer;
        try {
            writer = new PrintWriter(new FileWriter(log));
        } catch (IOException e) {
            System.out.println("Error while opening file " + log.getName());
            return;
        }
        timeStamp(Locale.ENGLISH, "File opened", writer);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            timeStamp(Locale.ENGLISH, "Waiting interrupted", writer);
        }
        timeStamp(Locale.ENGLISH, "File closed", writer);
        writer.close();
        if (writer.checkError()) {
            System.out.println("Input-output error");
        }
    }

    public static void timeStamp(Locale l, String message, PrintWriter writer) {
        writer.printf(l, "[%tc] %s\n", Calendar.getInstance(), message);
    }

    public static void timeStamp(Locale l, PrintWriter writer) {
        timeStamp(l, "", writer);
    }

    public static void timeStamp(String message, PrintWriter writer) {
        timeStamp(Locale.getDefault(), message, writer);
    }

    public static void timeStamp(PrintWriter writer) {
        timeStamp(Locale.getDefault(), "", writer);
    }
}
/*
 * output:
 * TimeStamp.log
 * [Mon Feb 24 23:12:00 MSK 2020] File opened
 * [Mon Feb 24 23:12:10 MSK 2020] File closed
 * */