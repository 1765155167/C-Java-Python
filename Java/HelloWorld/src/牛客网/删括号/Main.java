package 牛客网.删括号;

import java.util.Scanner;

/**
 * 题目描述
 * 给你一个合法的括号序列s1，每次你可以删除一个"()"
 * 你可以删除0个或者多个"()"
 * 求能否删成另一个括号序列s2
 * <p>
 * 输入描述:
 * 第一行输入一个字符串s (2 ≤ |s| ≤ 100)
 * 第二行输入一个字符串t (2 ≤ |t| ≤ 100 )
 * 输出描述:
 * 如果可以输出"Possible"
 * 否则输出"Impossible"
 * <p>
 * dp[i][j][k] :代表s[0-i] t[0-j] k=s删除'('数 - s 删除')'数 是否匹配
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s, t;
        s = sc.nextLine();
        t = sc.nextLine();
        boolean dp[][][] = new boolean[s.length() + 1][t.length() + 1][s.length() / 2];
        dp[0][0][0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                for (int k = 0; k < s.length() / 2; k++) {
                    if (dp[i][j][k]) {
                        if (i + 1 < s.length() && j + 1 < t.length() && k == 0 && s.charAt(i + 1) == t.charAt(j + 1)) {
                            dp[i + 1][j + 1][0] = true;
                        }
                        if (i + 1 < s.length() && s.charAt(i + 1) == '(') {
                            dp[i + 1][j][k + 1] = true;
                        } else if (i + 1 < s.length() && k > 0) {
                            dp[i + 1][j][k - 1] = true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                for (int k = 0; k < s.length() / 2; k++) {
                    System.out.print(i + ":" + j + ":" + k + ":" + dp[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
