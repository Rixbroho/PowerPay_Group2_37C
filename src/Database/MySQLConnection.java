package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/powerpay"; // replace with your DB
    private static final String USER = "root"; // replace with your username
    private static final String PASSWORD = "hellobrother123"; // replace with your password

    private static Connection connection = null;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connected successfully.");
        } catch (SQLException e) {
            System.out.println("❌ Failed to connect to the database.");
            System.out.println("Reason: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
