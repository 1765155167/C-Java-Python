package JavaBase.多线程.线程池;

import java.util.concurrent.*;

public class Example {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors
                .newFixedThreadPool(5);
        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                return "null";
            }
        });
        System.out.println("1111");
        String string  = future.get();
        System.out.println(string);
        System.out.println("222");
        service.shutdownNow();
    }
}
