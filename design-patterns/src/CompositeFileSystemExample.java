import java.util.ArrayList;
import java.util.List;

public class CompositeFileSystemExample {

    // ----- Component -----
    interface FileSystemNode {
        String getName();
        int getSize();          // size in KB (for simplicity)
        void print(String indent);
    }

    // ----- Leaf: File -----
    static class FileNode implements FileSystemNode {

        private final String name;
        private final int size; // in KB

        public FileNode(String name, int size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public int getSize() {
            return size;
        }

        @Override
        public void print(String indent) {
            System.out.println(indent + "- " + name + " (" + size + " KB)");
        }
    }

    // ----- Composite: Directory (can contain files and other directories) -----
    static class DirectoryNode implements FileSystemNode {

        private final String name;
        private final List<FileSystemNode> children = new ArrayList<>();

        public DirectoryNode(String name) {
            this.name = name;
        }

        public void add(FileSystemNode child) {
            children.add(child);
        }

        public void remove(FileSystemNode child) {
            children.remove(child);
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public int getSize() {
            // total size = sum of all children sizes
            int total = 0;
            for (FileSystemNode child : children) {
                total += child.getSize();
            }
            return total;
        }

        @Override
        public void print(String indent) {
            System.out.println(indent + "+ " + name + " [" + getSize() + " KB]");
            for (FileSystemNode child : children) {
                child.print(indent + "   ");
            }
        }
    }

    // ----- Client Demo -----
    public static void main(String[] args) {

        // Create some files (leaves)
        FileSystemNode file1 = new FileNode("resume.pdf", 120);
        FileSystemNode file2 = new FileNode("photo.jpg", 350);
        FileSystemNode file3 = new FileNode("notes.txt", 30);
        FileSystemNode file4 = new FileNode("presentation.ppt", 500);

        // Create directories (composites)
        DirectoryNode docs = new DirectoryNode("Documents");
        DirectoryNode images = new DirectoryNode("Images");
        DirectoryNode root = new DirectoryNode("Root");

        // Build tree
        docs.add(file1);
        docs.add(file3);
        images.add(file2);
        root.add(docs);
        root.add(images);
        root.add(file4); // file directly under root

        // Use the composite
        root.print(""); // prints full hierarchy
        System.out.println("\nTotal size of root: " + root.getSize() + " KB");
    }
}
