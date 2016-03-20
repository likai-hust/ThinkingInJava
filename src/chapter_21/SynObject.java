package chapter_21;

class DualSynch {
    private Object syncObject = new Object();
    public synchronized void f() {
        for(int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }
    public void g() {
        //获取syncObject的锁后才能进行操作
        synchronized (syncObject) {
            for(int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
/**
 * Created by KaiLee on 2016/3/17.
 */
public class SynObject {
    public static void main(String... args) {
        final DualSynch ds = new DualSynch();
        //ds.f()执行线程
        new Thread() {
            public void run() {
                ds.f();
            }
        }.start();
        //主线程
        ds.g();
    }
}
/*
    结果交叉输出，
    一个线程并没有因为另一个线程拿走了锁而阻塞，
    因为它们的锁是不同的(不同的对对象有不同的锁)
 */