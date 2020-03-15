import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(minRemove("((mi)((ha)(you)))))"));
    }

    public static String minRemove(String s) {
        int num = 0;
        char[] chars = new char[s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            chars[j++] = s.charAt(i);
            if (s.charAt(i) == '(') {
                num++;
            }
            if (s.charAt(i) == ')') {
                if (num > 0) {
                    num--;
                } else {
                    j--;
                }
            }
        }
        if (num > 0) {
            int num_bck = num;
            int a = 0;
            for (int i = 0; i < j; i++) {
                if (chars[i] == '(') {
                    a++;
                }
                if (chars[i] == ')') {
                    if (a > 0) {
                        a--;
                    } else {
                        if (num > 0 && chars[i] == '(') {
                            for (int k = i; k < j - i; k++) {
                                chars[k] = chars[k + 1];
                            }
                            num--;
                        }
                    }
                }
            }
            j -= num_bck;
        }
        return new String(chars, 0, j);
    }
}
