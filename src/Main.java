import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws IOException {
Thread t1=new Thread(){
    public void run(){
        for (int i=0;i<100;i++){
        try {
            if(!Files.exists(Path.of("txt"))){
                Files.createFile(Path.of("txt"));
            }

            Files.write(Paths.get("txt"),"salam ".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            System.out.println(System.nanoTime() +" salam");
    }}
};
        Thread t2=new Thread(){
            public void run(){
                for (int i=0;i<100;i++){
                    try {
                        if(!Files.exists(Path.of("txt"))){
                            Files.createFile(Path.of("txt"));
                        }
                        Files.write(Paths.get("txt"),"sagol".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(System.nanoTime() +" sagol");
                }}
        };
        ExecutorService ex=Executors.newFixedThreadPool(2);
        ex.submit(t1);
        ex.submit(t2);

ex.shutdown();
    }
}