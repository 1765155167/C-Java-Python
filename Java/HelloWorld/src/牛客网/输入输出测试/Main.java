package 牛客网.输入输出测试;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个单词");
        if (in.hasNext()) {
            String name = in.next();
            System.out.println(name);
        }
        in.nextLine();//处理了掉输入单词剩下的回车与空格
        System.out.println("请输入一行字符串");
        if (in.hasNextLine()) {
            String name = in.nextLine();
            System.out.println(name);
        }
        System.out.println("请输入一个整数");
        if (in.hasNextInt()) {
            int num = in.nextInt();
            System.out.println(num);
        }
        System.out.println("请输入一个小数");
        if (in.hasNextDouble()) {
            double num = in.nextDouble();
            System.out.println(num);
        }
        System.out.println("循环输入两个整数输出整数的和");
        while (in.hasNextInt()) {
            int a = in.nextInt();
            if (in.hasNextInt()) {
                int b = in.nextInt();
                System.out.println(a + b);
            } else {
                break;
            }
        }
        System.out.println("程序结束");
    }
}
