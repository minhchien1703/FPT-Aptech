package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static String url = "jdbc:mysql://localhost:3306/herogame";
    static String username = "root";
    static String password = "";

    // Phương thức để lấy kết nối MySQL
    public static Connection getMySqlConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Lỗi khi kết nối tới cơ sở dữ liệu: " + e.getMessage());
        }
        return conn;
    }
}
