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
              <script src="STT.js"></script>
              <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


              <!-- MAIN CSS -->
              <link rel="stylesheet" href="assets/css/style.css">
              <style>
                     .center {
                            text-align: center;
                     }
              </style>

              <title>Quiz</title>
       </head>
       <body>
              <c:if test="${lessonItem.itemTypeID.equalsIgnoreCase('Read') or lessonItem.itemTypeID.equalsIgnoreCase('Listen')}">

                     <section class="site-section bg-light">
                            <div class="container">
                                   <c:if test="${not empty newquestions}">

                                          <div class="question bg-white p-3 border-bottom">
                                                 <h2 class="text-center ">${lesson.lessonName} Quiz</h2>
                                                 <h4>Read the following paragraph and answer the question. There are ${fn:length(newquestions)} questions :</h4>
                                                 <br>
                                                 <p>${lessonItem.content}</p>
                                                 <br>
                                                 <audio controls autoplay>
                                                        <source src="./ListeningAudio/${lessonItem.content}" type="audio/mpeg">
                                                        Your browser does not support the audio element.
                                                 </audio>
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
                                                 <c:if test="${points == fn:length(questions)}">
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
                                                                                                  <h3 style="color:#ff9900;">Q.${question.questionID}: ${question.question}</h3>
                                                                                           </div>

                                                                                           <c:forEach var="answer" items="${question.answer}">
                                                                                                  <div class="row ">
                                                                                                         <div class="col-lg-12">
                                                                                                                <label class="radio"> <input type="radio"  name="answers[${question.questionID}]" value="${answer}"> <span>${answer}</span>
                                                                                                                </label>
                                                                                                         </div>
                                                                                                  </div>
                                                                                           </c:forEach>

                                                                                    </div>
                                                                             </div>
                                                                      </div>
                                                                      <br>
                                                               </c:forEach>
                                                               <div class="col-12 col-lg-12">
                                                                      <div class="justify-content-between align-items-center p-3 bg-white">
                                                                             Make sure to check your answer before submit:
                                                                             <input type="hidden" name="lessonItemID" value="${lessonItem.lessonItemID}">
                                                                             <input type="hidden" name="itemTypeID" value="${lessonItem.itemTypeID}">
                                                                             <input class="btn btn-success" type="submit" name="action" value="Submit Answer">
                                                                      </div>
                                                               </div>
                                                        </form>
                                                 </c:if>
                                                 <form method="post" action="QuestionController">
                                                        <input type="hidden" name="lessonItemID" value="${lessonItem.lessonItemID}">
                                                        <input  class="btn btn-primary" type="submit" name="action" value="Reload">
                                                        <a class="btn btn-primary" href="LessonItemController?lessonID=${lessonItem.lessonID}" >Return To Lesson</a>
                                                 </form>

                                          </div>
                                   </div>
                            </div>
                     </section>
              </c:if>
              <c:if test="${lessonItem.itemTypeID.equalsIgnoreCase('Speak')}">
                     <section class="site-section bg-light">
                            <div class="container">
                                   <div class="question bg-white p-3 border-bottom">
                                          <h2 class="text-center ">${lesson.lessonName} Quiz</h2>
                                          <h4>
                                                 This is the speaking practice test:
                                          </h4>
                                          <br>
                                          <p>${lessonItem.content}</p>
                                   </div>
                                   <c:if test="${not empty newquestions}">
                                          <div class="container mt-5">
                                                 <div class="d-flex justify-content-center row" >
                                                        <c:forEach var="question" items="${newquestions}" varStatus="status">
                                                               <div class="col-12 col-lg-12" style="padding: 1rem;">
                                                                      <div class="border">
                                                                             <div class="question bg-white p-3 border-bottom">
                                                                                    <h4 class="text-danger">Q.${question.questionID}: ${question.question}</h4>
                                                                                    <br>
                                                                                    <div class="speaker" style="display: flex;justify-content: space-between;width: 13rem;box-shadow: 0 0 13px #0000003d;border-radius: 5px;">
                                                                                           <p id="action-${question.questionID}" style="color: grey;font-weight: 800; padding: 0; padding-left: 2rem;"></p>
                                                                                           <button class="btn-success" onclick="runSpeechRecog(${question.questionID})" style="border: transparent;padding: 0 0.5rem;">
                                                                                                  Speech
                                                                                           </button>
                                                                                    </div>
                                                                                    <h3 id="output-${question.questionID}" class="hide"></h3>
                                                                                    <form id="speechForm-${question.questionID}" action="STTController" method="post">
                                                                                           <input id="transcriptInput-${question.questionID}" type="hidden" name="transcript">
                                                                                           <input type="hidden" name="pattern" value="${question.question}">
                                                                                           <input type="hidden" name="lessonItemID" value="${lessonItem.lessonItemID}">
                                                                                    </form>
                                                                             </div>
                                                                      </div>
                                                               </div>
                                                        </c:forEach>
                                                 </div>
                                          </div>

                                          <br>

                                          <c:if test="${speechPoint != null}">

                                                 <script>
                                                        Swal.fire({
                                                               title: "Result",
                                                               html: `
                                             <h4>Text you just said: ${text}</h4>
                                             <h4>Score based on what you said is :</h4>
                                             <div class="center">
                                               <h4>${speechPoint}</h4>
                                             </div>
                                           `,
                                                               confirmButtonText: "Close"
                                                        });
                                                 </script>
                                          </c:if>
                                   </c:if>
                                   <div class="center">
                                          <form method="post" action="QuestionController">
                                                 <input type="hidden" name="lessonItemID" value="${lessonItem.lessonItemID}">
                                                 <a class="btn btn-primary" href="LessonItemController?lessonID=${lessonItem.lessonID}">Return To Lesson</a>
                                          </form>
                                   </div>
                            </div>
                     </section>
              </c:if>
       </body>
</html>