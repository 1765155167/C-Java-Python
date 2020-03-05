package XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;

public class SAX {
    public static void main(String[] args) throws Exception {
        InputStream in = SAX.class.getResourceAsStream("/book.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(in, new MyHandle());
    }
}

class MyHandle extends DefaultHandler {

    private Deque<String> stringDeque;

    public MyHandle() {
        stringDeque = new ArrayDeque<>();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("start document------------------------------");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("start element:" + localName + ":" + qName);
        stringDeque.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("end element:" + localName + ":"  + qName);
        stringDeque.pop();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("end document-------------------------------");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("characters:"
                + stringDeque.peek() + " = "
                + new String(ch, start, length));
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        e.printStackTrace();
    }
}
