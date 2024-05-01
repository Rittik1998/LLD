package ConcurrencyAndMultithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Ways of creating threads
public class Client {
    public static void main(String[] args) {
        //way 1(using Thread class)-----------------------------
        MyThread1 thread1 = new MyThread1();
        thread1.start();

        //way 2(using Runnable Interface in which the thread doesn't return anything)----------------------------
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();

        //way 3(using Executors)----------------------------------

        /*using newSingleThreadExecutor() -> Creates an Executor that uses a single worker thread operating off an unbounded queue
        Useful when you need to execute tasks sequentially in the same thread, ensuring that no two tasks are executed concurrently.
         */
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new MyRunnable());
        executor.shutdown();

        /*using newFixedThreadPool(int nThreads) -> Creates a thread pool with a fixed number of threads.
        Any submitted task is executed by an available thread in the pool.
        Useful when you have a lot of short-lived tasks and want to limit the number of concurrent threads to control resource usage.
         */
        ExecutorService executor1 = Executors.newFixedThreadPool(2);
        executor1.submit(new MyRunnable());
        executor1.shutdown();

        /*using newFixedThreadPool(int nThreads) -> Creates a thread pool that creates new threads as needed
        but will reuse previously constructed threads when they are available.(mostly use this as it's safe)
        Ideal for applications that require launching many short-lived tasks.
        The pool improves performance by reusing existing threads and automatically reducing the number of idle threads.
         */
        ExecutorService executor2 = Executors.newCachedThreadPool();
        executor2.submit(new MyRunnable());
        executor2.shutdown();

        //way4(using Callable Interface in which the thread return something)------------------------
        ExecutorService executor3 = Executors.newSingleThreadExecutor();
        // Submit the callable task and receive a Future object
        Future<Integer> val = executor3.submit(new MyCallable());
        // Do some other tasks if necessary...

        // Use future.get() to retrieve the result from the callable task
        try{
            int result = val.get();
            System.out.println("The result is : " + result);
        }
        catch(Exception e){
            System.out.println(e);
        }
        executor3.shutdown();

        //way5(Using lambda func) -----------------------------
        Thread thread3 = new Thread(()->{
            System.out.println("I am running using lambda func from "+ Thread.currentThread().getName());
        });
        thread3.start();

        // we can write Executors also using lamba func
    }
}
