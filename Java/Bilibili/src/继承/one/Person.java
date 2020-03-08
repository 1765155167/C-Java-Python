package 继承.one;

public class Person {
    protected int id;
    protected int age; //同包和外包子类都可以访问
    String name; //default 同包可以访问，包外子类不可以访问
    //public 同胞，外包所有类都可以访问
    //private 只有类本身可以访问

    public Person(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
