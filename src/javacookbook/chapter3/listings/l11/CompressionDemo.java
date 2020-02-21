package javacookbook.chapter3.listings.l11;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressionDemo {
    public static void main(String[] args) {
        DataInputStream in;
        DataOutputStream out;
        Random r = new Random(47);
        double[] data = new double[r.nextInt(10) + 1];
        for (int i = 0; i < data.length; i++) {
            data[i] = Math.round((r.nextDouble() + r.nextInt(100)) * 10000) / 10000D;
        }
        String path = System.getProperty("java.class.path") + "/";
        path += CompressionDemo.class.getPackageName().replace(".", "/") + "/";
        File file = new File(path + "data.compressed");
        try {
            out = new DataOutputStream(new DeflaterOutputStream(new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            System.out.println("Error while opening file " + file.getName());
            return;
        }
        try {
            out.writeInt(data.length);
            for (double d : data) {
                out.writeDouble(d);
            }
        } catch (IOException e) {
            System.out.println("Error while writing data to file " + file.getName());
        }
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("Error while closing output file " + file.getName());
        }

        try {
            in = new DataInputStream(new InflaterInputStream(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            System.out.println("Input file " + file.getName() + " not found");
            return;
        }
        try {
            int amount = in.readInt();
            double sum = 0.0;
            double[] d = new double[amount];
            System.out.print("Received data: ");
            for (int i = 0; i < amount; i++) {
                d[i] = in.readDouble();
                sum += d[i];
            }
            System.out.println(Arrays.toString(d));
            System.out.println("Amount: " + amount);
            System.out.printf(Locale.ENGLISH, "Average: %.4f\n", sum / amount);
        } catch (IOException e) {
            System.out.println("Error while reading input file " + file.getName());
        }
        try {
            in.close();
        } catch (IOException e) {
            System.out.println("Error while closing input file " + file.getName());
        }
    }
}
/*
 * output:
 * Received data: [61.3998, 68.1602, 7.417, 51.2679, 78.1144, 20.8037, 40.5537, 4.5296, 75.2498]
 * Amount: 9
 * Average: 45.2773
 * */