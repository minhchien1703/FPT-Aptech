<%@ page import="model.Cart, model.CartItem" %>
<%
    Cart cart = (Cart) session.getAttribute("cart");
%>

<h2>Your Cart</h2>

<%
    if (cart != null) {
        for (CartItem item : cart.getItems()) {
%>
<p>
    <%= item.getProduct().getName() %>
    - Qty: <%= item.getQuantity() %>
    - Total: $<%= item.getTotalPrice() %>
    <a href="cart?action=remove&id=<%= item.getProduct().getId() %>">Remove</a>
</p>
<%
    }
%>
<h3>Total: $<%= cart.getTotal() %></h3>
<%
    }
%>

<a href="products">Continue Shopping</a>
