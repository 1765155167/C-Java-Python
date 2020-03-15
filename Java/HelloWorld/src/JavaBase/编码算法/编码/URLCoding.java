package JavaBase.编码算法.编码;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLCoding {
    public static void main(String[] args) {
        String encoder = URLEncoder.encode("HelloWorld+-*/_ 中文! ", StandardCharsets.UTF_8);
        System.out.println(encoder);
        String decode = URLDecoder.decode(encoder,StandardCharsets.UTF_8);
        System.out.println(decode);//将中文，+，/， ！，空格，
    }
}
