package chapter_21;


/**多个消费者队列和生产者，使用synchronized实现
 * Created by KaiLee on 2016/3/28.
 */
public class MultiConsumerAndProductor {
    private final static int MAX_PRODUCT = 20;
    private static volatile int numProduct = 0;
}
