package model.csv;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Processor {
    private String brand;
    private String type;
    private String cores;
    private String speed;
}
