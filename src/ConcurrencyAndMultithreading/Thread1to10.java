package ConcurrencyAndMultithreading;

public class Thread1to10 {
    public static void main(String[] args) {
        Thread mythread1to10 = new Thread(()->{
            for(int i=1; i<=10; i++) System.out.println(i + " " + Thread.currentThread().getName());
        });
        mythread1to10.start();
    }
}
