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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=DM+Sans:300,400,700|Indie+Flower" rel="stylesheet">
    <link rel="stylesheet" href="assets/fonts/icomoon/style.css">
    <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="assets/css/jquery.fancybox.min.css">
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="assets/fonts/flaticon/font/flaticon.css">
    <link rel="stylesheet" href="assets/css/aos.css">
    <link href="assets/css/course.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/kid_profile.css" rel="stylesheet" type="text/css"/>


    <!-- MAIN CSS -->
    <link rel="stylesheet" href="assets/css/style.css">


    <title>Quiz</title>
    <!--              <style>
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
                  </style>-->
</head>
<body>

<section class="site-section bg-light">
    <div class="container">
        <c:if test="${not empty newquestions}">

        <div class="question bg-white p-3 border-bottom">
            <h2 class="text-center ">${lesson.lessonName} Quiz</h2>
            <h4>
                                          <span>
                                                 Read the following paragraph and answer the question. There are ${fn:length(newquestions)} questions :
                                                 <br>
                                                 ${lessonItem.content}
                                               <audio controls autoplay>
  <source src="./ListeningAudio/${lessonItem.content}" type="audio/mpeg">
Your browser does not support the audio element.
</audio>
                                          </span>
            </h4>
        </div>
        </c:if>
        <%-- Check if the form is submitted --%>
        <c:if test="${not empty points}">
            <div class="container mt-5">
                <h3>Quiz Results</h3>
                <p>Points: ${points}</p>
                <c:if test="${not empty incorrectAnswers}">
                    <h4>Incorrect Answers:</h4>
                    <ul>
                        <c:forEach var="entry" items="${incorrectAnswers}">
                            <li style="color: red">Q.${entry.key}, Submitted Answer: ${entry.value}</li>
                        </c:forEach>
                    </ul>
                </c:if>
                <c:if test="${empty incorrectAnswers and points == fn:length(newquestions)}">
                    <p style="color: darkseagreen">All of the answers is correct</p>
                </c:if>
            </div>
        </c:if>
        <c:if test="${points ==0}">
            <p style="color: red"> No answer was submitted</p>
        </c:if>


        <c:if test="${not empty newquestions}">
        <div class="container mt-5">
            <div class="d-flex justify-content-center row">
                <form method="post" action="QuestionController">
                    <c:forEach var ="question" items="${newquestions}">
                        <div class="col-12 col-lg-12">
                            <div class="border">
                                <div class="question bg-white p-3 border-bottom">
                                    <div class="d-flex flex-row align-items-center question-title">
                                        <h3 class="text-danger">Q.${question.questionID}: ${question.question}</h3>
                                    </div>
                                    <div class="row ">
                                        <div class="col-lg-4">
                                            <c:forEach var="answer" items="${question.answer}">
                                                <label class="radio"> <input type="radio"  name="answers[${question.questionID}]" value="${answer}"> <span>${answer}</span>
                                                </label>

                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br>
                    </c:forEach>
                    <div class="col-12 col-lg-12">
                        <div class="justify-content-between align-items-center p-3 bg-white">
                            Make sure to check your answer before submit:
                            <input type="hidden" name="lessonItemID" value="${lessonItem.lessonItemID}">
                            <input class="btn btn-primary" type="submit" name="action" value="Submit Answer">
                        </div>
                    </div>
                </form>
                </c:if>
                <form method="post" action="QuestionController">
                    <input type="hidden" name="lessonItemID" value="${lessonItemID}">
                    <input  class="btn btn-primary" type="submit" name="action" value="Reload">
                    <button class="btn btn-primary">
                        <a style="color: white" href="LessonController" class="nav-link">Return To Lesson</a>
                    </button>
                </form>

            </div>
        </div>
    </div>
</section>
</body>
</html>