package chapter_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;
    public CircularSet(int size) {
        array = new int[size];
        len = size;
        for(int i = 0; i < size; i++) {
            array[i] = -1;
        }
    }
    /*将操作放在本类中，加锁操作，不会出现重复的数字*/
//    private static volatile int serialNumber = 0;
//    public static synchronized int nextSerialNumber() {
//        return serialNumber++;
//    }

    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len;
    }
    public synchronized boolean contains(int val) {
        for(int i = 0; i < len; i++)
            if(array[i] == val) return true;
        return false;
    }
}
/**
 * Created by KaiLee on 2016/3/17.
 */
public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {
        @Override
        public void run() {
            while(true) {
                //nextSerialNumber没有锁，且++并非原子操作
                int serial = SerialNumberGenerator.nextSerialNumber();
                if(serials.contains(serial)) {
                    System.out.println("Duplicate : " + serial);
                    System.exit(0);
                }
            serials.add(serial);
            }
        }
    }
    public static void main(String... args) {
        // 十个线程去同时对于static volatile变量进行++操作，虽然add和contains加锁
        // 但在多个线程对于++操作并没有上锁，所以会出现汇编语句中间读取或写入。
        // 于是Java引入了原子类Atomic...
        for(int i = 0; i < SIZE; i++) {
            exec.execute(new SerialChecker());
        }
    }
}