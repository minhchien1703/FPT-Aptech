<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>${not empty product ? "Chỉnh sửa sản phẩm" : "Thêm sản phẩm mới"}</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary: #2563eb;
            --primary-hover: #1d4ed8;
            --bg: #f8fafc;
            --border: #e2e8f0;
            --text-main: #1e293b;
            --text-label: #64748b;
        }

        body {
            font-family: 'Inter', sans-serif;
            background-color: var(--bg);
            color: var(--text-main);
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .form-card {
            background: white;
            width: 100%;
            max-width: 500px;
            padding: 40px;
            border-radius: 16px;
            box-shadow: 0 10px 25px -5px rgba(0, 0, 0, 0.1);
        }

        h2 {
            margin: 0 0 30px 0;
            font-size: 1.5rem;
            font-weight: 700;
            text-align: center;
            color: #111827;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-size: 0.875rem;
            font-weight: 600;
            color: var(--text-label);
            margin-bottom: 8px;
        }

        input[type="text"],
        input[type="number"],
        textarea {
            width: 100%;
            padding: 12px 16px;
            border: 1px solid var(--border);
            border-radius: 8px;
            font-size: 1rem;
            font-family: inherit;
            color: var(--text-main);
            transition: all 0.2s;
            box-sizing: border-box; /* Đảm bảo padding không làm tràn width */
        }

        input:focus, textarea:focus {
            outline: none;
            border-color: var(--primary);
            box-shadow: 0 0 0 4px rgba(37, 99, 235, 0.1);
        }

        textarea {
            resize: vertical;
            min-height: 100px;
        }

        .btn-group {
            display: flex;
            gap: 12px;
            margin-top: 30px;
        }

        button {
            flex: 2;
            background-color: var(--primary);
            color: white;
            border: none;
            padding: 12px;
            border-radius: 8px;
            font-size: 1rem;
            font-weight: 600;
            cursor: pointer;
            transition: background 0.2s;
        }

        button:hover {
            background-color: var(--primary-hover);
        }

        .btn-cancel {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            text-decoration: none;
            background-color: #f1f5f9;
            color: #475569;
            border-radius: 8px;
            font-weight: 600;
            font-size: 0.875rem;
            transition: background 0.2s;
        }

        .btn-cancel:hover {
            background-color: #e2e8f0;
        }
        .btn-continue { text-decoration: none; display: inline-block; padding: 10px 20px; background: #599cde; color: #ffffff; border-radius: 8px; margin-bottom: 20px; transition: 0.2s; }
        .btn-continue:hover { background: #e2e8f0; }

    </style>
</head>
<body>

<div class="form-card">
    <h2>${not empty product ? "Cập nhật sản phẩm" : "Tạo sản phẩm mới"}</h2>

    <form action="products" method="post">
        <input type="hidden" name="action" value="${not empty product ? 'update' : 'insert'}">

        <c:if test="${not empty product}">
            <input type="hidden" name="id" value="${product.id}">
        </c:if>

        <div class="form-group">
            <label>Tên sản phẩm</label>
            <input type="text" name="name" value="${product.name}" placeholder="Ví dụ: iPhone 15 Pro Max" required>
        </div>

        <div class="form-group">
            <label>Giá bán (VND)</label>
            <input type="number" step="0.01" name="price" value="${product.price}" placeholder="0.00" required>
        </div>

        <div class="form-group">
            <label>Mô tả sản phẩm</label>
            <textarea name="description" placeholder="Nhập mô tả chi tiết về sản phẩm...">${product.description}</textarea>
        </div>

        <div class="btn-group">
            <button type="submit">
                ${not empty product ? "Lưu thay đổi" : "Thêm sản phẩm"}
            </button>
            <a href="products" class="btn-cancel">Hủy</a>
        </div>
    </form>
</div>

</body>
</html>