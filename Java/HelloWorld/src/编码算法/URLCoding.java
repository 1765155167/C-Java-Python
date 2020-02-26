package 编码算法;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLCoding {
    public static void main(String[] args) {
        String encoder = URLEncoder
                .encode("中文! ", StandardCharsets.UTF_8);
        System.out.println(encoder);
        String decode = URLDecoder
                .decode(encoder,StandardCharsets.UTF_8);
        System.out.println(decode);
    }
}
