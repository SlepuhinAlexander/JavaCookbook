package javacookbook.chapter5.listings.l6;

import java.util.Comparator;

public class ReverseMessageComparator implements Comparator<Message> {
    @Override
    public int compare(Message m1, Message m2) {
        return m2.priority.compareTo(m1.priority);
    }
}
