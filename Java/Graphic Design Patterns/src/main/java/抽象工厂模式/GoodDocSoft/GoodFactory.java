package 抽象工厂模式.GoodDocSoft;


import 抽象工厂模式.Servies.AbstractFactory;
import 抽象工厂模式.Servies.HtmlDocument;
import 抽象工厂模式.Servies.WordDocument;

public class GoodFactory implements AbstractFactory {
    @Override
    public HtmlDocument createHtml(String md) {
        return null;
    }

    @Override
    public WordDocument createWord(String md) {
        return null;
    }
}
