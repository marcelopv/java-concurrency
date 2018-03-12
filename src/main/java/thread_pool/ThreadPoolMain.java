package thread_pool;

import java.util.concurrent.*;

public class ThreadPoolMain {

    public static void main(String[] args) {
        String[] inFiles = {"/Users/mvargas/projects/java-concurrency/src/main/resources/file1.txt",
                "/Users/mvargas/projects/java-concurrency/src/main/resources/file2.txt",
                "/Users/mvargas/projects/java-concurrency/src/main/resources/file3.txt"};

        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer>[] results = new Future[inFiles.length];

        for (int i=0; i < inFiles.length; i++){
            FutureAdder adder = new FutureAdder(inFiles[i]);
            results[i] = es.submit(adder);
        }

        for (Future<Integer> result : results) {
            try {
                Integer total = result.get();
                System.out.println("Total: "+total);
            } catch (InterruptedException | ExecutionException e) {
                Throwable cause = e.getCause();
                System.out.println(cause);
            }
        }

        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch (Exception e){
            System.out.println(e);
        }

        System.out.println("finished file reading process");

    }

}
