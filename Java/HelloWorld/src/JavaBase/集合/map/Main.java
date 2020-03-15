package JavaBase.集合.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Java放入的集合为元素本身，更改元素本身属性，集合元素属性也会发生变化
 */
public class Main {
    public static void main(String[] args) {
        Map<String, Person> personMap = new HashMap<>();
        Person person = new Person("胡秋峰", 15);
        personMap.put(person.getName(), person);
        person.setId(16);
        for (Map.Entry<String, Person> stringPersonEntry : personMap.entrySet()) {
            System.out.println(stringPersonEntry.getKey());
            System.out.println(stringPersonEntry.getValue());
        }
    }
}
