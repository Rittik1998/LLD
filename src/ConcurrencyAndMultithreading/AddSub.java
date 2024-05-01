package ConcurrencyAndMultithreading;

public class AddSub {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Thread adder = new Thread(new Adder(count));
        Thread subtractor = new Thread(new Subtractor(count));
        adder.start();
        subtractor.start();

        adder.join();//waits for the thread adder to complete, code will not go to next line till adder completes
        subtractor.join();

        System.out.println("Count: " + count.getVal());
    }
}
class Count{
    private int val;
    public Count(){
        val = 0;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void addValue(int i){
        this.val += i;
    }
}

class Adder implements Runnable{
    Count count;
    public Adder(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=1; i<=10000; i++){
            count.addValue(i);
        }
    }
}

class Subtractor implements Runnable{
    Count count;
    public Subtractor(Count count){
        this.count = count;
    }
    @Override
    public void run() {
        for(int i=1; i<=10000; i++){
            count.addValue(-i);
        }
    }
}