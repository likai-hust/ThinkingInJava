package chapter_14;

/**
 * 透过类型信息，可以发现接口的耦合性。
 * Created by KaiLee on 2016/2/29.
 */
interface A {
    void f();
}
 class B implements  A {
     @Override
    public void f() {}
    public void g() {}
}
public class InterfaceViolation {
    public static void main(String args[]) {
        A a = new B();
        a.f();
        System.out.println(a.getClass().getName());
        if(a instanceof B) {
            //a被当作B去实现，并转型后可以调用B的方法，此时需要将C当作包访问权限去实现
            B b = (B)a;
            b.g();
        }
    }
}
