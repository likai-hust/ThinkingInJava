package chapter_08;
class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }
    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}
class RoundGlyph extends Glyph {
    private int radius = 1;
    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }
    void draw() {
        System.out.println("RoundGlyph.draw, radius = " + radius);
    }
}
/**
 * 一个有趣的现象，说明构造器调用方法时，继承过程中发生的问题
 * @author KaiLee
 * @version 2016.01.20
 */
public class ConstructorCallMethod {

    public static void main(String[] args) {
        new RoundGlyph(5);
    }

} /* Output:
Glyph() before draw()
RoundGlyph.draw, radius = 0			//并非是5，由于属性的初始化后于构造函数调用
Glyph() after draw()
RoundGlyph.RoundGlyph(), radius = 5
*///

