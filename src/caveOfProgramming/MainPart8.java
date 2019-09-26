package caveOfProgramming;

import java.util.Scanner;

public class MainPart8 {
    public static void main(String[] args) throws InterruptedException {
    final Process process=new Process();

    Thread t1=new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                process.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    Thread t2=new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                process.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    t1.start();
    t2.start();
    t1.join();
    t2.join();

    }
}


class Process{
public void produce() throws InterruptedException {
    synchronized (this){
        System.out.println("Producer thread running");
        wait();
        System.out.println("Resumed");
    }
}

public void consume() throws InterruptedException {
    Scanner scanner=new Scanner(System.in);
    Thread.sleep(2000);
    synchronized (this){
        System.out.println("Waiting for return key");
        scanner.nextLine();
        System.out.println("Return key pressed");
        notify();
    }
}


}