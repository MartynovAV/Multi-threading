package threadsLessonsNeil;

import java.util.Scanner;

public class TestMain7 {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify wn=new WaitAndNotify();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}

class WaitAndNotify{
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("Producer Thread Started...");
            wait();
            System.out.println("Producer Thread resumed...");
        }

    }
    public void consume() throws InterruptedException{
        Thread.sleep(2000);
        Scanner scanner=new Scanner(System.in);

        synchronized (this){
            System.out.println("Waiting for Enter key Pressed");
            scanner.nextLine();
            notify();
            Thread.sleep(5000);
        }

    }
}
