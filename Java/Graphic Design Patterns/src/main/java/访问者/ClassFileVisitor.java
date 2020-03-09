package 访问者;

import java.io.File;

public class ClassFileVisitor implements Visitor {
    @Override
    public void visitDir(File dir) {
        System.out.println("Visitor" + dir.getName());
    }

    @Override
    public void visitFile(File file) {
        if (file.getName().endsWith(".class")) {
            System.out.println("Find Class" + file);
        }
    }
}
