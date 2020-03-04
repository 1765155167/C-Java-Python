package 数据表示格式.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import 测试.Factorial;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;

/**
 * Document：代表整个XML文档
 * Element：代表一个XML元素
 * Attribute：代表一个元素的某个属性
 * DOM：一次性读取XML，并在内存中表示为树形结构
 */
public class DOM {
    public static void main(String[] args) throws Exception {
        InputStream in = DOM.class.getResourceAsStream("/book.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(in);
        printNode(document, 4);
    }

    private static void printNode(Node document, int index) {
        for (int i = 0; i < index; i++) {
            System.out.print(' ');
        }
        switch (document.getNodeType()) {
            case Node.DOCUMENT_NODE://DOCUMENT节点
                System.out.println("Document: " + document.getNodeName());
                break;
            case Node.ELEMENT_NODE://元素节点
                System.out.println("ELEMENT: " + document.getNodeName());
                break;
            case Node.TEXT_NODE://文本
                System.out.println("Test: " + document.getNodeName() +
                        "=" + document.getNodeValue());
                break;
            case Node.ATTRIBUTE_NODE://属性
                System.out.println("Attr: " + document.getNodeName() +
                        "=" + document.getNodeValue());
                break;
            default:
                System.out.println("NodeType: " + document.getNodeType() +
                        "NodeName: " + document.getNodeName());
        }
        for (Node child = document.getFirstChild();
             child != null; child = child.getNextSibling()) {
            printNode(child, index);
        }
    }

}
