package chapter_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car {
    private boolean waxOn = false;
    /*打蜡操作，进行完毕后唤醒其他线程，通知可以进行剩余操作*/
    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }
    /*抛光，*/
    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }
    public synchronized void waitForWaxing() throws InterruptedException {
        //必须使用while检查条件变化
        while(waxOn == false)
            wait();
    }
    public synchronized void waitForBuffing() throws InterruptedException {
        while(waxOn == true)
            wait();
    }
}
class WaxOn implements Runnable {
    private Car car;
    public WaxOn(Car c) { car = c; }
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                System.out.println("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupted");
        }
        System.out.println("Ending Wax On task");
    }
}
class WaxOff implements Runnable {
    private Car car;
    public WaxOff(Car c) { car = c; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Wax Off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch(InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}
/**
 * wait只能在同步方法块中使用，wait将会释放锁。sleep不会释放锁，仅仅是休眠，用于非同步的线程中。
 * Created by KaiLee on 2016/3/20.
 */
public class WaxOMatic {
    public static void main(String... args) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
