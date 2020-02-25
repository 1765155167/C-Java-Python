package 文件;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        String source = null;
        String copy = null;
        if (args.length < 2) {
            System.out.println(args + ":" + args.length);
            System.exit(-1);
        }
        source = args[0];
        copy = args[1];
        byte[] data = new byte[10];
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(".\\" + source);
            out = new FileOutputStream(".\\" + copy);
            int n = 0;
            while ((n = in.read(data)) != -1) {
                out.write(data, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
