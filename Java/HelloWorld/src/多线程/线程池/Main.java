package 多线程.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池:
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));//放入任务
        }
        //放入6个任务单线程池为固定大小为4的线程池，
        //则一次只能运行4个任务，等待完成后在运行后两个
        // 关闭线程池:
        es.shutdown();
//        es.awaitTermination(1, TimeUnit.SECONDS);
    }
}
class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end task " + name);
    }
}