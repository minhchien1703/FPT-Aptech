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

    private StudentFacade studentFacade = new StudentFacade();
    private SubjectFacade subjectFacade = new SubjectFacade();
    private StudentScoreFacade scoreFacade = new StudentScoreFacade();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            List<StudentScore> list = scoreFacade.findAll();
            request.setAttribute("scores", list);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if (action.equals("addStudent")) {
            Student s = new Student();
            s.setStudentCode(request.getParameter("code"));
            s.setFullName(request.getParameter("name"));
            s.setAddress(request.getParameter("address"));
            studentFacade.create(s);
            response.sendRedirect("StudentServlet?action=list");

        } else if (action.equals("prepareScore")) {
            request.setAttribute("students", studentFacade.findAll());
            request.setAttribute("subjects", subjectFacade.findAll());
            request.getRequestDispatcher("addScore.jsp").forward(request, response);

        } else if (action.equals("addScore")) {
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
        } else if (action.equals("editScore")) {
            int scoreId = Integer.parseInt(request.getParameter("id"));
            StudentScore score = scoreFacade.find(scoreId);

            request.setAttribute("score", score);
            request.setAttribute("students", studentFacade.findAll());
            request.setAttribute("subjects", subjectFacade.findAll());

            request.getRequestDispatcher("editScore.jsp").forward(request, response);
        } else if (action.equals("updateScore")) {
            int scoreId = Integer.parseInt(request.getParameter("scoreId"));
            double s1 = Double.parseDouble(request.getParameter("score1"));
            double s2 = Double.parseDouble(request.getParameter("score2"));

            StudentScore sc = scoreFacade.find(scoreId);
            sc.setScore1(s1);
            sc.setScore2(s2);


            scoreFacade.edit(sc);
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