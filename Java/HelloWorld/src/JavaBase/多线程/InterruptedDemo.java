package JavaBase.多线程;

public class InterruptedDemo {
    public static void main(String[] args) {
        try {
            test02();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test02() throws InterruptedException {
        System.out.println("main start");
        MyThread3 myThread3 = new MyThread3();
        myThread3.start();
        Thread.sleep(2000);
        myThread3.running = false;
        System.out.println("main end");
    }

    public static void test01() throws InterruptedException {
        System.out.println("main start..");
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        Thread.sleep(1000);
        myThread1.interrupt();
        myThread1.join();
        System.out.println("main end...");
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        try {
            myThread2.join();
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        myThread2.interrupt();
        System.out.println("interrupted...");
    }
}
class MyThread2 extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
class MyThread3 extends Thread {
    public volatile boolean running = true;

    @Override
    public void run() {
        int n = 0;
        while (running) {
            System.out.println(++n + "hello");
        }
        System.out.println("thread end");
    }
}
