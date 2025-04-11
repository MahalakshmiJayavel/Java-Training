import java.util.concurrent.CompletableFuture;

public class CompletablefutureDemo {
    public static void main(String[] args) {
        String[] users = {"Maha", "Shwe", "Shamee", "Arun"};

        for (String user : users) {
            CompletableFuture
                    .supplyAsync(() -> {
                        System.out.println("Fetching details for " + user + "...");
                        try { Thread.sleep(500); } catch (Exception e) {}
                        return user;
                    })
                    .thenAccept(u -> {
                        System.out.println("Sending welcome email to " + u + "...");
                        try { Thread.sleep(300); } catch (Exception e) {}
                        System.out.println(" Email sent to " + u);
                    });
        }

       // try { Thread.sleep(3000); } catch (Exception e) {}
    }
}
