package caveOfProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainPart4 {
    public static void main(String[] args) {
            new Worker().main();
    }
}

class Worker{
    private Object lock1=new Object();
    private Object lock2=new Object();

    private Random random=new Random();

    private List<Integer> list1=new ArrayList<>();
    private List<Integer> list2=new ArrayList<>();

    public void stageOne() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }
    public void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    public void process(){
        for (int i = 0; i <1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void main(){
        System.out.println("Starting....");

        long start =System.currentTimeMillis();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end =System.currentTimeMillis();

        System.out.println("Time taken "+(end-start)+" ms");
        System.out.println("List 1 size:"+list1.size()+" List2 size:"+list2.size());
    }
}