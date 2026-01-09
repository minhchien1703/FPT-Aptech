<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Đăng nhập hệ thống | Login</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary: #2563eb;
            --primary-hover: #1d4ed8;
            --bg: #f8fafc;
            --text-main: #1e293b;
            --error: #ef4444;
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

        .login-card {
            background: white;
            width: 100%;
            max-width: 400px;
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 10px 25px -5px rgba(0, 0, 0, 0.1), 0 8px 10px -6px rgba(0, 0, 0, 0.1);
        }

        .login-card h2 {
            margin: 0 0 10px 0;
            font-size: 1.75rem;
            font-weight: 700;
            text-align: center;
            color: #0f172a;
        }

        .subtitle {
            text-align: center;
            color: #64748b;
            margin-bottom: 30px;
            font-size: 0.95rem;
        }

        .error-box {
            background-color: #fef2f2;
            color: var(--error);
            padding: 12px;
            border-radius: 10px;
            font-size: 0.875rem;
            margin-bottom: 25px;
            border: 1px solid #fee2e2;
            text-align: center;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            font-size: 0.875rem;
            font-weight: 600;
            margin-bottom: 8px;
            color: #475569;
        }

        .form-group input {
            width: 100%;
            padding: 12px 16px;
            border: 1.5px solid #e2e8f0;
            border-radius: 10px;
            font-size: 1rem;
            box-sizing: border-box;
            transition: all 0.2s ease;
        }

        .form-group input:focus {
            outline: none;
            border-color: var(--primary);
            box-shadow: 0 0 0 4px rgba(37, 99, 235, 0.1);
        }

        .button-group {
            display: flex;
            gap: 12px;
            margin-top: 25px;
        }

        .btn-login {
            flex: 2;
            background-color: var(--primary);
            color: white;
            border: none;
            padding: 14px;
            border-radius: 10px;
            font-size: 1rem;
            font-weight: 600;
            cursor: pointer;
            transition: background 0.2s, transform 0.1s;
        }

        .btn-login:hover {
            background-color: var(--primary-hover);
        }

        .btn-login:active {
            transform: scale(0.98);
        }

        .btn-register-link {
            flex: 1;
            background-color: #f1f5f9;
            color: #475569;
            border: none;
            padding: 14px;
            border-radius: 10px;
            font-size: 1rem;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.2s;
        }

        .btn-register-link:hover {
            background-color: #e2e8f0;
            color: #1e293b;
        }

        .forgot-pass {
            display: block;
            text-align: right;
            margin-top: 10px;
            font-size: 0.85rem;
            color: var(--primary);
            text-decoration: none;
        }

        .forgot-pass:hover {
            text-decoration: underline;
        }
        .btn-continue { text-decoration: none; display: inline-block; padding: 10px 20px; background: #599cde; color: #ffffff; border-radius: 8px; margin-bottom: 20px; transition: 0.2s; }
        .btn-continue:hover { background: #e2e8f0; }

    </style>
</head>
<body>
<div class="login-card">
    <h2>Chào mừng trở lại</h2>
    <p class="subtitle">Vui lòng đăng nhập để tiếp tục</p>

    <c:if test="${not empty error}">
        <div class="error-box">${error}</div>
    </c:if>

    <form action="auth" method="post">
        <input type="hidden" name="action" value="login">

        <div class="form-group">
            <label>Tên đăng nhập</label>
            <input type="text" name="name" placeholder="Nhập username" required>
        </div>

        <div class="form-group">
            <label>Mật khẩu</label>
            <input type="password" name="password" placeholder="••••••••" required>
        </div>

        <div class="button-group">
            <button type="submit" class="btn-login">Đăng nhập</button>
            <button type="button" class="btn-register-link"
                    onclick="location.href='auth?action=register'">Đăng ký</button>
        </div>
    </form>

    <a href="#" class="forgot-pass">Quên mật khẩu?</a>
    <a href="home.jsp" class="forgot-pass">Quay lại</a>
</div>

</body>
</html>