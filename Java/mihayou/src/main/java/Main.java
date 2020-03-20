import java.util.*;

public class Main {
    public static void main(String[] args) {
        int A[] = {1,2,4,5,4};
        int B[] = {1,4,4,5};
        System.out.println(maxUncrossedLines(A, B));
    }
    /**
     * 返回两个数组中相同数字不相交的最大连线数
     * @param A int整型一维数组 整数集合A
     * @param B int整型一维数组 整数集合B
     * @return int整型
     */
    public static int maxUncrossedLines (int[] A, int[] B) {
        int num = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if ((i + j) < B.length && A[i] == B[i + j]) {//向左偏
                    if (map.get(i) == null) {
                        //i - i+j 之间都没有连线
                        boolean flag = false;
                        for (int k = i; k < i + j; k++) {
                            if (map.get(i) != null && map.get(i) <= i + j) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag == false) {
                            num++;
                            map.put(i, i+j);
                            throw new NullPointerException();
                        }
                    }
                }
            }
        }
        return num;
    }
}