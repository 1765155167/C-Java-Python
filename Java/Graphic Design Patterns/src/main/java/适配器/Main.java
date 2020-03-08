package 适配器;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Callable<Long> callable = new Task(20);
        Thread thread = new Thread(new RunnableAdapter(callable));
        thread.start();
    }
}
