package ConcurrencyAndMultithreading;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("I am running from " + Thread.currentThread().getName());
    }
}
