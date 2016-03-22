/**
 *
 * Created by Kai on 2016/3/22.
 */
public class StringTest {
    public static void main(String...args) {
        String s1 = "kai";                      //在字符串常量池创建一个字符串
        String s2 = new String("kai");          //在堆区常见字符串对象
        System.out.println(s1 == s2);
        String s3 = new String("kai").intern(); //先在字符串常量池中查询，存在则返回字符串常量区的引用，否则存入字符串常量池
        System.out.println(s1 == s3);           //

        String s4 = new String("2") + new String("2");
        s4.intern();
        String s5 = "22";
        System.out.println(s4 == s5);

        String s6 = new String("7");
        s6.intern();                            //返回常量区引用
        String s7 = "7";
        System.out.println(s6 == s7);
    }
}
