package controller;

import dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.CartItem;
import model.Product;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
        private ProductDao productDao = new ProductDao();

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String action = request.getParameter("action");
            HttpSession session = request.getSession();

            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<>();
                session.setAttribute("cart", cart);
            }

            if (action == null) {
                request.getRequestDispatcher("cart.jsp").forward(request, response);
                return;
            }

            try {
                switch (action) {
                    case "add":
                        addToCart(request, cart);
                        response.sendRedirect("cart");
                        break;

                    case "update":
                        updateCart(request, cart);
                        response.sendRedirect("cart");
                        break;

                    case "delete":
                        deleteFromCart(request, cart);
                        response.sendRedirect("cart");
                        break;

                    case "clear":
                        cart.clear();
                        response.sendRedirect("cart");
                        break;

                    default:
                        request.getRequestDispatcher("cart.jsp").forward(request, response);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("products");
            }
        }

        private void addToCart(HttpServletRequest request, List<CartItem> cart) {
            int id = Integer.parseInt(request.getParameter("id"));

            for (CartItem item : cart) {
                if (item.getProduct().getId() == id) {
                    item.setQuantity(item.getQuantity() + 1);
                    return;
                }
            }

            Product p = productDao.getById(id);
            if (p != null) {
                cart.add(new CartItem(p, 1));
            }
        }

        private void updateCart(HttpServletRequest request, List<CartItem> cart) {
            int id = Integer.parseInt(request.getParameter("id"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            for (CartItem item : cart) {
                if (item.getProduct().getId() == id) {
                    if (quantity > 0) {
                        item.setQuantity(quantity);
                    } else {
                        cart.remove(item);
                    }
                    break;
                }
            }
        }

        private void deleteFromCart(HttpServletRequest request, List<CartItem> cart) {
            int id = Integer.parseInt(request.getParameter("id"));
            cart.removeIf(item -> item.getProduct().getId() == id);
        }

}
