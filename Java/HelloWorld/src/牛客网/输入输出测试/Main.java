package 牛客网.输入输出测试;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name = new String();
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
