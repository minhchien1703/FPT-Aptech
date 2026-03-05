<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
<h2>Insert Score</h2>
<form action="StudentServlet" method="POST">
    <input type="hidden" name="action" value="addScore">

    Student:
    <select name="studentId">
        <c:forEach var="st" items="${students}">
            <option value="${st.student_id}">${st.fullName}</option>
        </c:forEach>
    </select><br><br>

    Subject:
    <select name="subjectId">
        <c:forEach var="sj" items="${subjects}">
            <option value="${sj.subject_id}">${sj.subjectName}</option>
        </c:forEach>
    </select><br><br>

    Score 1: <input type="number" step="0.1" name="score1" required><br><br>
    Score 2: <input type="number" step="0.1" name="score2" required><br><br>

    <input type="submit" value="Save Score">
</form>
</body>
</html>