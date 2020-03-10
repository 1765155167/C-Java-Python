package bigInteger;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BigInteger num = new BigInteger("123456789000");
        BigInteger sum = num.add(BigInteger.valueOf(1));
        try {
            System.out.println(sum.multiply(sum).longValueExact());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        BigDecimal n = new BigDecimal("1234567890000.123456");
        BigDecimal m = new BigDecimal("12345");
        var data = n.divideAndRemainder(m);
        System.out.println(data[0].stripTrailingZeros());
        System.out.println(data[1]);

        BigDecimal num1 = new BigDecimal("3.1415926");
        BigDecimal num2 = new BigDecimal("3.1415927");
        System.out.println(num1.compareTo(num2));


        //伪随机数需要指定随机种子，默认系统时间戳
//        Random r = new Random(12345);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(r.nextInt(100));
//        }
//        // 51, 80, 41, 28, 55...
        //真随机数
//        SecureRandom sr = null;
//        try {
//            sr = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
//        } catch (NoSuchAlgorithmException e) {
//            sr = new SecureRandom(); // 获取普通的安全随机数生成器
//        }
//        byte[] buffer = new byte[16];
//        sr.nextBytes(buffer); // 用安全随机数填充buffer
//        System.out.println(Arrays.toString(buffer));
    }
}
