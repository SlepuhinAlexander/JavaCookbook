package javacookbook.chapter3.listings.l2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBytes {
    public static void main(String[] args) {
        byte[] values = new byte[52];
        for (int i = 0; i < 26; i++) {
            values[2 * i] = (byte) (65 + 32 + i);
            values[2 * i + 1] = (byte) (65 + i);
        }
        System.out.println("Test byte array to write: ");
        for (byte b : values) {
            System.out.print(((char) b));
        }
        FileOutputStream fos;
        try {
            String path = System.getProperty("java.class.path") + "/";
            path += WriteBytes.class.getPackageName().replace(".", "/") + "/alphabet.txt";
            fos = new FileOutputStream(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("Error while opening file");
            return;
        }
        try {
            for (int i = 0; i < values.length; i += 2) {
                fos.write(values[i]);
            }
            for (int i = 0; i < values.length; i += 2) {
                fos.write(values[i + 1]);
            }
        } catch (IOException e) {
            System.out.println("Error while writing to file");
            return;
        }
        try {
            fos.close();
        } catch (IOException e) {
            System.out.println("Error while closing file");
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