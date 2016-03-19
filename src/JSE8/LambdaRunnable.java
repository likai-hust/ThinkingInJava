package JSE8;

import java.util.concurrent.TimeUnit;

/**
 * Created by KaiLee on 2016/3/19.
 */
public class LambdaRunnable {
    public static void main(String... args) {
        //通过lambda表达式，直接设置任务，并在lambda表达式中捕获异常
        Runnable task  = () -> { System.out.println("Hello, world!");
           try{
               TimeUnit.SECONDS.sleep(3);
           } catch (InterruptedException e) {
           } };
        new Thread(task).start();
    }
}
