package javacookbook.chapter5.listings.l10;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class SortAndSearchDemo {
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            list.add(i);
        }
        Collections.shuffle(list, new Random(47)); // using Random with defined seed for stable output
        System.out.println("Unsorted list:\n" + list + "\n");
        Collections.sort(list);
        System.out.println("Sorted list:\n" + list + "\n");
        System.out.println("Searching for 'F':");
        int i = Collections.binarySearch(list, 'F');
        if (i >= 0) {
            System.out.println("Object " + list.get(i) + " found at index " + i);
        } else {
            System.out.println("Not found");
        }
    }
}
/*
 * output:
 * Unsorted list:
 * [B, O, X, H, M, Q, U, G, W, S, P, Z, R, V, D, E, J, A, T, I, C, L, K, N, F, Y]
 *
 * Sorted list:
 * [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]
 *
 * Searching for 'F':
 * Object F found at index 5
 * */
