package chapter_03;
/**
 * 测试类
 * @author KaiLee
 *
 */
class Letter{
    char c;
}
/**
 * 测试类之间的引用传递
 * <em>1.传递基本类型，传递的是拷贝</em>
 * <em>2.传递类类型，传递的是引用</em>
 * @author KaiLee
 * @version 1.0 2016.01.16
 */
public class Reference {
    /**
     * 实现类的改变
     * @param t
     */
    public static void transClassAttribute(Letter t) {
        t.c = '0';
    }
    /**
     * 在方法中，实现Letter t == Letter x;
     * @param t
     */
    public static void transClass(Letter t) {
        Letter x = new Letter();
        x.c = 'c';
        t = x;
    }
    /**
     * 在方法中传递int，失败; 需要把int 包装成Integer
     * @param i
     */
    public static void transInt(int i) {
        i = 10;
    }
    public static void main(String[] args) {
        Letter t1 = new Letter();
        Letter t2 = new Letter();
        t1.c = '5';
        t2.c = '4';
        System.out.println("t1.level = " + t1.c + "\n" + "t2.level = " + t2.c);
        t1 = t2;
        t2.c = '1';
        System.out.println("t1.level = " + t1.c + "\n" + "t2.level = " + t2.c);
        Letter t = new Letter();
        t.c = 'b';
        System.out.println(t.c);
        transClassAttribute(t);
        System.out.println(t.c);
        transClass(t);
        System.out.println(t.c);
        int i = 5;
        transInt(i);
        System.out.println(i);
    }
}/* Output
t1.level = 5
t2.level = 4
t1.level = 1
t2.level = 1
b
0
0
5
*///
