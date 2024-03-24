package thread;

public class ThreadApp {
    public static void main(String[] args) {
         Thread thread = new Thread(
                 () -> System.out.println("Thread : " + Thread.currentThread().getName())
         );
         thread.start();

    }
}
