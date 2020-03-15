package JavaBase.sort;

public class Sort {

    public static void bubbleSort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] < data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void selectSort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        for (int i = 0; i < data.length; i++) {
            int maxIndex = i;
            for (int j = i; j < data.length; j++) {
                if (data[maxIndex] < data[j]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = data[i];
                data[i] = data[maxIndex];
                data[maxIndex] = temp;
            }
        }
    }

    public static void insertSort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        for (int i = 1; i < data.length; i++) {
            int index = data[i];//index待插入元素
            int j = i;//j插入位置
            for (; j >= 1; j--) {
                if (data[j - 1] > index) {
                    data[j] = index;
                    break;
                }
                data[j] = data[j - 1];//后移动
            }
            if (j == 0) {
                data[j] = index;
            }
        }
    }

    private static void mergeSort(int[] data, int begin, int end) {
        if (begin == end - 1) {
            return;
        }
        int mid = (begin + end) / 2;
        mergeSort(data, begin, mid);
        mergeSort(data, mid, end);
        int num = 0;
        int[] temp = new int[end - begin];
        int i = begin, j = mid;
        for (; i < mid && j < end; ) {
            if (data[i] < data[j]) {
                temp[num++] = data[j++];
            } else {
                temp[num++] = data[i++];
            }
        }
        if (i == mid) {
            while (j < end) {
                temp[num++] = data[j++];
            }
        } else {
            while (i < mid) {
                temp[num++] = data[i++];
            }
        }
        for (int k = 0; k < temp.length; k++) {
            data[k + begin] = temp[k];
        }
    }

    public static void mergeSort(int[] data) {
        if (data == null || data.length <= 1) {
            return;
        }
        mergeSort(data, 0, data.length);
    }

}
