import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.*;

public class futureDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();//this will create thread pool with just one thread

        Runnable task = () -> System.out.println("Running a simple task");//simple runnable task with no return value

        Future<?> future = executor.submit(task); //submit task to executor and returns future object as it could be anything or null
        future.get(); // Waits for task to finish, returns null as runnable does not return anything

        executor.shutdown();
    }
}
