package 访问者;

import java.io.File;

public class JavaFileVisitor implements Visitor {
    @Override
    public void visitDir(File dir) {
        System.out.println("Visitor" + dir);
    }

    @Override
    public void visitFile(File file) {
        if (file.getName().endsWith(".java")) {
            System.out.println("Find Java file" + file);
        }
    }
}
