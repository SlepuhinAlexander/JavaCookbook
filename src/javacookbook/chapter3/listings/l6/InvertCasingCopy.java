package javacookbook.chapter3.listings.l6;

import java.io.*;

public class InvertCasingCopy {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java InvertCasingCopy originalFilename copyFilename");
            // test usage: java InvertCasingCopy README.md README.copy
            return;
        }

        String path = System.getProperty("java.class.path") + "/";
        path += InvertCasingCopy.class.getPackageName().replace(".", "/") + "/";
        BufferedReader reader;
        BufferedWriter writer;
        try {
            reader = new BufferedReader(new FileReader(new File(path + args[0])));
        } catch (FileNotFoundException e) {
            System.out.println("Original file " + args[0] + " not found");
            return;
        }
        try {
            writer = new BufferedWriter(new FileWriter(new File(path + args[1])));
        } catch (IOException e) {
            System.out.println("Error while opening output file " + args[1]);
            try {
                reader.close();
            } catch (IOException ex) {
                System.out.println("Error while closing input file " + args[0]);
            }
            return;
        }

        try {
            int i;
            do {
                i = reader.read();
                if (i != -1) {
                    if (Character.isLowerCase((char) i)) {
                        writer.write(Character.toUpperCase((char) i));
                    } else if (Character.isUpperCase((char) i)) {
                        writer.write(Character.toLowerCase((char) i));
                    } else {
                        writer.write((char) i);
                    }
                }
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Read-Write error");
        }

        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Error while closing input file " + args[0]);
        }
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Error while closing output file " + args[1]);
        }
    }
}

/*
 * output:
 *
 * README.copy:
 * ### bUFFERED CHARACTERS FILE INPUT-OUTPUT
 * */