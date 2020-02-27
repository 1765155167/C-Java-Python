import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Sort {
    //将data数组中的[start, end) 左闭右开区间  进行降序排序
    public static void sort(int[] data, int start, int end) {

        if (end == start + 1) {//只有一个元素 因该是end = start + 1，有序直接返回
            return;//递归推出条件
        }
        int mid = start + (end - start) / 2;//计算出中间位置 这里这里注意一下中间位置要加上start
        sort(data, start, mid);//将数组分成两部分进行排序
        sort(data, mid, end);
        //将分成的两部分有序数组进行整合
        int i = start;
        int j = mid;
        int k = 0;
        int[] temp = new int[end - start];
        for (; i < mid && j < end; ) {
            if (data[i] > data[j]) {
                temp[k++] = data[i++];//降序排序
            } else {
                temp[k++] = data[j++];
            }
        }
        if (i < mid) {//说明后半部分赋值完毕
            while (i < mid) {
                temp[k++] = data[i++];
            }
        } else {
            while (j < end) {
                temp[k++] = data[j++];
            }
        }
        //此时将两部分有序数组合并到temp中
        for (int l = 0; l < end - start; l++) {
            data[l+start] = temp[l];
        }
        //函数功能完成
    }
    //希尔排序 下面创建一个测试文件
    public static void sort(int[] data) {
        sort(data, 0, data.length);
    }
    //测试方法一，使用main方法进行测试
    //排序成功
    public static void main(String[] args) {
        int[] data = new int[]{2,5,6,7,5,1,45,6,748,1,256,6};
        System.out.println("排序前");
        System.out.println(Arrays.toString(data));
        sort(data);
        System.out.println("排序后");
        System.out.println(Arrays.toString(data));
    }
    /**
     * 下面介绍另一种测试方法使用JUnil
     * 1. 在项目根目录下新建一个test文件夹
     * 2. 设置test文件加为测试文件夹
     */


}
