package DesignPattern.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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
}
