package chapter_17;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class SetType {
    int i;
    public SetType(int i) {
        this.i = i;
    }
    public boolean equals(Object obj) {
        return obj instanceof SetType && (i == ((SetType)obj).i);
    }
    public String toString() {
        return Integer.toString(i);
    }
}
//实现了代表其唯一性的hashcode
class HashType extends SetType {
    public HashType(int i) {
        super(i);
    }
    public int hashCode() {
        return i;
    }
}
//实现了compareble接口，从而可以产生排序的set
class TreeType extends SetType
implements Comparable<TreeType> {
    public TreeType(int i) {
        super(i);
    }
    public int compareTo(TreeType arg) {
        return (arg.i < i ? -1 : (arg.i == i ? 0 : 1));
    }
}
/**
 * Created by KaiLee on 2016/3/5.
 */
public class TypesForSet {
    static <T> Set<T> fill(Set<T> set, Class<T> type) {
        try {
            for(int i = 0; i < 10; i++) {
                set.add(type.getConstructor(int.class).newInstance(i));
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return set;
    }
    static <T> void test(Set<T> set, Class<T> type) {
        fill(set, type);
        fill(set, type);
        fill(set, type);
        System.out.println(set);
    }
    public static void mian(String[] args) {
        //三种set类型，hash，tree，link
        test(new HashSet<HashType>(), HashType.class);      //唯一
        test(new LinkedHashSet<HashType>(), HashType.class);//插入有序
        test(new TreeSet<TreeType>(), TreeType.class);      //排序
        //
        test(new HashSet<SetType>(), SetType.class);        //未覆盖hashcode，使用obj的hashcode，插入不唯一
        test(new HashSet<TreeType>(), TreeType.class);      //未覆盖hashcode，使用obj的hashcode，插入不唯一
        test(new LinkedHashSet<SetType>(), SetType.class);  //插入仍然有序
        test(new LinkedHashSet<TreeType>(), TreeType.class);//插入仍然有序
    }
 }
