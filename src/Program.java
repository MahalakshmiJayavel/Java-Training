import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\mahal\\IdeaProjects\\BootCamp\\logs";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String userInput = scanner.nextLine().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        scanner.close();LocalDate localDate = LocalDate.parse(userInput, formatter);
        // Get the current time from the system clock
        LocalTime localTime = LocalTime.now();

        // Combine the date and time
        LocalDate localDateTime = LocalDateTime.of(localDate, localTime).toLocalDate();

        // Convert to Instant
       // Instant filterTime = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
       // System.out.println("Log messages after " + filterTime + ":\n");

        HashMap<String, Integer> messageCount = new HashMap<>();
        Pattern pattern = Pattern.compile("^(\\S+)\\s+(.+)$");

        try {
            List<String> logs = Files.readAllLines(Paths.get(filePath));

            for (String log : logs) {
                Matcher matcher = pattern.matcher(log);
                if (matcher.find()) {
                    LocalDate logTime = ZonedDateTime.parse(matcher.group(1), DateTimeFormatter.ISO_DATE_TIME).toLocalDate();
                    //LocalDate logTime = LocalDate.parse(matcher.group(1),formatter);
                    String message = matcher.group(2);

                    if (logTime.equals(localDate)) {
                        int count = messageCount.getOrDefault(message, 0) + 1;
                        messageCount.put(message, count);

                        // Only print the message part (hide timestamp)
                        System.out.println(message + (count > 1 ? " (repeated " + count + " times)" : ""));
                    }
                   // System.out.println(message);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
