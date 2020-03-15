package JavaBase.多线程.死锁;

public class Main {
    public static final Object lockA = new Object();
    public static final Object lockB = new Object();
    public static int numA = 0;
    public static int numB = 0;
    public static void main(String[] args) {
        new Thread(()->{
            int n = 1000;
            while (n-- > 0) {
                synchronized (lockA) {
                    numA += 1;
                    System.out.println("A++");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockB) {
                        numB += 1;
                        System.out.println("B++");
                    }
                } //4B6VYTJLXYZU
            }
        }).start();
        new Thread(()->{
            int n = 1000;
            while (n-- > 0) {
                synchronized (lockB) {
                    numB -= 1;
                    System.out.println("B--");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockA) {
                        numA -= 1;
                        System.out.println("A--");
                    }
                } //4B6VYTJLXYZU
            }
        }).start();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(numA + ":" + numB);
    }
}
