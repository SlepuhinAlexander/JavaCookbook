package javacookbook.chapter05.listings.l05;

import java.util.TreeSet;

public class ComparableDemo {
    public static void main(String[] args) {
        TreeSet<Product> products = new TreeSet<>();
        products.add(new Product("Shelf", 13546));
        products.add(new Product("Keyboard Tray", 2546));
        products.add(new Product("Desk", 12221));
        products.add(new Product("File Cabinet", 44387));
        System.out.println("Products sorted by name:\n");
        for (Product p : products) {
            System.out.printf("%-14s ID: %05d\n", p.getName(), p.getID());
        }
    }
}
/*
 * output:
 * Products sorted by name:
 *
 * Desk           ID: 12221
 * File Cabinet   ID: 44387
 * Keyboard Tray  ID: 02546
 * Shelf          ID: 13546
 * */
