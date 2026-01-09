<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Mich app</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
    <style>
        :root { --primary: #2563eb; --bg: #f8fafc; }
        body { font-family: 'Inter', sans-serif; background: var(--bg); display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; }
        .welcome-card { background: white; padding: 40px; border-radius: 20px; box-shadow: 0 10px 25px rgba(0,0,0,0.1); text-align: center; max-width: 600px; }
        h1 { color: #1e293b; margin-bottom: 10px; }
        p { color: #64748b; margin-bottom: 30px; }
        .options { display: grid; grid-template-columns: 1fr 1fr; gap: 20px; }
        .option-card { border: 2px solid #f1f5f9; padding: 25px; border-radius: 15px; text-decoration: none; color: inherit; transition: all 0.3s; }
        .option-card:hover { border-color: var(--primary); transform: translateY(-5px); box-shadow: 0 5px 15px rgba(37,99,235,0.1); }
        .icon { font-size: 2.5rem; margin-bottom: 15px; display: block; }
        .title { font-weight: 700; font-size: 1.1rem; color: #1e293b; }
    </style>
</head>
<body>
<div class="welcome-card">
    <h1>Chào mừng tới Mich App</h1>
    <p>Vui lòng chọn chức năng bạn muốn thực hiện</p>

    <div class="options">
        <a href="products" class="option-card">
            <span class="icon">🛒</span>
            <span class="title">Shopping Cart</span>
            <p style="font-size: 0.85rem;">Mua sắm và quản lý sản phẩm</p>
        </a>

        <a href="lottery" class="option-card">
            <span class="icon">🏠</span>
            <span class="title">Bốc thăm Nhà ở</span>
            <p style="font-size: 0.85rem;">Hệ thống bốc thăm công bằng</p>
        </a>
    </div>
</div>
</body>
</html>