package 牛客网.万万没想到之聪明的编辑;

import java.util.Scanner;

public class Main {
    /**
     * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
     * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
     * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
     * @param args
     */
//    public static void main(String[] args) {
//        int n = 0;
//        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            String data = new String();
//            data = scanner.next();
//            System.out.println(data);
//            data = data.replaceAll("(.)\\1+","$1$1");
//            System.out.println(data);
//        }
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个单词");
        if (in.hasNext()) {
            String name = in.next();
            System.out.println(name);
        }
        in.nextLine();//处理了掉输入单词剩下的空格
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
