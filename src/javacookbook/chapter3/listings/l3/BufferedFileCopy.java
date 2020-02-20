package javacookbook.chapter3.listings.l3;

import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java BufferedFileCopy originalFilename copyFilename");
            // test usage: java BufferedFileCopy README.md README.copy
            return;
        }
        String path = System.getProperty("java.class.path") + "/";
        path += BufferedFileCopy.class.getPackageName().replace(".", "/") + "/";
        BufferedInputStream in;
        BufferedOutputStream out;
        try {
            in = new BufferedInputStream(new FileInputStream(new File(path + args[0])));
        } catch (FileNotFoundException e) {
            System.out.println("Original file " + args[0] + " not found");
            return;
        }
        try {
            out = new BufferedOutputStream(new FileOutputStream(new File(path + args[1])));
        } catch (FileNotFoundException e) {
            System.out.println("Error while opening output file " + args[1]);
            try {
                in.close();
            } catch (IOException ex) {
                System.out.println("Error while closing input file " + args[0]);
            }
            return;
        }
        try {
            int i;
            do {
                i = in.read();
                if (i != -1) {
                    out.write(i);
                }
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Read-write error");
        }
        try {
            in.close();
        } catch (IOException e) {
            System.out.println("Error while closing input file " + args[0]);
        }
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("Error while closing output file " + args[1]);
        }
    }
}
/*
 * output:
 *
 * README.copy:
 * ### Buffered byte file input-output
 * */
