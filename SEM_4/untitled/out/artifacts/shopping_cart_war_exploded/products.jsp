<%@ page import="java.util.*, model.Product" %>
<h2>Product List</h2>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    for (Product p : products) {
%>
<p>
    <%= p.getName() %> - $<%= p.getPrice() %>
    <a href="cart?action=add&id=<%= p.getId() %>">Add to cart</a>
</p>
<%
    }
%>

<a href="cart.jsp">View Cart</a>
