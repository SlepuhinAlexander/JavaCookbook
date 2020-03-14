package javacookbook.chapter03.listings.l10;

import java.io.File;
import java.io.FileFilter;

public class ListFiles {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ListFiles directoryName");
            // test usage: java ListFiles javacookcook/chapter3
            return;
        }
        String path = System.getProperty("java.class.path") + File.separator;
        File directory = new File(path + args[0]);
        if (!directory.exists()) {
            System.out.println(directory.getName() + " not found");
            return;
        }
        if (!directory.isDirectory()) {
            System.out.println(directory.getName() + " is not a directory");
        }
        System.out.println("All files and folders:");
        listFiles(directory);
        System.out.println("\nOnly java class files:");
        listFiles(directory, new JavaFiles());
    }

    public static void listFiles(File file) {
        System.out.println(file.getName());
        listFiles(file, 1, null);
    }

    public static void listFiles(File file, FileFilter filter) {
        System.out.println(file.getName());
        listFiles(file, 1, filter);
    }

    private static void listFiles(File file, int depth, FileFilter filter) {
        if (depth < 0) {
            return;
        }
        File[] files;
        if (filter == null) {
            files = file.listFiles();
        } else files = file.listFiles(filter);
        if (files == null) {
            return;
        }
        for (File f : files) {
            for (int i = 0; i < depth; i++) {
                System.out.print("   ");
            }
            System.out.println(f.getName());
            if (f.isDirectory()) {
                listFiles(f, depth + 1, filter);
            }
        }
    }
}
/*
 * output:
 * All files and folders:
 * chapter3
 *    listings
 *       l1
 *          HexDump.class
 *          README.md
 *       l10
 *          JavaFiles.class
 *          ListFiles.class
 *          README.md
 *       l2
 *          alphabet.txt
 *          README.md
 *          WriteBytes.class
 *       l3
 *          BufferedFileCopy.class
 *          README.copy
 *          README.md
 *       l4
 *          README.md
 *          ShowFile.class
 *       l5
 *          employees.txt
 *          README.md
 *          WriteChars.class
 *       l6
 *          InvertCasingCopy.class
 *          README.copy
 *          README.md
 *       l7
 *          README.copy
 *          README.md
 *          ReverseFile.class
 *       l8
 *          README.md
 *          ShowFileAttributes.class
 *       l9
 *          README.md
 *          SetFileAttributes.class
 *          Test.txt
 *    README.md
 *
 * Only java class files:
 * chapter3
 *    listings
 *       l1
 *          HexDump.class
 *       l10
 *          JavaFiles.class
 *          ListFiles.class
 *       l2
 *          WriteBytes.class
 *       l3
 *          BufferedFileCopy.class
 *       l4
 *          ShowFile.class
 *       l5
 *          WriteChars.class
 *       l6
 *          InvertCasingCopy.class
 *       l7
 *          ReverseFile.class
 *       l8
 *          ShowFileAttributes.class
 *       l9
 *          SetFileAttributes.class
 * */