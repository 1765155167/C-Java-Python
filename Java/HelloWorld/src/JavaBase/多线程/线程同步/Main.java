package JavaBase.多线程.线程同步;

public class Main {
    public static void main(String[] args) {
        new Thread(()->{
            int n = 1000;
            while (n-- > 0) {
                synchronized (Count.lock) {
                    Count.count++;
                }
            }
        }).start();
        new Thread(()->{
            int n = 1000;
            while (n-- > 0) {
                synchronized (Count.lock) {
                    Count.count--;
                }
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count:"+Count.count);
    }
}
class Count {
    public static final Object lock = new Object();
    public static int count = 0;
}
