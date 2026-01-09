package controller;

import dao.ApplicantDao;
import dao.WinnerDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Applicant;
import service.LotteryService;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@WebServlet("/lottery")
public class LotteryServlet extends HttpServlet {
    private ApplicantDao applicantDao = new ApplicantDao();
    private LotteryService lotteryService = new LotteryService();
    private WinnerDao winnerDao = new WinnerDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("export".equals(action)) {
            // Lấy toàn bộ 500 người (không phân trang để xuất file đầy đủ)
            List<Applicant> allWinners = winnerDao.getAll("", 1, 500);

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=Danh_Sach_Trung_Giai.xlsx");

            try (OutputStream out = response.getOutputStream()) {
                winnerDao.exportWinnersToExcel(allWinners, out);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return; // Dừng xử lý sau khi xuất file
        }

        if ("reset".equals(action)) {
            winnerDao.deleteAllWinners();
            response.sendRedirect("lottery"); // Quay lại trang này nhưng không còn action nữa
            return;
        }

        String searchTerm = request.getParameter("search");
        if (searchTerm == null) searchTerm = "";

        int page = 1;
        try {
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
        } catch (NumberFormatException e) { page = 1; }

        int pageSize = 10;

        WinnerDao winnerDao = new WinnerDao();
        List<Applicant> winners = winnerDao.getAll(searchTerm, page, pageSize);
        int totalWinners = winnerDao.getTotalCount(searchTerm);
        int totalPages = (int) Math.ceil((double) totalWinners / pageSize);

        request.setAttribute("winners", winners);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", page);

        request.getRequestDispatcher("lottery-result.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("draw".equals(action)) {
            List<Applicant> all = applicantDao.getAll();
            List<Applicant> winners = lotteryService.shuffleAndDraw(all, 500);

            applicantDao.saveWinners(winners);

            request.setAttribute("winners", winners);
            request.getRequestDispatcher("lottery-result.jsp").forward(request, response);
        }
    }
}
