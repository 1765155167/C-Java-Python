package XML;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class DOM {
    public static void main(String[] args) throws Exception {
        InputStream in = DOM.class.getResourceAsStream("/book.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(in);
        printNode(document, 4);
    }

    private static void printNode(Node document, int index) {
        for (int j = 0; j < index; j++) {
            System.out.print(' ');
        }
        switch (document.getNodeType()) {
            case Node.DOCUMENT_NODE:
                System.out.println("Document" + document.getNodeName());
                break;
            case Node.ELEMENT_NODE:
                System.out.println("Element" + document.getNodeName());
                break;
            case Node.TEXT_NODE:
                System.out.println("Text" + document.getNodeName() + "=" + document.getNodeValue());
                break;
            case Node.ATTRIBUTE_NODE:
                System.out.println("Attribute" + document.getNodeName() + "=" + document.getNodeValue());
                break;
            default:
                System.out.println("default" + document.getNodeType() + document.getNodeName());
        }
        for (Node child = document.getFirstChild(); child != null; child = child.getNextSibling() ) {
            printNode(child, index);
        }
    }
}
