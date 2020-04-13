package 牛客网.万万没想到之聪明的编辑;

import java.util.Scanner;

public class Main {
    /**
     * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
     * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
     * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            char[] chars = new char[string.length()];
            int j = 0;
            for (int i = 0; i < string.length() - 2; i++) {
                chars[j++] = string.charAt(i);
                if (string.charAt(i) == string.charAt(i + 1)) {
                    if (string.charAt(i + 1) == string.charAt(i + 2)) {
                        j--;
                    }
                }
            }
            System.out.println(new String(chars));
        }
    }
}
