package dao;

import model.PlayerModel;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao {

    public List<PlayerModel> getAllPlayers() {
        List<PlayerModel> list = new ArrayList<>();
        try {
            Connection conn = DBUtil.getMySqlConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `PlayerId`, `NationalId`, `PlayerName`, `HighScore`, `Level` FROM `player`");

            while (rs.next()) {
                int playerId = rs.getInt(1);
                int nationalId = rs.getInt(2);
                String playerName = rs.getString(3);
                int highCore = rs.getInt(4);
                int level = rs.getInt(5);

                list.add(new PlayerModel(playerId, nationalId, playerName, highCore, level));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public boolean insertNewPlayer(PlayerModel player) {
        try {
            Connection conn = DBUtil.getMySqlConnection();
            PreparedStatement preparedStatement
                    = conn.prepareStatement("INSERT INTO player (NationalId ,  PlayerName, HighScore, Level) " +
                    "VALUES (?,?,?,?)");

            preparedStatement.setInt(1, player.getNationalId());
            preparedStatement.setString(2, player.getPlayerName());
            preparedStatement.setInt(3, player.getHighScore());
            preparedStatement.setInt(4, player.getLevel());
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

    public boolean deletePlayerById(int id) {
        try {
            Connection conn = DBUtil.getMySqlConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM `player` WHERE `playerId` = ?");
            stmt.setInt(1, id);
            int rowAffected = stmt.executeUpdate();
            return rowAffected > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public PlayerModel getPlayerByName(String name) {
        try {
            Connection conn = DBUtil.getMySqlConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT `PlayerId`, `NationalId`, `PlayerName`, `HighScore`, `Level` FROM `player` WHERE `playerName` = ?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs != null && rs.next()) {
                int playerIdId = rs.getInt("PlayerId");
                int nationalId = rs.getInt("NationalId");
                String pName = rs.getString("PlayerName");
                int highScore = rs.getInt("HighScore");
                int level = rs.getInt("level");
                conn.close();
                return new PlayerModel(playerIdId, nationalId,pName, highScore,level);
            } else {
                System.out.println("Does not exist !");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
