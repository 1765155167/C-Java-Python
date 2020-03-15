package JavaBase.正则表达式;

import java.util.List;

public class Regex {
    public static void main(String[] args) {
        String regex = "20\\d\\d";
        System.out.println("2020".matches(regex));
        System.out.println("1021".matches(regex));
        System.out.println("a b".matches("a\\sb"));
        String str = "a\tb";
        System.out.println(str.matches("a\\sb"));
        String phoneRegex = "\\d{3,4}\\-\\d{6,8}";
        for (String s : List.of("010-12345678", "020-9999999", "0755-7654321")) {
            if (!s.matches(phoneRegex)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        for (String s : List.of("010 12345678", "A20-9999999", "0755-7654.321")) {
            if (s.matches(phoneRegex)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        System.out.println("测试成功!");
        String regex1 = "learn\\s((j|J)ava|(P|p)hp|(G|g)o)";
        String[] string = {"learn java", "learn Java", "learn php", "learn Php", "learn go", "learn Go"};
        for (String s :
                string) {
            if (!s.matches(regex1)) {
                System.out.println("测试失败" + s);
            }
        }
        System.out.println("测试成功");
    }
}
