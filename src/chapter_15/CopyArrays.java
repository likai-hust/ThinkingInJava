package chapter_15;

import java.util.Arrays;

public class CopyArrays {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 100);
        System.out.println("i = " + Arrays.toString(i));
        System.out.println("j = " + Arrays.toString(j));
        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println("j = " + Arrays.toString(j));
        Integer[] u = new Integer[10];
        Integer[] v = new Integer[5];
        Arrays.fill(u, new Integer(48));
        Arrays.fill(v, new Integer(100));
        System.out.println("u = " + Arrays.toString(u));
        System.out.println("v = " + Arrays.toString(v));
        System.arraycopy(v, 0, u, 0, v.length);
        System.out.println("u = " + Arrays.toString(u));
     }
} /*Output
i = [47, 47, 47, 47, 47, 47, 47]
j = [100, 100, 100, 100, 100, 100, 100, 100, 100, 100]
j = [47, 47, 47, 47, 47, 47, 47, 100, 100, 100]
u = [48, 48, 48, 48, 48, 48, 48, 48, 48, 48]
v = [100, 100, 100, 100, 100]
u = [100, 100, 100, 100, 100, 48, 48, 48, 48, 48]   //ǳ������ֻ����������
*/
