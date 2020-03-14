package javacookbook.chapter05.listings.l06;


import java.util.PriorityQueue;
import java.util.Queue;

public class MessagePriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Message> straight = new PriorityQueue<>(3);
        straight.add(new Message("Meeting in main office at 3pm", Message.Priority.Low));
        straight.add(new Message("Storehouse revision!", Message.Priority.High));
        straight.add(new Message("Report till Tuesday", Message.Priority.Medium));
        PriorityQueue<Message> reverse = new PriorityQueue<>(3, new ReverseMessageComparator());
        reverse.addAll(straight);
        System.out.println("Messages in natural order:");
        printMessageQueue(straight);
        System.out.println();
        System.out.println("Messages in reverse priority order:");
        printMessageQueue(reverse);
    }

    public static void printMessageQueue(Queue<Message> queue) {
        Message m;
        while ((m = queue.poll()) != null) {
            System.out.println(m.message + " | priority: " + m.priority);
        }
    }
}
/*
 * output:
 * Messages in natural order:
 * Meeting in main office at 3pm | priority: Low
 * Report till Tuesday | priority: Medium
 * Storehouse revision! | priority: High
 *
 * Messages in reverse priority order:
 * Storehouse revision! | priority: High
 * Report till Tuesday | priority: Medium
 * Meeting in main office at 3pm | priority: Low
 * */
