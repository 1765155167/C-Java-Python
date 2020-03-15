package JavaBase.多线程.WiatAndNotify;

import java.util.*;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        TaskQueue queue = new TaskQueue();
        List<Thread> list = new ArrayList<>();
        //创建五个读取队列的线程
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    String msg = null;
                    try {
                        msg = queue.remove();
                        System.out.println(msg);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            });
            t.start();
            list.add(t);
        }
        //向队列中放入元素
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Random random = new Random();
                queue.add("add task " + random.nextInt(20));
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (var t : list) {
            t.interrupt();
        }
    }
}

//class TaskQueue {
//    Queue<String> queue = new LinkedList<>();
//
//    public synchronized void add(String msg) {
//        queue.add(msg);
//        notifyAll();
//    }
//
//    public synchronized String remove() throws InterruptedException {
//        while (queue.isEmpty()) {
//            wait();
//        }
//        return queue.remove();
//    }
//}

//通过ReentrantLock和Condition实现
class TaskQueue {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void add(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();//notifyAll()
        } finally {
            lock.unlock();
        }
    }

    public String remove() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();//wait()
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
}

