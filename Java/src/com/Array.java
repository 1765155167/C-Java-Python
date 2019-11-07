package com;

import java.util.Random;
/**
 * 重载：
 * 方法名相同，参数个数/参数类型不同
 * */
public class Array {
    public static int GetMax(int[] num) {
        int max = num[0];
        for (int i = 0; i < num.length; i++) {
            if(max < num[i])
            {
                max = num[i];
            }
        }
        return max;
    }
    public static long GetMax(long[] num) {
        long max = num[0];
        for (int i = 0; i < num.length; i++) {
            if(max < num[i])
            {
                max = num[i];
            }
        }
        return max;
    }
    public static char GetMax(char[] num) {
        char max = num[0];
        for (int i = 0; i < num.length; i++) {
            if(max < num[i])
            {
                max = num[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        //int[] num = new int[]{1,2,3,4,5};//静态初始化
        int[] num = new int[20];
        int[] data = new int[20];
        char[] str = new char[]{'H','e','l','l','o'};
        System.out.println(num);
        System.out.println(data);
        Random rd = new Random(100L);
        for (int i = 0; i < num.length; i++) {
            num[i] = rd.nextInt(100);
        }
        for (int i = 0; i < num.length; i++) {
            System.out.println("num[" + i + "] = " + num[i]);
        }
        data = num;
        for (int i = 0; i < data.length; i++) {
            System.out.println("data[" + i + "] = " + data[i]);
        }
        System.out.println(data);
        System.out.println(GetMax(data));
        System.out.println(GetMax(str));
    }
}
