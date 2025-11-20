import java.util.ArrayList;
import java.util.List;

// Iterator Interface
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Collection Interface
interface IterableCollection<T> {
    Iterator<T> createIterator();
}

// Concrete Collection
class NameCollection implements IterableCollection<String> {
    private String[] names;
    private int size;

    public NameCollection(int capacity) {
        names = new String[capacity];
        size = 0;
    }

    public void addName(String name) {
        if (size < names.length) {
            names[size++] = name;
        }
    }

    @Override
    public Iterator<String> createIterator() {
        return new NameIterator();
    }

    // Concrete Iterator
    private class NameIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public String next() {
            String returnValue = names[index];
            index = index + 1;
            return returnValue;
        }
    }
}

class NameCollectionOne implements IterableCollection<String> {
    private List<String> names;
    private int size;

    public NameCollectionOne(int capacity) {
        names = new ArrayList<>(capacity);
        size = 0;
    }

    public void addName(String name) {
        if (size < names.size()) {
            names.add(name);
            size = size + 1;
        }
    }

    @Override
    public Iterator<String> createIterator() {
        return new NameIterator();
    }

    // Concrete Iterator
    private class NameIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public String next() {
            String returnValue = names.get(index);
            index = index + 1;
            return returnValue;
        }
    }
}
public class IteratorDemo2 {
    public static void main(String[] args) {
        NameCollection nameCollection = new NameCollection(5);
        nameCollection.addName("Alice");
        nameCollection.addName("Bob");
        nameCollection.addName("Charlie");

        Iterator<String> iterator = nameCollection.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        NameCollectionOne nameCollectionOne = new NameCollectionOne(5);
        nameCollectionOne.addName("Alice");
        nameCollectionOne.addName("Bob");
        nameCollectionOne.addName("Charlie");

        Iterator<String> iteratorOne = nameCollectionOne.createIterator();
        while (iteratorOne.hasNext()) {
            System.out.println(iteratorOne.next());
        }
    }
}