package javacookbook.chapter5.listings.l8;

import java.util.ArrayDeque;

public class StackQueueDemo {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        System.out.println("Stack demo:");
        System.out.println("Pushing \"A\"");
        stack.push("A");
        System.out.println("Pushing \"B\"");
        stack.push("B");
        System.out.println("Pushing \"C\"");
        stack.push("C");
        System.out.println("Pushing \"D\"");
        stack.push("D");
        System.out.println("Stack: " + stack);
        System.out.print("Popping out of stack: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("\n");

        ArrayDeque<String> queue = new ArrayDeque<>();
        System.out.println("Queue demo:");
        System.out.println("Adding \"A\"");
        queue.add("A");
        System.out.println("Adding \"B\"");
        queue.add("B");
        System.out.println("Adding \"C\"");
        queue.add("C");
        System.out.println("Adding \"D\"");
        queue.add("D");
        System.out.println("Queue: " + queue);
        System.out.print("Removing out of stack: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println("\n");
    }
}
/*
 * output:
 * Stack demo:
 * Pushing "A"
 * Pushing "B"
 * Pushing "C"
 * Pushing "D"
 * Stack: [D, C, B, A]
 * Popping out of stack: D C B A
 *
 * Queue demo:
 * Adding "A"
 * Adding "B"
 * Adding "C"
 * Adding "D"
 * Queue: [A, B, C, D]
 * Removing out of stack: A B C D
 * */
