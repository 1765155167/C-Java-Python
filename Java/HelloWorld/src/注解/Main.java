package 注解;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {
        Person person = new Person("hqf", "henan");
        System.out.println(person.toString());
    }
}
