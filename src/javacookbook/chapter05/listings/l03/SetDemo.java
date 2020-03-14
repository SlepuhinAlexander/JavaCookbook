package javacookbook.chapter05.listings.l03;

import java.util.HashSet;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("one");
        hashSet.add("two");
        hashSet.add("three");
        System.out.println("Contents of HashSet: " + hashSet);
        System.out.println("Trying to add one more \"three\" element");
        if (!hashSet.add("three")) {
            System.out.println("HashSet did not change: " + hashSet);
        }
        System.out.println();

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(8);
        treeSet.add(19);
        treeSet.add(-2);
        treeSet.add(3);
        System.out.println("Contents of TreeSet: " + treeSet);
        System.out.println("// Notice, that they are sorted");
        System.out.println("First element of TreeSet: " + treeSet.first());
        System.out.println("First last of TreeSet: " + treeSet.last());
        System.out.println("First element bigger than '15' in TreeSet: " + treeSet.higher(15));
        System.out.println("First element smaller than '15' in TreeSet: " + treeSet.lower(15));
    }
}
/*
 * output:
 * Contents of HashSet: [one, two, three]
 * Trying to add one more "three" element
 * HashSet did not change: [one, two, three]
 *
 * Contents of TreeSet: [-2, 3, 8, 19]
 * // Notice, that they are sorted
 * First element of TreeSet: -2
 * First last of TreeSet: 19
 * First element bigger than '15' in TreeSet: 19
 * First element smaller than '15' in TreeSet: 8
 * */
