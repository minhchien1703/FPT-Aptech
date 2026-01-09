<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <title>Cart</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary: #2563eb;
            --danger: #ef4444;
            --bg: #f8fafc;
            --text: #1e293b;
        }

        body {
            font-family: 'Inter', sans-serif;
            background-color: var(--bg);
            color: var(--text);
            margin: 0;
        }

        .container {
            max-width: 1000px;
            margin: 40px auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1);
        }

        h2 {
            font-weight: 700;
            margin-bottom: 30px;
            color: #111827;
            border-left: 5px solid var(--primary);
            padding-left: 15px;
        }

        /* Header giỏ hàng */
        .cart-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        /* Style cho bảng */
        table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0 10px;
        }

        th {
            text-transform: uppercase;
            font-size: 0.8rem;
            letter-spacing: 0.05em;
            color: #64748b;
            padding: 15px;
            text-align: left;
        }

        td {
            background: white;
            padding: 20px 15px;
            border-top: 1px solid #f1f5f9;
            border-bottom: 1px solid #f1f5f9;
        }

        td:first-child { border-left: 1px solid #f1f5f9; border-radius: 8px 0 0 8px; }
        td:last-child { border-right: 1px solid #f1f5f9; border-radius: 0 8px 8px 0; }

        /* Input số lượng */
        .qty-input {
            width: 60px;
            padding: 8px;
            border: 1px solid #cbd5e1;
            border-radius: 6px;
            text-align: center;
            outline: none;
            transition: border 0.2s;
        }

        .qty-input:focus { border-color: var(--primary); }

        /* Nút xóa */
        .btn-delete {
            color: var(--danger);
            text-decoration: none;
            font-weight: 600;
            padding: 8px 12px;
            border-radius: 6px;
            transition: background 0.2s;
        }

        .btn-delete:hover { background: #fef2f2; }

        /* Footer & Total */
        .cart-footer {
            margin-top: 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding-top: 20px;
            border-top: 2px solid #f1f5f9;
        }

        .total-price {
            font-size: 1.5rem;
            font-weight: 700;
            color: var(--primary);
        }

        .actions-group a {
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-weight: 600;
            transition: 0.2s;
        }

        .btn-continue { background: #f1f5f9; color: #475569; }
        .btn-continue:hover { background: #e2e8f0; }

        .btn-clear { color: var(--danger); }

        .empty-msg {
            text-align: center;
            padding: 50px;
            color: #64748b;
        }

        /*    style new */
        /* Navbar Header */
        .navbar {
            background: white;
            padding: 15px 10%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 1px 3px rgba(0,0,0,0.1);
        }

        .logo {
            font-size: 1.5rem;
            font-weight: 700;
            color: var(--primary);
            text-decoration: none;
        }

        .user-menu a {
            text-decoration: none;
            color: var(--secondary);
            font-weight: 500;
            margin-left: 20px;
            transition: 0.2s;
        }

        .user-menu a:hover { color: var(--primary); }
    </style>
</head>
<body>
<nav class="navbar">
    <a href="home.jsp" class="logo">MICH APP</a>
    <div class="user-menu">
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <span>Chào, <strong>${sessionScope.user.name}</strong></span>
                <a href="cart">🛒 Giỏ hàng</a>
                <a href="auth?action=logout" style="color: var(--danger);">Đăng xuất</a>
            </c:when>
            <c:otherwise>
                <a href="auth?action=login">Đăng nhập</a>
            </c:otherwise>
        </c:choose>
    </div>
</nav>

<div class="container">
    <div class="cart-header">
        <h2>Giỏ hàng của bạn</h2>
        <span>Số lượng: <strong>${empty sessionScope.cart ? 0 : sessionScope.cart.size()} sản phẩm</strong></span>
    </div>

    <c:choose>
        <c:when test="${empty sessionScope.cart}">
            <div class="empty-msg">
                <p>🛒 Giỏ hàng của bạn đang trống.</p>
                <a href="products" style="color: var(--primary); text-decoration: none; font-weight: 600;">Quay lại cửa hàng ngay →</a>
            </div>
        </c:when>
        <c:otherwise>
            <table>
                <thead>
                <tr>
                    <th>Sản phẩm</th>
                    <th>Đơn giá</th>
                    <th>Số lượng</th>
                    <th>Thành tiền</th>
                    <th>Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:set var="total" value="0" />
                <c:forEach var="item" items="${sessionScope.cart}">
                    <tr>
                        <td style="font-weight: 600;">${item.product.name}</td>
                        <td><fmt:formatNumber value="${item.product.price}" type="currency" currencySymbol="₫"/></td>
                        <td>
                            <form action="cart" method="get" style="margin:0;">
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="id" value="${item.product.id}">
                                <input type="number" name="quantity" value="${item.quantity}" min="1"
                                       onchange="this.form.submit()" class="qty-input">
                            </form>
                        </td>
                        <td style="font-weight: 600; color: #334155;">
                            <fmt:formatNumber value="${item.subTotal}" type="currency" currencySymbol="₫"/>
                        </td>
                        <td>
                            <a href="cart?action=delete&id=${item.product.id}" class="btn-delete">Xóa</a>
                        </td>
                    </tr>
                    <c:set var="total" value="${total + item.subTotal}" />
                </c:forEach>
                </tbody>
            </table>

            <div class="cart-footer">
                <div class="actions-group">
                    <a href="products" class="btn-continue">← Tiếp tục mua sắm</a>
                    <a href="cart?action=clear" class="btn-clear" onclick="return confirm('Xóa tất cả sản phẩm?')">Xóa toàn bộ</a>
                </div>
                <div>
                    <span style="color: #64748b; margin-right: 10px;">Tổng thanh toán:</span>
                    <span class="total-price"><fmt:formatNumber value="${total}" type="currency" currencySymbol="₫"/></span>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>