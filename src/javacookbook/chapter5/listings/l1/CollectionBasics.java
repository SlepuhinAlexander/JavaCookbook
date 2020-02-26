package javacookbook.chapter5.listings.l1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionBasics {
    public static void main(String[] args) {
        ArrayList<Integer> col = new ArrayList<>();
        System.out.println("Initial size of collection: " + col.size());
        for (int i = 0; i < 10; i++) {
            col.add(i + 10);
        }
        System.out.println("Size of collection after adding 10 elements: " + col.size());
        System.out.println("Contents of collection 1: ");
        printCollection(col);
        System.out.println();
        if (col.contains(12)) {
            System.out.println("Collection 1 contains '12'");
        } else {
            System.out.println("Collection 1 does not contain '12'");
        }
        if (col.contains(-9)) {
            System.out.println("Collection 1 contains '-9'");
        } else {
            System.out.println("Collection 1 does not contain '-9'");
        }
        System.out.println();

        ArrayList<Integer> col2 = new ArrayList<>();
        col2.add(100);
        col2.add(200);
        col2.add(8);
        col2.add(-10);
        System.out.println("Contents of collection 2: ");
        printCollection(col2);
        System.out.println();

        col.addAll(col2);
        System.out.println("Contents of collection 1 after adding collection 2: ");
        printCollection(col);
        if (col.containsAll(col2)) {
            System.out.println("Collection 1 contains all elements of collection 2");
        } else {
            System.out.println("Collection 1 does not contain all elements of collection 2");
        }
        System.out.println();

        col.remove(((Integer) 10));
        col.remove(((Integer) 200));
        System.out.println("Contents of collection 1 after removing elements '10' and '200':");
        printCollection(col);
        System.out.println();

        col.removeAll(col2);
        System.out.println("Contents of collection 1 after removing all elements of collection 2: ");
        printCollection(col);
        System.out.println();

        col.addAll(col2);
        System.out.println("Contents of collection 1 after adding collection 2 again: ");
        printCollection(col);
        System.out.println();

        col.retainAll(col2);
        System.out.println("Contents of collection 1 after retaining collection 2: ");
        printCollection(col);
        System.out.println();

        System.out.println("Collection 1 converted to regular array: ");
        System.out.println(Arrays.toString(col.toArray()));
        System.out.println();

        col.clear();
        System.out.println("Clearing collection 1: ");
        printCollection(col);
        System.out.println("Collection 1 size: " + col.size());
        if (col.isEmpty()) {
            System.out.println("Collection 1 is empty");
        } else {
            System.out.println("Collection 1 is not empty");
        }
    }

    public static void printCollection(Collection<?> c) {
        System.out.print("{");
        for (Object o : c) {
            System.out.print(o + " ");
        }
        System.out.println("}");
    }
}
/*
 * output:
 * Initial size of collection: 0
 * Size of collection after adding 10 elements: 10
 * Contents of collection 1:
 * {10 11 12 13 14 15 16 17 18 19 }
 *
 * Collection 1 contains '12'
 * Collection 1 does not contain '-9'
 *
 * Contents of collection 2:
 * {100 200 8 -10 }
 *
 * Contents of collection 1 after adding collection 2:
 * {10 11 12 13 14 15 16 17 18 19 100 200 8 -10 }
 * Collection 1 contains all elements of collection 2
 *
 * Contents of collection 1 after removing elements '10' and '200':
 * {11 12 13 14 15 16 17 18 19 100 8 -10 }
 *
 * Contents of collection 1 after removing all elements of collection 2:
 * {11 12 13 14 15 16 17 18 19 }
 *
 * Contents of collection 1 after adding collection 2 again:
 * {11 12 13 14 15 16 17 18 19 100 200 8 -10 }
 *
 * Contents of collection 1 after retaining collection 2:
 * {100 200 8 -10 }
 *
 * Collection 1 converted to regular array:
 * [100, 200, 8, -10]
 *
 * Clearing collection 1:
 * {}
 * Collection 1 size: 0
 * Collection 1 is empty
 * */
