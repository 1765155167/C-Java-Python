package JavaBase.demo;

public class MainActivity {

    public static void insert(int position, int num, int[][] data1) {
        int[] data = data1[0];
        int[] newData = new int[data.length + 1];
        for (int i = 0; i < newData.length; i++) {
            if (i < position) {
                newData[i] = data[i];
            } else if (i == position) {
                newData[i] = num;
            } else {
                newData[i] = data[i - 1];
            }
        }
        data1[0] = newData;
    }

    public static void main(String[] args) {
        String s = "A,B,,C,D,,E,F";
        String a =  s.replaceAll("[\\,\\;\\s]+", ",");
        System.out.println(a);
    }
}
