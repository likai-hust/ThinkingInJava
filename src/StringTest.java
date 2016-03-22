/**
 *
 * Created by Kai on 2016/3/22.
 */
public class StringTest {
    public static void main(String...args) {
        String s1 = "kai";                      //在字符串常量池创建一个字符串
        String s2 = new String("kai");          //在堆区常见字符串对象
        System.out.println(s1 == s2);           //false
        String s3 = new String("kai").intern(); //先在字符串常量池中查询，存在则返回字符串常量区的引用，否则存入字符串常量池
        System.out.println(s1 == s3);           //true

        //由于字符串常量池没有"22"，是将 s3中的“11”字符串放入 String 常量池中，因为此时常量池中不存在“11”字符串，
        // 因此常规做法是跟 jdk6 图中表示的那样，在常量池中生成一个 “11″ 的对象，关键点是 jdk7 中常量池不在 Perm
        // 区域了，这块做了调整。常量池中不需要再存储一份对象了，可以直接存储堆中的引用。这份引用指向 s3 引用的对象。
        //总结：此时字符串常量区存放的是堆区的引用。
        // 也就是说引用地址是相同的。
        String s4 = new String("2") + new String("2");
        s4.intern();
        String s5 = "22";
        System.out.println(s4 == s5);           //输出true
        //创建两份，一个保存在堆区，一个保存在常量池。
        String ss1 = new String("5");
        ss1.intern();                           //检查常量池是否存在
        String ss2 = "5";
        System.out.println(ss1 == ss2);         //实质比较堆区的ss1和常量池区的ss2
        String s6 = new String("7");
        s6.intern();                            //返回常量区引用
        String s7 = "7";
        System.out.println(s6 == s7);
    }
}
