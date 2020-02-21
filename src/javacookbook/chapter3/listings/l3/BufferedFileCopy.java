package javacookbook.chapter3.listings.l3;

import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java BufferedFileCopy originalFilename copyFilename");
            // test usage: java BufferedFileCopy README.md README.copy
            return;
        }
        String path = System.getProperty("java.class.path") + File.separator;
        path += BufferedFileCopy.class.getPackageName().replace(".", File.separator) + File.separator;
        BufferedInputStream in;
        BufferedOutputStream out;
        File input = new File(path + args[0]);
        File output = new File(path + args[1]);
        try {
            in = new BufferedInputStream(new FileInputStream(input));
        } catch (FileNotFoundException e) {
            System.out.println("Original file " + input.getName() + " not found");
            return;
        }
        try {
            out = new BufferedOutputStream(new FileOutputStream(output));
        } catch (FileNotFoundException e) {
            System.out.println("Error while opening output file " + output.getName());
            try {
                in.close();
            } catch (IOException ex) {
                System.out.println("Error while closing input file " + input.getName());
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
            System.out.println("Error while closing input file " + input.getName());
        }
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("Error while closing output file " + output.getName());
        }
    }
}
/*
 * output:
 *
 * README.copy:
 * ### Buffered byte file input-output
 * */
