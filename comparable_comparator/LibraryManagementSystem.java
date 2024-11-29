import java.util.ArrayList;

public class LibraryManagementSystem {
    ArrayList<String> books = new ArrayList<>();
    LibraryManagementSystem() {
        books.add("Book 1");
        books.add("Book 2");
        books.add("Book 3");
    }

    void delete(String book) {
        books.remove(book);
    }

    public static void main(String[] args) {

    }
}
