package controller;

import dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Define URL mapping without web.xml
//@WebServlet( name = "productServlet", urlPatterns = "/product")
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private ProductDao productDao = new ProductDao();

    private void listProducts(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        List<Product> products = productDao.getAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("products.jsp").forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        productDao.delete(id);
        response.sendRedirect("products");
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        request.getRequestDispatcher("product-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("id"));
        Product productExisting = productDao.getById(id);
        request.setAttribute("product", productExisting);
        request.getRequestDispatcher("product-form.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String action = request.getParameter("action");

        if (action == null) {
            listProducts(request, response);
        } else {
            switch (action){
                case "add":
                    showForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
                default:
                    listProducts(request, response);

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String desc = request.getParameter("description");

        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        p.setDescription(desc);

        if ("insert".equals(action)) {
            productDao.insert(p);
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            productDao.update(p);
        }
        response.sendRedirect("products");
    }

}
