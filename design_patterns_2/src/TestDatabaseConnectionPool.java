import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseConnectionPool {
    // Static instance of the class
    private static DatabaseConnectionPool instance;
    private Connection connection;

    // Private constructor to prevent multiple instantiations
    private DatabaseConnectionPool() {
        try {
            // Example database URL, username, and password
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password = "password";

            // Create a connection
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Public method to provide access to the instance
    public static DatabaseConnectionPool getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionPool();
        }
        return instance;
    }

    // Method to get the connection
    public Connection getConnection() {
        return connection;
    }
}

// Testing the DatabaseConnectionPool Singleton
public class TestDatabaseConnectionPool {
    public static void main(String[] args) {
        DatabaseConnectionPool pool1 = DatabaseConnectionPool.getInstance();
        DatabaseConnectionPool pool2 = DatabaseConnectionPool.getInstance();

        // Verify the same instance is used
        System.out.println(pool1 == pool2); // Output: true

        // Get the connection and use it
        Connection connection = pool1.getConnection();
        if (connection != null) {
            System.out.println("Connection established!");
        } else {
            System.out.println("Failed to establish connection.");
        }
    }
}
