import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Streams {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\mahal\\OneDrive\\Documents\\employees.csv";

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            String Names = lines
                    .skip(1)
                    .map(line -> line.split(",")[1])
                    .collect(Collectors.joining(", "));

            System.out.println("Employee Names: " + Names);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
