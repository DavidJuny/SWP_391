<%-- 
    Document   : course
    Created on : Jun 21, 2023, 5:21:14 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
       <head>
              <title>Course page</title>
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
                                                 <span class="text-cursive h5 text-red">Begin to learn</span>
                                                 <h1 class="mb-3 font-weight-bold text-teal">Course</h1>
                                                 <p><a href="index.html" class="text-white">Home</a> <span class="mx-3">/</span> <strong>Course</strong></p>
                                          </div>
                                   </div>
                            </div>
                     </div>
              </div>
              <section class="site-section" style="background-color: #ebebeb">
                     <div class="container-fluid    ">
                            <h1 class="heading mt-3 text-center">Course's info</h1>
                            <hr>

                            <c:if test="${KIDLEARNING == null}">
                                   <p class ="text-center" style="color:red">You haven't buy any course yet !</p>
                            </c:if>
                            <div class="row justify-content-center">
                                   <c:forEach var="i" items="${KIDLEARNING}">
                                          <div class="col-3 m-3">
                                                 <div class="card" style="width: 25rem;">
                                                        <img src="${i.courseImage}" class="card-img-top"  alt="">
                                                        <div class="card-body">
                                                               <h5 class="card-title">${i.courseName}</h5>
                                                               <p class="card-text">Course level : ${i.courseLevel}</p>
                                                               <form action="LessonController" method ="post">
                                                                      <input type="hidden" name="courseID" value="${i.courseID}">
                                                                      <button type="submit" class="btn btn-primary">Let's start learning !</button>
                                                               </form>
                                                        </div>
                                                 </div>
                                          </div>
                                   </c:forEach>
                            </div>
                     </div>
              </section>

              <%@include file="footer.jsp" %>
       </body>

</html>
