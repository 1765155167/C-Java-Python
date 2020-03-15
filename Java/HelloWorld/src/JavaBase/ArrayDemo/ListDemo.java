package JavaBase.ArrayDemo;

import java.security.SecureRandom;
import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
//        Collections.shuffle(list);
        shuffle(list);// 洗牌算法suffle可以随机交换List中的元素位置:
        Integer[] integers1 = list.toArray(new Integer[list.size()]);
        Integer[] integers2 = list.toArray(Integer[]::new);
        for (int i = 0; i < integers1.length; i++) {
            System.out.print(integers1[i] + " ");
        }
        System.out.println();

        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(toString(list));
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");

        List<Person> personList = List.of(
                new Person("Hu","QiuFeng", 21),
                new Person("Xiao", "Ming", 18),
                new Person("Bob", "Smith", 20));
        boolean exist = personList.contains(new Person("Xiao", "Ming", 18));
        System.out.println(exist ? "测试成功!" : "测试失败!");
    }

    private static String toString(List<Integer> list) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (Integer num:
             list) {
            joiner.add(num.toString());
        }
        return joiner.toString();
    }

    private static void shuffle(List<Integer> list) {
        SecureRandom random = new SecureRandom();
        for (int i = list.size() - 1; i > 0; i--) {
            swap(list, i, random.nextInt(i + 1));
        }
    }

    private static void swap(List<Integer> list, int i, int nextInt) {
        Integer temp = list.get(i);
        list.set(i, list.get(nextInt));
        list.set(nextInt, temp);
    }

    private static int findMissingNumber(int start, int end, List<Integer> list) {
        for (int i = start; i <= end; i++) {
//            if (!list.contains(Integer.valueOf(i))) {
//                return i;
//            }
            if (list.indexOf(i) == -1) {
                return i;
            }
        }
        return end;
    }
}
