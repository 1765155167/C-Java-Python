package JavaBase.文件;

import java.io.*;

public class ReaderDemo {
    public static void main(String[] args) {
        try (Reader reader = new InputStreamReader
                (new FileInputStream(".\\text.md"),"UTF-8")
            ; Writer writer = new OutputStreamWriter
                (new FileOutputStream(".\\readme.md"),"UTF-8")) {
            char[] data = new char[1024];
            int n = 0;
            while ((n = reader.read(data)) != -1) {
                writer.write(data, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
