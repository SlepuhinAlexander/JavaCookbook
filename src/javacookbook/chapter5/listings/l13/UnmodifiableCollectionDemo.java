package javacookbook.chapter5.listings.l13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class UnmodifiableCollectionDemo {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('X');
        System.out.println("Element added to list: " + list.get(0));
        Collection<Character> immutableCollection = Collections.unmodifiableCollection(list);
        immutableCollection.add('Y'); // now throws UnsupportedOperationException
    }
}
/*
 * output:
 * Element added to list: X
 * Exception in thread "main" java.lang.UnsupportedOperationException
 * 	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1060)
 * 	at javacookbook.chapter5.listings.l13.UnmodifiableCollectionDemo.main(UnmodifiableCollectionDemo.java:13)
 * */
