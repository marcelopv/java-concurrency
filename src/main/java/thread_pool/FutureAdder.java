package thread_pool;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class FutureAdder implements Callable<Integer> {

    private String inFile;

    public FutureAdder(String inFile) {
        this.inFile = inFile;
    }

    public int add() throws IOException {
        int total = 0;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            while(reader.readLine() != null){
                total += 1;
            }
        }

        return total;
    }

    @Override
    public Integer call() throws IOException {
        return add();
    }
}
