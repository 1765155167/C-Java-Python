package 算法.堆排序;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {8, 5, 9, 6, 7, 4, 1, 2, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        //1. 建立大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子节点开始
            adjustHeap(arr, i, arr.length);
        }
        //
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
    }

    //调整堆结构 从i节点开始往后调整
    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k = k + 1;//k为i节点最大的子节点
            }
            if (temp < arr[k]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }//[9, 7, 8, 6, 5, 4, 1, 2, 3]
        arr[i] = temp;
    }

    private static void swap(int[] arr, int i, int k) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
}
