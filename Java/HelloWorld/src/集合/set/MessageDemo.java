package 集合.set;

import java.util.*;

public class MessageDemo {
    public static void main(String[] args) {
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    private static List<Message> process(List<Message> received) {
        Set<Message> set = new TreeSet<>();
        for (var msg : received) {
            set.add(msg);
        }
        List<Message> list = new ArrayList<>(set);
        return list;
    }
}

class Message implements Comparable<Message> {
    public final int sequence;
    public final String text;

    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, sequence);
    }

    @Override
    public boolean equals(Object obj) {
        Message msg = (Message) obj;
        return this.sequence == msg.sequence && Objects.equals(this.text, msg.text);
    }

    @Override
    public int compareTo(Message o) {
        if (o.sequence > this.sequence) {
            return -1;
        } else if (o.sequence == this.sequence) {
            return 0;
        } else {
            return 1;
        }
    }
}
