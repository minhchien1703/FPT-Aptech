package dao;

import model.Applicant;
import utils.DBConnection;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WinnerDao {
    public List<Applicant> getAll(String searchTerm, int page, int pageSize) {
        List<Applicant> list = new ArrayList<>();
        String sql = "SELECT a.id, a.name, a.status FROM Winner w " +
                "JOIN Applicant a ON w.ticketId = a.id " +
                "WHERE a.name LIKE ? " +
                "LIMIT ? OFFSET ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            if (conn == null) throw new RuntimeException("Connection null!");

            // Thiết lập các tham số
            ps.setString(1, "%" + searchTerm + "%");
            ps.setInt(2, pageSize);
            ps.setInt(3, (page - 1) * pageSize);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Applicant applicant = new Applicant();
                    applicant.setId(rs.getInt("id"));
                    applicant.setName(rs.getString("name"));
                    applicant.setStatus(rs.getInt("status"));
                    list.add(applicant);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Hàm phụ để đếm tổng số bản ghi (phục vụ việc tính tổng số trang ở giao diện)
    public int getTotalCount(String searchTerm) {
        String sql = "SELECT COUNT(*) FROM Winner w JOIN Applicant a ON w.ticketId = a.id WHERE a.name LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + searchTerm + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean deleteAllWinners() {
        String sql = "DELETE FROM Winner";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            return ps.executeUpdate() >= 0; // Trả về true nếu thực thi thành công
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void exportWinnersToExcel(List<Applicant> winners, OutputStream out) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Danh sách trúng giải");

            // 1. Tạo Header
            Row headerRow = sheet.createRow(0);
            String[] columns = {"STT", "Mã số (ID)", "Họ và Tên"};

            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);

            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerStyle);
            }

            // 2. Đổ dữ liệu từ danh sách winners
            int rowIdx = 1;
            for (Applicant a : winners) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(rowIdx - 1);
                row.createCell(1).setCellValue(a.getId());
                row.createCell(2).setCellValue(a.getName());
            }

            // Tự động căn chỉnh độ rộng cột
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(out);
        }
    }
}
