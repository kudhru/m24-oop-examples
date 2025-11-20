// Singleton class
class DatabaseConnection {

    // Private static instance of the class
    private static DatabaseConnection instance;

    // Private constructor to prevent external instantiation
    private DatabaseConnection() {
        System.out.println("DatabaseConnection instance created.");
        // Simulate some initialization work
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Public static method to get the single instance of the class
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Example method to demonstrate functionality
    public void connect() {
        System.out.println("Connected to the database.");
    }

    // Prevent cloning
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of Singleton is not allowed.");
    }
}

//Demo class
public class SingletonDemo {
	
 public static void main(String[] args) {
     System.out.println("--- Singleton Pattern Demo ---");

     // Get the first instance
     DatabaseConnection connection1 = DatabaseConnection.getInstance();
     connection1.connect();

     // Get the second instance
     DatabaseConnection connection2 = DatabaseConnection.getInstance();
     connection2.connect();

     // Verify that both references point to the same instance
     if (connection1 == connection2) {
         System.out.println("Both 'connection1' and 'connection2' refer to the same instance.");
     } else {
         System.out.println("Error: Multiple instances of DatabaseConnection were created.");
     }

     // Attempt to clone (will throw CloneNotSupportedException)
     try {
         // DatabaseConnection connection3 = (DatabaseConnection) connection1.clone(); // This line will cause a compilation error if not handled
         System.out.println("Attempting to clone the singleton instance...");
         Object clonedObject = connection1.clone();
         // This line will not be reached if CloneNotSupportedException is thrown
     } catch (CloneNotSupportedException e) {
         System.out.println("Caught expected exception: " + e.getMessage());
     }
 }
}