package Krish.src.MultiThreading;

public class Singleton {
    static void main() {
        // Get the single instance of DatabaseConnection
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        connection1.connect();

        // Try to get another instance
        DatabaseConnection connection2 = DatabaseConnection.getInstance();

        // Verify that both variables point to the exact same object in memory
        if (connection1 == connection2) {
            System.out.println("Success: Both references point to the same instance.");
        }
    }

    static class DatabaseConnection {
        // 1. Private static variable to hold the single instance.
        // The 'volatile' keyword ensures changes are visible across threads.
        private static volatile DatabaseConnection instance;

        // 2. Private constructor to prevent direct instantiation using 'new'
        private DatabaseConnection() {
        }

        // 3. Public static method to provide the global access point
        public static DatabaseConnection getInstance() {
            // First check (no locking) for performance
            if (instance == null) {
                // Synchronize on the class level to prevent concurrent initialization
                synchronized (DatabaseConnection.class) {
                    // Second check (with locking) to ensure only one thread creates it
                    if (instance == null) {
                        instance = new DatabaseConnection();
                    }
                }
            }
            return instance;
        }

        // Example behavior method
        public void connect() {
            String connectionUrl = "jdbc:mysql://localhost:3306/mydb";
            System.out.println("Connecting to: " + connectionUrl);
        }
    }
}