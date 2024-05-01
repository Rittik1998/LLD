package ConcurrencyAndMultithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AddSubWithAtomicInt {
    public static void main(String[] args) throws InterruptedException {
        Count5 count = new Count5();
        Thread adder = new Thread(new Adder5(count));
        Thread subtractor = new Thread(new Subtractor5(count));
        adder.start();
        subtractor.start();

        adder.join();//waits for the thread adder to complete, code will not go to next line till adder completes
        subtractor.join();

        System.out.println("Count: " + count.getVal());
    }
}
class Count5{
    private AtomicInteger val;
    public Count5(){
        this.val = new AtomicInteger(0);
    }

    public int getVal() {
        return val.get();
    }

    public void setVal(int val) {
        this.val.set(val);
    }

    public void addValue(int i){
        this.val.addAndGet(i);
    }
}

class Adder5 implements Runnable{
    Count5 count;
    public Adder5(Count5 count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=1; i<=10000; i++){
            count.addValue(i);
        }
    }
}

class Subtractor5 implements Runnable{
    Count5 count;
    public Subtractor5(Count5 count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=1; i<=10000; i++){
            count.addValue(-i);
        }
    }
}