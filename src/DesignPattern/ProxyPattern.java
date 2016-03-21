package DesignPattern;

/**
 * 抽象对象角色
 */
abstract class AbstractObject {
    //操作
    public abstract void operation();
}
/**
 * 目标对象角色
 */
class RealObject extends AbstractObject {
    @Override
    public void operation() {
        System.out.println("真实角色操作");
    }
}
class ProxyObject extends AbstractObject {
    RealObject realObject = new RealObject();
    @Override
    public void operation() {
        System.out.println("befor");
        realObject.operation();
        System.out.println("after");
    }
}

/**
 * From:http://www.cnblogs.com/java-my-life/archive/2012/04/23/2466712.html
 * 三种角色：
 * 1.抽象对象角色：声明了目标对象和代理对象的共同接口，这样一来在任何可以使用目标对象的地方都可以使用代理对象。
 * 2.目标对象角色：定义了代理对象所代表的目标对象。
 * 3.代理对象角色：代理对象内部含有目标对象的引用，从而可以在任何时候操作目标对象；
 *   代理对象提供一个与目标对象相同的接口，以便可以在任何时候替代目标对象。
 *   代理对象通常在客户端调用传递给目标对象之前或之后，执行某个操作，而不是单纯地将调用传递给目标对象。
 * 总结：出代理对象将客户端的调用委派给目标对象，在调用目标对象的方法之前跟之后都可以执行特定的操作。
 * 要点：拥有<strong>相同</strong>的接口，可以相互<strong>替代</strong>，代理持有<strong>真实对象</strong>，可以操作真实对象，还可以在真实对象之前进行<strong>额外</strong>的操作。
 * Created by Kai on 2016/3/21.
 */
public class ProxyPattern {
    public static void main(String... args) {
        AbstractObject obj = new ProxyObject();
        obj.operation();
    }
}
