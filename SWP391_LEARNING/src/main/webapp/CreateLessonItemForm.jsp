<%@ page import="Entity.lesson" %>
<%@ page import="java.util.ArrayList" %><%--
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
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: "Roboto", "Helvetica", "Arial", sans-serif;
        background-color: #f2f2f2;
    }

    form {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        margin-top: 10vh;
    }

    label {
        font-size: 14px;
        font-weight: 500;
        color: #333;
        margin-bottom: 5px;
    }

    input[type="text"],
    input[type="password"] {
        width: 250px;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 3px;
        font-size: 14px;
        transition: border-color 0.3s ease-in-out;
    }

    input[type="text"]:focus,
    input[type="password"]:focus {
        border-color: #4CAF50;
    }

    input[type="submit"] {
        width: 100px;
        padding: 10px;
        border: none;
        border-radius: 3px;
        font-size: 14px;
        font-weight: 500;
        color: #fff;
        background-color: #4CAF50;
        cursor: pointer;
        transition: background-color 0.3s ease-in-out;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    .error-message {
        color: #ff0000;
        margin-top: 5px;
    }

    .error-input {
        border-color: #ff0000;
    }

    .name-length {
        color: #999;
        margin-top: 5px;
    }
    h1 {
        text-align: center;
    }
</style>
<body>
<%@ page session="true" %>

<%
    ArrayList<lesson> lessons = (ArrayList<lesson>) session.getAttribute("lessons");
%>
<h1 >Create Lesson Item</h1>
<form action="AdminLessonItemController" method="post">
    <label for="lessonID">Lesson ID:</label>
    <select id="lessonID" name="lessonID" required>
        <option value="">Select a course</option>
        <%-- Iterate over the courses and generate option elements --%>
        <% for (lesson lesson : lessons) { %>
        <option value="<%= lesson.getLessonID() %>"><%= lesson.getLessonName() %></option>
        <% } %>
    </select>
    <br>

    <label for="ItemTypeID">Item Type ID:</label>
    <select id="ItemTypeID" name="ItemTypeID" required>
        <option value="">Select Type</option>
        <%-- Iterate over the courses and generate option elements --%>
        <option value="Read">Read</option>
        <option value="Listen">Listen</option>
        <option value="Speak">Speak</option>
    </select><br>

    <label for="content">Content:</label>
    <textarea id="content" name="content" rows="4" cols="50" required></textarea><br>

    <input type="submit" value="CreateLessonItem" name="action">
</form>
</body>
</html>
