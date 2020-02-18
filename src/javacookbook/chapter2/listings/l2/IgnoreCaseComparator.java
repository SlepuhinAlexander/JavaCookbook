package javacookbook.chapter2.listings.l2;

import java.text.Collator;
import java.util.Comparator;

public class IgnoreCaseComparator implements Comparator<String> {
    private Collator collator;

    public IgnoreCaseComparator() {
        collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);
    }

    @Override
    public int compare(String stringA, String stringB) {
        return collator.compare(stringA, stringB);
    }
}
