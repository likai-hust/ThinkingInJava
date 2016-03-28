package JSE8;

/**
 * Created by KaiLee on 2016/3/12.
 */
public interface DefaultMethodInterface {
    //接口默认方法
    default void PrintObj() {
        System.out.println(this.getClass().getSimpleName());
    }
    //void print();
}