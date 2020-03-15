package JavaBase.多线程;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        //创建异步执任务
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureDemo::fetchPrice);
        //成功
//        cf.thenAccept(new Consumer<Double>() {
//            @Override
//            public void accept(Double aDouble) {
//                System.out.println("price" + aDouble);
//            }
//        });
        //lambda语法 简化代码
        cf.thenAccept((result) -> {
            System.out.println("price" + result);
        });
        //异常
        cf.exceptionally(new Function<Throwable, Double>() {
            @Override
            public Double apply(Throwable throwable) {
                throwable.printStackTrace();
                return null;
            }
        });
        //主线程执行任务
        System.out.println("JavaBase.String.Main start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("JavaBase.String.Main end");
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("获取价格失败！！");
        }
        return 5 + Math.random() * 20;
    }
}
