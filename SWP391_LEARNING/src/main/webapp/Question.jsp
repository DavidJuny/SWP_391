<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/23/2023
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
    <title>Quiz</title>
    <style>
        body{
            background-color:#eee;
        }

        label.radio {
            cursor: pointer;
        }

        label.radio input {
            position: absolute;
            top: 0;
            left: 0;
            visibility: hidden;
            pointer-events: none;
        }

        label.radio span {
            padding: 4px 0px;
            border: 1px solid red;
            display: inline-block;
            color: red;
            width: 100px;
            text-align: center;
            border-radius: 3px;
            margin-top: 7px;
            text-transform: uppercase;
        }

        label.radio input:checked + span {
            border-color: red;
            background-color: red;
            color: #fff;
        }

        .ans {
            margin-left: 36px !important;
        }

        .btn:focus {
            outline: 0 !important;
            box-shadow: none !important;
        }

        .btn:active {
            outline: 0 !important;
            box-shadow: none !important;
        }

    </style>
</head>
<body>

<div class="question bg-white p-3 border-bottom">
    <div class="d-flex flex-row justify-content-between align-items-center mcq">
        <h4>${lesson.lessonName} Quiz
    </div>
    <h2>
        <span>
            Read the following paragraph and answer the question.There are ${fn:length(newquestions)} questions :
            <br>
            ${lessonItem.content}
        </span>
    </h2>
</div>
<%-- Check if the form is submitted --%>
<c:if test="${not empty points}">
    <div class="container mt-5">
        <h3>Quiz Results</h3>
        <p>Points: ${points}</p>
        <h4>Incorrect Answers:</h4>
        <c:if test="${not empty incorrectAnswers}">
            <ul>
                <c:forEach var="entry" items="${incorrectAnswers}">
                    <li>Q.${entry.key}, Submitted Answer: ${entry.value}</li>
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${empty incorrectAnswers}">
            <p>No incorrect answers.</p>
        </c:if>
    </div>
</c:if>
<form method="post" action="QuestionController">
<c:forEach var ="question" items="${newquestions}">
<div class="container mt-5">
    <div class="d-flex justify-content-center row">
        <div class="col-md-10 col-lg-10">
            <div class="border">

                <div class="question bg-white p-3 border-bottom">
                    <div class="d-flex flex-row align-items-center question-title">
                        <h3 class="text-danger">Q.${question.questionID}</h3>
                        <h5 class="mt-1 ml-2">${question.question}</h5>
                    </div>
                    <c:forEach var="answer" items="${question.answer}">
                    <div class="ans ml-2">
                    <label class="radio"> <input type="radio"  name="answers[${question.questionID}]" value="${answer}"> <span>${answer}</span>
                    </label>
                </div>

                </div>
                </c:forEach>
                </c:forEach>

                <div class="d-flex flex-row justify-content-between align-items-center p-3 bg-white">
                    <input type="submit" name="action" value="Submit Answer">
                </div>
            </div>
        </div>
    </div>
</div>
</form>

</body>
</html>
