import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

public class StringTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "Hello,World  ";
        str = str + "!";
        str = str.toUpperCase();
        str = str.toLowerCase();
        boolean flag = equalsString(str, "Hello!");
        flag = str.contains("ll");
        String str1 = str.substring(2, 4);
        str = str.replace('l', '.');
        str = str.replaceAll("[\\,\\;\\s]+", "."); // "A,B,C,D"
        String[] ss = str.split("\\.");
        str.trim();//去除空格 返回一个新的字符串
        str.strip();//去除空格，和trim类似，不同的时会将中文的空格也去掉
        System.out.println(str);
        String name = "Mr \n胡";
        byte[] array = name.getBytes("GBK");
        System.out.println(Arrays.toString(array));
    }
    public static boolean equalsString(String a, String b) {
        return (a == b) || (a != null && a.equalsIgnoreCase(b));
    }
}
