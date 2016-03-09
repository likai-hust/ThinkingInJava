package chapter_21;

/**
 * 内部类创建线程
 */
class InnerThread1 {
    private int countDown = 5;
    private Inner inner;
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
 * 感受不同的方式创建子线程
 * Created by KaiLee on 2016/3/9.
 */
public class ThreadVariations {
    /**
     * 测试，main方法，入口
     * @param args
     */
    // TODO: 2016/3/9 尚待完成：几种子类的创建方式
    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
    }
}
