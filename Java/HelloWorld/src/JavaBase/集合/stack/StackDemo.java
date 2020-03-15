package JavaBase.集合.stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackDemo {
    public static void main(String[] args) {
        String hex = toHexNew(12500);
        System.out.println(hex);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        Deque<Integer> integers = new LinkedList<>();
        while (n / 16 != 0) {
            int d = n / 16;
            int m = n % 16;
            n = d;
            integers.push(Integer.valueOf(m));
        }
        integers.push(Integer.valueOf(n%16));
        StringBuilder builder = new StringBuilder();
        while (!integers.isEmpty()) {
            int num = integers.poll().intValue();
            if (num < 10) {
                builder.append(num);
            } else {
                char c = (char) ('A' + (num - 10));
                builder.append(c);
            }
        }
        return builder.toString();
    }
    static String toHexNew(int n) {
        MyStack stack = new MyStack();
        while (n / 16 != 0) {
            int d = n / 16;
            int m = n % 16;
            n = d;
            stack.push(m);
        }
        stack.push(n%16);
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (num < 10) {
                builder.append(num);
            } else {
                char c = (char) ('A' + (num - 10));
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
