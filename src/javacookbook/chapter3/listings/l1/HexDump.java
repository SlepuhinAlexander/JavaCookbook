package javacookbook.chapter3.listings.l1;

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
            fis = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
        try {
            System.out.println(args[0] + " in hex:"); // for example, using the README.md
            int i;
            int count = 0;
            do {
                i = fis.read();
                if (i != -1) {
                    System.out.printf("%02X ", i);
                    count++;
                    if (count == 16) {
                        System.out.println();
                        count = 0;
                    }
                }
            } while (i != -1);
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
 * 23 20 4A 61 76 61 20 50 72 6F 67 72 61 6D 6D 69
 * 6E 67 20 43 6F 6F 6B 62 6F 6F 6B 0D 0A 4C 69 73
 * 74 69 6E 67 73 20 61 6E 64 20 65 78 61 6D 70 6C
 * 65 73 20 66 72 6F 6D 20 48 65 72 62 20 53 63 68
 * 69 6C 64 74 27 73 20 4A 61 76 61 20 50 72 6F 67
 * 72 61 6D 6D 69 6E 67 20 43 6F 6F 6B 62 6F 6F 6B
 * */
