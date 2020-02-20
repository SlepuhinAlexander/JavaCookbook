package javacookbook.chapter3.listings.l5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteChars {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java WriteChars filename");
            // test usage: java WriteChars employees.txt
            return;
        }
        String path = System.getProperty("java.class.path") + "/";
        path += WriteChars.class.getPackageName().replace(".", "/") + "/";

        FileWriter writer;
        String[] data = {"32435 Tom@HerbSchildt.com", "86754 Mary@HerbSchildt.com", "35789 TC@HerbSchildt.com"};

        try {
            writer = new FileWriter(new File(path + args[0]));
        } catch (IOException e) {
            System.out.println("Error while opening file " + args[0]);
            return;
        }
        try {
            for (String s : data) {
                writer.write(s);
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error while writing to file " + args[0]);
        }
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Error while closing file " + args[0]);
        }
    }
}

/*
 * output:
 *
 * employees.txt
 * 32435 Tom@HerbSchildt.com
 * 86754 Mary@HerbSchildt.com
 * 35789 TC@HerbSchildt.com
 * */
