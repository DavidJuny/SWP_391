<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/29/2023
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Lesson Item</title>
</head>
<body>
<h1>Create Lesson Item</h1>
<form action="AdminLessonItemController" method="post">
    <label for="lessonID">Lesson ID:</label>
    <input type="number" id="lessonID" name="lessonID" required><br>

    <label for="ItemTypeID">Item Type ID:</label>
    <input type="text" id="ItemTypeID" name="ItemTypeID" required><br>

    <label for="content">Content:</label>
    <textarea id="content" name="content" rows="4" cols="50" required></textarea><br>

    <input type="submit" value="CreateLessonItem" name="action">
</form>
</body>
</html>
