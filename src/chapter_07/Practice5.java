package chapter_07;

class A {
    A() {
        System.out.println("constructor of A.");
    }
    public void f() {
        System.out.println("A");
    }
}
class B {
    B() {
        System.out.println("constructor of B.");
    }
    public void f() {
        System.out.println("A");
    }
}
class C extends A {
    B b = new B();
    @Override	//若使用f(int i)，提示出错
    //The method f(int) of type C must override or implement a supertype method
    public void f() {
        System.out.println("C");
    }
}
public class Practice5 {

    public static void main(String[] args) {
        C c = new C();
        c.f();
    }
} /* Output
constructor of A.	//A()被调用了
constructor of B.
C					//覆盖的时候最好使用override，避免发生重载
*///
