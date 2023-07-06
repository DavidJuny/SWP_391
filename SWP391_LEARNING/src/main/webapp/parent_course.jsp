<%-- 
    Document   : parent_course
    Created on : Jun 30, 2023, 12:12:29 PM
    Author     : PC
--%>


<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
       <head>
              <title>Course</title>
              <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
       </head>
       <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
              <%@include file="header.jsp" %>
              <div class="ftco-blocks-cover-1">
                     <!-- data-stellar-background-ratio="0.5" style="background-image: url('images/hero_1.jpg')" -->
                     <div class="site-section-cover overlay" data-stellar-background-ratio="0.5" style="background-image: url('assets/images/hero_1.jpg')">
                            <div class="container">
                                   <div class="row align-items-center ">

                                          <div class="col-md-5 mt-5 pt-5">
                                                 <span class="text-cursive h5 text-red">Join our Course !</span>
                                                 <h1 class="mb-3 font-weight-bold text-teal">Course</h1>
                                                 <p><a href="index.html" class="text-white">Home</a> <span class="mx-3">/</span> <strong>Course</strong></p>
                                          </div>
                                   </div>
                            </div>
                     </div>
              </div>
              <div class="site-section bg-light" style="background-color: #ebebeb">
                     <div class="container-fluid  ">
                            <div class="row justify-content-center text-center">
                                   <div class="col-7 text-center mb-5">
                                          <h2> Let's your kid have a great time with English ! </h2>
                                          <p>Make sure that your kid have an account in order to learn English.</p>
                                   </div>
                            </div>
                            <div class="container">
                                   <div class="row justify-content-center">
                                          <c:if test="${COURSELIST !=null}">
                                                 <c:forEach  var="i"  items="${COURSELIST}">
                                                        <div class="col-lg-4 mb-5 pb-5">
                                                               <div class="card" style="width: 18rem;">
                                                                      <img src="assets/images/post_1.jpg" class="card-img-top" alt="">
                                                                      <div class="card-body">
                                                                             <h5 class="card-title">${i.courseName}</h5>
                                                                             <p class="card-text">Course Level : ${i.courseLevel}</p>
                                                                             <form action="PaymentInfoController" method ="post">
                                                                                    <input type="hidden" name="courseID" value="${i.courseID}">
                                                                                    <button type="submit" class="btn btn-primary">Buy this Course</button>
                                                                             </form>
                                                                      </div>
                                                               </div>
                                                        </div>
                                                 </c:forEach>
                                          </c:if>
                                   </div>
                            </div>
                     </div>
              </div>
              <%@include file="footer.jsp" %>
       </body>
</html>
