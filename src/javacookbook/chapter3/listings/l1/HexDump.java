package javacookbook.chapter3.listings.l1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HexDump {
    // expected to use filename as first argument
    public static void main(String[] args) {
        FileInputStream fis;
        if (args.length < 1) {
            System.out.println("Usage: java HexDump filename");
            return;
        }
        try {
            String path = System.getProperty("java.class.path") + "/";
            path += HexDump.class.getPackageName().replace(".","/") + "/";
            fis = new FileInputStream(new File(path + args[0]));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
        try {
            System.out.println(args[0] + " in hex:"); // for example, using the README.md
            int length;
            byte[] data = new byte[16];
            do {
                length = fis.read(data);
                for (int i = 0; i < length; i++) {
                    System.out.printf("%02X ", data[i]);
                }
                System.out.println();
            } while (length != -1);
        } catch (IOException e) {
            System.out.println("Error while reading file");
            return;
        }
        try {
            fis.close();
        } catch (IOException e) {
            System.out.println("Error while closing file");
        }
    }
}
/*
 * output:
 * README.md in hex:
 * 23 23 23 20 52 65 61 64 69 6E 67 20 62 79 74 65
 * 73 20 66 72 6F 6D 20 61 20 66 69 6C 65
 * */
