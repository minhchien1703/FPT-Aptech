package controller;

import dao.AuthDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private AuthDao authDao = new AuthDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("register".equals(action)) {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");


//        if ("login".equals(action)) {
//            login(request, response);
//        } else if ("register".equals(action)) {
//            login(request, response);
//        }
            login(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassword");

            if (!password.equals(confirmPassword)) {
                request.setAttribute("error", "Mật khẩu xác nhận không khớp!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }

            User newUser = new User();
            newUser.setName(name);
            newUser.setPassword(password);

            if (authDao.register(newUser)) {
                response.sendRedirect("auth?action=login&msg=success");
                return;
            } else {
                request.setAttribute("error", "Tên đăng nhập đã tồn tại hoặc lỗi hệ thống!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        }

        String name = request.getParameter("name");
        String pass = request.getParameter("password");
        User user = authDao.login(name, pass);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String pass = request.getParameter("password");
        User newUser = new User();
        newUser.setName(name);
        newUser.setPassword(pass);

        if (authDao.register(newUser)) {
            response.sendRedirect("auth?action=login");
        } else {
            request.setAttribute("error", "Đăng ký thất bại!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("auth?action=login");
    }
}
