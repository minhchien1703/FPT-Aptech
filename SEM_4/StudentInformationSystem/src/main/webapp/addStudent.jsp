<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<h2>Add New Student</h2>
<form action="StudentServlet" method="POST">
    <input type="hidden" name="action" value="addStudent">
    Code: <input type="text" name="code" required><br><br>
    Full Name: <input type="text" name="name" required><br><br>
    Address: <input type="text" name="address"><br><br>
    <input type="submit" value="Save Student">
</form>
</body>
</html>