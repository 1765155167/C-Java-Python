package 抽象工厂模式.GoodDocSoft;

import 抽象工厂模式.Servies.HtmlDocument;

import java.io.IOException;
import java.nio.file.Path;

public class GoodHtmlDocument implements HtmlDocument {
    @Override
    public String toHtml() {
        return null;
    }

    @Override
    public void save(Path path) throws IOException {

    }
}
