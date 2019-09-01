package geekON;
//https://youtu.be/HSh_Gpnn6fo
//https://www.yegor256.com/2015/10/20/interrupted-exception.html
//https://stackoverflow.com/questions/1904072/java-difference-in-usage-between-thread-interrupted-and-thread-isinterrupted
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainGeek {
    public static void main(String[] args) throws InterruptedException {
        final List<Integer> list=new ArrayList<>();

        Thread thread=new Thread(() -> {
            while(true){
                list.clear();
                for (int i = 0; i <100 ; i++) {
                   list.add(i);
            }
            }
        });

        //thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(1L);

        System.out.println("We want you to stop");
        thread.interrupt();

        System.out.println("Items in the list "+list.size());

        System.out.println("Hello");
    }
}
