<%@taglib uri="jakarta.tags.core" prefix="c"%>
<h2>Edit Student Score</h2>
<form action="StudentServlet" method="POST">
    <input type="hidden" name="action" value="updateScore">
    <input type="hidden" name="scoreId" value="${score.student_score_id}">

    Student: <strong>${score.student.fullName}</strong><br><br>
    Subject: <strong>${score.subject.subjectName}</strong><br><br>

    Score 1: <input type="number" step="0.1" name="score1" value="${score.score1}" required><br><br>
    Score 2: <input type="number" step="0.1" name="score2" value="${score.score2}" required><br><br>

    <input type="submit" value="Update Score">
</form>