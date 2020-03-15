package JavaBase.demo;

public class Student extends Person implements Interface {
    private String name;
    private String id;

    public Student(String name, String id) {
        super(name, id);
        this.name = name;
        this.id = id;
    }

    @Override
    public void abs() {
        System.out.println("Student abs");
    }

    @Override
    public void abs(int a) {
        System.out.println("Student abs fun" + a);
    }

    public void abs(int a, int b) {
        super.abs(2);
        System.out.println("Student abs fun" + a + b);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public void cat() {
        System.out.println("Student cat");
    }

    @Override
    public void run() {
        System.out.println("Student run");
    }
}
