package 抽象工厂模式;

import 抽象工厂模式.Servies.AbstractFactory;
import 抽象工厂模式.Servies.HtmlDocument;
import 抽象工厂模式.Servies.WordDocument;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        // 创建AbstractFactory，实际类型是FastFactory:
//        AbstractFactory factory = new FastFactory();
        AbstractFactory factory = AbstractFactory.createFactory("fast");
        // 生成Html文档:
        HtmlDocument html = factory.createHtml("#Hello\nHello, world!");
        html.save(Paths.get(".", "fast.html"));
        // 生成Word文档:
        WordDocument word = factory.createWord("#Hello\nHello, world!");
        word.save(Paths.get(".", "fast.doc"));
    }
}
