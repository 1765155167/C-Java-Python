package JavaBase.多线程.threadLocal.并发模拟;

public class Var<T> {
    T v;

    public T get() {
        return v;
    }

    public void set(T v) {
        this.v = v;
    }
}
