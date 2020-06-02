package xml.model.jaxb;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@XmlRootElement(name = "catalog")
@NoArgsConstructor
public class Catalog {

    private List<CD> cdList = new ArrayList<>();

    @XmlElement(name = "CD")
    public void setCdList(List<CD> cdList) {
        this.cdList = cdList;
    }

    public Optional<CD> getByTitle(String cdTitle) {
        return cdList.stream()
                .filter(cd -> cd.getTitle().equalsIgnoreCase(cdTitle))
                .findFirst();
    }

    public void displayCD() {
        for (CD cd : cdList) {
            System.out.println(cd);
        }
    }
}
