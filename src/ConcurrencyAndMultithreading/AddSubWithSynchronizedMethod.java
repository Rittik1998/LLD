package ConcurrencyAndMultithreading;

public class AddSubWithSynchronizedMethod {
    public static void main(String[] args) throws InterruptedException {
        Count4 count = new Count4();

        Thread adder = new Thread(new Adder4(count));
        Thread subtractor = new Thread(new Subtractor4(count));

        adder.start();
        subtractor.start();

        adder.join();//waits for the thread adder to complete, code will not go to next line till adder completes
        subtractor.join();

        System.out.println("Count: " + count.getVal());
    }
}
class Count4{
    private int val;
    public Count4(){
        val = 0;
    }

    public int getVal() {
        return val;
    }

    public synchronized void addValue(int i){
        this.val += i;
    }
}

class Adder4 implements Runnable{
    private Count4 count;
    public Adder4(Count4 count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=1; i<=10000; i++){
            count.addValue(i);
        }
    }
}

class Subtractor4 implements Runnable{
    private Count4 count;
    public Subtractor4(Count4 count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=1; i<=10000; i++){
            count.addValue(-i);
        }
    }
}