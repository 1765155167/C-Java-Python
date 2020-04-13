package 算法.梅森素数;

import java.math.BigInteger;

/**
 * 求2^11213 - 1 这个素数十进制表示的后100位
 */
public class Main {
    public static void main(String[] args) {
        BigInteger num = BigInteger.valueOf(2);
        num = num.pow(11213).subtract(BigInteger.valueOf(1));
        String value = num.toString();
        String res = value.substring(value.length() - 100);
        System.out.println(res.length() + " " + res);
    }
}
