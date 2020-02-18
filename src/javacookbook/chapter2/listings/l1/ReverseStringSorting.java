package javacookbook.chapter2.listings.l1;

import java.util.Arrays;

public class ReverseStringSorting {
    public static void main(String[] args) {
        String[] strings = {"dog", "horse", "zebra", "cow", "cat"};
        System.out.print("Initial order: ");
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();
        Arrays.sort(strings);
        System.out.print("Natural order: ");
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();
        Arrays.sort(strings, new ReverseStringComparator());
        System.out.print("Reverse order: ");
        for (String s : strings) {
            System.out.print(s + " ");
        }
    }
}

/*
* output:
* Initial order: dog horse zebra cow cat
* Natural order: cat cow dog horse zebra
* Reverse order: zebra horse dog cow cat
* */
