class Logger {
    // Static instance of the Logger class
    private static Logger instance;

    // Private constructor
    private Logger() {}

    // Public method to provide access to the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

// Testing the Logger Singleton
public class SingletonExample {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

//        Logger logger3 = new Logger();
//        Logger logger4 = new Logger();
//        Logger logger5 = new Logger();
        logger1.log("This is a test message.");

        // Verify that both instances are the same
        System.out.println(logger1 == logger2); // Output: true
    }
}
