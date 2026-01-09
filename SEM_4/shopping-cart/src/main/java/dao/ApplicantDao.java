package dao;

import model.Applicant;
import model.Product;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicantDao {

    public ApplicantDao() {}

    public boolean insert(Applicant applicant) {
        String sql = "INSERT INTO applicant (name, status) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (conn == null) { throw new RuntimeException("Connection is null!"); }

            ps.setString(1, applicant.getName());
            ps.setInt(2, applicant.getStatus());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Applicant> getAll() {
        List<Applicant> list = new ArrayList<>();
        String sql = "SELECT * FROM applicant WHERE status = 1";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            if (conn == null) { throw new RuntimeException("Connection is null!"); }

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Applicant applicant = new Applicant();
                applicant.setId(rs.getInt("id"));
                applicant.setName(rs.getString("name"));
                applicant.setStatus(rs.getInt("status"));

                list.add(applicant);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM applicant WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void saveWinners(List<Applicant> winners) {
        String sql = "INSERT INTO winner (ticketId) VALUES (?)";
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                for (Applicant a : winners) {
                    ps.setInt(1, a.getId());
                    ps.addBatch();
                }
                ps.executeBatch();
                conn.commit();
            } catch (Exception e) { conn.rollback(); throw e; }
        } catch (Exception e) { e.printStackTrace(); }
    }



}
