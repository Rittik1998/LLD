package ConcurrencyAndMultithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumberPrinter {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i=1; i<=10; i++){
            executor.submit(new MyPrinterRunnable(i));
        }
    }
}

class MyPrinterRunnable implements Runnable{
    int num;
    public MyPrinterRunnable(int num){
        this.num = num;
    }
    @Override
    public void run() {
        System.out.println(num + " " + Thread.currentThread().getName());
    }
}
