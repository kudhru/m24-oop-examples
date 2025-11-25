import javax.swing.*;
import java.util.logging.Logger;

// Singleton.java
class Singleton {

    // 1. single instance created eagerly when class loads
    private static final Singleton INSTANCE = new Singleton();

    // 2. private constructor prevents external instantiation
    private Singleton() {
        // initialization code (if any)
    }

    // 3. global access point
    public static Singleton getInstance() {
        return INSTANCE;
    }

    // example method
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

// TestSingleton.java
public class TestSingleton {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        s1.showMessage();

        System.out.println(s1 == s2); // true (both references point to same object)
    }
}
