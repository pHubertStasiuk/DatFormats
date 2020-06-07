import model.csv.Laptop;
import parsers.csv.apache.ApacheParser;

import java.io.File;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        File file = new File("src/main/resources/laptops.csv");

        ApacheParser parser = new ApacheParser();

        List<Laptop> parse = parser.parse(file);


    }
}
