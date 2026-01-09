<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <title>Bốc bát họ</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/canvas-confetti@1.6.0/dist/confetti.browser.min.js"></script>
    <style>
        /* ... Các style cũ giữ nguyên ... */
        :root { --primary: #2563eb; --secondary: #64748b; --success: #10b981; --danger: #ef4444; --bg: #f1f5f9; }
        body { font-family: 'Inter', sans-serif; background-color: var(--bg); margin: 0; color: #1e293b; }
        .navbar { background: white; padding: 15px 10%; display: flex; justify-content: space-between; align-items: center; box-shadow: 0 1px 3px rgba(0,0,0,0.1); }
        .logo { font-size: 1.5rem; font-weight: 700; color: var(--primary); text-decoration: none; }
        .user-menu a { text-decoration: none; color: var(--secondary); font-weight: 500; margin-left: 20px; transition: 0.2s; }
        .container { max-width: 1200px; margin: 40px auto; padding: 0 20px; }
        .card { background: white; border-radius: 12px; overflow: hidden; box-shadow: 0 4px 6px -1px rgba(0,0,0,0.1); }
        table { width: 100%; border-collapse: collapse; }
        thead { background: #f8fafc; }
        th { text-align: left; padding: 16px; font-size: 0.85rem; color: var(--secondary); text-transform: uppercase; border-bottom: 1px solid #e2e8f0; }
        td { padding: 16px; border-bottom: 1px solid #f1f5f9; vertical-align: middle; }
        .btn-add { background: var(--primary); color: white; text-decoration: none; padding: 12px 24px; border-radius: 8px; font-weight: 600; transition: 0.3s; box-shadow: 0 4px 6px -1px rgba(37, 99, 235, 0.2); border:none; cursor:pointer;}

        /* Style Vòng Quay */
        .wheel-container { display: flex; flex-direction: column; align-items: center; margin-bottom: 50px; transition: opacity 0.5s ease; }
        .wheel-wrapper { position: relative; width: 300px; height: 300px; margin-bottom: 20px; }
        .wheel-arrow { position: absolute; top: -10px; left: 50%; transform: translateX(-50%); width: 30px; height: 40px; background: var(--danger); clip-path: polygon(50% 100%, 0 0, 100% 0); z-index: 10; }
        .wheel { width: 100%; height: 100%; border-radius: 50%; border: 8px solid #334155; background: conic-gradient(#2563eb 0deg 45deg, #10b981 45deg 90deg, #f59e0b 90deg 135deg, #ef4444 135deg 180deg, #2563eb 180deg 225deg, #10b981 225deg 270deg, #f59e0b 270deg 315deg, #ef4444 315deg 360deg); box-shadow: 0 0 20px rgba(0,0,0,0.2); transition: transform 4s cubic-bezier(0.15, 0, 0.15, 1); }

        /* Quan trọng: Sửa lại display mặc định */
        #result-content {
            /* Nếu winners trống thì ẩn (để quay), nếu có dữ liệu thì hiện luôn */
            display: ${empty winners ? 'none' : 'block'};
            animation: fadeInUp 1s ease forwards;
        }

        @keyframes fadeInUp { from { opacity: 0; transform: translateY(20px); } to { opacity: 1; transform: translateY(0); } }
        .btn-continue { text-decoration: none; display: inline-block; padding: 10px 20px; background: #599cde; color: #ffffff; border-radius: 8px; margin-bottom: 20px; transition: 0.2s; }
        .btn-continue:hover { background: #e2e8f0; }

        .pagination {
            display: flex;
            justify-content: center;
            gap: 5px;
            margin-top: 20px;
            padding-bottom: 20px;
        }
        .page-link {
            padding: 8px 16px;
            border: 1px solid #e2e8f0;
            border-radius: 6px;
            text-decoration: none;
            color: var(--secondary);
            transition: 0.3s;
        }
        .page-link:hover { background: #e2e8f0; }
        .page-link.active {
            background: var(--primary);
            color: white;
            border-color: var(--primary);
        }
    </style>
</head>
<body>
<nav class="navbar">
    <a href="home.jsp" class="logo">MICH APP</a>
    <div class="user-menu">
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <span>Chào, <strong>${sessionScope.user.name}</strong></span>
                <a href="auth?action=logout" style="color: var(--danger);">Đăng xuất</a>
            </c:when>
            <c:otherwise>
                <a href="auth?action=login">Đăng nhập</a>
            </c:otherwise>
        </c:choose>
    </div>
</nav>

<div class="container">
    <a href="home.jsp" class="btn-continue">← Quay về trang chủ</a>

    <c:choose>
        <%-- TRƯỜNG HỢP 1: Chưa có kết quả -> Hiển thị Vòng quay --%>
        <c:when test="${empty winners}">
            <div id="wheel-section" class="wheel-container">
                <div class="wheel-wrapper">
                    <div class="wheel-arrow"></div>
                    <div id="main-wheel" class="wheel"></div>
                </div>
                <button type="button" onclick="startSpin()" id="spin-btn" class="btn-add">
                    🎡 BẤM ĐỂ QUAY SỐ
                </button>
            </div>
        </c:when>

        <%-- TRƯỜNG HỢP 2: Đã có kết quả -> Có thể hiển thị nút Reset hoặc thông báo --%>
        <c:otherwise>
            <div style="text-align: center; margin-bottom: 20px;">
                <p>🎉 Kết quả bốc thăm đã được xác định!</p>
                <a href="lottery?action=reset"
                   class="btn-add"
                   style="background: var(--secondary); text-decoration: none;"
                   onclick="return confirm('Hành động này sẽ xóa toàn bộ 500 người trúng giải cũ để bốc thăm lại. Bạn chắc chắn chứ?')">
                    Bốc thăm đợt mới
                </a>
            </div>
        </c:otherwise>
    </c:choose>

    <c:if test="${not empty winners and winners.size() > 1}">
        <div class="search-container" style="margin-bottom: 20px; display: flex; gap: 10px;">
            <form action="lottery" method="get" style="display: flex; width: 100%; gap: 10px;">
                <input type="hidden" name="action" value="showWinners">

                <input type="text" name="search" value="${param.search}"
                       placeholder="Nhập tên người trúng giải..."
                       style="flex: 1; padding: 10px; border: 1px solid #ddd; border-radius: 8px;">

                <button type="submit" class="btn-add" style="padding: 10px 20px;">Tìm kiếm</button>

                    <%-- Nút xóa lọc chỉ hiện khi đang có từ khóa tìm kiếm --%>
                <c:if test="${not empty param.search}">
                    <a href="lottery?action=showWinners" class="btn-continue" style="margin: 0; padding: 10px; text-decoration: none; display: flex; align-items: center;">Xóa lọc</a>
                </c:if>
            </form>
        </div>
    </c:if>

    <%-- Bảng kết quả --%>
    <div id="result-content" class="card">
        <div class="page-header" style="padding: 20px; display: flex; justify-content: space-between;">
            <h2>🎉 Danh sách 500 người trúng giải bốc bát họ</h2>
        </div>

        <c:if test="${not empty winners}">
            <div style="margin-bottom: 20px;">
                <a href="lottery?action=export" class="btn-add" style="background-color: var(--success); text-decoration: none;">
                    Excel Xuất danh sách (.xlsx)
                </a>
            </div>
        </c:if>

        <table>
            <thead>
            <tr>
                <th>STT</th>
                <th>Mã số (ID)</th>
                <th>Họ và Tên</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="w" items="${winners}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td><strong>#${w.id}</strong></td>
                    <td>${w.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
<%--        <div class="pagination">--%>
<%--            &lt;%&ndash; Nút Previous &ndash;%&gt;--%>
<%--            <c:if test="${currentPage > 1}">--%>
<%--                <a href="lottery?action=showWinners&page=${currentPage - 1}&search=${param.search}" class="page-link">«</a>--%>
<%--            </c:if>--%>

<%--            &lt;%&ndash; Hiển thị các số trang &ndash;%&gt;--%>
<%--            <c:forEach begin="1" end="${totalPages}" var="i">--%>
<%--                <a href="lottery?action=showWinners&page=${i}&search=${param.search}"--%>
<%--                   class="page-link ${i == currentPage ? 'active' : ''}">${i}</a>--%>
<%--            </c:forEach>--%>

<%--            &lt;%&ndash; Nút Next &ndash;%&gt;--%>
<%--            <c:if test="${currentPage < totalPages}">--%>
<%--                <a href="lottery?action=showWinners&page=${currentPage + 1}&search=${param.search}" class="page-link">»</a>--%>
<%--            </c:if>--%>
<%--        </div>--%>

        <div class="pagination">
            <%-- Nút Previous --%>
            <c:if test="${currentPage > 1}">
                <a href="lottery?action=showWinners&page=${currentPage - 1}&search=${param.search}" class="page-link">«</a>
            </c:if>

            <%-- Hiển thị trang đầu tiên nếu trang hiện tại quá xa đầu danh sách --%>
            <c:if test="${currentPage > 3}">
                <a href="lottery?action=showWinners&page=1&search=${param.search}" class="page-link">1</a>
                <c:if test="${currentPage > 4}">
                    <span class="page-sep">...</span>
                </c:if>
            </c:if>

            <%-- Hiển thị các trang xung quanh trang hiện tại (tối đa 5 trang) --%>
            <c:forEach begin="${currentPage - 2 > 0 ? currentPage - 2 : 1}"
                       end="${currentPage + 2 < totalPages ? currentPage + 2 : totalPages}"
                       var="i">
                <a href="lottery?action=showWinners&page=${i}&search=${param.search}"
                   class="page-link ${i == currentPage ? 'active' : ''}">${i}</a>
            </c:forEach>

            <%-- Hiển thị trang cuối cùng nếu trang hiện tại quá xa cuối danh sách --%>
            <c:if test="${currentPage < totalPages - 2}">
                <c:if test="${currentPage < totalPages - 3}">
                    <span class="page-sep">...</span>
                </c:if>
                <a href="lottery?action=showWinners&page=${totalPages}&search=${param.search}" class="page-link">${totalPages}</a>
            </c:if>

            <%-- Nút Next --%>
            <c:if test="${currentPage < totalPages}">
                <a href="lottery?action=showWinners&page=${currentPage + 1}&search=${param.search}" class="page-link">»</a>
            </c:if>
        </div>
    </div>
</div>

<script>
    function startSpin() {
        const btn = document.getElementById('spin-btn');
        const wheel = document.getElementById('main-wheel');
        const wheelSection = document.getElementById('wheel-section');

        // 1. Vô hiệu hóa nút và bắt đầu quay hiệu ứng ngay lập tức
        btn.disabled = true;
        btn.innerText = "ĐANG QUAY...";

        const randomDegree = Math.floor(Math.random() * 360) + 1800;
        wheel.style.transform = `rotate(${randomDegree}deg)`;

        // 2. Gửi lệnh "draw" về Servlet ngầm (Ajax)
        // Trong khi Server xử lý bốc thăm thì vòng quay vẫn đang quay (tận dụng thời gian chờ)
        fetch('lottery?action=draw', {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        })
            .then(response => {
                if (!response.ok) throw new Error('Network response was not ok');
                return response.text(); // Nhận về toàn bộ HTML của trang lottery-result.jsp
            })
            .then(htmlData => {
                // 3. Đợi đủ 4 giây (để vòng quay dừng lại cho đẹp) rồi mới hiện kết quả
                setTimeout(() => {
                    fireworks(); // Bắn pháo hoa ăn mừng

                    // Hiệu ứng mờ dần vòng quay
                    if(wheelSection) wheelSection.style.opacity = "0";

                    setTimeout(() => {
                        // Thay thế toàn bộ nội dung bằng HTML mới từ Servlet gửi về
                        document.open();
                        document.write(htmlData);
                        document.close();

                        // Cuộn xuống bảng kết quả (vì lúc này trang đã được ghi lại nội dung mới)
                        const result = document.getElementById('result-content');
                        if(result) result.scrollIntoView({ behavior: 'smooth' });
                    }, 500);
                }, 4000);
            })
            .catch(error => {
                console.error('Lỗi:', error);
                alert("Có lỗi xảy ra khi bốc thăm, vui lòng thử lại!");
                btn.disabled = false;
                btn.innerText = "🎡 BẤM ĐỂ QUAY SỐ";
            });
    }

    // Hàm pháo hoa giữ nguyên
    function fireworks() {
        var duration = 5 * 1000;
        var animationEnd = Date.now() + duration;
        var defaults = { startVelocity: 30, spread: 360, ticks: 60, zIndex: 9999 };
        function randomInRange(min, max) { return Math.random() * (max - min) + min; }
        var interval = setInterval(function() {
            var timeLeft = animationEnd - Date.now();
            if (timeLeft <= 0) return clearInterval(interval);
            var particleCount = 50 * (timeLeft / duration);
            confetti(Object.assign({}, defaults, { particleCount, origin: { x: randomInRange(0.1, 0.3), y: Math.random() - 0.2 } }));
            confetti(Object.assign({}, defaults, { particleCount, origin: { x: randomInRange(0.7, 0.9), y: Math.random() - 0.2 } }));
        }, 250);
    }
</script>
</body>