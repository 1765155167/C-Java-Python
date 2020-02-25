package ArrayDemo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        Map<Student, Integer> map = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.score == o2.score) {
                    return o1.name.compareTo(o2.name);
                }
                return Integer.compare(o1.score, o2.score);
            }
        });
//        Map<Student, Integer> map = new HashMap<>();
        map.put(new Student(55,"HQF"), 1);
        map.put(new Student(55,"MLXG"), 2);
        map.put(new Student(87,"MING"), 3);
        map.put(new Student(88,"UZI"), 4);
        for (var data: map.entrySet()) {
            System.out.println(data.getKey().toString()+data.getValue());
        }
        System.out.println(map.get(new Student(55, "MLXG")));
    }
    private static class Student {
        int score;
        String name;

        public Student(int score, String name) {
            this.score = score;
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "score=" + score +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}


