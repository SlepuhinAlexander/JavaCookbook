package javacookbook.chapter03.listings.l02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBytes {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("usage: java WriteBytes filename");
            // test usage: java WriteBytes alphabet.txt
            return;
        }
        byte[] values = new byte[52];
        for (int i = 0; i < 26; i++) {
            values[2 * i] = (byte) (65 + 32 + i);
            values[2 * i + 1] = (byte) (65 + i);
        }
        System.out.println("Test byte array to write: ");
        for (byte b : values) {
            System.out.print(((char) b));
        }
        FileOutputStream out;
        String path = System.getProperty("java.class.path") + File.separator;
        path += WriteBytes.class.getPackageName().replace(".", File.separator) + File.separator;
        File file = new File(path + args[0]);
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error while opening file " + file.getName());
            return;
        }
        try {
            for (int i = 0; i < values.length; i += 2) {
                out.write(values[i]);
            }
            for (int i = 0; i < values.length; i += 2) {
                out.write(values[i + 1]);
            }
        } catch (IOException e) {
            System.out.println("Error while writing to file " + file.getName());
            return;
        }
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("Error while closing file " + file.getName());
        }
    }
}
/*
 * output:
 * Test byte array to write:
 * aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ
 *
 * alphabet.txt:
 * abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
 * */