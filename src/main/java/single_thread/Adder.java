package single_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Adder {

    private String inFile;

    public Adder(String inFile) {
        this.inFile = inFile;
    }

    public void add() throws IOException {
        int total = 0;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            while(reader.readLine() != null){
                total += 1;
            }
        }

        System.out.println("Number of lines of file"+inFile+" : "+total);
    }

}
