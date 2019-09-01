package learnJava;
//https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ThreadPoolExecutor.html
//https://www.youtube.com/watch?v=nU3Yf8UVWVc&list=PLyxk-1FCKqodhV1d55ZmoAcz6aeyhLxnr&index=28
import java.util.concurrent.*;

public class Main28 {
    public static void main(String[] args) {
        ThreadPoolExecutor es=new ThreadPoolExecutor(
                2,4,1, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(2),
                new MyReject()
        );
        for (int i = 0; i <7 ; i++) {
            MyCallable2 mc=new MyCallable2();
            es.submit(mc);
        }
        es.shutdown();
    }
}

class MyCallable2 implements Callable<Long>{
    @Override
    public Long call() throws Exception {
        try{
            System.out.println("Thread Started:"+Thread.currentThread().getId());
            Thread.sleep(3000);
            System.out.println("Thread Finished:"+Thread.currentThread().getId());
        }catch(Exception ex){
            ex.printStackTrace(System.out);
        }
        return Thread.currentThread().getId();
    }
}

class MyReject implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("REJECTED");
    }
}