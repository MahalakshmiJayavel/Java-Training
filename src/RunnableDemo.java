public class RunnableDemo {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Runnable is running");

        Thread thread = new Thread(task);
        thread.setName("thread-1");
        thread.start();




    }

    public class ThreadExample extends Thread{
       public void run(){
            System.out.println(Thread.currentThread().getName()+" running");
        }

       void executeThread(){

            ThreadExample threadExample =   new ThreadExample();
            threadExample.setName("Thread-2");
            threadExample.start();
        }

    }
}
