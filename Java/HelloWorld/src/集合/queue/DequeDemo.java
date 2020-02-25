package 集合.queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> stringDeque = new LinkedList<>();
        stringDeque.addFirst("firstOne");
        stringDeque.addLast("LastOne");
        stringDeque.offerFirst("firstTwo");
        stringDeque.offerLast("LastTwo");
        while (!stringDeque.isEmpty()) {
            System.out.println(stringDeque.pollFirst());
        }
    }
}
