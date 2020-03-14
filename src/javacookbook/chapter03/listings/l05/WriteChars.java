package javacookbook.chapter03.listings.l05;

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
        String path = System.getProperty("java.class.path") + File.separator;
        path += WriteChars.class.getPackageName().replace(".", File.separator) + File.separator;
        File file = new File(path + args[0]);

        FileWriter writer;
        String[] data = {"32435 Tom@HerbSchildt.com", "86754 Mary@HerbSchildt.com", "35789 TC@HerbSchildt.com"};

        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            System.out.println("Error while opening file " + file.getName());
            return;
        }
        try {
            for (String s : data) {
                writer.write(s);
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error while writing to file " + file.getName());
        }
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Error while closing file " + file.getName());
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
