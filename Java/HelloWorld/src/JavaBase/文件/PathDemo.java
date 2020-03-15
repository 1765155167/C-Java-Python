package JavaBase.文件;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {

    static void pathText() {
        Path path = Paths.get(".", "project", "study");
        System.out.println(path);
        Path path1 = path.toAbsolutePath();//转为绝对路径
        System.out.println(path1);
        Path path2 = path1.normalize();//转为规范路径
        System.out.println(path2);
        File file = path2.toFile();//转为File对象
        System.out.println(file);
        for (Path p :
                Paths.get("..").toAbsolutePath()) {
            System.out.println(" " + p);
        }
    }

    public static void main(String[] args) {
        try {
            readFile(".\\text.md");
            writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void readFile(String Url) throws IOException {
//        try(InputStream in = new FileInputStream(Url)) {
//            String info = readAsString(in);
//            System.out.println(info);
//        }
        byte[] data = { 72, 101, 108, 108, 111, 33 };
        try (InputStream in = new ByteArrayInputStream(data)) {
            System.out.println(readAsString(in));
        }
    }
    static void writeFile() throws IOException {
//        try (OutputStream out = new FileOutputStream(".\\readme.md")) {
//            out.write("Hello".getBytes("UTF-8"));
//        }
        byte[] data;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            out.write("Hello.".getBytes("UTF-8"));
            out.write("World".getBytes("UTF-8"));
            data = out.toByteArray();
        }
        System.out.println(new String(data, "UTF-8"));
    }
    static String readAsString(InputStream in) throws IOException {
        StringBuilder builder = new StringBuilder();
        int n;
        while ((n = in.read()) != -1) {
            builder.append((char)n);
        }
        return builder.toString();
    }
}
