package dao;

import jakarta.faces.context.PartialResponseWriter;
import model.Product;
import utils.DBConnection;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductDao {


    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            if (conn == null) {
                throw new RuntimeException("DB Connection is NULL!");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setCreateAt(rs.getTimestamp("createdAt").toLocalDateTime());

                products.add(product);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM product WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            if (conn == null) {
                throw new RuntimeException("DB connection is null");
            }

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }


    public void insert(Product p) {
        String sql = "INSERT INTO product (name, price, description, createdAt) VALUES (?, ?, ?, NOW())";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setString(3, p.getDescription());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void update(Product p) {
        String sql = "UPDATE product SET name=?, price=?, description=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setString(3, p.getDescription());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    // ProductDao.java
    public Product getById(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Product p = new Product();
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setPrice(rs.getDouble("price"));
                    p.setDescription(rs.getString("description"));
                    return p;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<Integer, Product> getAllPaged(int offset, int limit) {
        Map<Integer, Product> productMap = new LinkedHashMap<>();

        String sql = "SELECT * FROM product ORDER BY id DESC LINIT ? OFFSET ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            if (conn == null) { throw new RuntimeException("DB connection is null!"); }

        ps.setInt(1, limit);
        ps.setInt(2, offset);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
