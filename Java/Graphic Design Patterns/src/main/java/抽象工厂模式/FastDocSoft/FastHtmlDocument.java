package 抽象工厂模式.FastDocSoft;

import 抽象工厂模式.Servies.HtmlDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FastHtmlDocument implements HtmlDocument {
    private String md;

    public FastHtmlDocument(String md) {
        this.md = md;
    }

    @Override
    public String toHtml() {
        return md.lines().map(s -> {
            if (s.startsWith("#")) {
                return "<h1>" + s.substring(1) + "</h1>";
            }
            return "<p>" + s + "</p>";
        }).reduce("", (acc, s) -> acc + s + "\n");
    }

    @Override
    public void save(Path path) throws IOException {
        Files.write(path, toHtml().getBytes("UTF-8"));
    }
}
