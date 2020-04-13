package 算法.栈.括号匹配;

import java.util.ArrayDeque;
import java.util.Deque;

public class Mapping {
    public static void main(String[] args) {
        String s = "((())())())(()())";
        fun(s);
        System.out.println(s);
    }

    private static void fun(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (var c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            if (c == ')') {
                var c1 = stack.pop();
                if (c1 == null);
            }
        }
    }
}
