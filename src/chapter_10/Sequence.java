package chapter_10;

interface Selector {
    boolean end();
    Object current();
    void next();
}
/**
 * 内部类的“迭代器”设计模式
 * @author KaiLee
 * @verison 2016.01.23
 */
public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size)
    {
        items = new Object[size];
    }
    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean end() {
            // TODO Auto-generated method stub
            return i == items.length;
        }

        @Override
        public Object current() {
            // TODO Auto-generated method stub
            return items[i];
        }

        @Override
        public void next() {
            // TODO Auto-generated method stub
            if(i < items.length)
                i++;
        }

    }
    public Selector selector() {
        return new SequenceSelector();
    }
    public static void main(String args[]) {
        Sequence sequence = new Sequence(10);
        for(int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }
    }
}
