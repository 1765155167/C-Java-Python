package 牛客网.输入输出测试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryTree {
    public static void main(String[] args) {
        //1 2 3 null 4 null 5
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] sd = line.split(" ");
        for (String data : sd) {
            if (data.equals("null")) {
                list.add(null);
            }else {
                list.add(Integer.parseInt(data));
            }
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
