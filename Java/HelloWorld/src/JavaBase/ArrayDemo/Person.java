package JavaBase.ArrayDemo;

import java.util.Objects;

public class Person {
    String firstName;
    String lastName;
    int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return Objects.equals(this.firstName, p.firstName)
                    && Objects.equals(this.lastName, p.lastName)
                    && this.age == p.age;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.firstName, this.lastName, this.age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
