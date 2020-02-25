package Throwable;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("计算a/b请输入a:");
        int a = scanner.nextInt();
        System.out.print("请输入b:");
        int b = scanner.nextInt();
        assert b!=0:"分母必须大于零";
        try {
            System.out.println(div(a,b));
        } catch (IllegalArgumentException|FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            System.out.println("finally");
        }
    }

    public static int div(int a, int b)
            throws IllegalArgumentException, FileNotFoundException {
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        div1();
        return a / b;
    }

    public static void div1() throws FileNotFoundException {
        throw new FileNotFoundException();
    }
}
