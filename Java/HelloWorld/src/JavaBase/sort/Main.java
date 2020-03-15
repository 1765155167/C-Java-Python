package JavaBase.sort;

import java.security.SecureRandom;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
//        Integer[] data = new Integer[20];
        int[] data = new int[20];
        for (int i = 0; i < data.length; i++) {
            data[i] = secureRandom.nextInt(100);
        }
        System.out.println("排序前：" + Arrays.toString(data));
        Sort.insertSort(data);
//        SortMode.insertSort(data, new Compare<Integer>() {
//            @Override
//            public int compareTo(Integer data1, Integer data2) {
//                if (data1 > data2) {
//                    return 1;
//                } else if (data1 == data2) {
//                    return 0;
//                } else {
//                    return -1;
//                }
//            }
//        });
        System.out.println("排序后：" + Arrays.toString(data));
        boolean flag = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] < data[i + 1]) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "Success" : "Failure");
    }
}
