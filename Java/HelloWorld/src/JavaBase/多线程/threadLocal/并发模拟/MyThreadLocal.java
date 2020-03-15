package JavaBase.多线程.threadLocal.并发模拟;

import java.awt.*;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadLocal<T> {

    static AtomicInteger atomicInteger = new AtomicInteger();

    Integer threadLocalHash = atomicInteger.getAndAdd(0x61c88647);//自定义一个哈希值

    static HashMap<Thread, HashMap<Integer, Object>> threadLocal = new HashMap<>();

    synchronized static HashMap<Integer, Object> getMap() {
        var thread = Thread.currentThread();
        if (!threadLocal.containsKey(thread)) {
            threadLocal.put(thread, new HashMap<>());
        }
        return threadLocal.get(thread);
    }

    protected T initialValue(){
        return null;
    }

    public T get(){
        var map = getMap();
        if (!map.containsKey(this)) {
            map.put(this.threadLocalHash, initialValue());
        }
        return (T) map.get(this.threadLocalHash);
    }

    public void set(T v) {
        var map = getMap();
        map.put(this.threadLocalHash, v);
    }
}
