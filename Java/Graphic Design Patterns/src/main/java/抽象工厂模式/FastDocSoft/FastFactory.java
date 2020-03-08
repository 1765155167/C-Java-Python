package 抽象工厂模式.FastDocSoft;

import 抽象工厂模式.Servies.AbstractFactory;
import 抽象工厂模式.Servies.HtmlDocument;
import 抽象工厂模式.Servies.WordDocument;

public class FastFactory implements AbstractFactory {
    @Override
    public HtmlDocument createHtml(String md) {
        return new FastHtmlDocument(md);
    }

    @Override
    public WordDocument createWord(String md) {
        return new FastWordDocument(md);
    }
}
