package 文件;

import java.io.*;
import java.util.Properties;

/**
 * createNewFile()创建文件，成功返回true
 * createTempFile()创建临时文件 deleteOnExit()JVM退出时自动删除文件
 *
 * delete()删除文件 成功返回true
 * getPath()返回构造方法传入的路径
 * getAbsolutePath()返回绝对路径
 * getCanonicalPath()返回绝对路径
 * length()返回文件长度
 * isFile()判断是不是文件
 * isDirectory()判断是不是目录
 * canRead() canWrite() canExecute() 判断可读可写可执行
 * File.separator 文件分隔符 win \ linux /
 * list()和listFiles()列出目录下的文件和子目录名
 * mkdir()创建目录
 * mkdirs()创建层级目录
 * delete()删除空目录
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("/.\\text.md");
        System.out.println(file);
        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.length());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(File.separator);
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.canExecute());
        File file1 = new File(".");
        File[] files = file1.listFiles();
        for (var f:
             files) {
            System.out.println(f);
        }
        Properties props = new Properties();
        try {
            props.setProperty("key1","!!!");
            props.setProperty("key2","@@@");
            props.store(new FileOutputStream("/default.properties"), "注释");
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = new byte[1024];
        try (InputStream in = FileDemo.class.getResourceAsStream("/default.properties")) {
            if (in != null) {
                in.read(data);
                System.out.println(new String(data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
