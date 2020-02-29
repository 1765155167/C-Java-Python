package 多线程.定期执行;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService ses =
                Executors.newScheduledThreadPool(4);
        ses.scheduleAtFixedRate(new Task("fixed-rate 1"),
                2, 3, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(new Task("fixed-rate 2"),
                2, 3, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(new Task("fixed-rate 3"),
                2, 3, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(new Task("fixed-rate 4"),
                2, 3, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(new Task("fixed-rate 5"),
                2, 3, TimeUnit.SECONDS);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        ses.shutdown();
    }
}

class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end task " + name);
    }
}
