import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalOperators {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Maha", "IT", "Developer", 5000.0),
                new Employee("Shameema", "IT", "Data Science", 5000.0),
                new Employee("Shwetha", "Finance", "Analyst", 6000.0)
        );

        System.out.println("forEach:");
        employees.stream()
                .forEach(e -> System.out.println(
                       e));
        System.out.println("Collect: ");
        List<Employee> itEmployees = employees.stream()
                .filter(e -> e.department.equals("IT"))
                .collect(Collectors.toList());


            System.out.println("reduce: ");
            double totalSalary = employees.stream()
                    .map(emp -> emp.salary)
                    .reduce(0.0, Double::sum);
            System.out.println("Total Salary: " + totalSalary);

        }
    }

