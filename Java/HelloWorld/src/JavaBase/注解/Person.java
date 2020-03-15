package JavaBase.注解;

public class Person {
    @Range(min = 1, max = 30)
    String name;
    @Range(max = 10)
    String city;

    public Person(String name, String city) throws ReflectiveOperationException {
        this.name = name;
        this.city = city;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
