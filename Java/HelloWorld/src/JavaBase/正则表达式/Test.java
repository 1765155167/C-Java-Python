package JavaBase.正则表达式;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("cat");
        Matcher m = p.matcher("one cat two cats in the yard");
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            m.appendReplacement(sb, "dog");
        }
        m.appendTail(sb);//加上尾巴
        System.out.println(sb.toString());

        String mode = "Hello, ${name}! You are learning ${lang}!";
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Bod");
        map.put("lang", "Java");
        Pattern pattern = Pattern.compile("\\$\\{(\\w+)\\}");
        Matcher matcher = pattern.matcher(mode);
        StringBuilder sb1 = new StringBuilder();
        while (matcher.find()) {
            String str = mode.substring(matcher.start() + 2, matcher.end() - 1);
            matcher.appendReplacement(sb1, str);
        }
        matcher.appendTail(sb1);
        System.out.println(sb1.toString());
    }
}
