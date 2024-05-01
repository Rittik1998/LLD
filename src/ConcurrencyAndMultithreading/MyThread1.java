package ConcurrencyAndMultithreading;

public class MyThread1 extends Thread{
    public void run(){
        System.out.println("I am running from "+ Thread.currentThread().getName());
    }
}
