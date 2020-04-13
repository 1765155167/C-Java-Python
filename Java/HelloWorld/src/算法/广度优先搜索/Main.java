package 算法.广度优先搜索;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int m;
    private static int n;
    private static int[][] arr;
    private static int num;

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
        System.out.println(nfs(arr));
    }
    //广度优先搜索
    private static int nfs(int[][] arr) {
        Queue<Parameters> queue = new LinkedList<>();
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        queue.add(new Parameters(0, 0, arr[0][0], 0, 1));
        arr[0][0] = -1;
        while (!queue.isEmpty()) {
            Parameters parameters = queue.remove();
            if (parameters.sum == num) {
                return parameters.index;
            }
            for (int i = 0; i < 4; i++) {
                int gx = parameters.x + dx[i];
                int gy = parameters.y + dy[i];
                if (gx >= 0 && gx < n && gy >= 0 && gy < m &&
                        arr[gx][gy] != -1) {
                    queue.add(new Parameters(gx, gy, arr[gx][gy], parameters.sum,parameters.index + 1));
                    arr[gx][gy] = -1;
                }
            }
        }
        return -1;
    }
}

class Parameters {
    int x;
    int y;
    int value;
    int sum;
    int index;

    public Parameters(int x, int y, int value, int sum, int index) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.sum = sum + value;
        this.index = index;
    }
}
