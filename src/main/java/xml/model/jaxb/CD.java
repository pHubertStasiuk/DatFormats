package xml.model.jaxb;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;

@Data
@XmlType(propOrder = {"title", "artist", "country", "company", "price", "year"})
@XmlRootElement(name = "CD")
@NoArgsConstructor
public class CD {

    private String title;

    @XmlElement(name = "TITLE")
    public void setTitle(String title) {
        this.title = title;
    }

    private String artist;

    @XmlElement(name = "ARTIST")
    public void setArtist(String artist) {
        this.artist = artist;
    }

    private String country;

    @XmlElement(name = "COUNTRY")
    public void setCountry(String country) {
        this.country = country;
    }

    private String company;

    @XmlElement(name = "COMPANY")
    public void setCompany(String company) {
        this.company = company;
    }

    private BigDecimal price;

    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    @XmlElement(name = "PRICE")
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private int year;

    @XmlElement(name = "YEAR")
    public void setYear(int year) {
        this.year = year;
    }
}
