package 抽象工厂模式.Servies;

import 抽象工厂模式.FastDocSoft.FastFactory;
import 抽象工厂模式.GoodDocSoft.GoodFactory;

public interface AbstractFactory {
    static AbstractFactory createFactory(String name) {
        if (name.equalsIgnoreCase("fast")) {
            return new FastFactory();
        } else if (name.equalsIgnoreCase("good")) {
            return new GoodFactory();
        } else {
            throw new IllegalArgumentException("Invalid factory name");
        }
    }
    //创建HTML文件
    HtmlDocument createHtml(String md);
    //创建Word文档
    WordDocument createWord(String md);
}
