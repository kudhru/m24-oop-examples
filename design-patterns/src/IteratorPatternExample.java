public class IteratorPatternExample {

    // ----- Iterator interface (our own, simplified) -----
    interface MyIterator<T> {
        boolean hasNext();
        T next();
    }

    // ----- Aggregate / Collection -----
    static class NameCollection {

        private String[] names = new String[10];
        private int size = 0;

        public void add(String name) {
            if (size < names.length) {
                names[size++] = name;
            }
        }

        // Factory method to create an iterator
        public MyIterator<String> iterator() {
            return new NameIterator();
        }

        // Inner class: concrete iterator over NameCollection
        private class NameIterator implements MyIterator<String> {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public String next() {
                return names[index++];
            }
        }
    }

    // ----- Client code -----
    public static void main(String[] args) {

        NameCollection collection = new NameCollection();
        collection.add("Alice");
        collection.add("Bob");
        collection.add("Charlie");

        // Client knows NOTHING about arrays, size, etc.
        MyIterator<String> it = collection.iterator();

        while (it.hasNext()) {
            String name = it.next();
            System.out.println(name);
        }
    }
}
