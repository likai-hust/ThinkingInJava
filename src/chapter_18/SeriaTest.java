package chapter_18;

import java.io.*;

/**
 * 实现Serializable接口，通过ObjectOut和ObjectIn流进行序列化操作
 * Created by KaiLee on 2016/3/7.
 */
class Person implements Serializable{
    public static int count = 0;
    public int age;
    public int high;
    public String name;
    public transient  String sex;   //transient可以屏蔽序列化某个域，从而防止通过反射/网络传输获取。
    public final int id = count++;
    public Person() {}
    public Person(int age, int high, String name, String sex) {
        this.age = age;
        this.high = high;
        this.name = name;
        this.sex = sex;
    }
    @Override
    public String toString() {

        return "id : " + id + ", " +
                "age : " + age + ", " +
                "high : " + high + "cm, " +
                "name : " + name + ", " +
                "sex : " + sex;
    }
}
public class SeriaTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("D:/person.obj"));
        out.writeObject(new Person(23, 170, "Kai Lee", "male"));
        out.writeObject(new Person(24, 174, "Yanan Zhao", "female"));
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:/person.obj"));
        Person kai = (Person) in.readObject();
        Person nan = (Person) in.readObject();
        System.out.println(kai);
        System.out.println(nan);
    }
}
