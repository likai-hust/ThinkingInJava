package JSE8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by KaiLee on 2016/3/12.
 */
public class Lambda {
    public static void main(String... args) {
        List<String> s = Arrays.asList("wo shi yi ge er bi".split(" "));
        s.forEach(c -> System.out.println(c));
    }
}
