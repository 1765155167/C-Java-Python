package ArraysDemo;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] myArrays = {"Apple", "Banana", "Orange"};
        //不可修改 add remove clear会抛出异常
//        List<String> myList = Arrays.asList(myArrays);
//        List<String> myList = Arrays.asList("Apple", "Banana", "Orange");
//        List<String> myList = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange"));
        //可以add remove clear
        List<String> myList = new ArrayList<>(Arrays.asList(myArrays));
//        List<String> myList = Arrays.stream(myArrays).collect(Collectors.toList());
        myList.add("Hello");
        Collections.reverse(myList);//反转
        String[] s = myList.toArray(new String[0]);//new String[0] 声明元素为String类型
        System.out.println(Arrays.toString(s));

        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (Objects.equals(item, "Hello")) {
                iterator.remove();
            }
        }
    }
}
