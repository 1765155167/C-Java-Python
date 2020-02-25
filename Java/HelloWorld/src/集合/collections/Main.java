package 集合.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<String> list = Collections.emptyList();//创建一个空元素
//        List<String> list = Collections.singletonList("AAA");//创建一个单元素集合
//        List<String> list = List.of("AAA");//既可以创建空元素也可创建单多元素
        /**
         * Collections.emptyList()，
         * Collections.singletonList("AAA")，
         * List.of("AAA") 创建的集合都是不可变集合
         * Collections.sort(list);//对可可变集合进行排序
         * Collections.shuffle(list);//洗牌
         * Collections.unmodifiableList();封装成不可变集合
         */
//        List<String> list = new ArrayList<>();
//        list.add("AAA");
//        list.add("BBB");
//        list.add("DDD");
//        list.add("CCC");
//        System.out.println(list);
//        Collections.sort(list);//排序
//        System.out.println(list);
//        Collections.shuffle(list);//洗牌
//        System.out.println(list);
//        List<String> list1 =  Collections.unmodifiableList(list);
//        list.add("AAA");
//        System.out.println(list1);
        List<String> list = getString();
        System.out.println(list);
        List<String> list1 = Collections.synchronizedList(list);
        System.out.println(list1);
        list.add("AAA");
    }

    public static List<String> getString() {
        List<String> stringList = new ArrayList<>();
        stringList.add("AAA");
        stringList.add("BBB");
        return Collections.unmodifiableList(stringList);
    }

}
