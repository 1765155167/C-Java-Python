package JavaBase.ArrayDemo;

import java.util.EnumMap;

public class EnumMapDemo {
    public static void main(String[] args) {
        EnumMap<WeekDay, String> enumMap = new EnumMap<>(WeekDay.class);
        enumMap.put(WeekDay.SUN, "星期日");
        enumMap.put(WeekDay.MON, "星期一");
        enumMap.put(WeekDay.TUE, "星期二");
        enumMap.put(WeekDay.WED, "星期三");
        enumMap.put(WeekDay.THU, "星期四");
        enumMap.put(WeekDay.FRI, "星期五");
        enumMap.put(WeekDay.SAT, "星期六");
        System.out.println(enumMap);
        System.out.println(enumMap.get(WeekDay.FRI));
    }
}

enum WeekDay {
    SUN, MON, TUE, WED, THU, FRI, SAT
}
