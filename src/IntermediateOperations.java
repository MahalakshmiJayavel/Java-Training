import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

public class IntermediateOperations {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Maha", "IT", "Developer", 8000.0),
                new Employee("Shameema", "IT", "Data Science", 8000.0),
                new Employee("Shwetha", "Finance", "Analyst", 8000.0),
                new Employee("Arun", "HR", "Manager", 90000.0),
                new Employee("Sam", "Marketing", "Executive", 40000.0),
                new Employee("Deepa", "IT", "Tester", 68000.0),
                new Employee("Kumar", "Finance", "Senior Analyst", 71000.0),
                new Employee("Meera", "IT", "DevOps Engineer", 72000.0),
                new Employee("Vikram", "Admin", "Coordinator", 30000.0),
                new Employee("Sita", "IT", "Architect", 95000.0)
        );
       IntermediateOperations obj= new IntermediateOperations();
                obj.work(employees);
                obj.findTopEarnersByDepartment(employees);

    }

    public void work(List<Employee> employees) {
        System.out.println("Sort (salary > 50000):");
 //       Comparator<Double> SalaryComparator = Comparator.comparingDouble(Employee::getSalary);
    employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
    System.out.println(employees);

        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(e -> System.out.println(e.name  + e.salary));
    }
    public void findTopEarnersByDepartment(List<Employee> employees) {
        System.out.println("maximum salary");
        Map<String, Optional<Employee>> result = employees.stream()
//                .filter(e -> e.salary > 7000)
                .collect(groupingBy(
                        e -> e.department,
                        maxBy(Comparator.comparingDouble(e -> e.salary))
                ));

                        System.out.println(result);
  }
}