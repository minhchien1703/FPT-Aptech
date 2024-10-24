package transactions;

import com.mysql.cj.xdevapi.DocResultImpl;

import java.sql.*;


public class Main {

    public static Connection getConn() {
        String url = "jdbc:mysql://localhost:3306/employees_transactions?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "";

        Connection conn;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username, password);
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public static void main(String[] args) {

        try {
            Connection conn = getConn();
            PreparedStatement pstmtSubtractMoney
            = conn.prepareStatement("UPDATE employees SET income = income - ? WHERE emp_id = ?"  );
            pstmtSubtractMoney.setInt(1, 1000000);
            pstmtSubtractMoney.setInt(2, 1);
            PreparedStatement pstmtSumMoney
            = conn.prepareStatement("UPDATE employees SET income = income + ? WHERE emp_id = ?" );
            pstmtSumMoney.setInt(1, 100000);
            pstmtSumMoney.setInt(2, 2);

            conn.setAutoCommit(false);

            int result = pstmtSubtractMoney.executeUpdate();

            if (result == 1) {
                pstmtSumMoney.executeUpdate();
                conn.commit();
                System.out.println("OKKKKKKKKKK !");
            } else {
                conn.rollback();
                System.out.println("FAILSSSSSSSSS !");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}
