package chapter_05;
/**
 * 测试类中static的初始化时机
 * @author KaiLee
 *
 */
class Test1 {
    public static int i;
    Test1() {
        System.out.println("constructor of test1.");
    }
    Test1(int i) {
        System.out.println("constructor of test1. i = " + i);
    }
}
class Test2 extends Test1{
    static Test1 test1 = new Test1(3);
    private int i;
    Test2() {
        System.out.println("construct of test2.");
    }
    Test2(int i) {
        System.out.println("constructor of test2. i = " + i);
    }
    static Test1 test12 = new Test1(4);
}
public class Static {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test1 t1_1 = new Test1(5);
        t1_1.i = 5;
        Test1 t1_2 = new Test1();
        System.out.println("test1.i: " + t1_1.i);
        System.out.println("test2.i: " + t1_2.i);
        System.out.println("----------------------");
        Test2 t2_1 = new Test2(5);
        Test2 t2_2 = new Test2();
    }
}/* Output:
constructor of test1. i = 5	//test1 t1的构造方法
constructor of test1.		//test1 t2的空构造方法
test1.i: 5					//
test2.i: 5					//t1和t2共用静态变量i
----------------------
constructor of test1. i = 3	//定义的第一个静态变量 test1类
constructor of test1. i = 4	//定义的第二个静态变量 test1类
constructor of test2. i = 5	//test2 的构造方法
							//类初始化时，静态 方法/变量 先于构造方法执行
*///: ~