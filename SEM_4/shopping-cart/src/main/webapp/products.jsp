<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <title>Cửa hàng trực tuyến | Product List</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary: #599cde;
            --secondary: #64748b;
            --success: #10b981;
            --danger: #ef4444;
            --bg: #f1f5f9;
        }

        body {
            font-family: 'Inter', sans-serif;
            background-color: var(--bg);
            margin: 0;
            color: #1e293b;
        }

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

        /* Main Content */
        .container {
            max-width: 1200px;
            margin: 40px auto;
            padding: 0 20px;
        }

        .page-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 30px;
        }

        .btn-add {
            background: var(--primary);
            color: white;
            text-decoration: none;
            padding: 12px 24px;
            border-radius: 8px;
            font-weight: 600;
            transition: 0.3s;
            box-shadow: 0 4px 6px -1px rgba(37, 99, 235, 0.2);
        }

        .btn-add:hover { background: #1d4ed8; transform: translateY(-1px); }

        /* Table Style */
        .card {
            background: white;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 4px 6px -1px rgba(0,0,0,0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        thead { background: #f8fafc; }

        th {
            text-align: left;
            padding: 16px;
            font-size: 0.85rem;
            color: var(--secondary);
            text-transform: uppercase;
            border-bottom: 1px solid #e2e8f0;
        }

        td {
            padding: 16px;
            border-bottom: 1px solid #f1f5f9;
            vertical-align: middle;
        }

        .product-name { font-weight: 600; color: #111827; }
        .product-price { color: var(--success); font-weight: 700; }

        /* Action Buttons */
        .actions a {
            text-decoration: none;
            font-size: 0.9rem;
            font-weight: 500;
            padding: 6px 12px;
            border-radius: 6px;
            transition: 0.2s;
            margin-right: 5px;
        }

        .btn-cart { background: #eff6ff; color: var(--primary); }
        .btn-cart:hover { background: var(--primary); color: white; }

        .btn-edit { background: #f8fafc; color: var(--secondary); }
        .btn-edit:hover { background: #e2e8f0; }

        .btn-delete { color: var(--danger); }
        .btn-delete:hover { background: #fef2f2; }

        .btn-continue { text-decoration: none; display: inline-block; padding: 10px 20px; background: #599cde; color: #ffffff; border-radius: 8px; margin-bottom: 20px; transition: 0.2s; }
        .btn-continue:hover { background: #e2e8f0; }
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
    <a href="home.jsp" class="btn-continue">← Quay về home</a>

    <div class="page-header">
        <h2>Danh sách sản phẩm</h2>
        <a href="products?action=add" class="btn-add">+ Thêm sản phẩm mới</a>
    </div>

    <div class="card">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Tên sản phẩm</th>
                <th>Giá bán</th>
                <th>Mô tả</th>
                <th>Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${products}">
                <tr>
                    <td style="color: var(--secondary);">#${p.id}</td>
                    <td class="product-name">${p.name}</td>
                    <td class="product-price">
                        <fmt:formatNumber value="${p.price}" type="currency" currencySymbol="₫"/>
                    </td>
                    <td style="max-width: 300px; color: var(--secondary); font-size: 0.9rem;">
                            ${p.description}
                    </td>
                    <td class="actions">
                        <a href="cart?action=add&id=${p.id}" class="btn-cart">🛒 Vào giỏ</a>
                        <a href="products?action=edit&id=${p.id}" class="btn-edit">Sửa</a>
                        <a href="products?action=delete&id=${p.id}" class="btn-delete"
                           onclick="return confirm('Bạn chắc chắn muốn xóa sản phẩm này?')">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>