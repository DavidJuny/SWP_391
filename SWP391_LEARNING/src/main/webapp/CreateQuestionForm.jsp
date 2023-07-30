<%@ page import="DAO.LessonDAO" %>
<%@ page import="Entity.lessonItem" %>
<%@ page import="java.util.ArrayList" %><%--
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
<%
    LessonDAO lessonDAO = new LessonDAO();
    ArrayList<lessonItem> lessonItems = lessonDAO.GetAllLessonItem();

%>
<h1 >Create Question</h1>
<form method="post" action="AdminQuestionController"> <!-- Replace "YourServletName" with the actual name of your servlet or server-side endpoint -->
    <input type="hidden" name="action" value="CreateQuestion"> <!-- Hidden input field to set the 'action' parameter -->
    <label for="lessonItemID">Lesson Item ID:</label>
    <select id="lessonItemID" name="lessonItemID" required>
        <option value="">Select a course</option>
        <%-- Iterate over the courses and generate option elements --%>
        <% for (lessonItem lessonItem : lessonItems) { %>
        <option value="<%= lessonItem.getLessonItemID() %>"><%= lessonItem.getContent() %></option>
        <% } %>
    </select>
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

