import xml.model.jaxb.Catalog;
import xml.parsers.jaxb.JAXBParser;

import java.io.File;

public class Application {

    public static void main(String[] args) {
//        DOMParser domParser = new DOMParser();
        JAXBParser jaxbParser = new JAXBParser();
        File file = new File("src/main/resources/data.xml");
        Catalog catalog = jaxbParser.parse(file);
        catalog.displayCD();
    }
}
