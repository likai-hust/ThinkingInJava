package DesignPattern.ProxyPattern;

import java.lang.reflect.*;

interface Interface {
    void doSomething();
    void somethingElse(String arg);
}
class RealObject1 implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }
    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}
class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if(args != null)
            for(Object arg : args)
                System.out.println(" " + arg);
        return method.invoke(proxied, args);
    }
}
/**
 * 动态代理：动态的创建代理，动态的处理所代理方法的调用。
 * Created by Kai on 2016/3/22.
 */
public class DynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("kaikai");
    }
    public static void main(String... args) {
        RealObject1 real = new RealObject1();
        consumer(real);
        Interface proxy = (Interface) java.lang.reflect.Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{ Interface.class},
                new DynamicProxyHandler(real));
        consumer(real);
    }
}
