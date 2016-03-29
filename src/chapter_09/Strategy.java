package chapter_09;

import java.util.Arrays;

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }
    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    @Override
    String process(Object input) {
        return ((String)input).toUpperCase();
    }
}
class Downcase extends Processor {
    @Override
    String process(Object input) {
        return ((String)input).toLowerCase();
    }
}
class Splitter extends Processor {
    @Override
    String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}
/**
 * <ul>
 * 	<li>策略设计模式</li>
 * </ul>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;策略模式把对象本身和运算规则区分开来，其功能非常强大，因为这个设计模式本身的核心思想就是面向对象编程的多形性的思想。<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;定义抽象策略：具体的策略实现这个抽象策略，客户端可以定义抽象策略的引用。实现不同策略
 * @author KaiLee
 * @version 1.0 2016/01/22
 */
public class Strategy {
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
    public static String s = "Disagreement with beliefs is by definition incorrect";
    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }

}
