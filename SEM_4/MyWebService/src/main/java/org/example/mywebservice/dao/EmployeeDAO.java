package org.example.mywebservice.dao;

import org.example.mywebservice.dao.dto.*;
import org.example.mywebservice.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public List<res> getAllEmployees() {
        List<res> list = new ArrayList<>();
        String sql = "SELECT * FROM Employee";

        try (Connection conn = dao.DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                res emp = new res();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setSalary(rs.getDouble("salary"));
                list.add(emp);
            }
        } catch (Exception ex) {
            System.out.println("Lỗi DAO getAllEmployees: " + ex.getMessage());
        }
        return list;
    }

    public boolean addEmployee(req e) {
        String sql = "INSERT INTO Employee(id, name, salary) VALUES (?, ?, ?)";

        try (Connection conn = dao.DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setDouble(3, e.getSalary());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (Exception ex) {
            System.out.println("Lỗi DAO addEmployee: " + ex.getMessage());
            return false;
        }
    }

    public boolean updateEmployee(req e) {
        String sql = "UPDATE Employee SET name = ?, salary = ? WHERE id = ?";

        try (Connection conn = dao.DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, e.getName());
            ps.setDouble(2, e.getSalary());
            ps.setInt(3, e.getId());

            int result = ps.executeUpdate();
            return result > 0;

        } catch (Exception ex) {
            System.out.println("Lỗi DAO updateEmployee: " + ex.getMessage());
            return false;
        }
    }
}
