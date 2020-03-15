package JavaBase.多线程.threadLocal;

public class Basic {
    //在每个线程中都有一个该变量
    public static ThreadLocal<Long> x = new ThreadLocal<>(){
        @Override
        protected Long initialValue() {
            System.out.println("Initial Value run...");
            return Thread.currentThread().getId();
        }
    };

    public static void main(String[] args) {
//        x.set(1000l);
        new Thread(()->{
            System.out.println(x.get());
        }).start();
        x.set(127l);
//        x.remove();
        System.out.println(x.get());
    }
}
