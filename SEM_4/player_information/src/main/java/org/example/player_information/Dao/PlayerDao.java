package org.example.player_information.Dao;

import org.example.player_information.Model.Player;
import org.example.player_information.Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao {
        // Lấy thông tin 1 cầu thủ để đổ vào form Sửa
        public Player getById(int id) {
            String sql = "SELECT * FROM player WHERE id = ?";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Player p = new Player();
                        p.setId(rs.getInt("id"));
                        p.setName(rs.getString("name"));
                        p.setAge(rs.getInt("age"));
                        p.setIndexName(rs.getString("index_name"));
                        p.setValue(rs.getInt("value"));
                        return p;
                    }
                }
            } catch (Exception e) { e.printStackTrace(); }
            return null;
        }

        // Thêm mới hoặc Cập nhật cầu thủ
        public boolean save(Player p) {
            String sql;
            if (p.getId() > 0) {
                sql = "UPDATE player SET name=?, age=?, index_name=?, value=? WHERE id=?";
            } else {
                sql = "INSERT INTO player (name, age, index_name, value) VALUES (?, ?, ?, ?)";
            }

            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, p.getName());
                ps.setInt(2, p.getAge());
                ps.setString(3, p.getIndexName());
                ps.setInt(4, p.getValue());
                if (p.getId() > 0) ps.setInt(5, p.getId());

                return ps.executeUpdate() > 0; // Trả về true nếu thành công
            } catch (Exception e) { e.printStackTrace(); return false; }
        }

        // Xóa cầu thủ theo ID
        public boolean delete(int id) {
            String sql = "DELETE FROM player WHERE id = ?";
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                return ps.executeUpdate() > 0;
            } catch (Exception e) { e.printStackTrace(); return false; }
        }

    public List<Player> getAll() {
        List<Player> list = new ArrayList<>();
        // Câu lệnh SQL lấy toàn bộ dữ liệu từ bảng player
        String sql = "SELECT * FROM player";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (conn == null) throw new RuntimeException("Kết nối Database thất bại!");

            while (rs.next()) {
                Player p = new Player();
                // Ánh xạ dữ liệu từ ResultSet vào Object Player
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                p.setIndexName(rs.getString("index_name"));
                p.setValue(rs.getInt("value"));

                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    }

