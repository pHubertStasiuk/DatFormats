package model.csv;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Laptop {
    private Long id;
    private String title;
    private BigDecimal price;
    private Processor processor;
    private String gpu;
    private int memory;
    private HardDrive hardDrive;
}
