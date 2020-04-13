package 算法.动态规划.最短路径;

import java.util.Scanner;

/**
 * 输入MxN矩阵求从左上角到右下角的最短路径
 */
public class Main {

    private static int[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m,n;
        m = sc.nextInt();
        n = sc.nextInt();
        a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(geiMinDis(0,0,m-1,n-1));
        print(m, n, a);
    }

    private static int geiMinDis(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            return a[x1][y1];
        }
        if (x1 + 1 <= x2 && y1 + 1 <= y2) {
            return a[x1][y1] + Math.min(geiMinDis(x1, y1 + 1, x2, y2),
                    geiMinDis(x1 + 1, y1, x2, y2));
        } else if (x1 + 1 <= x2) {
            return a[x1][y1] + geiMinDis(x1 + 1, y1, x2, y2);
        } else {
            return a[x1][y1] + geiMinDis(x1, y1 + 1, x2, y2);
        }
    }

    private static void print(int m, int n, int[][] a) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
