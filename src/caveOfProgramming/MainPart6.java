package caveOfProgramming;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPart6 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch =new CountDownLatch(3);
        ExecutorService es= Executors.newFixedThreadPool(3);
        for (int i = 0; i <3 ; i++) {
            es.submit(new Processor1(countDownLatch));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed");
        es.shutdown();
    }
}

class Processor1 implements Runnable{
    private CountDownLatch countDownLatch;

    public Processor1(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Started...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}