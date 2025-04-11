
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class ParallelStreamsDemo {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\mahal\\OneDrive\\Documents\\employees.csv";

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            long count = lines
                    .skip(1)
                    .parallel()
                    .map(line -> line.split(","))
                    .filter(parts -> {
                        try {
                            return Double.parseDouble(parts[7]) > 8000;
                        } catch (Exception e) {
                            return false;
                        }
                    })
                    .count();

            System.out.println("Employees earning more than 8000: " + count);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
