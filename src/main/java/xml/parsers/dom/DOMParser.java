package xml.parsers.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xml.model.dom.CD;
import xml.parsers.Parser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DOMParser implements Parser<List<CD>> {

    public List<CD> parse(File file) {
        try {
            Document document = getDocument(file);
            String rootElement = getRootElement(document);
            System.out.println("Root element: " + rootElement);
            NodeList nodeList = document.getElementsByTagName("CD");
            return getElements(nodeList);
        } catch (Exception exception) {
            throw new RuntimeException("Could not parse XML file!");
        }
    }

    private List<CD> getElements(NodeList nodeList) {
        List<CD> cdList = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                CD cd = CD.builder()
                        .title(element.getElementsByTagName("TITLE").item(0).getTextContent())
                        .artist(element.getElementsByTagName("ARTIST").item(0).getTextContent())
                        .country(element.getElementsByTagName("COUNTRY").item(0).getTextContent())
                        .company(element.getElementsByTagName("COMPANY").item(0).getTextContent())
                        .price(new BigDecimal(element.getElementsByTagName("PRICE").item(0).getTextContent()))
                        .year(Integer.parseInt(element.getElementsByTagName("YEAR").item(0).getTextContent()))
                        .build();
                cdList.add(cd);
            }
        }
        return cdList;
    }

    private String getRootElement(Document document) {
        return document.getDocumentElement().getNodeName();
    }

    private Document getDocument(File file) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        return doc;
    }
}
