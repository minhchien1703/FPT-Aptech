package controller;

import entities.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessionbeans.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    @EJB
    private StudentFacade studentFacade;
    @EJB
    private SubjectFacade subjectFacade;
    @EJB
    private StudentScoreFacade scoreFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            // Câu 3: Hiển thị danh sách
            List<StudentScore> list = scoreFacade.findAll();
            request.setAttribute("scores", list);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if (action.equals("addStudent")) {
            // Câu 1: Lưu sinh viên mới
            Student s = new Student();
            s.setStudentCode(request.getParameter("code"));
            s.setFullName(request.getParameter("name"));
            s.setAddress(request.getParameter("address"));
            studentFacade.create(s);
            response.sendRedirect("StudentServlet?action=list");

        } else if (action.equals("prepareScore")) {
            // Chuẩn bị dữ liệu cho form nhập điểm (lấy list SV và môn học)
            request.setAttribute("students", studentFacade.findAll());
            request.setAttribute("subjects", subjectFacade.findAll());
            request.getRequestDispatcher("addScore.jsp").forward(request, response);

        } else if (action.equals("addScore")) {
            // Câu 2: Lưu điểm
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            int subjectId = Integer.parseInt(request.getParameter("subjectId"));
            double s1 = Double.parseDouble(request.getParameter("score1"));
            double s2 = Double.parseDouble(request.getParameter("score2"));

            StudentScore sc = new StudentScore();
            sc.setStudent(studentFacade.find(studentId));
            sc.setSubject(subjectFacade.find(subjectId));
            sc.setScore1(s1);
            sc.setScore2(s2);

            scoreFacade.create(sc);
            response.sendRedirect("StudentServlet?action=list");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}