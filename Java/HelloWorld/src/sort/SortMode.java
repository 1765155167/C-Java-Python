package sort;

import java.util.Collection;
import java.util.Collections;

public class SortMode {
    public static <T>
    void bubbleSort(T[] data, Compare<T> compare) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (compare.compareTo(data[j + 1], data[j]) > 0) {
                    T temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

    public static <T>
    void insertSort(T[] data, Compare<T> compare) {
        for (int i = 1; i < data.length; i++) {
            T index = data[i];//待插入元素
            int j = i;
            for (; j > 0; j--) {
                if (compare.compareTo(data[j - 1], index) == 1) {
                    data[j] = index;
                }
                data[j] = data[j - 1];
            }
            if (j == 0) {
                data[j] = index;
            }
        }
    }
}
