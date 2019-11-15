package Sort;
/*
* 冒泡排序
* */
public class BubbleSort {
    public static  void swap(int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }
    public static void bubbleSort(int [] arr)
    {
        int temp;
        boolean flag = false;
        for(int i = 0; i < arr.length - 1; ++i)
        {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; ++j)
            {
                if(arr[j] < arr[j + 1])
                {
                    swap(arr[j], arr[j + 1]);
                    flag = true;
                }
            }
            if(flag == false)
            {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,5,6,3,2,4,8,12,13,15,6,4,8};
        bubbleSort(arr);
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
