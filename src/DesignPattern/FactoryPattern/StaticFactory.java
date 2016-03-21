package DesignPattern.FactoryPattern;

interface Car {
    public void printType();
}
class Jeep implements Car {
    @Override
    public void printType() {
        System.out.println("Product a Jeep");
    }
}
class Suv implements Car {
    @Override
    public void printType() {
        System.out.println("Product a Suv");
    }
}
/**
 * 简单工厂模式，有三个角色
 *  1.工厂（Creator）角色:
 *      简单工厂模式的核心，它负责实现创建所有实例的内部逻辑。工厂类的创建产品类的方法可以被外界直接调用，创建所需的产品对象。
 *  2.抽象产品（Product）角色：
 *      简单工厂模式所创建的所有对象的父类，它负责描述所有实例所共有的公共接口。
 *  3.具体产品（Concrete Product）角色：
 *      是简单工厂模式的创建目标，所有创建的对象都是充当这个角色的某个具体类的实例。
 * 使用：实现不同的产品继承自抽象产品，根据静态方法接受的参数创建具体产品。
 * 缺点：违反开闭原则（对扩展开放、对修改关闭），每增加一种车，就要在静态方法中去修改代码
 * Created by Kai on 2016/3/21.
 */
public class StaticFactory {
    public static Car createCar(String carType) {
        switch (carType) {
            case "Jeep" :
                return new Jeep();
            case "Suv" :
                return new Suv();
            default:
                return null;
        }
    }
    public static void main(String... args) {
        Car car1 = StaticFactory.createCar("Jeep");
        car1.printType();
        Car car2 = StaticFactory.createCar("Suv");
        car2.printType();
    }
}
