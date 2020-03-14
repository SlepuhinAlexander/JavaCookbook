package javacookbook.chapter03.listings.l07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReverseFile {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ReverseFile originalFilename destinationFilename");
            //test usage: java ReverseFile README.md README.copy
            return;
        }
        String path = System.getProperty("java.class.path") + File.separator;
        path += ReverseFile.class.getPackageName().replace(".", File.separator) + File.separator;
        RandomAccessFile in, out;
        File input = new File(path + args[0]);
        File output = new File(path + args[1]);
        try {
            in = new RandomAccessFile(input, "r");
        } catch (FileNotFoundException e) {
            System.out.println("Error while opening input file " + input.getName());
            return;
        }
        try {
            out = new RandomAccessFile(output, "rw");
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
            for (int i = 0; i < in.length(); i++) {
                out.write(in.read());
            }
        } catch (IOException e) {
            System.out.println("Error while copying from " + input.getName() + " to " + output.getName());
        }
        try {
            int x, y;
            for (long i = 0, j = out.length() - 1; i < j; i++, j--) {
                out.seek(i);
                x = out.read();
                out.seek(j);
                y = out.read();
                out.seek(i);
                out.write(y);
                out.seek(j);
                out.write(x);
            }
        } catch (IOException e) {
            System.out.println("Error while writing to output file " + output.getName());
        }
        try {
            in.close();
        } catch (IOException e) {
            System.out.println("Error while closing input file " + input.getName());
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
 * gnitirw dna gnidaer selif ssecca-modnaR ###
 * */
