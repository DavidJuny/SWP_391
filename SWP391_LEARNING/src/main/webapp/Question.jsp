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

       </head>
       <body>
              <section class="site-section bg-light">
                     <div class="container">

                            <div class="question bg-white p-3 border-bottom">
                                   <h2 class="text-center ">${lesson.lessonName} Quiz</h2>
                                   <h4>
                                          <span>
                                                 Read the following paragraph and answer the question. There are ${fn:length(newquestions)} questions :
                                                 <br>
                                                 ${lessonItem.content}
                                          </span>
                                   </h4>
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
                                                               <input class="btn btn-primary" type="submit" name="action" value="Submit Answer">
                                                        </div>
                                                 </div>
                                          </form>
                                   </div>
                            </div>
                     </div>
              </section>
       </body>
</html>

