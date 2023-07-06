<%-- 
    Document   : kid_profile
    Created on : Jun 21, 2023, 5:23:29 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
       <head>
              <title>Profile</title>
              <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
       </head>
       <body>
              <%@include file="header.jsp" %>
              <div class="ftco-blocks-cover-1">
                     <!-- data-stellar-background-ratio="0.5" style="background-image: url('images/hero_1.jpg')" -->
                     <div class="site-section-cover overlay" data-stellar-background-ratio="0.5" style="background-image: url('assets/images/hero_1.jpg')">
                            <div class="container">
                                   <div class="row align-items-center ">

                                          <div class="col-md-5 mt-5 pt-5">
                                                 <span class="text-cursive h5 text-red">Profile</span>
                                                 <h1 class="mb-3 font-weight-bold text-teal">Welcome ${KID.kidAccount}</h1>
                                                 <p><a href="homepage.jsp" class="text-white">Home</a> <span class="mx-3">/</span> <strong>Profile</strong></p>
                                          </div>
                                   </div>
                            </div>
                     </div>
              </div>

              <div class="site-section bg-light" id="contact-section">
                     <div class="container">
                            <div class="row justify-content-center text-center">
                                   <div class="col-7 text-center mb-5">
                                          <h2>Let's review your profile !</h2>
                                          <p>Make sure that you have pay for your course to learn English.</p>
                                   </div>
                            </div>

                            <div class="row">
                                   <div class="col-lg-8 mb-5 bg-white pt-3 pb-3 "  >
                                          <h3 class="center">Course enrolled</h3>
                                          <c:if test="${COURSEINFO==null}">
                                                 <p style="color:red;"> You haven't enroll to any course yet !</p>
                                          </c:if>
                                          <c:if test="${COURSEINFO!=null}">

                                                 <table class="table">
                                                        <thead>
                                                               <tr>
                                                                      <th scope="col">Name</th>
                                                                      <th scope="col">Level</th>
                                                                      <th scope="col">Status</th>
                                                               </tr>
                                                        </thead>
                                                        <c:forEach var="i" items="${COURSEINFO}">
                                                               <tbody>
                                                                      <tr>
                                                                             <td>${i.courseName}</td>
                                                                             <td>${i.courseLevel}</td>
                                                                             <td>${i.status}</td>
                                                                      </tr>
                                                               </tbody>
                                                        </c:forEach>
                                                 </table>
                                          </c:if>
                                          <div class="course_box bg-white" ></div>
                                   </div>
                                   <div class="col-lg-4 ml-auto">
                                          <div class="bg-white p-3 p-md-5">
                                                 <h3 class="text-black mb-4">Kid Info</h3>
                                                 <ul class="list-unstyled footer-link">
                                                        <li class="d-block mb-3">
                                                               <img src="${KID.kidImage}" alt="Avatar" class="avatarkid"/>

                                                        <li class="d-block mb-3">
                                                               <span class="d-block text-black">Full name:</span><span>${KID.kidName}</span></li>
                                                        <li class="d-block mb-3"><span class="d-block text-black">Birthday:</span><span>${KID.kidBrithday}</span></li>
                                                 </ul>
                                          </div>
                                   </div>
                            </div>
                     </div>
              </div>
              <%@include file="footer.jsp" %>
       </body>
</html>
