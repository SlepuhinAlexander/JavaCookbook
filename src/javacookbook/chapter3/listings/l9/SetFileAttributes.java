package javacookbook.chapter3.listings.l9;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SetFileAttributes {
    static void fileStatus(File f) {
        if (f.canRead()) {
            System.out.println("Readable");
        } else {
            System.out.println("Not readable");
        }
        if (f.canWrite()) {
            System.out.println("Writable");
        } else {
            System.out.println("Not writable");
        }
        System.out.printf(Locale.ENGLISH, "Last modified: %s\n", new Date(f.lastModified()));
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java SetFileAttributes filename");
            //test usage: java SetFileAttributes Test.txt
            return;
        }
        String path = System.getProperty("java.class.path") + "/";
        path += SetFileAttributes.class.getPackageName().replace(".", "/") + "/";
        File file = new File(path + args[0]);
        if (!file.exists()) {
            System.out.println("File " + args[0] + " not found");
            return;
        }
        System.out.println("Original " + args[0] + " file status:");
        fileStatus(file);

        if (!file.setReadOnly()) {
            System.out.println("Cannot set readonly state");
        }
        if (!file.setLastModified(file.lastModified() + 1000 * 60 * 60 * 24 * 7)) {
            System.out.println("Cannot set last modified time");
        }
        System.out.println("\nChanged " + args[0] + " file status:");
        fileStatus(file);
        if (!file.setWritable(true, false)) {
            System.out.println("Cannot change writable state");
        }
        if (!file.setLastModified(Calendar.getInstance().getTimeInMillis())) {
            System.out.println("Cannot set last modified time");
        }
        System.out.println("\nRestored " + args[0] + " file status");
        fileStatus(file);
    }
}
/*
 * output:
 * Original Test.txt file status:
 * Readable
 * Writable
 * Last modified: Fri Feb 21 15:48:10 MSK 2020
 *
 * Changed Test.txt file status:
 * Readable
 * Not writable
 * Last modified: Fri Feb 28 15:48:10 MSK 2020
 *
 * Restored Test.txt file status
 * Readable
 * Writable
 * Last modified: Fri Feb 21 15:48:23 MSK 2020
 * */
