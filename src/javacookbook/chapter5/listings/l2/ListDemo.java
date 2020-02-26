package javacookbook.chapter5.listings.l2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('A');
        list.add('B');
        list.add('D');
        System.out.println("List in order of its indexes: ");
        printList(list);
        System.out.println();

        list.add(2, 'C');
        System.out.println("List after adding 'C' to index 2:");
        printList(list);
        System.out.println();

        list.remove(1);
        System.out.println("List after removing element with index 1:");
        printList(list);
        System.out.println();

        list.set(list.size() - 1, 'X');
        System.out.println("List after setting the last element to 'X':");
        printList(list);
        System.out.println();

        list.add('C');
        System.out.println("List after adding one more 'C':");
        printList(list);
        System.out.println("Index of the first 'C': " + list.indexOf('C'));
        System.out.println("Index of the last 'C': " + list.lastIndexOf('C'));
        System.out.println();

        list.clear();
        list.ensureCapacity(26);
        System.out.println("List after clearing:");
        printList(list);
        System.out.println("List size: " + list.size());
        System.out.println();

        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
        }
        System.out.println("List after adding alphabet:");
        printList(list);
        System.out.println();

        System.out.println("Creating linked list");
        LinkedList<Character> linkedList = new LinkedList<>(list);
        System.out.println("Contents of linked list:");
        printList(linkedList);
    }

    public static <T> void printList(List<T> l) {
        System.out.print("{");
        for (int i = 0; i < l.size() - 1; i++) {
            System.out.print(l.get(i) + ", ");
        }
        if (!l.isEmpty()) {
            System.out.print(l.get(l.size() - 1));
        }
        System.out.println("}");
    }
}
/*
 * output:
 * List in order of its indexes:
 * {A, B, D}
 *
 * List after adding 'C' to index 2:
 * {A, B, C, D}
 *
 * List after removing element with index 1:
 * {A, C, D}
 *
 * List after setting the last element to 'X':
 * {A, C, X}
 *
 * List after adding one more 'C':
 * {A, C, X, C}
 * Index of the first 'C': 1
 * Index of the last 'C': 3
 *
 * List after clearing:
 * {}
 * List size: 0
 *
 * List after adding alphabet:
 * {a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z}
 *
 * Creating linked list
 * Contents of linked list:
 * {a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z}
 * */
