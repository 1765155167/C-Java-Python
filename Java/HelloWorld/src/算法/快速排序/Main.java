package 算法.快速排序;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 7, 9, 12, 3, 4, 3, 0};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //升序
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (end <= start + 1) return;
        int i = start;
        int j = end - 1;
        int temp = arr[i];
        while (i < j) {//首先填充i位置
            ///从右到左查找第一个小于标准值得位置
            while (i < j && arr[j] <= temp) {
                j--;
            }
            //找到了
            if (i < j) {
                arr[i++] = arr[j];
            }
            ///从左到右查找第一个大于标准值得位置
            while (i < j && arr[i] > temp) {
                i++;
            }
            //找到了
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = temp;
        quickSort(arr, start, i);
        quickSort(arr, i + 1, end);
    }
}
