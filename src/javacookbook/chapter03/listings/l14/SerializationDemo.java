package javacookbook.chapter03.listings.l14;

import java.io.*;
import java.util.Arrays;

public class SerializationDemo {
    private static final String path = System.getProperty("java.class.path") + File.separator +
            SerializationDemo.class.getPackageName().replace(".", File.separator) + File.separator;

    public static void main(String[] args) {
        SerializableClass first = new SerializableClass(
                "This is a test", "Test.txt", 1.1, 2.2, 3.3);
        SerializableClass second = new SerializableClass(
                "Alpha Beta Gamma", "Sample.dat", 9.0, 8.0, 7.0, 6.0, 5.0);
        ObjectOutputStream out;
        ObjectInputStream in;
        File file = new File(path + "objects.ser");
        try {
            out = new ObjectOutputStream(new FileOutputStream(file));
        } catch (IOException e) {
            System.out.println("Error while opening output file " + file.getName());
            return;
        }
        System.out.println("Writing objects to file " + file.getName());
        try {
            System.out.println("first: \n" + first);
            out.writeObject(first);
            System.out.println("second: \n" + second);
            out.writeObject(second);
        } catch (IOException e) {
            System.out.println("Error while writing objects");
        }
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("Error while closing file " + file.getName());
            return;
        }
        try {
            in = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException e) {
            System.out.println("Error while opening input file " + file.getName());
            return;
        }
        System.out.println("\nRestoring objects from file " + file.getName());
        try {
            SerializableClass input;
            input = (SerializableClass) in.readObject();
            System.out.println("First object: \n" + input);
            input = (SerializableClass) in.readObject();
            System.out.println("Second object: \n" + input);
        } catch (IOException e) {
            System.out.println("Error while reading objects data from file " + file.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("Class definition not found");
        }
        try {
            in.close();
        } catch (IOException e) {
            System.out.println("Error while closing input file " + file.getName());
        }
    }

    private static class SerializableClass implements Serializable {
        private String description;
        private File file;
        private double[] values;

        public SerializableClass(String desc, String name, double... numbers) {
            description = desc;
            file = new File(path + name);
            values = numbers;
        }

        @Override
        public String toString() {
            return "    description: " + description +
                    "\n    file: " + file.getName() +
                    "\n    values: " + Arrays.toString(values);
        }
    }
}
/*
 * output:
 * Writing objects to file objects.ser
 * first:
 *     description: This is a test
 *     file: Test.txt
 *     values: [1.1, 2.2, 3.3]
 * second:
 *     description: Alpha Beta Gamma
 *     file: Sample.dat
 *     values: [9.0, 8.0, 7.0, 6.0, 5.0]
 *
 * Restoring objects from file objects.ser
 * First object:
 *     description: This is a test
 *     file: Test.txt
 *     values: [1.1, 2.2, 3.3]
 * Second object:
 *     description: Alpha Beta Gamma
 *     file: Sample.dat
 *     values: [9.0, 8.0, 7.0, 6.0, 5.0]
 * */
