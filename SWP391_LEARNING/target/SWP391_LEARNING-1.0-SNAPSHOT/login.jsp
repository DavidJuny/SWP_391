<%-- 
    Document   : login
    Created on : Jun 2, 2023, 10:53:17 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <head>
              <title>Login</title>
              <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
              <meta charset="utf-8">
              <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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

              <!-- MAIN CSS -->
              <link rel="stylesheet" href="assets/css/style.css">


       </head>
       <body>
              <%
                     String username = "", password = "", remember = "";
                     Cookie[] cookies = request.getCookies();
                     if (cookies != null) {
                            for (Cookie cook : cookies) {
                                   if (cook.getName().equals("cookieUsername")) {
                                          username = cook.getValue();
                                   } else if (cook.getName().equals("cookiePassword")) {
                                          password = cook.getValue();
                                   } else if (cook.getName().equals("cookieRemember")) {
                                          remember = cook.getValue();
                                   }
                            }
                     }
              %>
              <section class="vh-100">
                     <div class="container mt-5">
                            <div class="row">
                                   <div class="col-sm-6 text-black mt-5">
                                          <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">
                                                 <div class="login-box">
                                                        <form action="MainController" method="post" style="width: 23rem;">

                                                               <h3 class="fw-normal mb-3 pb-3 mt-5" style="letter-spacing: 1px;">Log in</h3>

                                                               <div class="form-outline mb-4">
                                                                      <input type="text" id="labelusername" name="username" required="" value="<%=username%>" class="form-control form-control-lg" />
                                                                      <label class="form-label" for="labelusername">Username</label>
                                                               </div>

                                                               <div class="form-outline mb-4">
                                                                      <input type="password" id="labelpassword" name="password" required=""  value="<%=password%>" class="form-control form-control-lg" />
                                                                      <label class="form-label" for="labelpassword">Password</label>
                                                               </div>

                                                               <div class="pt-1 mb-4">
                                                                      <button class="btn btn-info btn-lg btn-block" type="submit" name ="action" value="Login">Login</button>
                                                               </div>

                                                               <p class="small mb-5 pb-lg-2"><a class="text-muted" href="#!">Forgot password?</a></p>
                                                               <h6 class="h6" style="color:red">${msg}</h6
                                                               <p>Don't have an account? <a href="register.jsp" class="link-info">Register here</a></p>

                                                        </form>
                                                 </div>
                                          </div>

                                   </div>
                                   <div class="col-sm-6 px-0 d-none d-sm-block">
                                          <img src="assets/images/loginpicture-3.png"
                                               alt="Login image" class="login_image_1" style="object-fit: cover; object-position: left;">
                                   </div>
                            </div>
                     </div>
              </section>
       </body>
</html>
