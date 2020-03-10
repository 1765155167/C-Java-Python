package 多线程.threadLocal.并发模拟;

import java.util.HashSet;
import java.util.Set;

public class StatController {
    static Set<Var<Integer>> set = new HashSet<>();

    synchronized static void addSet(Var<Integer> v) {
        set.add(v);
    }

    static MyThreadLocal<Var<Integer>> count = new MyThreadLocal<>() {
        @Override
        protected Var<Integer> initialValue() {
            Var<Integer> v = new Var<>();
            v.set(0);
            addSet(v);
            return v;
        }
    };

    synchronized public void _add_() {
        Var<Integer> v = count.get();
        v.set(v.get() + 1);
    }

    public Integer start() {
        return set.stream().map(x -> x.get()).reduce((a,x) -> a+x).get();
    }

    public void add() {
        _add_();
        return;
    }
}
