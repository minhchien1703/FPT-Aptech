package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Product;

import java.io.IOException;
import java.rmi.ServerException;

@WebServlet("cart")
public class CartServlet extends HttpServlet {
    private ProductServlet productServelet;

    @Override
    public void init() { productServelet = new ProductServlet(); }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServerException, IOException
    {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");
        int productId = Integer.parseInt(request.getParameter("id"));

        Product product = productServelet.getProductById(productId);

        if ("add".equals(action)) {
            cart.addProduct(product);
        } else {
            cart.removeProduct(productId);
        }

        response.sendRedirect("cart.jsp");
    }
}
