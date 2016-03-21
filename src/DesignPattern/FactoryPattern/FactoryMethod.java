package DesignPattern.FactoryPattern;

/**
 * 抽象工厂
 */
interface Factory {
    public Product create();
}
/**
 * 具体工厂：Bread工厂
 */
class BreadFactory implements Factory {
    @Override
    public Product create() {
        return new Bread();
    }
}
/**
 * 具体工厂：Cake工厂
 */
class CakeFactory implements Factory {
    @Override
    public  Product create() {
        return new Cake();
    }
}
/**
 * 抽象产品
 */
interface Product {
    public void printType();
}
/**
 * 具体产品：Bread
 */
class Bread implements Product {
    @Override
    public void printType() {
        System.out.println("I am Bread.");
    }
}

/**
 * 具体产品：Cake
 */
class Cake implements Product {
    @Override
    public void printType() {
        System.out.println("I am cake.");
    }
}
/**
 * 工厂方法：4个角色,定义一个用于创建对象的接口，让子类决定实例化哪一个类.
 * 1、抽象工厂角色：这是工厂方法模式的核心，它与应用程序无关。是具体工厂角色必须实现的接口或者必须继承的父类。
 * 2、具体工厂角色：它含有和具体业务逻辑有关的代码。由应用程序调用以创建对应的具体产品的对象。
 * 3、抽象产品角色：它是具体产品继承的父类或者是实现的接口。
 * 4、具体产品角色：具体工厂角色所创建的对象就是此角色的实例。
 * 总结：完全实现‘开－闭 原则’，实现了可扩展。其次更复杂的层次结构，可以应用于产品结果复杂的场合。一个抽象工厂，一个抽象产品。 　
 * Created by Kai on 2016/3/21.
 */
public class FactoryMethod {
    public static void main(String... args) {
        Factory factory1 = new BreadFactory();
        Product product = factory1.create();
        product.printType();
        Factory factory2 = new CakeFactory();
        Product product2 = factory2.create();
        product2.printType();
    }
}
