package ConcurrencyAndMultithreading;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 5;
    }
}
