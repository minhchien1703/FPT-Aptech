package org.example.player_information.Controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.player_information.Dao.PlayerDao;
import org.example.player_information.Model.Player;

import java.io.IOException;

@WebServlet("/players")
public class PlayerServlet extends HttpServlet {
    private PlayerDao dao = new PlayerDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("player", dao.getById(id));
                request.getRequestDispatcher("player-form.jsp").forward(request, response);
                break;
            case "delete":
                int delId = Integer.parseInt(request.getParameter("id"));
                dao.delete(delId);
                response.sendRedirect("players");
                break;
            default: // List
                request.setAttribute("players", dao.getAll());
                request.getRequestDispatcher("player-list.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String indexName = request.getParameter("indexName");
        int value = Integer.parseInt(request.getParameter("value"));

        Player p = new Player();
        if (idStr != null && !idStr.isEmpty()) p.setId(Integer.parseInt(idStr));
        p.setName(name);
        p.setAge(age);
        p.setIndexName(indexName);
        p.setValue(value);

        dao.save(p);
        response.sendRedirect("players");
    }

}
