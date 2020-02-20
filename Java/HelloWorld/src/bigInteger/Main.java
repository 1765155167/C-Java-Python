package bigInteger;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //伪随机数需要指定随机种子，默认系统时间戳
//        Random r = new Random(12345);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(r.nextInt(100));
//        }
//        // 51, 80, 41, 28, 55...
        //真随机数
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
        } catch (NoSuchAlgorithmException e) {
            sr = new SecureRandom(); // 获取普通的安全随机数生成器
        }
        byte[] buffer = new byte[16];
        sr.nextBytes(buffer); // 用安全随机数填充buffer
        System.out.println(Arrays.toString(buffer));
    }
}
