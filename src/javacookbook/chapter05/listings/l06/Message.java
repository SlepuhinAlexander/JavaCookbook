package javacookbook.chapter05.listings.l06;

public class Message implements Comparable<Message> {
    String message;
    Priority priority;

    public Message(String msg, Priority pri) {
        message = msg;
        priority = pri;
    }

    @Override
    public int compareTo(Message message) {
        return priority.compareTo(message.priority);
    }

    enum Priority {
        High, Medium, Low
    }
}
