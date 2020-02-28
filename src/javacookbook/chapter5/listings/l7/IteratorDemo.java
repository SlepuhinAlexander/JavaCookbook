package javacookbook.chapter5.listings.l7;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {
        LinkedList<PhoneEntry> phoneList = new LinkedList<>();
        phoneList.add(new PhoneEntry("Eric", "555-3456"));
        phoneList.add(new PhoneEntry("Cliff", "555-3976"));
        phoneList.add(new PhoneEntry("Ken", "555-1010"));
        Iterator<PhoneEntry> iterator = phoneList.iterator();
        PhoneEntry entry;
        System.out.println("Iteration through list in straight order:");
        while (iterator.hasNext()) {
            entry = iterator.next();
            System.out.printf("%-10s : %10s\n", entry.name, entry.number);
        }
        ListIterator<PhoneEntry> listIterator = phoneList.listIterator(phoneList.size());
        System.out.println();
        System.out.println("Iteration through list in reverse order:");
        while (listIterator.hasPrevious()) {
            entry = listIterator.previous();
            System.out.printf("%-10s : %10s\n", entry.name, entry.number);
        }
    }
}
/*
 * output:
 * Iteration through list in straight order:
 * Eric       :   555-3456
 * Cliff      :   555-3976
 * Ken        :   555-1010
 *
 * Iteration through list in reverse order:
 * Ken        :   555-1010
 * Cliff      :   555-3976
 * Eric       :   555-3456
 * Process finished with exit code 0
 * */
