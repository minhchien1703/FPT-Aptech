package dao;

import model.NationalModel;
import model.PlayerModel;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NationalDao {

    public boolean insertNewNational(NationalModel national) {
        try {
            Connection conn = DBUtil.getMySqlConnection();
            PreparedStatement preparedStatement
                    = conn.prepareStatement("INSERT INTO `national`(`NationalName`) VALUES (?)");

            preparedStatement.setString(1, national.getNationalName());
            int result = preparedStatement.executeUpdate();

            if(result > 0) {
                conn.close();
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteNationalById(int id) {
        try {
            Connection conn = DBUtil.getMySqlConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM `national` WHERE `NationalId` = ?");
            stmt.setInt(1, id);
            int rowAffected = stmt.executeUpdate();
            return rowAffected > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
