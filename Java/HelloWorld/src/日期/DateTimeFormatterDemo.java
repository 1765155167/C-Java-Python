package 日期;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
        System.out.println(formatter.format(LocalDateTime.now()));

        LocalDateTime time = LocalDateTime
                .parse("2020/02/24 17:48:08.275", formatter);
        System.out.println(time);
    }
}
