package chapter_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class EvenGenerate {
    private int even = 0;
    public int next() {
        ++even;
        ++even;
        return even;
    }
}
class EvenGet implements Runnable {
    private EvenGenerate evenGenerate;
    private final int id;
    public EvenGet(EvenGenerate e, int id) {
        evenGenerate = e;
        this.id = id;
    }
    @Override
    public void run() {
        int val = evenGenerate.next();
        if(val % 2 != 0) {
            System.out.println(val + " not even");
        } else {
            System.out.println(val + " even");
        }
    }
    public static void test(EvenGenerate eg, int count) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < count; i++)
            exec.execute(new EvenGet(eg, i));
        exec.shutdown();
    }
    public static void test(EvenGenerate eg) {
        test(eg, 10);
    }
}
public class EvenTest {
    public static void main(String[] args) {
        EvenGet.test(new EvenGenerate());
    }
}
