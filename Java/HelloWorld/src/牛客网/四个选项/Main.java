package 牛客网.四个选项;

import java.util.Scanner;

public class Main {
    static int[] parent;//记录父节点
    static int[] weight;//记录每组的题目数量
    static int count;//解总数

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int na = input.nextInt();
        int nb = input.nextInt();
        int nc = input.nextInt();
        int nd = input.nextInt();
        int m = input.nextInt();

        parent = new int[13];
        weight = new int[13];
        for (int i = 1; i < 13; i++) {
            parent[i] = i;//初始每个节点的父节点指向自己
            weight[i] = 1;//初始每组题目数量为1
        }
        for (int i = 0; i < m; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            unionElement(x, y);
        }
        cal(na, nb, nc, nd, 0);
        System.out.println(count);
    }

    private static void cal(int na, int nb, int nc, int nd, int i) {
        if (i == 12) {//所有题目都能分配到选项即有解
            count++;
            return;
        }
        int q = 1;
        int max = weight[1];
        for (int j = 1; j <= 12; j++) {//每次找到题目数量最大的那组题
            if (max < weight[j]) {
                max = weight[j];
                q = j;
            }
        }
        if (nb >= max) {//只有选项总数大于题组题数，这组题可以使用这个选项
            weight[q] = 0;
            nb -= max;
            cal(na, nb, nc, nd, i + max);
            weight[q] = max;//回朔
            nb += max;
        }
        if (na >= max) {
            weight[q] = 0;
            na -= max;
            cal(na, nb, nc, nd, i + max);
            weight[q] = max;
            na += max;
        }
        if (nc >= max) {
            weight[q] = 0;
            nc -= max;
            cal(na, nb, nc, nd, i + max);
            weight[q] = max;
            nc += max;
        }
        if (nd >= max) {
            weight[q] = 0;
            nd -= max;
            cal(na, nb, nc, nd, i + max);
            weight[q] = max;
            nd += max;
        }
    }

    private static void unionElement(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {//本来就同根，就没必要继续了
            return;
        }

        if (weight[pa] > weight[pb]) {//小树并入大树
            parent[pb] = pa;
            weight[pa] += weight[pb];
            weight[pb] = 0;       //小树并入大树后，这棵树就不存在了
        } else {
            parent[pa] = pb;
            weight[pb] += weight[pa];
            weight[pa] = 0;
        }
    }

    private static int find(int a) {//只有根节点才会自己指向自己，其它的都指向自己的父节点
        while (a != parent[a]) {
            a = parent[a];
        }
        return a;
    }

}