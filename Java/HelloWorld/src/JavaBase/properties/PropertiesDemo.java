package JavaBase.properties;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) {
        String settings = "# test" + "\n" + "course=Java" + "\n" + "last_open_date=2019-08-07T12:35:01";
        ByteArrayInputStream input = null;
        Properties properties = new Properties();
        try {
            input = new ByteArrayInputStream(settings.getBytes("UTF-8"));
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("course"));
        System.out.println(properties.getProperty("last_open_date"));
        System.out.println(properties.getProperty("auto_save", "60"));
    }
}
