<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
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
  <script>
    function validateForm() {
      var courseIdInput = document.getElementById("courseId");
      var courseIdValue = courseIdInput.value.trim();

      var pattern = /^C\d/;
      if (!pattern.test(courseIdValue)) {
        var errorMessage = "Course ID must start with 'C' followed by a number.";
        var errorContainer = document.getElementById("errorContainer");
        errorContainer.innerHTML = "<p class='error-message'>" + errorMessage + "</p>";
        courseIdInput.classList.add("error-input");
        return false; // Prevent form submission
      }

      var courseLevelInput = document.getElementById("courseLevel");
      var courseLevelValue = parseInt(courseLevelInput.value);
      if (isNaN(courseLevelValue) || courseLevelValue <= 0) {
        var errorMessage = "Course Level must be a positive integer.";
        var errorContainer = document.getElementById("errorContainer");
        errorContainer.innerHTML = "<p class='error-message'>" + errorMessage + "</p>";
        courseLevelInput.classList.add("error-input");
        return false; // Prevent form submission
      }

      return true; // Allow form submission
    }

    function trackNameLength(input) {
      var nameLength = input.value.length;
      var nameLengthContainer = document.getElementById("nameLengthContainer");
      nameLengthContainer.innerHTML = "<p class='name-length'>" + nameLength + " characters</p>";

      var courseNameInput = document.getElementById("courseName");
      if (nameLength < 20) {
        courseNameInput.classList.add("error-input");
      } else {
        courseNameInput.classList.remove("error-input");
      }
    }
  </script>
</head>

<body>
<form action="CourseController" method="post" onsubmit="return validateForm()">
  <label for="courseId">Course ID:</label>
  <input type="text" id="courseId" name="courseId" required>

  <label for="courseName">Course Name:</label>
  <input type="text" id="courseName" name="courseName" oninput="trackNameLength(this)" required>
  <div id="nameLengthContainer"></div>

  <label for="courseImage">Course Image:</label>
  <input type="text" id="courseImage" name="courseImage" required>

  <label for="courseLevel">Course Level:</label>
  <input type="text" id="courseLevel" name="courseLevel" required>

  <input type="submit" name="action" value="CreateCourse">

  <div id="errorContainer">
    <c:if test="${not empty error}">
      <p class="error-message">${error}</p>
    </c:if>
  </div>
</form>
</body>

</html>
