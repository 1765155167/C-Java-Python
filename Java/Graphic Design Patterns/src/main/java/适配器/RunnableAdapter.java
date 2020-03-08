package 适配器;

import java.util.concurrent.Callable;

public class RunnableAdapter implements Runnable {
    private Callable<Long> callable;

    public RunnableAdapter(Callable<Long> callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
