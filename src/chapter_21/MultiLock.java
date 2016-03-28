package chapter_21;

/**
 * 多个锁交叉调用
 * Created by KaiLee on 2016/3/20.
 */
public class MultiLock {
    public synchronized void f1(int count) {
        if(count-- > 0) {
            System.out.println("f1() calling f2() with count " + count);
            f2(count);
            System.out.println("f1() finished " + count);
        }
    }
    public synchronized void f2(int count) {
        if(count-- > 0) {
            System.out.println("f2() calling f2() with count " + count);
            f1(count);
            System.out.println("f2() finished " + count);
        }
    }
    public static void main(String... args) {
        final MultiLock multiLock = new MultiLock();
        new Thread( () -> { multiLock.f1(10); } ).start();
    }
}
