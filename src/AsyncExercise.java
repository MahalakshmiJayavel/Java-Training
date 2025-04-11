import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class AsyncExercise {

    public static CompletableFuture<List<String[]>> readCSVAsync(String filePath) {
        return CompletableFuture.supplyAsync(() -> {
            List<String[]> rows = new ArrayList<>();
            try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    rows.add(line.split(","));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return rows;
        });
    }

    public static void main(String[] args) {
        // Correctly formatted Windows path
        String filePath = "C:\\Users\\mahal\\OneDrive\\Documents\\employees.csv";

        readCSVAsync(filePath).thenAccept(data -> {
            if (data.isEmpty()) {
                System.out.println("No data found!");
                return;
            }

            int columns = data.get(0).length;
            List<List<String>> attributeArrays = new ArrayList<>();
            for (int i = 0; i < columns; i++) {
                attributeArrays.add(new ArrayList<>());
            }

            for (int i = 0; i < data.size(); i++) {
                String[] row = data.get(i);
                for (int j = 0; j < columns; j++) {
                    attributeArrays.get(j).add(row[j]);
                }
            }

            for (int i = 0; i < columns; i++) {
                System.out.println("Attribute " + (i + 1) + ": " + attributeArrays.get(i));
            }
            //finding teh second highest salary
            int salaryCol = 7;
            Set<Double> salaries = new TreeSet<>(Comparator.reverseOrder());

            for (int i = 1; i < data.size(); i++) {
                try {
                    String[] row = data.get(i);
                    double salary = Double.parseDouble(row[salaryCol]);
                    salaries.add(salary);
                } catch (Exception e) {
                    System.out.println("Invalid salary at row " + (i + 1));
                }
            }

            if (salaries.size() >= 2) {
                Iterator<Double> it = salaries.iterator();
                it.next(); // skip highest
                double secondHighest = it.next();
                System.out.println("\nSecond Highest Salary: " + secondHighest);
            } else {
                System.out.println("\nNot enough unique salaries to find second highest.");
            }
        }).join();
    }
}
