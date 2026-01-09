<style>
    :root { --main-color: #d17a5d; }
    table { width: 100%; border-collapse: collapse; margin-top: 20px; }
    thead { background-color: var(--main-color); color: white; }
    th, td { padding: 12px; text-align: left; border-bottom: 1px solid #eee; }
    .btn-add { background: var(--main-color); color: white; padding: 8px 20px; border-radius: 5px; text-decoration: none; float: right; }
    .footer { background: var(--main-color); color: white; padding: 10px; margin-top: 20px; }
</style>

<div class="container">
    <a href="player-form.jsp" class="btn-add">Add</a>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Player name</th>
            <th>Player age</th>
            <th>Index name</th>
            <th>Value</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${players}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.age}</td>
                <td>${p.indexName}</td>
                <td>${p.value}</td>
                <td>
                    <a href="players?action=edit&id=${p.id}">Edit</a> |
                    <a href="players?action=delete&id=${p.id}" onclick="return confirm('Delete?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="footer">Số 8, Tôn Thất Thuyết, Cầu Giấy, Hà Nội</div>
</div>