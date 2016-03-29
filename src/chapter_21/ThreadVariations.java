package chapter_21;

import java.util.concurrent.TimeUnit;

/**
 * 内部类创建线程
 */
class InnerThread1 {
    private int countDown = 5;
    private Inner inner;
    //必须在这里创建线程类，才能启动
    public InnerThread1(String name) {
        inner = new Inner(name);
    }
    private class Inner extends Thread {
        Inner(String name) {
            super(name);
            //构造器内启动线程
            start();
        }
        public void run() {
            try {
                while(true) {
                    System.out.println(this);
                    if(--countDown == 0) return;
                    sleep(10);
                }
            } catch(InterruptedException e) {
                System.out.println("Interrupued");
            }
        }
        public String toString() {
            return getName() + " : " + countDown;
        }
    }
}
/**
 * 匿名内部类创建线程
 */
class InnerThread2 {
    private int countDown = 5;
    private Thread t;
    public InnerThread2(String name) {
        t = new Thread(name) {
            public void run() {
                try {
                    while(true) {
                        System.out.println(this);
                        if(--countDown == 0) return;
                        sleep(10);
                    }
                } catch(InterruptedException e) {
                    System.out.println("sleep() interrupted");
                }
            }
            public String toString() {
                return getName() + " : " + countDown;
            }
        };
        t.start();
    }
}
/**
 * 用一个内部类实现Runnable接口
 */
class InnerRunnable1 {
    private int countDown = 5;
    private Inner inner;
    private class Inner implements Runnable {
        Thread t;
        Inner(String name) {
            //在内部类的构造方法地方创建了线程并启动
            t = new Thread(this, name);
            t.start();
        }
        public void run() {
            try {
                while(true) {
                    System.out.println(this);
                    if(--countDown == 0) return;
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch(InterruptedException e) {
                System.out.println("sleep() interrupted");
            }
        }
        public String toString() {
            return t.getName() + " : " + countDown;
        }
    }
    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }
}
/**
 * 使用匿名内部类实现Runnable接口
 */
class InnerRunnable2 {
    private int countDown = 5;
    private Thread t;
    public InnerRunnable2(String name) {
        t = new Thread(new Runnable(){
            public void run() {
                try {
                    while(true) {
                        System.out.println(this);
                        if(--countDown == 0) return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("sleep () interrupted");
                }
            }
            public String toString() {
                return Thread.currentThread().getName() +
                        " : " + countDown;
            }
        }, name);
        t.start();
    }
}
/**
 * 分离的方法，task
 */

/**
 * 感受不同的方式创建子线程，task放在run中执行
 * Created by KaiLee on 2016/3/9.
 */
public class ThreadVariations {
    /**
     * 测试，main方法，入口
     * @param args
     */
    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
    }
}