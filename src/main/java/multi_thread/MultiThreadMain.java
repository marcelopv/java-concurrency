package multi_thread;

public class MultiThreadMain {

    public static void main(String[] args) throws InterruptedException {
        String[] inFiles = {"/Users/mvargas/projects/java-concurrency/src/main/resources/file1.txt",
                "/Users/mvargas/projects/java-concurrency/src/main/resources/file2.txt",
                "/Users/mvargas/projects/java-concurrency/src/main/resources/file3.txt"};

        Thread[] threads = new Thread[inFiles.length];

        for (int i=0; i < inFiles.length; i++){
            RunnableAdder adder = new RunnableAdder(inFiles[i]);
            threads[i] = new Thread(adder);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("finished file reading process");

    }

}
