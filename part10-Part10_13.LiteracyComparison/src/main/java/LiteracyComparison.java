
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        String file = "literacy.csv";
        try {
            Files.lines(Paths.get(file)).map(line -> line.split(","))
                                        .sorted((lr1, lr2) -> {
                                            return Double.compare(Double.parseDouble(lr1[5]), Double.parseDouble(lr2[5]));
                                        }).forEach(parts -> System.out.println(parts[3].trim() + " (" + parts[4] + "), " + parts[2].trim().split(" ")[0] + ", " + parts[5]));
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
