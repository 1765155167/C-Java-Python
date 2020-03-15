package JavaBase.demo;

interface Interface {
    void cat();
    void run();
    //定义一个方法，可以不必重写这个方法
    default void abs(int a) {
        System.out.println("Interface Hello");
    }
    default void abs() {
        System.out.println("Interface Hello");
    }
}
