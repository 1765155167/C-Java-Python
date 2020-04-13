package 算法.树两点间最大距离;

import java.util.*;

/**
 * 1 2 2 点1到点2的距离位2
 * 1 3 1
 * 2 4 5
 * 2 5 4
 * 最大距离位点4到点5位9 res = 11 + 12 + ... + 19
 */
public class Main {

    private static int n;
    private static Map<Integer, List<Node>> map;//采用邻接表方式存储图
    private static int max = -1;
    private static Map<Integer, Integer> res;

    //有距离算出价值
    static int getMany(int dis) {
        return 11 * dis + dis * (dis - 1) / 2;//等差熟练首相a1 = 11 d = 1 n = dis
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new HashMap<>();
        res = new HashMap<>();
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n - 1; i++) {
            String[] input = sc.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            insertMap(a, b, c);
            insertMap(b, a, c);
        }
        for (int i = 1; i < n; i++) {
            dis(i, i, 0);//以i位根节点求到叶子节点的最大距离
            res.put(i, max);
            max = -1;
        }
        //打印res
        int maxDis = -1;
        for (var data : res.entrySet()) {
            maxDis = Math.max(maxDis, data.getValue());
        }
        System.out.println(getMany(maxDis));
    }

    /**
     * 深度优先搜索求两点之间的距离
     *
     * @param from 上一个点
     * @param num  当前点
     * @param dis  已经走过的距离
     */
    private static void dis(int from, int num, int dis) {
        boolean isLeaf = true;
        List<Node> list = map.get(num);
        for (Node n :
                list) {
            if (n.num == from) continue;//不能回去
            dis(num, n.num, dis + n.dis);
            isLeaf = false;//可以走则不是叶子节点
        }
        if (isLeaf) {//是叶子节点
            max = Math.max(max, dis);
        }
    }

    private static void printMap() {
        for (var data : map.entrySet()) {
            List<Node> nodes = data.getValue();
            System.out.print(data.getKey());
            for (var node : nodes) {
                System.out.print("(" + node.num + ", " + node.dis + "), ");
            }
            System.out.println();
        }
    }

    private static void insertMap(int a, int b, int c) {
        if (map.containsKey(a)) {
            var data = map.get(a);
            data.add(new Node(b, c));
        } else {
            List<Node> list = new ArrayList<>();
            list.add(new Node(b, c));
            map.put(a, list);
        }
    }
}

class Node {
    int num;//节点
    int dis;//距离

    public Node(int num, int dis) {
        this.num = num;
        this.dis = dis;
    }
}