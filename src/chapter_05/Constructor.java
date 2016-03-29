package chapter_05;
/**
 * 类的默认构造方法与用户定义构造方法
 * @author KaiLee
 * @version 1.0 2016.01.16
 */
public class Constructor {
    /**
     * 构造函数默认是：public, static.
     * @param i
     */
    Constructor(int i){
        System.out.println(i + "/第一个构造函数");
    }
    /**
     * 构造函数可以调用另一个构造函数，只能调用一个且出现在第一句
     * @param s
     * @param i
     */
    Constructor(String s, int i) {
        this(i);
        System.out.println(s + "/第二个构造函数");
    }
    public static void main(String[] args) {
        //Constructor b = new Constructor();	//false: The constructor Constructor() is undefined.
        @SuppressWarnings("unused")
        Constructor c = new Constructor(5);
        @SuppressWarnings("unused")
        Constructor d = new Constructor("Kai", 5);
    }
}/* Output
5/第一个构造函数
5/第一个构造函数
Kai/第二个构造函数
*///
