package JavaBase.正则表达式;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Split {
    public static void main(String[] args) {
        String[] strings = "a;b,c d;f,g".split("[\\,\\;\\s]");
        System.out.println(Arrays.toString(strings));
        //搜索字符串
        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            System.out.println(sub);
        }
        //替换字符串
        String s1 = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
        String r = s1.replaceAll("\\s+"," ");
        System.out.println(r);
        //反向引用
        String r1 = r.replaceAll("\\s([a-z]+)\\s", " <b>$1</b> ");
        System.out.println(r1);
    }
}
