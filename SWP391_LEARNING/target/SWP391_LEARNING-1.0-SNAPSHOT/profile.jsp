<%-- 
    Document   : profile
    Created on : Jun 4, 2023, 6:45:33 PM
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
                     <div class="site-section-cover overlay" data-stellar-background-ratio="0.5" style="background-image: url('images/hero_1.jpg')">
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

              <div class="site-section bg-light" id="contact-section">
                     <div class="container">
                            <div class="row justify-content-center text-center">
                                   <div class="col-7 text-center mb-5">
                                          <h2>Create account for your Kid !!</h2>
                                          <p>Make sure that your kid have an account in order to learn English.</p>
                                   </div>
                            </div>
                            <c:if test="${sessionScope.PARENT==null} ">
                                   <a href="login.jsp">Login here !</a>
                            </c:if>
                            <div class="row">
                                   <div class="col-lg-8 mb-5" >
                                          <h3 class="center">Account for Kids</h3>
                                          <form action="MainController" method="post">
                                                 <input type="hidden" name="parentID" value="${PARENT.parentID}" />
                                                 <div class="form-group row">
                                                        <div class="col-md-12 mb-4 mb-lg-0">
                                                               <label class="form-label" for="labelkusername">Username</label>
                                                               <input type="text" id="labelkusername" class="form-control" name="kusername" required="">
                                                        </div>
                                                 </div>
                                                 <div class="form-group row">
                                                        <div class="col-md-6">
                                                               <label class="form-label" for="labelkpassword">Password</label>
                                                               <input type="password" id="labelkpassword" class="form-control" name="kpassword" required="">
                                                        </div>
                                                        <div class="col-md-6">
                                                               <label class="form-label" for="labelkconfpassword">Confirm Password</label>
                                                               <input type="password" id="labelkconfpassword" class="form-control" name="kconfpassword" required="">
                                                        </div>
                                                 </div>

                                                 <div class="form-group row">
                                                        <div class="col-md-8">
                                                               <label class="form-label" for="labelkfullname">Fullname</label>
                                                               <input type="text" class="form-control" name="kfullname" required="">
                                                        </div>
                                                        <div class="col-md-4">
                                                               <label class="form-label" for="labelkbirthday">Birthday</label>
                                                               <input id="labelkbirthday" type="date" class="form-control" name="kbirthday" required="">
                                                        </div>
                                                 </div>
                                                 <div class="form-group row">
                                                        <div class="col-md-12">
                                                               <label class="form-label" for="labelkimage">Kid image</label><br>
                                                               <input type="file" id="labelkimage" name="kimage" class="image"/>
                                                        </div>
                                                 </div>

                                                 <div class="form-group row">
                                                        <div class="col-md-6 mr-auto">
                                                               <br>
                                                               <h5 style="color:green">${msg}</h5>
                                                               <input type="submit" name ="action" class="btn btn-block btn-primary text-white py-3 px-5" value="Create">
                                                        </div>
                                                 </div>
                                          </form>
                                   </div>
                                   <div class="col-lg-4 ml-auto">
                                          <div class="bg-white p-3 p-md-5">
                                                 <h3 class="text-black mb-4">Parent Info</h3>
                                                 <ul class="list-unstyled footer-link">
                                                        <li class="d-block mb-3">
                                                               <span class="d-block text-black">Full name:</span>
                                                               <span>${PARENT.parentName}</span></li>
                                                        <li class="d-block mb-3"><span class="d-block text-black">Phone:</span><span>${PARENT.parentPhone}</span></li>
                                                        <li class="d-block mb-3"><span class="d-block text-black">Sex:</span><span>${PARENT.parentSex}</span></li>
                                                 </ul>
                                          </div>
                                   </div>
                            </div>
                     </div>
              </div>
              <%@include file="footer.jsp" %>
       </body>
</html>
