import java.util.*;
import java.time.Duration;
import java.time.Instant;

public class threadVirtual {

    public static void main(String[] args) {
        int threadCount = 100000;
        boolean useVirtualThreads = false; // change to false to use platform threads

        System.out.println("Running with " + (useVirtualThreads ? "VIRTUAL" : "PLATFORM") + " threads");

        Runnable task = () -> sleep(3000); // Simulate blocking work

        List<Thread> threads = new ArrayList<>();
        Instant start = Instant.now();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = useVirtualThreads
                    ? Thread.ofVirtual().unstarted(task)
                    : new Thread(task);

            thread.setName("Thread-" + i);
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Total Execution Time: " + duration.toMillis() + " ms");

        // Memory usage
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // force garbage collection
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used Memory: " + usedMemory / (1024 * 1024) + " MB");
    }

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}