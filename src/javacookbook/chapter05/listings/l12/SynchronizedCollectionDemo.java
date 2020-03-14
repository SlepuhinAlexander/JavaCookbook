package javacookbook.chapter05.listings.l12;

import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

public class SynchronizedCollectionDemo {
    public static void main(String[] args) {
        TreeSet<String> tree = new TreeSet<>();
        Collection<String> syncCollection = Collections.synchronizedCollection(tree);
//        Collection<String> syncCollection = tree; // in this case ConcurrentModificationException is thrown
        syncCollection.add("Gamma");
        syncCollection.add("Beta");
        syncCollection.add("Alpha");
        new MyThread(syncCollection);
        try {
            synchronized (syncCollection) {
                for (String s : syncCollection) {
                    System.out.println("Main thread: " + s);
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread has been interrupted");
        }
    }

    static class MyThread implements Runnable {
        Thread t;
        Collection<String> col;

        public MyThread(Collection<String> c) {
            col = c;
            t = new Thread(this, "Second thread");
            t.start();
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
                col.add("Omega");
                synchronized (col) {
                    for (String s : col) {
                        System.out.println("Second thread: " + s);
                        Thread.sleep(500);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Second thread has been interrupted");
            }
        }
    }
}
/*
 * output:
 * Main thread: Alpha
 * Main thread: Beta
 * Main thread: Gamma
 * Second thread: Alpha
 * Second thread: Beta
 * Second thread: Gamma
 * Second thread: Omega
 * */
