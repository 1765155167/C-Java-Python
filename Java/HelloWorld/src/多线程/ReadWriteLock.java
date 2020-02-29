package 多线程;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

public class ReadWriteLock {
    public static void main(String[] args) {
        Point point = new Point();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                point.move(1, 1);
            });
            threads.add(t);
        }
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(() -> {
                double num = point.distanceFromOrigin();
                System.out.println("num=" + num);
            });
            threads.add(t);
        }
        Collections.shuffle(threads);
        for (var t :
                threads) {
            try {
                Thread.sleep((long) (Math.random()%10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.start();
        }
        for (var t :
                threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("main end");
    }
}

class Point {
    private final StampedLock stampedLock = new StampedLock();

    private double x;
    private double y;

    public void move(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock(); // 获取写锁
        try {
            try {
                Thread.sleep((long) Math.random() % 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp); // 释放写锁
        }
    }

    public double distanceFromOrigin() {
        long stamp = stampedLock.tryOptimisticRead(); // 获得一个乐观读锁
        // 注意下面两行代码不是原子操作
        // 假设x,y = (100,200)
        double currentX = x;
        // 此处已读取到x=100，但x,y可能被写线程修改为(300,400)
        double currentY = y;
        // 此处已读取到y，如果没有写入，读取是正确的(100,200)
        // 如果有写入，读取是错误的(100,400)
        if (!stampedLock.validate(stamp)) { // 检查乐观读锁后是否有其他写锁发生
            stamp = stampedLock.readLock(); // 获取一个悲观读锁
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlockRead(stamp); // 释放悲观读锁
            }
        }
//        return Math.sqrt(currentX * currentX + currentY * currentY);
        return currentX + currentY;
    }
}