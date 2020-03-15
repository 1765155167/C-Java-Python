package JavaBase.正则表达式;

import java.io.StringWriter;
import java.time.Instant;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher matcher = pattern.matcher("0370-5972337");
        System.out.println(matcher);
        if (matcher.matches()) {
            String whole = matcher.group(0);
            String area = matcher.group(1);
            String tel = matcher.group(2);
            System.out.println(whole);
            System.out.println(area);
            System.out.println(tel);
        }
        int[] data = timeRegex("12:00:10");
        System.out.println(Arrays.toString(data));
    }

    //利用分组匹配提取时间12:59:12的时分秒
    public static int[] timeRegex(String time) {
        Pattern pattern = Pattern.compile("((0\\d)|(1[0-2])):(([0-5]\\d)):(([0-5]\\d))");
        Matcher matcher = pattern.matcher(time);
        if (matcher.matches()) {//匹配成功
//            for (int i = 0; i < matcher.groupCount(); i++) {
//                System.out.println(i + ":" + matcher.group(i));
//            }
            int[] data = new int[3];
            data[0] = Integer.valueOf(matcher.group(1));
            data[1] = Integer.valueOf(matcher.group(4));
            data[2] = Integer.valueOf(matcher.group(7));
            return data;
        } else {
            System.out.println("匹配失败！");
            return null;
        }
    }
}
