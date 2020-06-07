package parsers.csv.apache;

import model.csv.HardDrive;
import model.csv.Laptop;
import model.csv.Processor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import parsers.Parser;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ApacheParser implements Parser<List<Laptop>> {

    @Override
    public List<Laptop> parse(File file) {
        List<Laptop> laptops = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(file.toPath());
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                     .withFirstRecordAsHeader()
                     .withIgnoreHeaderCase()
                     .withTrim())) {
            for (CSVRecord csvRecord : csvParser) {
                Laptop laptop = Laptop.builder()
                        .id(Long.parseLong(csvRecord.get("Id")))
                        .title(csvRecord.get("Title"))
                        .price(new BigDecimal(csvRecord.get("Price")))
                        .processor(extractProcessor(csvRecord))
                        .hardDrive(extractHardDrive(csvRecord))
                        .memory(Integer.parseInt(csvRecord.get("RAM in GB")))
                        .build();
                laptops.add(laptop);
            }

        } catch (IOException ex) {
            throw new RuntimeException("Could not parse csv!", ex);
        }

        return laptops;
    }

    private Processor extractProcessor(CSVRecord csvRecord) {
        return Processor.builder()
                .type(csvRecord.get("CPU_Type"))
                .brand(csvRecord.get("CPU_Brand"))
                .speed(csvRecord.get("CPU_Speed"))
                .cores(csvRecord.get("CPU_Cores"))
                .build();
    }

    private HardDrive extractHardDrive(CSVRecord csvRecord) {
        return HardDrive.builder()
                .type(csvRecord.get("Hard Drive / Type"))
                .capacity(Integer.parseInt(csvRecord.get("Hard Drive / Capacity (GB)")))
                .build();

    }
}
