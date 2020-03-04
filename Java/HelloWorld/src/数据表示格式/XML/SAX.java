package 数据表示格式.XML;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

/**
 * 它是一种基于流的解析方式，边读取XML边解析，并以事件回调的方式让调用者获取数据。
 * 因为是一边读一边解析，所以无论XML有多大，占用的内存都很小。
 */
public class SAX {
    public static void main(String[] args) throws Exception {
        InputStream in = SAX.class.getResourceAsStream("/book.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(in, new MyHandler());
    }
}
