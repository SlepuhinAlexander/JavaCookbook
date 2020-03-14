package javacookbook.chapter04.listings.l07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Formatter;

public class FormatterStreams {
    public static void main(String[] args) {
        String path = System.getProperty("java.class.path") + File.separator;
        path += FormatterStreams.class.getPackageName().replace(".", File.separator) + File.separator;
        Formatter console = new Formatter(System.out);
        Formatter file;
        try {
            file = new Formatter(new FileOutputStream(new File(path + "format.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file format.txt");
            return;
        }
        console.format("NegativeNumber: %(.2f\n\n", -123.34);
        file.format("NegativeNumber: %(.2f\n\n", -123.34);
        console.format("%8s%8s\n", "Value", "Square");
        file.format("%8s%8s\n", "Value", "Square");
        for (int i = 111; i < 123; i++) {
            console.format("%8d%8d\n", i, i * i);
            file.format("%8d%8d\n", i, i * i);
        }
        file.close();
        if (file.ioException() != null) {
            System.out.println("IO exception");
        }
    }
}
/*
 * output:
 * NegativeNumber: (123,34)
 *    Value  Square
 *      111   12321
 *      112   12544
 *      113   12769
 *      114   12996
 *      115   13225
 *      116   13456
 *      117   13689
 *      118   13924
 *      119   14161
 *      120   14400
 *      121   14641
 *      122   14884
 *
 * format.txt:
 * NegativeNumber: (123,34)
 *    Value  Square
 *      111   12321
 *      112   12544
 *      113   12769
 *      114   12996
 *      115   13225
 *      116   13456
 *      117   13689
 *      118   13924
 *      119   14161
 *      120   14400
 *      121   14641
 *      122   14884
 * */
