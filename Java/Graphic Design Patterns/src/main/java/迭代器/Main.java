package 迭代器;

public class Main {
    public static void main(String[] args) {
        ReverseArrayCollection<String> array =
                new ReverseArrayCollection<>("Hello", "World", "!");
        for (var data : array) {
            System.out.println(data);
        }
    }
}
