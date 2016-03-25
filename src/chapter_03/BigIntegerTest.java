package chapter_03;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by KaiLee on 2016/3/25.
 */
public class BigIntegerTest {
    public static void main(String... args) {
        BigInteger a;
        BigInteger b;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextBigInteger();
        b = scanner.nextBigInteger();
        System.out.println(a.multiply(b));
    }
}
