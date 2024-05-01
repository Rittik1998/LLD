package ConcurrencyAndMultithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AddSubWithSynchronized {
    public static void main(String[] args) throws InterruptedException {
        Count3 count = new Count3();

        Thread adder = new Thread(new Adder3(count));
        Thread subtractor = new Thread(new Subtractor3(count));

        adder.start();
        subtractor.start();

        adder.join();//waits for the thread adder to complete, code will not go to next line till adder completes
        subtractor.join();

        System.out.println("Count: " + count.getVal());
    }
}
class Count3{
    private int val;
    public Count3(){
        val = 0;
    }

    public int getVal() {
        return val;
    }

    public void addValue(int i){
        this.val += i;
    }
}

class Adder3 implements Runnable{
    private Count3 count;
    public Adder3(Count3 count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=1; i<=10000; i++){
            synchronized (count) {
                count.addValue(i);
            }
        }
    }
}

class Subtractor3 implements Runnable{
    private Count3 count;
    public Subtractor3(Count3 count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=1; i<=10000; i++){
            synchronized (count) {
                count.addValue(-i);
            }
        }
    }
}