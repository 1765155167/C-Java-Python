package MethodDemo;

public class Main {
    public static void main(String[] args) {
        Class i = Integer.class;
        Class n = i.getSuperclass();
        Class o = n.getSuperclass();
        System.out.println(i);
        System.out.println(n);
        System.out.println(o);
        System.out.println(o.getSuperclass());
        Class[] cls = i.getInterfaces();
        for (var data : cls) {
            System.out.println(data);
        }
        System.out.println(Number.class.isAssignableFrom(Integer.class));
    }
}
