package future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SquareCalculator {

    private ExecutorService executor = Executors.newFixedThreadPool(2);

    public Future<Integer> calculate(Integer input) {
        return executor.submit(() -> {
            System.out.println("Calculating square for: "+input);
            Thread.sleep(SECONDS.toMillis(1));
            return input * input;
        });
    }

    public void shutDown(){
        this.executor.shutdown();
    }

}
