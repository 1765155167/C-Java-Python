package JavaBase.文件;

import java.io.*;

public class PrintWriteDemo {
    public static void main(String[] args) {
        StringWriter buffer = new StringWriter();
        try (PrintWriter writer = new PrintWriter(buffer)) {
            writer.println("Hello"+"World"+1256);
            writer.println(true);
        }
        System.out.println(buffer.toString());
    }
}
