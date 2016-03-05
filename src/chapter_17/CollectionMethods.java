package chapter_17;

import java.util.*;
import java.util.List;

/**
 * 练习Collection的功能方法
 * Created by KaiLee on 2016/3/2.
 */
public class CollectionMethods {
    public static void main(String[] args) {
        List<String> data = new ArrayList<String>();
        for(int i = 0; i < 10; i++)
            data.add(new String(new char[]{(char) ('A' + i), (char) ('a' + i)}));
        Collection<String> c = new ArrayList<String>();
        c.addAll(data);
        System.out.println(c);

        Iterator<String> it = c.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
