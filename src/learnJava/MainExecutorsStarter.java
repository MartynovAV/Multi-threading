package learnJava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class MainExecutorsStarter {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es= Executors.newFixedThreadPool(10,new MyFactory());
        for (int i = 0; i <3 ; i++) {
            es.submit(new MyRunnable());
        }
        es.shutdown();
    }
}

class MyFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        return new SimpleThread(r);
    }
}


class SimpleThread extends Thread{
    public SimpleThread(Runnable target) {
        super(target);
    }
}

