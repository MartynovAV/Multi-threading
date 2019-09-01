package caveOfProgramming;

import java.util.Scanner;

public class MainPart2 {
    public static void main(String[] args) {
        Processor processor1=new Processor();
        processor1.start();

        System.out.println("Press enter to stop");
        Scanner scanner=new Scanner(System.in);
        scanner.nextLine();
        processor1.shutdown();
    }
}

class Processor extends Thread{
    private volatile boolean running=true;

    @Override
    public void run() {
    while (running){
        System.out.println("Hello");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }

    public void shutdown(){
        running=false;
    }


}