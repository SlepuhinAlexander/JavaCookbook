package javacookbook.chapter5.listings.l4;

import java.util.TreeSet;

public class SetOperationsDemo {
    public static void main(String[] args) {
        TreeSet<Character> set1 = new TreeSet<>();
        TreeSet<Character> set2 = new TreeSet<>();
        for (int i = 0; i < 4; i++) {
            set1.add((char) ('A' + i));
            set2.add((char) ('C' + i));
        }
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println();

        System.out.println("Union of sets 1 and 2: " + SetOperations.union(set1, set2));
        System.out.println("Intersection of sets 1 and 2: " + SetOperations.intersection(set1, set2));
        System.out.println("Difference (set 1 minus set 2): " + SetOperations.difference(set1, set2));
        System.out.println("Difference (set 2 minus set 1): " + SetOperations.difference(set2, set1));
        System.out.println("Symmetric difference of sets 1 and 2: " + SetOperations.symmetricDifference(set1, set2));
        System.out.println();

        TreeSet<Character> set3 = new TreeSet<>(set1);
        set3.remove('D');
        System.out.println("Set 3: " + set3);
        System.out.println("Is set 1 a subset for set 2? " + SetOperations.isSubset(set1, set2));
        System.out.println("Is set 1 a superset for set 2? " + SetOperations.isSuperset(set1, set2));
        System.out.println("Is set 3 a subset for set 1? " + SetOperations.isSubset(set3, set1));
        System.out.println("Is set 3 a superset for set 1? " + SetOperations.isSuperset(set3, set1));
    }
}
/*
 * output:
 * Set 1: [A, B, C, D]
 * Set 2: [C, D, E, F]
 *
 * Union of sets 1 and 2: [A, B, C, D, E, F]
 * Intersection of sets 1 and 2: [C, D]
 * Difference (set 1 minus set 2): [A, B]
 * Difference (set 2 minus set 1): [E, F]
 * Symmetric difference of sets 1 and 2: [A, B, E, F]
 *
 * Set 3: [A, B, C]
 * Is set 1 a subset for set 2? false
 * Is set 1 a superset for set 2? false
 * Is set 3 a subset for set 1? true
 * Is set 3 a superset for set 1? false
 * */
