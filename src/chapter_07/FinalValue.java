package chapter_07;

class Kai {
    int v;
    public Kai(int v) {
        this.v = v;
    }
}
/**
 * 测试final方法和类在继承过程中的反应
 * @author KaiLee
 *
 */
final class FinalMethod {
    final public int f(final int i) {
        return i;
    }
}
/**
 * 测试final在属性，方法和类中的实际意义
 * @author KaiLee
 * @version 1.0 2016.01.17
 */
public class FinalValue {//extends FinalMethod	//The type FinalValue cannot subclass the final class FinalMethod
    private int v1 = 1;
    private final int v2 = 2;			//不能改变
    private static final int V3 = 3;	//所有类只能拥有一个且不能改变
    private Kai k1 = new Kai(5);
    private final Kai k2 = new Kai(6);	//引用不能改变，k2.i可以改变
    private static final Kai K3 = new Kai(7);
    /**
     * 测试final方法参数
     * @param i
     * @return
     */
    public int f(final int i) {	//extends FinalMethod. Cannot override the final method from FinalMethod.
        //i ++;	//The final local variable i cannot be assigned. It must be blank and not using a compound assignment
        return i + 1;
    }
    public static void main(String[] args) {
        FinalValue f = new FinalValue();
        //f.v2 = 3;	//the final field Final.v2 cannot be assigned
        f.k1 = new Kai(1);
        //f.k2 = new Kai(2);	//The final field Final.K2 cannot be assigned
        //f.K3 = new Kai(3);	//The final field Final.K3 cannot be assigned
        System.out.println(f.k1.v + " " + f.k2.v);
        f.k2.v = 5;
        System.out.println(f.k2.v);	//虽然f.k2的引用不能改变，但是引用的值可以变化。
    }
}
