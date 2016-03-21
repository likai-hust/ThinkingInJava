package DesignPattern;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * 1.最简版本，线程不安全，懒汉式
 */
class Singleton1 {
    //私有的类实例，保证只能在类中被创建
    private static Singleton1 instance = null;

    /**
     * 防止类被实例化
     */
    private Singleton1() { };
    /**
     * 通过判断instance是否已经创建，保证只有单例并返回。
     * @return Singleton1
     */
    public static Singleton1 getInstance() {
        return instance == null ? instance = new Singleton1() : instance;
    }
}
/**
 * 2.使用锁，线程安全
 */
class Singleton2 {
    private static Singleton2 instance = null;
    private Singleton2() { }
    public static Singleton2 getInstance() {
        synchronized (Singleton2.class) {
            if(instance == null) {
                instance = new Singleton2();
            }
        }
        return instance;
    }
}
/**
 * 3.改进的锁，线程安全，仅在第一次实例化时候加锁
 */
class Singleton3 {
    private static Singleton3 instance = null;
    private Singleton3() {}
    public static Singleton3 getInstance() {
        if(instance == null)
            synchronized (Singleton3.class) {
                if(null == instance)
                    instance = new Singleton3();
            }
        return instance;
    }
}
/**
 * 4.将instance声明为volatile，防止编译器优化给调整顺序
 *  1).给 singleton 分配内存
 *  2).调用 Singleton 的构造函数来初始化成员变量，形成实例
 *  3).将singleton对象指向分配的内存空间（执行完这步 singleton才是非null了）
 * 若顺序调整为1-3-2，尚未执行2，其它线程可能会根据非null从而进行实例化
 * <strong>缺陷：通过反射调用构造方法</strong>
 *
 */
class Singleton4 {
    private static volatile Singleton4 instance = null;
    private Singleton4() {}
    public static Singleton4 getInstance() {
        if(instance == null)
            synchronized (Singleton4.class) {
                if(null == instance)
                    instance = new Singleton4();
            }
        return instance;
    }
}
/**
 * 类初始化，借助类初始化期间的互斥锁
 * 初始化发生在锁获取之后和创建实例之前
 */
class Singleton5 {
    private static class SingletonHolder {
        private static final Singleton5 instance = new Singleton5();
    }
    private Singleton5() {}
    public Singleton5 getInstance() {
        return SingletonHolder.instance;
    }
}
/**
 * 枚举版本，创建实例线程安全
 */
enum Singleton6 {
    INSTANCE;
}
/**单例模式：保证只有一个类的实例
 * 比较几种不同的构造方法，推荐使用枚举版本
 * Created by Kai on 2016/3/21.
 */
public class SingletonPattren {
    public static void main(String... args) {
        if(Singleton1.getInstance() != null)
            System.out.println("Succeed");
    }
}
