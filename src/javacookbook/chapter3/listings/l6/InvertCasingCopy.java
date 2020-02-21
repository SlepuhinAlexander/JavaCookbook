package javacookbook.chapter3.listings.l6;

import java.io.*;

public class InvertCasingCopy {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java InvertCasingCopy originalFilename copyFilename");
            // test usage: java InvertCasingCopy README.md README.copy
            return;
        }

        String path = System.getProperty("java.class.path") + File.separator;
        path += InvertCasingCopy.class.getPackageName().replace(".", File.separator) + File.separator;
        File input = new File(path + args[0]);
        File output = new File(path + args[1]);
        BufferedReader reader;
        BufferedWriter writer;
        try {
            reader = new BufferedReader(new FileReader(new File(path + input.getName())));
        } catch (FileNotFoundException e) {
            System.out.println("Original file " + input.getName() + " not found");
            return;
        }
        try {
            writer = new BufferedWriter(new FileWriter(new File(path + output.getName())));
        } catch (IOException e) {
            System.out.println("Error while opening output file " + output.getName());
            try {
                reader.close();
            } catch (IOException ex) {
                System.out.println("Error while closing input file " + input.getName());
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
            System.out.println("Error while closing input file " + input.getName());
        }
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Error while closing output file " + output.getName());
        }
    }
}

/*
 * output:
 *
 * README.copy:
 * ### bUFFERED CHARACTERS FILE INPUT-OUTPUT
 * */