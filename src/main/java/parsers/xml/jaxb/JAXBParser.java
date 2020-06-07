package parsers.xml.jaxb;


import parsers.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.catalog.Catalog;
import java.io.File;

public class JAXBParser implements Parser<Catalog> {

    public Catalog parse(File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (Catalog) jaxbUnmarshaller.unmarshal(file);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
