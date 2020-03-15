package JavaBase.集合.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> stringQueue = new LinkedList<>();
        stringQueue.add("AAA");
        stringQueue.add("BBB");
        stringQueue.add("CCC");
        stringQueue.add("DDD");
        System.out.println(stringQueue.peek());//查看队首不删除 失败返回null
        System.out.println(stringQueue.element());//查看队首不删除 失败throwable
        System.out.println(stringQueue.poll());//取元素 失败返回null
        System.out.println(stringQueue.remove());//取元素 失败throwable
    }
}
