package internetMarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionUtils {

    public static final String URL = "jdbc:mysql://localhost:3306/lesson11";
    public static final String USER = "root";
    public static final String PASSWORD = "pass_mySQL";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
