package chapter_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 产品类
 */
class Goods {
    //生产者缓冲区最大值
    final static int MAX_GOODS = 20;
    final static int MAX_TIMES = 50;
    private static int times = 0;
    private static int goods = 0;
    private Goods() {}
    private static class SingletonHolder {
        private static final Goods instance = new Goods();
    }
    static Goods getSingleton() {
        //获取产品单例
        return SingletonHolder.instance;
    }
    void productGoods() {
        //产品递增
        times++;
        goods++;
    }
    void consumerGoods() {
        //产品递减
        goods--;
    }
    int getGoodsNum() {
        return goods;
    }
    int getProductTimes() {
        return times;
    }
}

/**
 * 生产者类
 */
class Producer implements Runnable{
    private ConsumerAndProducer factory;
    Producer(ConsumerAndProducer factory) {
        this.factory = factory;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (Goods.getSingleton().getGoodsNum() >= Goods.MAX_GOODS)
                        wait();
                }
                //由于只有一个生产者，所以不用加锁
                if(Goods.getSingleton().getProductTimes() >= Goods.MAX_TIMES)
                    factory.exec.shutdownNow();
                synchronized (factory.consumer) {
                    //暂停一秒，模拟生产过程
                    TimeUnit.MILLISECONDS.sleep(1000);
                    Goods.getSingleton().productGoods();
                    System.out.println("生产完毕，共有：" + Goods.getSingleton().getGoodsNum() +
                            "件产品，产品id：" + Goods.getSingleton().getProductTimes());
                    factory.consumer.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted");
        }
    }
}

/**
 * 消费者类
 */
class Consumer implements Runnable{
    private ConsumerAndProducer factory;
    Consumer(ConsumerAndProducer factory) {
        this.factory = factory;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (Goods.getSingleton().getGoodsNum() <= 0)
                        wait();
                }
                synchronized (factory.producer) {
                    //暂停一秒，模拟消费过程
                    TimeUnit.MILLISECONDS.sleep(500);
                    Goods.getSingleton().consumerGoods();
                    System.out.println("消费完毕，共有：" + Goods.getSingleton().getGoodsNum() + "件产品");
                    factory.producer.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted.");
        }
    }
}
/**消费者和生产者，有缓冲区，使用synchronized实现
 * Created by KaiLee on 2016/3/28.
 */
public class ConsumerAndProducer {
    Producer producer = new Producer(this);
    Consumer consumer = new Consumer(this);
    ExecutorService exec = Executors.newCachedThreadPool();
    ConsumerAndProducer() {
        exec.execute(producer);
        exec.execute(consumer);
    }
    public static void main(String...args) {
        new ConsumerAndProducer();
    }
}