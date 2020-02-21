package javacookbook.chapter3.listings.l12;

import java.io.*;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;

public class Zipper {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Zipper archiveFilename <list_of_filenames>");
            // test usage: java Zipper archive.zip data0.dat data1.dat data2.dat
            return;
        }
        String path = System.getProperty("java.class.path") + File.separator;
        path += Zipper.class.getPackageName().replace(".", File.separator) + File.separator;
        File archive = new File(path + args[0]);
        File entry;
        BufferedInputStream in;
        ZipOutputStream out;
        ZipEntry zipEntry = null;
        try {
            out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(archive)));
        } catch (FileNotFoundException e) {
            System.out.println("Error while opening output file " + archive.getName());
            return;
        }
        for (int n = 1; n < args.length; n++) {
            entry = new File(path + args[n]);
            try {
                in = new BufferedInputStream(new FileInputStream(entry));
            } catch (FileNotFoundException e) {
                System.out.println("Input file " + entry.getName() + " not found");
                try {
                    out.close();
                } catch (ZipException ex) {
                    System.out.println("Broken zip file " + archive.getName());
                } catch (IOException ex) {
                    System.out.println("Error while closing output file " + archive.getName());
                }
                return;
            }
            try {
                zipEntry = new ZipEntry(entry.getName());
                out.putNextEntry(zipEntry);
                int i;
                do {
                    i = in.read();
                    if (i != -1) {
                        out.write(i);
                    }
                } while (i != -1);
                out.closeEntry();
            } catch (ZipException e) {
                System.out.println("Broken zip file " + archive.getName());
            } catch (IOException e) {
                System.out.println("Error while writing to file " + archive.getName());
            }
            try {
                in.close();
                System.out.print("Compressing: " + entry.getName() + " | ");
                System.out.printf(Locale.ENGLISH,
                        "original size: %d | compressed size: %d | compression rate: %.2f\n",
                        zipEntry.getSize(), zipEntry.getCompressedSize(),
                        100d - (zipEntry.getCompressedSize() * 100d / zipEntry.getSize()));
            } catch (IOException e) {
                System.out.println("Error while closing input file " + entry.getName());
            }
        }
        try {
            out.close();
        } catch (ZipException e) {
            System.out.println("Broken zip file " + archive.getName());
        } catch (IOException e) {
            System.out.println("Error while writing to file " + archive.getName());
        }
    }
}
/*
 * output:
 * Compressing: data0.dat | original size: 5600 | compressed size: 899 | compression rate: 16.05
 * Compressing: data1.dat | original size: 7516 | compressed size: 1933 | compression rate: 25.72
 * Compressing: data2.dat | original size: 10040 | compressed size: 2455 | compression rate: 24.45
 * */