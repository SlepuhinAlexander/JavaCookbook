package javacookbook.chapter3.listings.l2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBytes {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("usage: java WriteBytes filename");
            // test usage: java WriteBytes alphabet.txt
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
        try {
            String path = System.getProperty("java.class.path") + "/";
            path += WriteBytes.class.getPackageName().replace(".", "/") + "/";
            out = new FileOutputStream(new File(path + args[0]));
        } catch (FileNotFoundException e) {
            System.out.println("Error while opening file " + args[0]);
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
            System.out.println("Error while writing to file " + args[0]);
            return;
        }
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("Error while closing file " + args[0]);
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