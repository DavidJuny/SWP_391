<%@ page import="java.util.ArrayList" %>
<%@ page import="Entity.course" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/13/2023
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Topic Form</title>
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
</style>
<body>
<%-- Retrieve the courses attribute --%>
<%@ page session="true" %>

<%
  ArrayList<course> courses = (ArrayList<course>) session.getAttribute("courses");
%>

<!-- Use the `courses` variable as needed -->
<taglib:tag courses="${courses}" />
<form action="TopicController" method="post" onsubmit="return validateForm()">
  <label for="topicID">Topic ID:</label>
  <input type="text" id="topicID" name="topicID" required>

  <label for="courseName">Course ID:</label>
  <select id="courseName" name="courseName" required>
    <option value="">Select a course</option>
    <%-- Iterate over the courses and generate option elements --%>
    <% for (course course : courses) { %>
    <option value="<%= course.getCourseID() %>"><%= course.getCourseName() %></option>
    <% } %>
  </select>

  <label for="topicName">Topic Name:</label>
  <input type="text" id="topicName" name="topicName" required>

  <label for="topicImage">Topic Image:</label>
  <input type="file" id="topicImage" name="topicImage" required>

  <input type="submit" name="action" value="CreateTopic">

  <div id="errorContainer">
    <c:if test="${not empty error}">
      <p class="error-message">${error}</p>
    </c:if>
  </div>
</form>
<script>
  function validateForm() {
    var topicNameInput = document.getElementById("topicName");
    var topicImageInput = document.getElementById("topicImage");
    var topicNameValue = topicNameInput.value;
    var topicImageValue = topicImageInput.value;

    // Validate topic name length
    if (topicNameValue.length < 10) {
      alert("Topic name must be at least 10 characters long.");
      return false;
    }

    // Validate file name and extension
    var validExtensions = [".jpg", ".jpeg", ".png"];
    var topicImageExtension = topicImageValue.substring(topicImageValue.lastIndexOf(".")).toLowerCase();
    if (!validExtensions.includes(topicImageExtension)) {
      alert("Please select a file with a valid image extension: .jpg, .jpeg, .png");
      return false;
    }

    return true; // Form is valid, proceed with submission
  }
</script>
</body>
</html>
