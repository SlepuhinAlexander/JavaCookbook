package javacookbook.chapter3.listings.l13;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class UnZipper {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java UnZipper archiveFilename");
            // test usage: java UnZipper archive.zip
            return;
        }
        String path = System.getProperty("java.class.path") + File.separator;
        path += UnZipper.class.getPackageName().replace(".", File.separator) + File.separator;
        File archive = new File(path + args[0]);
        File entry;
        BufferedInputStream in;
        BufferedOutputStream out;
        ZipFile zipFile;
        ZipEntry zipEntry;
        try {
            zipFile = new ZipFile(archive);
        } catch (ZipException e) {
            System.out.println("Incorrect ZIP-file " + archive.getName());
            return;
        } catch (IOException e) {
            System.out.println("Error while opening ZIP archive " + archive.getName());
            return;
        }
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            zipEntry = entries.nextElement();
            System.out.print("Extracting: " + zipEntry.getName() + " | ");
            try {
                in = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            } catch (ZipException e) {
                System.out.println("Broken ZIP archive " + archive.getName());
                break;
            } catch (IOException e) {
                System.out.println("Error while opening ZIP entry " + zipEntry.getName());
                break;
            }
            entry = new File(path + zipEntry.getName());
            try {
                out = new BufferedOutputStream(new FileOutputStream(entry));
            } catch (FileNotFoundException e) {
                System.out.println("Error while creating output file " + entry.getName());
                try {
                    in.close();
                } catch (IOException ex) {
                    System.out.println("Error while closing ZIP entry " + zipEntry.getName());
                }
                break;
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
                System.out.println("Error while extracting file " + entry.getName());
            }
            System.out.println("Compressed size: " + zipEntry.getCompressedSize() +
                    " | extracted size: " + zipEntry.getSize());
            try {
                out.close();
            } catch (IOException e) {
                System.out.println("Error while closing output file " + entry.getName());
            }
            try {
                in.close();
            } catch (IOException e) {
                System.out.println("Error while closing ZIP entry " + zipEntry.getName());
            }
        }
        try {
            zipFile.close();
        } catch (IOException e) {
            System.out.println("Error while closing ZIP archive " + archive.getName());
        }
    }
}
/*
 * output:
 * Extracting: data0.dat | Compressed size: 899 | extracted size: 5600
 * Extracting: data1.dat | Compressed size: 1933 | extracted size: 7516
 * Extracting: data2.dat | Compressed size: 2455 | extracted size: 10040
 * */
