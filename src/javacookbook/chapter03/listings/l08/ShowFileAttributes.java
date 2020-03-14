package javacookbook.chapter03.listings.l08;

import java.io.File;
import java.util.Date;
import java.util.Locale;

public class ShowFileAttributes {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ShowFileAttributes filename");
            // test usage: java ShowFileAttributes README.md
            return;
        }
        String path = System.getProperty("java.class.path") + File.separator;
        path += ShowFileAttributes.class.getPackageName().replace(".", File.separator) + File.separator;
        File file = new File(path + args[0]);
        showAttributes(file);
    }

    private static void showAttributes(File file) {
        if (!file.exists()) {
            System.out.println("File " + file.getName() + " not found");
            return;
        }
        System.out.println("File " + file.getName() + " attributes:");
        if (file.canRead()) {
            System.out.println("\tReadable");
        }
        if (file.canWrite()) {
            System.out.println("\tWritable");
        }
        if (file.canExecute()) {
            System.out.println("\tExecutable");
        }
        if (file.isDirectory()) {
            System.out.println("\tIs a directory");
        }
        if (file.isFile()) {
            System.out.println("\tIs an ordinary file");
        }
        if (file.isHidden()) {
            System.out.println("\tIs hidden");
        }
        System.out.println("\tSize: " + file.length() + " bytes");
        System.out.printf(Locale.ENGLISH, "\tLast modified: %s", new Date(file.lastModified()));
    }
}
/*
 * output:
 * File README.md attributes:
 *     Readable
 *     Writable
 *     Executable
 *     Is an ordinary file
 *     Size: 27 bytes
 *     Last modified: Thu Feb 20 23:01:30 MSK 2020
 * */