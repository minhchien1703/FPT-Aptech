package org.example.player_information.Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL =
            "jdbc:mysql://localhost:3306/player_information?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "chien";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MYSQL DRIVER LOADED");

            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("CONNECTION TO DB SUCCESSFULLY");
            return conn;

        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy Driver MySQL! Hãy kiểm tra lại thư viện Jar.");
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối: Sai URL, User hoặc Password. Chi tiết: " + e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
