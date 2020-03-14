package javacookbook.chapter02.listings.l02;

import java.util.Arrays;

public class IgnoreCaseSorting {
    public static void main(String[] args) {
        String[] strings = {"alpha", "Gamma", "Zeta", "beta"};
        System.out.print("Initial order: ");
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();
        Arrays.sort(strings);
        System.out.print("Case sensitive order: ");
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();
        Arrays.sort(strings, new IgnoreCaseComparator());
        System.out.print("Case insensitive order: ");
        for (String s : strings) {
            System.out.print(s + " ");
        }
    }
}

/*
* output:
* Initial order: alpha Gamma Zeta beta
* Case sensitive order: Gamma Zeta alpha beta
* Case insensitive order: alpha beta Gamma Zeta
* */
