package 访问者;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File path = new File("./");
        FileStructure fs = new FileStructure(path);
        fs.handle(new ClassFileVisitor());
    }
}
