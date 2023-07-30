<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/29/2023
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Lesson</title>
</head>
<body>
<h1>Create Lesson</h1>
<form action="AdminLessonController" method="post">
    <input type="hidden" name="action" value="CreateLesson">
    <label for="topicID">Topic ID:</label>
    <input type="text" id="topicID" name="topicID" required><br>

    <label for="lessonName">Lesson Name:</label>
    <input type="text" id="lessonName" name="lessonName" required><br>

    <input type="submit" value="CreateLesson" name="action">
</form>
</body>
</html>
