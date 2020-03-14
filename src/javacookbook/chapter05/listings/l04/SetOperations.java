package javacookbook.chapter05.listings.l04;

import java.util.Set;
import java.util.TreeSet;

public class SetOperations {
    public static <T> Set<T> union(Set<T> setA, Set<T> setB) {
        Set<T> tmp = new TreeSet<>(setA);
        tmp.addAll(setB);
        return tmp;
    }

    public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
        Set<T> tmp = new TreeSet<>(setA);
        tmp.retainAll(setB);
        return tmp;
    }

    public static <T> Set<T> difference(Set<T> setA, Set<T> setB) {
        Set<T> tmp = new TreeSet<>(setA);
        tmp.removeAll(setB);
        return tmp;
    }

    public static <T> Set<T> symmetricDifference(Set<T> setA, Set<T> setB) {
        return union(difference(setA, setB), difference(setB, setA));
    }

    // returns true if setA is a subset for setB
    public static <T> boolean isSubset(Set<T> setA, Set<T> setB) {
        return setB.containsAll(setA);
    }

    // returns true if setA is a superset for setB
    public static <T> boolean isSuperset(Set<T> setA, Set<T> setB) {
        return setA.containsAll(setB);
    }
}
