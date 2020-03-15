package JavaBase.ArrayDemo;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        map.put(new Person("胡", "秋峰", 20), "HQF");
        map.put(new Person("小", "红", 22), "RED");
        map.put(new Person("小", "明", 22), "MING");
        String name = map.get(new Person("小", "明", 22));
        System.out.println(name);

//        for (String key: map.keySet()) {
//            Person person = map.get(key);
//            System.out.println(person.toString());
//        }
//        for (Map.Entry<String, Person> entry : map.entrySet()) {
//            String key = entry.getKey();
//            Person value = entry.getValue();
//            System.out.println(key + ":" + value.toString());
//        }

    }
}
