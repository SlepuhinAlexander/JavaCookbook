package javacookbook.chapter02.listings.l01;

import java.util.Comparator;

public class ReverseStringComparator implements Comparator<String> {
    @Override
    public int compare(String stringA, String stringB) {
        return stringB.compareTo(stringA);
    }
}
