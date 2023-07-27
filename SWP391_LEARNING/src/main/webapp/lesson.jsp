<%-- 
    Document   : lesson
    Created on : Jul 4, 2023, 12:11:04 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
       <head>
              <title>Lesson page</title>
              <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
              <link href="https://fonts.googleapis.com/css?family=DM+Sans:300,400,700|Indie+Flower" rel="stylesheet">

       </head>
       <body>
              <%@include file="header.jsp" %>
              <div class="ftco-blocks-cover-1">
                     <!-- data-stellar-background-ratio="0.5" style="background-image: url('images/hero_1.jpg')" -->
                     <div class="site-section-cover overlay" data-stellar-background-ratio="0.5" style="background-image: url('assets/images/hero_1.jpg')">
                            <div class="container">
                                   <div class="row align-items-center ">
                                          <div class="col-md-5 mt-5 pt-5">
                                                 <span class="text-cursive h5 text-red">Let's start learning</span>
                                                 <h1 class="mb-3 font-weight-bold text-teal">Lesson</h1>
                                                 <p><a href="homepage.jsp" class="text-white">Home</a> <span class="mx-3">/</span> <strong>Lesson</strong></p>
                                          </div>
                                   </div>
                            </div>
                     </div>
              </div>
              <section class="site-section" style="background-color: #ebebeb">
                     <h1 class="heading mt-3 text-center">Chose your lesson and start learning</h1>
                     <div class="container justify-content-center  ">

                            <hr>
                            <c:if test="${LESSON_LIST == null}">
                                   <p class ="text-center" style="color:red">Please buy course to begin your lesson !</p>
                            </c:if>
                            <div class="row justify-content-center">
                                   <c:if test="${ COURSEID != null }">
                                          <c:forEach var="i" items="${LESSON_LIST}">
                                                 <c:if test="${(i.topic.courseID) == COURSEID}">
                                                        <div class='col-12'>
                                                               <div class="card mb-3">
                                                                      <div class="row g-0">
                                                                             <div class="col-md-4">
                                                                                    <img src="i.topic.topicImage" class="img-fluid rounded-start" alt="...">
                                                                             </div>
                                                                             <div class="col-md-8">
                                                                                    <div class="card-body">
                                                                                           <h5 class="card-title">${i.topic.topicName}</h5>
                                                                                           <p class="card-text">
                                                                                                  Lesson: ${i.lessonName}</p>
                                                                                           <p class="card-text">
                                                                                                  Course enrolled: ${i.topic.course.courseName}<br>
                                                                                                  Course level: ${i.topic.course.courseLevel}</p>
                                                                                           <form method="GET" action="LessonItemController" >
                                                                                                  <input type="hidden" name="lessonID" value="${i.lessonID}">
                                                                                                  <button type="submit" class="btn btn-primary">Let's Learn</button>
                                                                                           </form>
                                                                                    </div>
                                                                             </div>
                                                                      </div>
                                                               </div>
                                                        </div>
                                                 </c:if>
                                          </c:forEach>
                                   </c:if>
                            </div>
                     </div>
              </section>
              <%@include file="footer.jsp" %>
       </body>
</html>