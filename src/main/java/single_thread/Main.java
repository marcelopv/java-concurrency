package single_thread;

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        String[] inFiles = {"/Users/mvargas/projects/java-concurrency/src/main/resources/file1.txt",
                "/Users/mvargas/projects/java-concurrency/src/main/resources/file2.txt",
                "/Users/mvargas/projects/java-concurrency/src/main/resources/file3.txt"};


        try {
            for (int i=0; i < inFiles.length; i++){
                Adder adder = new Adder(inFiles[i]);
                adder.add();
            }
        } catch (IOException e){
            System.out.println(e);
        }

        System.out.println("finished file reading process");
    }

}
