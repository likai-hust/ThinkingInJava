package chapter_21;

import java.util.concurrent.TimeUnit;

class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Starting Adaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruputedException");
        } finally {
            System.out.println("Finally!");
        }
    }
}
/**
 * Created by KaiLee on 2016/3/9.
 */
public class DaemonsDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}
/// Output：不会输出finally
