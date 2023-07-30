<%@ page import="Entity.topic" %>
<%@ page import="java.util.ArrayList" %><%--
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
<style>
    h1 {
        text-align: center;
    }
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
</style>
<body>
<%@ page session="true" %>

<%
    ArrayList<topic> topics = (ArrayList<topic>) session.getAttribute("topics");
%>
<h1 >Create Lesson</h1>
<form action="AdminLessonController" method="post">
    <input type="hidden" name="action" value="CreateLesson">
    <label for="topicID">Topic ID:</label>
    <select id="topicID" name="topicID" required>
        <option value="">Select a course</option>
        <%-- Iterate over the courses and generate option elements --%>
        <% for (topic topic : topics) { %>
        <option value="<%= topic.getTopicID() %>"><%= topic.getTopicName() %></option>
        <% } %>
    </select>

    <br>

    <label for="lessonName">Lesson Name:</label>
    <input type="text" id="lessonName" name="lessonName" required><br>

    <input type="submit" value="CreateLesson" name="action">
</form>
</body>
</html>
