package javacookbook.chapter5.listings.l11;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class CheckedCollectionDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Collection<String> checkedCollection = Collections.checkedCollection(list, String.class);
//        Collection<String> checkedCollection = list; // in this case there no exception thrown when adding an Integer
        checkedCollection.add("Alpha");
        checkedCollection.add("Beta");
        checkedCollection.add("Gamma");
        System.out.println("List: " + checkedCollection);
        Collection rawCollection;
        rawCollection = checkedCollection;
        rawCollection.add(new Integer(23));
        System.out.println("Raw collection: " + checkedCollection);
    }
}
/*
 * output:
 * List: [Alpha, Beta, Gamma]
 * Exception in thread "main" java.lang.ClassCastException: Attempt to insert class java.lang.Integer element into
 * collection with element type class java.lang.String
 *     at java.base/java.util.Collections$CheckedCollection.typeCheck(Collections.java:3049)
 *     at java.base/java.util.Collections$CheckedCollection.add(Collections.java:3097)
 *     at javacookbook.chapter5.listings.l11.CheckedCollectionDemo.main(CheckedCollectionDemo.java:19)
 * */
