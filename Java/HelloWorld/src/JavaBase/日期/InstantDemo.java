package JavaBase.日期;

import org.w3c.dom.ls.LSOutput;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantDemo {

    public static void main(String[] args) {
//        Instant now = Instant.now();
        Instant now = Instant.ofEpochSecond(1988568760);
        System.out.println(now.getEpochSecond());
        System.out.println(now.toEpochMilli());
        ZonedDateTime time = now.atZone(ZoneId.systemDefault());
        System.out.println(time);
    }
}
