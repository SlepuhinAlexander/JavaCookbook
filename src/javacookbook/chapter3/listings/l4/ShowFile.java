package javacookbook.chapter3.listings.l4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ShowFile {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ShowFile filename");
            // test usage: java ShowFile README.md
            return;
        }
        String path = System.getProperty("java.class.path") + File.separator;
        path += ShowFile.class.getPackageName().replace(".", File.separator) + File.separator;
        File file = new File(path + args[0]);
        FileReader reader;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("File " + file.getName() + " not found");
            return;
        }
        try {
            int count;
            char[] chars = new char[80];
            do {
                count = reader.read(chars);
                for (int i = 0; i < count; i++) {
                    System.out.print(chars[i]);
                }
            } while (count != -1);
        } catch (IOException e) {
            System.out.println("Error while reading the file " + file.getName());
        }
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Error while closing the file " + file.getName());
        }
    }
}
/*
 * output:
 * ### Reading characters from a file
 * */