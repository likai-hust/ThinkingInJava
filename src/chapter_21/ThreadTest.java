package chapter_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private static int count = 0;
    private final int id = count++;
    private int taskLoop = 8;
    @Override
    public void run() {
        Thread.currentThread().setPriority(id + 1); //设置线程优先级[1 - 10]
        while(taskLoop-- > 0) {
            System.out.println("id:" + id + ",taskLoop:" + taskLoop + " ");
            //Thread.yield();   //让步，声明时间片可以抢占
            try {
                TimeUnit.MILLISECONDS.sleep(10);    //阻塞某段时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
/**
 * 测试多线程
 * Created by KaiLee on 2016/3/7.
 */
public class ThreadTest {
    public static void main(String[] args) {
        //main线程和自定义线程交错进行
        for(int i = 0; i < 5; i++) {
            Thread daemon = new Thread(new Task());
            daemon.setDaemon(true); //设置为后台线程
            daemon.start();
        }
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            executor.execute(new Task());
        executor.shutdown();    //防止新任务提交给executor
    }
}