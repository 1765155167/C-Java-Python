package 日期;

import java.time.*;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.now();
//        LocalDate date = LocalDate.now();
//        LocalTime time = LocalTime.now();
        LocalDate date = dateTime.toLocalDate();
        LocalTime time = dateTime.toLocalTime();
        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        //加五天减3小时
        LocalDateTime dateTime1 = dateTime.plusDays(5).minusHours(3);
        System.out.println(dateTime1);
        LocalDateTime target = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        System.out.println(dateTime.isBefore(target));//比较
        System.out.println(dateTime.isAfter(target));

        LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        LocalDateTime end = LocalDateTime.of(2020, 1, 9, 19, 25, 30);
        Duration d = Duration.between(start, end);//时间间隔
        System.out.println(d); // PT1235H10M30S 1235小时10分钟30秒
        //日期间隔
        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
        System.out.println(p); // P1M21D 1个月21天
    }
}
