package 日期;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeDemo {
    public static void main(String[] args) {
//        ZonedDateTime time = ZonedDateTime.now();
//        ZonedDateTime time1 = ZonedDateTime.now(ZoneId.of("America/New_York"));
//        System.out.println(time);
//        System.out.println(time1);

//        LocalDateTime localDateTime = LocalDateTime.now();
//        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
//        ZonedDateTime zonedDateTime1 = localDateTime.atZone(ZoneId.of("America/New_York"));
//        System.out.println(zonedDateTime);
//        System.out.println(zonedDateTime1);

        ZonedDateTime zTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime nTime = zTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        LocalDateTime lTime = zTime.toLocalDateTime();
        System.out.println(zTime);
        System.out.println(nTime);
        System.out.println(lTime);
    }
}
