<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- Import các class đã được IDE tự động sinh ra từ WSDL --%>
<%-- Lưu ý: Thay đổi package 'ws.client' cho đúng với tên package mà IDE của bạn sinh ra --%>
<%@page import="java.util.List"%>
<%@page import="ws.client.Employee"%>
<%@page import="ws.client.EmployeeWS"%>
<%@page import="ws.client.EmployeeWS_Service"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Management Client</title>
    <style>
        table, th, td { border: 1px solid black; border-collapse: collapse; padding: 8px; }
    </style>
</head>
<body>
<h1>Quản lý nhân viên FPT</h1>

<%
    // Khởi tạo Service Client
    EmployeeWS_Service service = new EmployeeWS_Service();
    EmployeeWS port = service.getEmployeeWSPort();

    // Xử lý logic khi người dùng bấm nút "Thêm mới"
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        try {
            // Lấy dữ liệu từ form
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double salary = Double.parseDouble(request.getParameter("salary"));

            // Tạo đối tượng Employee (sử dụng class Employee của Client)
            Employee newEmp = new Employee();
            newEmp.setId(id);
            newEmp.setName(name);
            newEmp.setSalary(salary);

            // Gọi Web Service để thêm nhân viên
            String message = port.addEmployees(newEmp);
            out.println("<p style='color:green;'><b>" + message + "</b></p>");
        } catch (Exception e) {
            out.println("<p style='color:red;'><b>Lỗi nhập liệu: " + e.getMessage() + "</b></p>");
        }
    }
%>

<hr>
<h3>Thêm nhân viên mới</h3>
<form method="POST" action="index.jsp">
    Mã NV (ID): <input type="number" name="id" required /><br><br>
    Tên (Name): <input type="text" name="name" required /><br><br>
    Lương (Salary): <input type="number" step="0.01" name="salary" required /><br><br>
    <button type="submit">Thêm Nhân Viên</button>
</form>

<hr>
<h3>Danh sách nhân viên</h3>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên nhân viên</th>
        <th>Mức lương</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Gọi Web Service để lấy danh sách
        List<Employee> list = port.getEmployees();
        if (list != null && !list.isEmpty()) {
            for (Employee emp : list) {
    %>
    <tr>
        <td><%= emp.getId() %></td>
        <td><%= emp.getName() %></td>
        <td><%= emp.getSalary() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="3">Chưa có nhân viên nào trong hệ thống.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>