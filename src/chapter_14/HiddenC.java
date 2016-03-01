package chapter_14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Created by KaiLee on 2016/2/29.
 */
class C implements A {
    @Override
    public void f() { System.out.println("public C.f()"); }
    public void g() { System.out.println("public c.g()"); }
    void u() { System.out.println("package C.u()"); }
    protected  void v() { System.out.println("protected C.v()"); }
    private void w() { System.out.println("private C.w()"); }

    /**
     * 测试反射机制
     * Created by Kai on 2016/2/29.
     */

    public static class ShowMethods {
        private static String usage =
                "usage:\n" +
                        "ShowMethods qualified.class.name\n" +
                        "To show all methods in class or:\n" +
                        "ShowMethods qualified.class.name.word\n" +
                        "To search for Methods involving 'word'";
        private static Pattern p = Pattern.compile("\\w+\\.");
        public static void main(String[] args) {
            if(args.length < 1) {
                System.out.println(usage);
                System.exit(0);
            }
            System.out.println(args[0]);
            int lines = 0;
            try {
                Class<?> c = Class.forName(args[0]);
                Method[] methods = c.getMethods();
                Constructor[] ctors = c.getConstructors();
                if(args.length == 1) {
                    for(Method method : methods)
                        System.out.println(p.matcher(method.toString()).replaceAll(""));
                    for(Constructor ctor : ctors)
                        System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                    lines = methods.length +ctors.length;
                } else {
                    for(Method method : methods)
                        if(method.toString().indexOf(args[1]) != -1) {
                            System.out.println(p.matcher(method.toString()).replaceAll(""));
                            lines++;
                        }
                    for(Constructor ctor : ctors)
                        if(ctor.toString().indexOf(args[1]) != -1) {
                            System.out.println(p.matcher(methods.toString()).replaceAll(""));
                            lines++;
                        }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
public class HiddenC {
    public static A makeA() {
        return new C();
    }

    /**
     * 通过反射机制，类的方法一览无余，甚至是private方法
     * 通过javap -private Class 可以查看类的所有成员
     * 私有的内部类和和各种域（通过class.getDeclaredFiled）
     * Created by KaiLee on 2016/2/29.
     */
    public static class HiddenImplementation {
        static void callHiddenMethod(Object a, String methodName)
            throws Exception {
            Method g = a.getClass().getDeclaredMethod(methodName);
            g.setAccessible(true);
            g.invoke(a);
        }
        public static void main(String[] args) throws Exception {
            A a = makeA();
            a.f();
            System.out.println(a.getClass().getName());
            callHiddenMethod(a, "g");
            callHiddenMethod(a, "u");
            callHiddenMethod(a, "v");
            callHiddenMethod(a, "w");
        }
    }
}
