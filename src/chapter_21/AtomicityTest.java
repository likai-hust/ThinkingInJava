package chapter_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 这个例子说明了synchronized锁在类里面是共享锁
 * 必须对getValue和evenIncrement同时加上锁，这样形成了一个同步锁，从而才可以保证现成的安全
 * Created by Kai on 2016/3/17.
 */
public class AtomicityTest implements Runnable {
    private int i = 0;
    public int getValue() {
        return i;
    }
    private synchronized void evenIncrement(){
        i++;
        i++;
    }
    @Override
    public void run() {
        while(true) {
            evenIncrement();
        }
    }
    public static void main(String... args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest atTest = new AtomicityTest();
        exec.execute(atTest);
        while(true) {
            int val = atTest.getValue();
            if(val % 2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
