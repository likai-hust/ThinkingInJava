package JSE8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by KaiLee on 2016/3/19.
 */
public class TestStream {
    public static void printInt(int... args) {
        for(int i : args)
            System.out.println(i);
    }
    public static void main(String... args) {
        List<String> contents = Arrays.asList("I am a pig, sadj asfjjk lkas afds".split(" "));
        long count = contents.stream().filter(w -> w.length() > 3).count();
        System.out.println(count);
        printInt(new int[] {1,2,3,4});
    }
}
