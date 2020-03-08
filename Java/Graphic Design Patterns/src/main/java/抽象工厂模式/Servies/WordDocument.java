package 抽象工厂模式.Servies;

import java.io.IOException;
import java.nio.file.Path;

public interface WordDocument {
    void save(Path path) throws IOException;
}
