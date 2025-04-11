import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {
    public static void main(String[] args) {

        // 1. Consumer: takes input, returns nothing
        Consumer<String> greet = name -> System.out.println("Hello, " + name);
        greet.accept("Maha");

        // 2. Supplier: takes nothing, returns a value
        Supplier<String> supplyName = () -> "Supplied: Maha@123";
        System.out.println(supplyName.get());

        // 3. Predicate: takes input, returns boolean
        Predicate<Integer> isAdult = age -> age >= 18;
        System.out.println("Is 20 an adult? " + isAdult.test(20)); // true
        System.out.println("Is 16 an adult? " + isAdult.test(16)); // false

        // 4. Function: takes input, returns output
        Function<String, Integer> getLength = str -> str.length();
        System.out.println("Length of 'Functional': " + getLength.apply("Functional"));
    }
}
