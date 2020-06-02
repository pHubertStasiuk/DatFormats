package xml.model.dom;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CD {
    private String title;
    private String artist;
    private String country;
    private String company;
    private BigDecimal price;
    private int year;
}
