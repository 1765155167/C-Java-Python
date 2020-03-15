package JavaBase.多线程.threadLocal.并发模拟;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        StatController stat = new StatController();
        for (int i = 0; i < 100 ; i++) {
            service.submit(()->{
                for (int j = 0; j < 100; j++) {
                    stat.add();
                }
            });
        }
        service.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(stat.start());
    }
}
