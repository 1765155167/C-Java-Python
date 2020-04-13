package 算法.错误票据;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            for (int j = 0; j < split.length; j++) {
                list.add(Integer.parseInt(split[j]));
            }
        }
        Collections.sort(list);
        int a = 0, b = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) == 2) {
                a = list.get(i) - 1;//丢失的数据
            }
            if (list.get(i).equals(list.get(i - 1))) {
                b = list.get(i);//重复的数据
            }
        }
        System.out.println(a + " " + b);
    }
}
