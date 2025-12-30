<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Tham gia cùng chúng tôi | Register</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary: #2563eb;
            --primary-dark: #1d4ed8;
            --bg: #f1f5f9;
            --error: #ef4444;
            --text-main: #1e293b;
        }

        body {
            font-family: 'Inter', sans-serif;
            background-color: var(--bg);
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            color: var(--text-main);
        }

        .auth-card {
            background: white;
            width: 100%;
            max-width: 400px;
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 20px 25px -5px rgba(0, 0, 0, 0.1), 0 10px 10px -5px rgba(0, 0, 0, 0.04);
        }

        .auth-card h2 {
            margin: 0 0 10px 0;
            font-size: 1.75rem;
            font-weight: 700;
            text-align: center;
            color: #0f172a;
        }

        .auth-card p.subtitle {
            text-align: center;
            color: #64748b;
            margin-bottom: 30px;
            font-size: 0.95rem;
        }

        .error-msg {
            background-color: #fef2f2;
            color: var(--error);
            padding: 12px;
            border-radius: 8px;
            font-size: 0.875rem;
            margin-bottom: 20px;
            border-left: 4px solid var(--error);
            text-align: center;
        }

        .form-group {
            margin-bottom: 18px;
        }

        .form-group label {
            display: block;
            font-size: 0.875rem;
            font-weight: 600;
            margin-bottom: 6px;
            color: #475569;
        }

        .form-group input {
            width: 100%;
            padding: 12px 14px;
            border: 1.5px solid #e2e8f0;
            border-radius: 10px;
            font-size: 1rem;
            box-sizing: border-box;
            transition: all 0.2s;
        }

        .form-group input:focus {
            outline: none;
            border-color: var(--primary);
            box-shadow: 0 0 0 3px rgba(37, 99, 235, 0.1);
        }

        button {
            width: 100%;
            background-color: var(--primary);
            color: white;
            padding: 14px;
            border: none;
            border-radius: 10px;
            font-size: 1rem;
            font-weight: 600;
            cursor: pointer;
            margin-top: 10px;
            transition: background 0.2s, transform 0.1s;
        }

        button:hover {
            background-color: var(--primary-dark);
        }

        button:active {
            transform: scale(0.98);
        }

        .footer-text {
            text-align: center;
            margin-top: 25px;
            font-size: 0.9rem;
            color: #64748b;
        }

        .footer-text a {
            color: var(--primary);
            text-decoration: none;
            font-weight: 600;
        }

        .footer-text a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="auth-card">
    <h2>Tạo tài khoản</h2>
    <p class="subtitle">Đăng ký để bắt đầu trải nghiệm mua sắm</p>

    <c:if test="${not empty error}">
        <div class="error-msg">${error}</div>
    </c:if>

    <form action="auth" method="post">
        <input type="hidden" name="action" value="register">

        <div class="form-group">
            <label>Tên đăng nhập</label>
            <input type="text" name="name" placeholder="Nhập tên của bạn" required>
        </div>

        <div class="form-group">
            <label>Mật khẩu</label>
            <input type="password" name="password" placeholder="••••••••" required>
        </div>

        <div class="form-group">
            <label>Xác nhận mật khẩu</label>
            <input type="password" name="confirmPassword" placeholder="••••••••" required>
        </div>

        <button type="submit">Đăng ký ngay</button>
    </form>

    <div class="footer-text">
        Đã có tài khoản? <a href="auth?action=login">Đăng nhập ngay</a>
    </div>
</div>

</body>
</html>