package ConcurrencyAndMultithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AddSubWithLock {
    public static void main(String[] args) throws InterruptedException {
        Count2 count = new Count2();
        Lock lock = new ReentrantLock(); //create a shared lock

        Thread adder = new Thread(new Adder2(count,lock));
        Thread subtractor = new Thread(new Subtractor2(count,lock));
        adder.start();
        subtractor.start();

        adder.join();//waits for the thread adder to complete, code will not go to next line till adder completes
        subtractor.join();

        System.out.println("Count: " + count.getVal());
    }
}
class Count2{
    private int val;
    public Count2(){
        val = 0;
    }

    public int getVal() {
        return val;
    }

    public void addValue(int i){
        this.val += i;
    }
}

class Adder2 implements Runnable{
    private Count2 count;
    private Lock lock;
    public Adder2(Count2 count, Lock lock){
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run() {
        for(int i=1; i<=10000; i++){
            lock.lock(); //lock
            count.addValue(i); //critical section
            lock.unlock(); //unlock
        }
    }
}

class Subtractor2 implements Runnable{
    private Count2 count;
    private Lock lock;
    public Subtractor2(Count2 count, Lock lock){
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run() {
        for(int i=1; i<=10000; i++){
            lock.lock(); //lock
            count.addValue(-i); //critical section
            lock.unlock(); //unlock
        }
    }
}