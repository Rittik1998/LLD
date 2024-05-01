package ConcurrencyAndMultithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Thread producer1 = new Thread(new Producer(shop));
        Thread producer2 = new Thread(new Producer(shop));

        Thread consumer1 = new Thread(new Consumer(shop));
        Thread consumer2 = new Thread(new Consumer(shop));
        Thread consumer3 = new Thread(new Consumer(shop));
        Thread consumer4 = new Thread(new Consumer(shop));

        producer1.start();
        producer2.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
    }
}

class Shop{
    private int stock;
    public int getStock(){
        return stock;
    }
    public synchronized void buy(){
        this.stock -= 1;
    }

    public synchronized void produce(){
        this.stock += 1;
    }
}

class Producer implements Runnable{
    private Shop shop;
    Producer(Shop shop){
        this.shop = shop;
    }
    @Override
    public void run() {
        while(true){
            if(shop.getStock()<5){
                shop.produce();
                System.out.println("Producer is producing, now shop has " + shop.getStock() + " clothes");
            }
        }
    }
}

class Consumer implements Runnable{
    Shop shop;
    Consumer(Shop shop){
        this.shop = shop;
    }
    @Override
    public void run() {
        while(true){
            if(shop.getStock()>0){
                shop.buy();
                System.out.println("Consumer is buying, now shop has " + shop.getStock() + " clothes");
            }
        }
    }
}
