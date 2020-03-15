package JavaBase.日期;

import java.util.TimeZone;

public class TimeZoneDemo {
    public static void main(String[] args) {
        TimeZone tzDefault = TimeZone.getDefault();
        TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00");
        TimeZone tzNy = TimeZone.getTimeZone("America/New_York");
        System.out.println(tzDefault);
        System.out.println(tzGMT9);
        System.out.println(tzNy);
    }
}
