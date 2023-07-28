<%-- 
    Document   : homepage
    Created on : May 23, 2023, 1:43:47 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Home page</title>
        <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
        <link href="https://fonts.googleapis.com/css?family=DM+Sans:300,400,700|Indie+Flower" rel="stylesheet">

    </head>


    <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">


        <%@include file="header.jsp" %>
                     <div class="ftco-blocks-cover-1">
                     <div class="site-section-cover overlay">
                            <div class="container">
                                   <div class="row align-items-center ">
                                          <div class="col-md-5 mt-5 pt-5">
                                                 <span class="text-cursive h5 text-red">Welcome To Our Website</span>
                                                 <h1 class="mb-3 font-weight-bold text-teal">Bring Fun Life To Your Kids</h1>
                                                 <p>Amazing Playground for your kids</p>
                                                 <p class="mt-5"><a class="btn btn-primary py-4 btn-custom-1">Well come</a></p>
                                          </div>
                                          <div class="col-md-6 ml-auto align-self-end">
                                                 <img src="assets/images/kid_transparent.png" alt="Image" class="img-fluid">
                                          </div>
                                   </div>
                            </div>
                     </div>
              </div>

              <div class="site-section bg-light">
                     <div class="container">
                            <div class="row">
                                   <div class="col-md-6 mb-5 mb-md-0">
                                          <img src="assets/images/img_1.jpg" alt="Image" class="img-fluid">
                                   </div>
                                   <div class="col-md-5 ml-auto pl-md-5">
                                          <span class="text-cursive h5 text-red">About Us</span>
                                          <h3 class="text-black">Bring Fun Life To Your Kids</h3>
                                          <p><span>Welcome to our fun-filled English learning website for kids! 🌟 Join us now to explore, play, and grow in the world of language and imagination. 🚀📚 Let's start this exciting journey together!
                                              Join us now and watch as your child unlocks the power of language, opens the door to new opportunities, and embraces a world of knowledge and imagination. Let's embark on this language-learning expedition together! 🚀🌍
                                              </span></p>
                                   </div>
                            </div>
                     </div>
              </div>
              <div class="site-section bg-info">
                     <div class="container">
                            <div class="row mb-5">
                                   <div class="col-12 text-center">
                                          <span class="text-cursive h5 text-red d-block">Packages You Like</span>
                                          <h2 class="text-white">Our Packages</h2>
                                   </div>
                            </div>
                            <div class="row">
                                   <div class="col-lg-4 mb-4 mb-lg-0">
                                          <div class="package text-center bg-white">
                                                 <span class="img-wrap"><img src="assets/images/reading.jpg" alt="Image" class="img-fluid"></span>
                                                 <h3 class="text-teal">Reading</h3>
                                                 <p>Immerse your child in captivating stories, exciting adventures, and fascinating texts. Unlock the power of reading and open the door to a world of knowledge and imagination.</p>
                                                 <p><a class="btn btn-primary btn-custom-1 mt-4">READ</a></p>
                                          </div>
                                   </div>
                                   <div class="col-lg-4 mb-4 mb-lg-0">
                                          <div class="package text-center bg-white">
                                                 <span class="img-wrap"><img src="assets/images/listening.jpg" alt="Image" class="img-fluid"></span>
                                                 <h3 class="text-success">listening</h3>
                                                 <p>Sharpen your ears to different accents and tones as we train your comprehension skills. Get ready to become a skilled listener and unravel the wonders of language together!</p>
                                                 <p><a class="btn btn-warning btn-custom-1 mt-4">LISTEN</a></p>
                                          </div>
                                   </div>
                                   <div class="col-lg-4 mb-4 mb-lg-0">
                                          <div class="package text-center bg-white">
                                                 <span class="img-wrap"><img src="assets/images/speaking.jpg" alt="Image" class="img-fluid"></span>
                                                 <h3 class="text-danger">speaking</h3>
                                                 <p> Unlock the secrets of clear communication! we'll master the art of pronunciation together. Let's embrace the joy of speaking with clarity and confidence!</p>
                                                 <p><a class="btn btn-success btn-custom-1 mt-4">SPEAK</a></p>
                                          </div>
                                   </div>
                            </div>
                     </div>
              </div>

              <div class="site-section py-5 bg-warning">
                     <div class="container">
                            <div class="row justify-content-center">
                                   <div class="col-md-12 d-flex">
                                          <h2 class="text-white m-0">Bring Fun Life To Your Kids</h2>
                                          <a href="login.jsp" class="btn btn-primary btn-custom-1 py-3 px-5 ml-auto">Get Started</a>
                                   </div>
                            </div>
                     </div>
              </div>

        <%@include file="footer.jsp" %>

    </body>

</html>

