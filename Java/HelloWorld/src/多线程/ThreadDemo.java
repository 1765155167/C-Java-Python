package 多线程;

public class ThreadDemo {
    public static void main(String[] args) {
        test02();
    }

    //使用lambda
    public static void test02() {
        System.out.println("main start.");
        Thread t = new Thread(() -> {
            System.out.println("start new thread!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end new thread!");
        });
        t.setPriority(10);
        t.start(); // 启动新线程
        try {
            t.join();//等待子线程线程完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end.");
    }

    public static void test01() throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        while (true) {
            System.out.println("Hello World");
            Thread.sleep(100);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("线程运行start。。。");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("end..");
            System.exit(1);
        }
    }
}
