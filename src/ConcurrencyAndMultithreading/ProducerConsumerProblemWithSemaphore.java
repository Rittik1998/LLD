package ConcurrencyAndMultithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ProducerConsumerProblemWithSemaphore {
    public static void main(String[] args) {
        Shop2 shop = new Shop2();
        Semaphore producerSemaphore = new Semaphore(5);
        Semaphore consumerSemaphore = new Semaphore(0);

        Thread producer1 = new Thread(new Producer2(shop,producerSemaphore,consumerSemaphore));
        Thread producer2 = new Thread(new Producer2(shop,producerSemaphore,consumerSemaphore));

        Thread consumer1 = new Thread(new Consumer2(shop,producerSemaphore,consumerSemaphore));
        Thread consumer2 = new Thread(new Consumer2(shop,producerSemaphore,consumerSemaphore));
        Thread consumer3 = new Thread(new Consumer2(shop,producerSemaphore,consumerSemaphore));
        Thread consumer4 = new Thread(new Consumer2(shop,producerSemaphore,consumerSemaphore));


        producer1.start();
        producer2.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
    }
}

class Shop2{
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

class Producer2 implements Runnable{
    private Shop2 shop;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;
    Producer2(Shop2 shop,Semaphore producerSemaphore, Semaphore consumerSemaphore){

        this.shop = shop;
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
    }
    @Override
    public void run() {
        while(true){
            try {
                producerSemaphore.acquire();
                shop.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Producer is producing, now shop has " + shop.getStock() + " clothes");
            consumerSemaphore.release();
        }
    }
}

class Consumer2 implements Runnable{
    Shop2 shop;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;
    Consumer2(Shop2 shop,Semaphore producerSemaphore, Semaphore consumerSemaphore){

        this.shop = shop;
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
    }
    @Override
    public void run() {
        while(true){
            try {
                consumerSemaphore.acquire();
                shop.buy();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Consumer is buying, now shop has " + shop.getStock() + " clothes");
            producerSemaphore.release();
        }
    }
}
