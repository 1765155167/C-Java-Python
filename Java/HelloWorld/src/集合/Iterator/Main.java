package 集合.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReverseList<String> reverseList = new ReverseList<String>();
        reverseList.add("AAA");
        reverseList.add("BBB");
        reverseList.add("CCC");
        for (var data:
             reverseList) {
            System.out.println(data);
        }
    }
}

class ReverseList<T> implements Iterable<T> {
    List<T> list = new ArrayList<>();

    public void add(T t) {
        list.add(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator(list.size());
    }

    class ReverseIterator implements Iterator <T> {

        public int index;

        public ReverseIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return (T) ReverseList.this.list.get(index);
        }
    }

}
