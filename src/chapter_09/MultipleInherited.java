package chapter_09;
interface A {
    void printA();
}
interface B {
    void printB();
}
/**
 * 通过接口实现多重继承，则可以同时创建两种接口的类型。
 * @author KaiLee
 * @version 2016.01.22
 */
public class MultipleInherited implements A, B {

    @Override
    public void printB() {
        System.out.println(this.getClass().getSimpleName() + " B");
    }

    @Override
    public void printA() {
        System.out.println(this.getClass().getSimpleName() + " A");
    }

    public static void main(String args[]) {
        A a = new MultipleInherited();
        B b = new MultipleInherited();
        MultipleInherited mInherited = new MultipleInherited();
        a.printA();
        b.printB();
        mInherited.printA();
        mInherited.printB();

    }
}
