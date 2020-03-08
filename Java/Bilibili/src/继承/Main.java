package 继承;

import 继承.one.Hello;
import 继承.one.InterFace;
import 继承.one.Student;

public class Main {
    public static void main(String[] args) {
        InterFace interFace = new Hello();
        interFace.default1();
        interFace.public1();
        Student student = new Student(1, 15, "hqf", "25");
        System.out.println(student.toString());
    }
}
