package connect_db.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    static String url = "jdbc:mysql://localhost:3306/java_connect_demo?useSSL=false&serverTimezone=UTC";
    static String username = "root";
    static String password = "";

    public static Connection getMySqlConnection() {
        try {
            //1. Register library
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2. create Connection
            Connection conn  = DriverManager.getConnection(url, username, password);

            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
