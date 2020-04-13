package 算法.全排列;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int ans = 0;
    private static int N = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        fun(arr, 0);
        System.out.println(ans);
    }

    //确认第k位的元素值
    private static void fun(int[] arr, int k) {
        if (k == arr.length) {//全部确认完毕
            check(arr);
            return;
        }
        //确认第k位元素
        for (int i = k; i < arr.length; i++) {
            //交换
            swap(arr, k, i);
            fun(arr, k + 1);//递归确认k+1位
            //回溯
            swap(arr, k, i);
        }
    }

    private static void check(int[] arr) {
        for (int i = 1; i < arr.length - 2; i++) {
            int num = getInt(arr, 0, i);
            if (num >= N) {
                continue;
            }
            for (int j = 1; j < arr.length - i - 1; j++) {
                int num1 = getInt(arr, i, j);
                int num2 = getInt(arr, i + j, arr.length - i - j);
                if (num1 % num2 == 0 && num + num1 / num2 == N) {
                    ans++;
//                    System.out.println(num + " " + num1 + " " + num2);
                }
            }
        }
    }

    //arr[pos,pos+len]
    private static int getInt(int[] arr, int pos, int len) {
        int t = 1;
        int ans = 0;
        for (int i = pos + len - 1; i >= pos; i--) {
            ans += arr[i] * t;
            t *= 10;
        }
        return ans;
    }

    private static void swap(int[] arr, int k, int i) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
}
