package model.csv;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HardDrive {
    private String type;
    private int capacity;
}
