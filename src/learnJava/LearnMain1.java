package learnJava;

public class LearnMain1 {
    public static void main(String[] args) {
        for (int i = 0; i <5; i++) {
            MyThread m=new MyThread();
            m.start();
        }
        for (int i = 0; i <5; i++) {
            MyRunnable r=new MyRunnable();
            Thread t=new Thread(r);
            t.start();
        }
    }
}


class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("Start Thread:"+getId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish Thread:"+getId());
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Start Runnable:"+Thread.currentThread().getId());
        System.out.println("Start Runnable:"+Thread.currentThread().getClass().getSimpleName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish Runnable:"+Thread.currentThread().getId());
    }
}