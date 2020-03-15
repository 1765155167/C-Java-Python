package JavaBase.集合.set;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> stringSet = new TreeSet<>();
        stringSet.add("123");
        stringSet.add("789");
        stringSet.add("456");
        stringSet.add("556");
        stringSet.add("566");
        stringSet.add("189");
        stringSet.remove("123");
        System.out.println(stringSet.contains("789"));
        System.out.println(stringSet.size());
        System.out.println(stringSet.containsAll(Arrays.asList(new String[]{"123", "456", "785"})));
        System.out.println(stringSet);
    }
}
