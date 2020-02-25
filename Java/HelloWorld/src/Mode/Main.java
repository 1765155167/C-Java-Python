package Mode;

import java.awt.*;
import java.awt.desktop.PreferencesEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    static <K> K[] pickTwo(K k1, K k2, K k3) {
        return asArray(k1, k2);
    }

    static <T> T[] asArray(T... objs) {
        return objs;
    }
    public static void main(String[] args) {
//        String[] arr = asArray("AA", "BB", "CC");
//        System.out.println(Arrays.toString(arr));
//        String[] arr1 = pickTwo("AA", "BB", "CC");
//        System.out.println(Arrays.toString(arr1));
        Pair[] arr = new Pair[2];
        Pair<String>[] ps = (Pair<String>[]) new Pair[2];
        ps[0] = new Pair<>("1", "2");
        ps[1] = new Pair<>("2", "3");
        System.out.println(ps.getClass() == Pair[].class);
    }

    static int add(Pair<? extends Number> pair) {
        Number first = pair.getFirst();
        Number second = pair.getSecond();
        return first.intValue() + second.intValue();
    }
}

class Person implements Comparable<Person> {
    String name;
    int score;

    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return this.name + "," + this.score;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}

class Pair<T> {
    T first;
    T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return getFirst() + ":" + getSecond();
    }
}

class ABC<T> {
    T[] createArray(Class<T> cls) {
        return (T[])Array.newInstance(cls, 5);
    }
}