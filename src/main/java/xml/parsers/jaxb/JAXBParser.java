package xml.parsers.jaxb;

import xml.model.jaxb.Catalog;
import xml.parsers.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBParser implements Parser<Catalog> {

    public Catalog parse(File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Catalog catalog = (Catalog) jaxbUnmarshaller.unmarshal(file);
            return catalog;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
