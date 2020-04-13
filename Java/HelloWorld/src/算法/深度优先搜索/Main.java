package 算法.深度优先搜索;

import java.util.Scanner;

import static java.lang.Math.min;

public class Main {
    private static int num = 0;
    private static int[][] arr;
    private static int n;
    private static int m;
    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        m = sc.nextInt();
        n = sc.nextInt();

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                sum += arr[i][j];
            }
        }
        num = sum / 2;
        int temp = arr[0][0];
        arr[0][0] = -1;
        dfs(0, 0, temp, 1);
        System.out.println(ans);
    }
    //深度优先搜索
    private static void dfs(int x, int y, int sum, int index) {
        if (sum > num) {
            return;
        }
        if (sum == num) {
            ans = min(ans, index);
            return;
        }

        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int gx = x + dx[i];
            int gy = y + dy[i];
            if (gx >= 0 && gx < n && gy >= 0 && gy < m && arr[gx][gy] != -1) {
                int temp = arr[gx][gy];
                arr[gx][gy] = -1;
                dfs(gx, gy, sum + temp, index + 1);
                arr[gx][gy] = temp;//不走则恢复
            }
        }
    }
}
