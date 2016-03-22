package DesignPattern.FactoryPattern;

/**
 * 抽象工厂角色
 */
interface AFactory {
    public SmallCar createProduct1();
    public BigCar createProduct2();
}
/**
 * 抽象产品角色1
 */
interface SmallCar {
    public void printType();
}
/**
 * 抽象产品角色2
 */
interface BigCar {
    public void printType();
}
/**
 * 真实产品角色1
 */
class Scooter implements SmallCar {
    @Override
    public void printType() {
        System.out.println("Scooter");
    }
}
/**
 * 真实产品角色2
 */
class MiniBus implements BigCar {
    @Override
    public void printType() {
        System.out.println("MiniBus");
    }
}
/**
 * 真实工厂角色
 */
class RealFactory implements AFactory {
    @Override
    public SmallCar createProduct1() {
        //生产大型车
        return new Scooter();
    }
    @Override
    public BigCar createProduct2() {
        //生产小型车
        return new MiniBus();
    }
}
/**
 * 抽象工厂：创建多个产品的等级结构
 * 1.角色同工厂方法中的角色，不同：具有多个抽象产品角色，用于创建一个产品族。
 * 优点：工厂方法更一般的形式。
 * 缺点：增加一类产品时候要修改多个工厂
 * Created by Kai on 2016/3/21.
 */
public class AbstractFactory {
    public static void main(String... args) {
        AFactory factory = new RealFactory();
        factory.createProduct1().printType();
        factory.createProduct2().printType();
    }
}
