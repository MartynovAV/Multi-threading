package learnJava;

import java.util.concurrent.*;
//https://www.geeksforgeeks.org/callable-future-java/

public class MainFutureStudy {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es= Executors.newFixedThreadPool(5);

        Future<Integer> sub = es.submit(new MyCallable());
        Thread.sleep(1000);
        sub.cancel(true);
        System.out.println(sub.isCancelled());

//        Integer id=sub.get();
//        System.out.println(id);

        System.out.println("Shutdown");
        es.shutdown();
    }
}


class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        System.out.println("Started:"+Thread.currentThread().getId());
        try {
            Thread.sleep(1);
            long d1=System.currentTimeMillis();
            long d2=System.currentTimeMillis();
            while(d2<d1+10000){
                d2=System.currentTimeMillis();
            }
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        }
        System.out.println("Finished:"+Thread.currentThread().getId());
        return 99;
    }
}