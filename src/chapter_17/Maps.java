package chapter_17;

import java.util.*;

/**
 * HashMap 性能最好，LinkedHashMap 插入有序，TreeMap 插入排序
 * Created by KaiLee on 2016/3/5.
 */
public class Maps {
    public static void main(String[] args) {
        String[] value = "updating your profile with your name and location and a profile picture helps other GitHub users get to know you".split(" ");
        Map<Integer, String> hashMap = new HashMap<>();
        for(String v : value) {
            hashMap.put(v.hashCode(), v);
        }
        //Iterator it = hashMap
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());
        Map<Integer, String> treeMap = new TreeMap<>();
        for(String v : value) {
            treeMap.put(v.hashCode(), v);
        }
        System.out.println(treeMap.keySet());
        System.out.println(treeMap.values());
        Map<Integer, String> linkedMap = new LinkedHashMap<>();
        for(String v : value) {
            linkedMap.put(v.hashCode(), v);
        }
        System.out.println(linkedMap);
        //How to Iterate Over a Map
        System.out.println("--------------直接使用entrySet");
        // 1.使用entry
        for(Map.Entry<Integer, String> entry : hashMap.entrySet())
            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
        System.out.println("--------------分别遍历keyset和values");
        // 2.分别遍历key和value
        for(Integer key : hashMap.keySet())
            System.out.println("key : " + key);
        for(String v : hashMap.values())
            System.out.println("value : " + v);
        System.out.println("--------------使用迭代器entryset.iterator");
        // 3.使用迭代器
        Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
        }
        System.out.println("--------------获取keyset，查找value");
        // 4.根据key查找value
        for(Integer i : hashMap.keySet()) {
            String v = hashMap.get(i);
            System.out.println("Key : " + i + ", Value : " + v);
        }
    }
}