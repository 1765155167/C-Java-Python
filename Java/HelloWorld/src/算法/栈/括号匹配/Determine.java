package 算法.栈.括号匹配;

import java.util.ArrayDeque;
import java.util.Deque;

public class Determine {
    public static void main(String[] args) {
        String s = "1*2+{2*5*(5+6)}{([)]}";
        System.out.println(fun(s));
    }

    private static boolean fun(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (var date:
             s.toCharArray()) {
            if (date == '(' || date == '{' || date == '[') {
                deque.push(date);
            }
            if (date == ')' || date == '}' || date == ']') {
                if (deque.isEmpty()) return false;
                var c = deque.pop();
                if (date == ')' && c != '(') return false;
                if (date == ']' && c != '[') return false;
                if (date == '}' && c != '{') return false;
            }
        }
        if (deque.isEmpty()) {
            return true;
        }
        return false;
    }
}
