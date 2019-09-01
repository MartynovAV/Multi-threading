package learnJava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainES27 {
    public static void main(String[] args) throws Exception {
        ExecutorService es= Executors.newFixedThreadPool(10);
        List<MyCallable1> tasks= new ArrayList<>();

        for (int i = 0; i <3; i++) {
            MyCallable1 mc=new MyCallable1();
            tasks.add(mc);

        }
        List<Future<Long>> futures = es.invokeAll(tasks);

        for(Future<Long>f:futures){
            System.out.println(f.get());
        }

        System.out.println("FINISH");
        es.shutdown();
    }
}

class MyCallable1 implements Callable<Long>{
    @Override
    public Long call(){
        try {
            System.out.println("Started:" + Thread.currentThread().getId());
            Thread.sleep(1000 + Math.round(Math.random() * 5000));
            System.out.println("Finished:" + Thread.currentThread().getId());
        } catch(Exception ex){
            ex.printStackTrace(System.out);
        }
        return Thread.currentThread().getId();
    }
}
