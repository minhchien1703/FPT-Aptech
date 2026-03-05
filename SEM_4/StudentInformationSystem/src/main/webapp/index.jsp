<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Information System</title>
    <style>
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .btn { padding: 10px; margin: 10px 0; display: inline-block; background: #007bff; color: white; text-decoration: none; border-radius: 5px; }
    </style>
</head>
<body>
<h2>Student Information System (SIS)</h2>
<a href="addStudent.jsp" class="btn">+ Student</a>
<a href="StudentServlet?action=prepareScore" class="btn">+ Score</a>

<table>
    <tr>
        <th>Id</th><th>Student Id</th><th>Student Name</th><th>Subject Name</th>
        <th>Score 1</th><th>Score 2</th><th>Credit</th><th>Grade Score</th><th>Grade</th>
    </tr>
    <c:forEach var="s" items="${scores}">
        <c:set var="totalScore" value="${0.3 * s.score1 + 0.7 * s.score2}" />
        <tr>
            <td>${s.student_score_id}</td>
            <td>${s.student.studentCode}</td>
            <td>${s.student.fullName}</td>
            <td>${s.subject.subjectName}</td>
            <td>${s.score1}</td>
            <td>${s.score2}</td>
            <td>${s.subject.credit}</td>
            <td>${totalScore}</td>
            <td>
                <c:choose>
                    <c:when test="${totalScore >= 8.0}">A</c:when>
                    <c:when test="${totalScore >= 6.0}">B</c:when>
                    <c:when test="${totalScore >= 4.0}">D</c:when>
                    <c:otherwise>F</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>