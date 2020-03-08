package 继承.one;

public class Student extends Person {

    String score;

    public Student(int id, int age, String name, String score) {
        super(id, age, name);
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score='" + score + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
