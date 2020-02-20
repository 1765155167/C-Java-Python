package demo;

public class Person {
    private String name;
    private String id;
    private static int count = 0;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
        count++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void abs(int a) {
        System.out.println("Person abs fun" + a);
    }

    public static int getCount() {
        return count;
    }
}
