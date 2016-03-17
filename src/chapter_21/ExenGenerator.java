package chapter_21;
import chapter_21.EvenChecker;
/**
 * Created by KaiLee on 2016/3/12.
 */
public class ExenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    public synchronized int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String... args) {
        EvenChecker.test(new ExenGenerator());
    }
}