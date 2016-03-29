package chapter_10;
/**
 * 访问内部类
 * @author KaiLee
 * @version 2016.01.22
 */
public class VisitInnerClass {
    private String kai = "kai";
    class Contents {
        private int i = 1;
        public int value() {
            return i;
        }
    }
    class Destination {
        private String label;
        public Destination(String whereTo) {
            //内部类默认拥有kai的访问权
            label = whereTo + kai;
        }
        String readLabel() {
            return label;
        }
    }
    public Destination to(String s) {
        return new Destination(s);
    }
    public Contents contents() {
        return new Contents();
    }
    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        VisitInnerClass vClass = new VisitInnerClass();
        vClass.ship("HaHa");
        VisitInnerClass vClass2 = new VisitInnerClass();
        //可以通过.new创建内部类
        VisitInnerClass.Contents c = vClass.new Contents();
        VisitInnerClass.Destination d = vClass2.to("LaLa");
    }
}
