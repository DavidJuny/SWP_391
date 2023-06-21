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
                     <div class="site-section-cover overlay" data-stellar-background-ratio="0.5" style="background-image: url('images/hero_1.jpg')">
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
                     <div class="container-fluid  ">
                            <h1 class="heading mt-3">Course's info</h1>
                            <br>
                            <div class="line"></div>
                            <br>
                            <div class="row">
                                   <c:if test="${KIDLEARNING == null}  ">
                                          <p>You haven't pay for any course at the moment</p>
                                   </c:if>
                                   <c:if test="${KIDLEARNING != null}  ">

                                          <c:forEach  var="i"  items="${KIDLEARNING}">
                                                 <div class="col-md-4">
                                                        <div class="box-container">
                                                               <div class="box">
                                                                      <div class='row'>
                                                                             <div class="col-12">
                                                                                    <div class="tutor">
                                                                                           <img class="avatar" src="${KID.kidImage}" alt="">
                                                                                           <div class="info">
                                                                                                  <h3>${KID.kidName}</h3>
                                                                                                  <h3>Course level: ${i.courseLevel}</h3>
                                                                                           </div>
                                                                                    </div>
                                                                             </div>
                                                                             <div class="col-12">
                                                                                    <div class="thumb">
                                                                                           <img src="${i.courseImage}" alt="">
                                                                                    </div>
                                                                                    <br>
                                                                                    <h3 class="title">${i.courseName}</h3>
                                                                             </div>
                                                                             <div class="col-12">
                                                                                    <c:if test="${(i.status).equals('Lock')}">
                                                                                           <h5 ><a  href="#">Purchase</a> this course to start Learning !</h5>
                                                                                    </c:if>
                                                                                    <c:if test="${(i.status).equals('UnLock')}">
                                                                                           <h5>Click <a style="color:green" href="#"> here !</a> to start course</h5>
                                                                                    </c:if>
                                                                             </div>
                                                                      </div>
                                                               </div>
                                                        </div>
                                                 </div>
                                          </c:forEach>
                                   </c:if>
                            </div>
              </section>
              <%@include file="footer.jsp" %>
       </body>
</html>
