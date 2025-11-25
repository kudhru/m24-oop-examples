public class IteratorWithoutPattern {

    static class NameCollection {
        private String[] names = new String[10];
        private int size = 0;

        public void add(String name) {
            if (size < names.length) {
                names[size++] = name;
            }
        }

        // BAD: exposes internal array
        public String[] getNames() {
            return names;
        }

        public int getSize() {
            return size;
        }
    }

    public static void main(String[] args) {
        NameCollection collection = new NameCollection();
        collection.add("Alice");
        collection.add("Bob");
        collection.add("Charlie");

        // Client must know:
        // - that names are stored in an array
        // - to use size, and ignore nulls after size
        String[] data = collection.getNames();
        for (int i = 0; i < collection.getSize(); i++) {
            System.out.println(data[i]);
        }
    }
}
