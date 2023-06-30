<%-- 
    Document   : payment
    Created on : Jun 30, 2023, 12:16:16 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
       <head>
              <title>Payment</title>
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
                                                 <h1 class="mb-3 font-weight-bold text-teal">Welcome ${PARENT.parentAccount}</h1>
                                                 <p><a href="homepage.jsp" class="text-white">Home</a> <span class="mx-3">/</span> <strong>Profile</strong></p>
                                          </div>
                                   </div>
                            </div>
                     </div>
              </div>
              <div class="site-section bg-white">
                     <div class="row justify-content-center text-center">
                            <div class="col-lg-8 mb-5" >
                                   <c:if test="${INFO!= null}">
                                          <h3 class="center">Please pay for the course regularly to improve our facilities !!</h3>
                                   </c:if>
                                   <c:if test="${INFO== null}">
                                          <h3 class="center" style=' color:red;'><a href="Parent_CourseController">Please chose which course you want to pay !!</a></h3>
                                   </c:if>
                            </div>
                            <div class="col-lg-8 mb-5">
                                   <div class="card p-3 " style="background-color: #e8e8e8">
                                          <div class="card-body ">
                                                 <p>
                                                        <a class="btn btn-primary p-2 w-100 h-100 d-flex align-items-center justify-content-between"
                                                           data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="true"
                                                           aria-controls="collapseExample">
                                                               <span class="fw-bold">Make Payment !!</span>
                                                               <span class="">
                                                                      <span class="fa fa-cc-amex fa-2x"></span>
                                                                      <span class="fa fa-cc-mastercard fa-2x"></span>
                                                                      <span class="fa fa-cc-discover fa-2x"></span>
                                                               </span>
                                                        </a>
                                                 </p>
                                                 <div class="collapse show p-3 pt-0" id="collapseExample">
                                                        <div class="row">
                                                               <div class="col-lg-5 mb-lg-0 mb-3">
                                                                      <p class="h4 mb-0">Course Info</p>
                                                                      <br>

                                                                      <p class="mb-0"><span class="fw-bold">Course Name: </span><span class="c-green">${INFO.courseName}</span>
                                                                      </p>
                                                                      <p class="mb-0">
                                                                             <span class="fw-bold">Price:</span>
                                                                             <span class="c-green">$50.00</span>
                                                                      </p>
                                                                      <p class="mb-0">Course Level: ${INFO.courseLevel}</p>
                                                               </div>
                                                               <div class="col-lg-7">
                                                                      <form action="PaymentController" method="post" class="form">
                                                                             <div class="row">
                                                                                    <div class="col-12">
                                                                                           <div class="form__div">
                                                                                                  <input id="Name" type="text" class="form-control" required="" disabled="" value="${PARENT.parentName}">
                                                                                                  <label for="Name" class="form__label">Parent's Name</label>
                                                                                           </div>
                                                                                    </div>
                                                                                    <div class="col-8">
                                                                                           <div class="form__div">
                                                                                                  <input id="CourseName" type="text" disabled="" required=""  class="form-control" value="${INFO.courseName}">
                                                                                                  <label for="CourseName" class="form__label">Course's Name</label>
                                                                                                  <input type="hidden" name="courseID" value="${INFO.courseID}"/>
                                                                                           </div>
                                                                                    </div>
                                                                                    <div class="col-4">
                                                                                           <div class="form__div">
                                                                                                  <input id="money" type="number"  class="form-control" name="ammount" value="50" required="">
                                                                                                  <label for="money" class="form__label">Course Cost</label>
                                                                                           </div>
                                                                                    </div>
                                                                                    <div class="col-12">
                                                                                           <select class="form-control" name="kidID" id="kids" aria-label="" required="">
                                                                                                  <option selected disabled=""> Select your kids</option>
                                                                                                  <c:forEach var="i" items="${KIDLIST}">
                                                                                                         <option value="${i.kidID}">${i.kidName}</option>
                                                                                                  </c:forEach>
                                                                                           </select>
                                                                                           <label for="kids" class="form__label">Your Kids</label>
                                                                                    </div>
                                                                                    <br></br>
                                                                                    <div class="col-12">
                                                                                           <button type="submit"  class="btn btn-primary w-100" >Purchase</button>
                                                                                    </div>

                                                                                    <div class="col-12">
                                                                                           <br>
                                                                                           <p>${msg}</p>
                                                                                    </div>
                                                                             </div>
                                                                      </form>
                                                               </div>
                                                        </div>
                                                 </div>
                                          </div>
                                   </div>
                            </div>
                     </div>
              </div>
              <%@include file="footer.jsp" %>
       </body>
</html>