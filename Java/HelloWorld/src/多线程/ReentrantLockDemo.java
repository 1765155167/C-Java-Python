package 多线程;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public static void main(String[] args) {
        TaskQueue taskQueue = new TaskQueue();
        new Thread(()->{
            int n = 1000;
            while (n-- > 0) {
                try {
                    taskQueue.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            int n = 1000;
            while (n-- > 0) {
                try {
                    taskQueue.div();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(taskQueue.count);
    }
}
class TaskQueue {
    private final Lock lock = new ReentrantLock();
    public int count = 0;

    public void add() throws InterruptedException {
        while (true) {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try{
                    count++;
                    return;
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public void div() throws InterruptedException {
        while (true) {
            if (lock.tryLock(1,TimeUnit.SECONDS)) {
                try {
                    count--;
                    return;
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}