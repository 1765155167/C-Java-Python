package 算法.排他平方数;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 一个6位数每一位数字都不相同，平方后的数每一位都不包含原先6位数的数字
 */
public class Main {
    private static int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        //生成一个每一位数字都不相同的六位数
        fun(0);
    }

    private static void fun(int index) {
        if (index == 6) {
            check();
        }
        for (int i = 0; i < 10 - index; i++) {
            swap(index, index + i);
            fun(index + 1);
            swap(index, index + i);
        }
    }

    private static void check() {
        int data = 0, d = 1;
        if (num[0] == 0) {
            return ;
        }
        for (int i = 5; i >= 0; i--) {
            data += num[i] * d;
            d *= 10;
        }

        BigInteger flight = BigInteger.valueOf(data).multiply(BigInteger.valueOf(data));
        String string = "" + flight;
        for (int i = 0; i < string.length(); i++) {
            if (isOK(string.charAt(i))) {
                return ;
            }
        }
        System.out.println(data + ":" + flight);
        return ;
    }

    private static boolean isOK(char c) {
        for (int i = 0; i < 6; i++) {
            if (c - '0' == num[i]) {
                return true;
            }
        }
        return false;
    }

    private static void swap(int x, int y) {
        int temp = num[x];
        num[x] = num[y];
        num[y] = temp;
    }
}
