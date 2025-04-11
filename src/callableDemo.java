import java.util.concurrent.Callable;

public class callableDemo {
    public static void main(String[] args) throws Exception {

        Callable<Integer> task = () -> {  // so this creates a task which returns an integer value
            int number = 4;
            Thread.sleep(1000);
            return number + number;

        };
        int result = task.call();  // Call the task directly

        System.out.println( result);
    }
}
