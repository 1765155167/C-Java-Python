package 抽象工厂模式.GoodDocSoft;

import 抽象工厂模式.Servies.WordDocument;

import java.io.IOException;
import java.nio.file.Path;

public class GoodWordDocument implements WordDocument {
    @Override
    public void save(Path path) throws IOException {

    }
}
