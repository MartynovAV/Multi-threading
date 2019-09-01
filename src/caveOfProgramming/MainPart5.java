package caveOfProgramming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainPart5 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        for (int i = 0; i <5 ; i++) {
            executorService.submit(new ProCessor(i));
        }
            executorService.shutdown();
            System.out.println("All tasks submitted");
            try {
                executorService.awaitTermination(1, TimeUnit.DAYS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("All tsks completed");

    }
}

class ProCessor implements Runnable{

    private int id;

    public ProCessor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting "+id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed "+id);
    }
}
