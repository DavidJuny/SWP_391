<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/29/2023
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Question</title>
</head>
<body>
<h2>Create Question</h2>
<form method="post" action="AdminQuestionController"> <!-- Replace "YourServletName" with the actual name of your servlet or server-side endpoint -->
    <input type="hidden" name="action" value="CreateQuestion"> <!-- Hidden input field to set the 'action' parameter -->
    <label for="lessonItemID">Lesson Item ID:</label>
    <input type="number" id="lessonItemID" name="lessonItemID">
    <br>
    <label for="question">Question:</label>
    <input type="text" id="question" name="question" required>
    <br>
    <label for="answer">Answer:</label>
    <input type="text" id="answer" name="answer" required>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

