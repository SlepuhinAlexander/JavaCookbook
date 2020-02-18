package javacookbook.chapter2.listings.l2;

import java.util.Comparator;

public class IgnoreCaseComparator implements Comparator<String> {
    @Override
    public int compare(String stringA, String stringB) {
        return stringA.compareToIgnoreCase(stringB);
    }
}
