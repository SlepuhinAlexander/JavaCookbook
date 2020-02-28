package javacookbook.chapter5.listings.l9;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class ReverseRotateShuffleDemo {
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        for (char n = 'A'; n <= 'F'; n++) {
            list.add(n);
        }
        System.out.println("List in initial state:\n" + list + "\n");
        Collections.reverse(list);
        System.out.println("Reversed list:\n" + list + "\n");
        Collections.rotate(list, 2);
        System.out.println("List rotated right by 2 positions:\n" + list + "\n");
        Collections.shuffle(list, new Random(47)); // adding Random with defined seed for stable output
        System.out.println("Shuffled list:\n" + list);
    }
}
/*
 * output:
 * List in initial state:
 * [A, B, C, D, E, F]
 *
 * Reversed list:
 * [F, E, D, C, B, A]
 *
 * List rotated right by 2 positions:
 * [B, A, F, E, D, C]
 *
 * Shuffled list:
 * [A, D, E, C, B, F]
 * */