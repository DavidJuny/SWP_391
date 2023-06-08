<%-- 
    Document   : gallery
    Created on : May 30, 2023, 12:12:42 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <head>
              <title> Gallery </title>
              <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
       </head>

       <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">


              <%@include file="header.jsp" %>
              <div class="ftco-blocks-cover-1">
                     <!-- data-stellar-background-ratio="0.5" style="background-image: url('images/hero_1.jpg')" -->
                     <div class="site-section-cover overlay" data-stellar-background-ratio="0.5" style="background-image: url('images/hero_1.jpg')">
                            <div class="container">
                                   <div class="row align-items-center ">

                                          <div class="col-md-5 mt-5 pt-5">
                                                 <span class="text-cursive h5 text-red">Gallery</span>
                                                 <h1 class="mb-3 font-weight-bold text-teal">Gallery Of Kids</h1>
                                                 <p><a href="index.html" class="text-white">Home</a> <span class="mx-3">/</span> <strong>Gallery</strong></p>
                                          </div>

                                   </div>
                            </div>
                     </div>
              </div>


              <div class="site-section">
                     <div class="container">
                            <div class="row mb-5">
                                   <div class="col-12 text-center">
                                          <span class="text-cursive h5 text-red d-block">Our Gallery</span>
                                          <h2 class="text-black">Gallery Of The Kids</h2>
                                   </div>
                            </div>
                            <div class="row">
                                   <div class="col-md-3 mb-4">
                                          <a href="assets/images/img_1.jpg" data-fancybox="gal"><img src="assets/images/img_1.jpg" alt="Image" class="img-fluid"></a>
                                   </div>
                                   <div class="col-md-3 mb-4">
                                          <a href="assets/images/img_2.jpg" data-fancybox="gal"><img src="assets/images/img_2.jpg" alt="Image" class="img-fluid"></a>
                                   </div>
                                   <div class="col-md-3 mb-4">
                                          <a href="assets/images/img_3.jpg" data-fancybox="gal"><img src="assets/images/img_3.jpg" alt="Image" class="img-fluid"></a>
                                   </div>
                                   <div class="col-md-3 mb-4">
                                          <a href="assets/images/img_4.jpg" data-fancybox="gal"><img src="assets/images/img_4.jpg" alt="Image" class="img-fluid"></a>
                                   </div>

                                   <div class="col-md-3 mb-4">
                                          <a href="assets/images/img_5.jpg" data-fancybox="gal"><img src="assets/images/img_5.jpg" alt="Image" class="img-fluid"></a>
                                   </div>
                                   <div class="col-md-3 mb-4">
                                          <a href="assets/images/img_2.jpg" data-fancybox="gal"><img src="assets/images/img_3.jpg" alt="Image" class="img-fluid"></a>
                                   </div>
                                   <div class="col-md-3 mb-4">
                                          <a href="assets/images/img_2.jpg" data-fancybox="gal"><img src="assets/images/img_2.jpg" alt="Image" class="img-fluid"></a>
                                   </div>
                                   <div class="col-md-3 mb-4">
                                          <img src="assets/images/img_1.jpg" alt="Image" class="img-fluid">
                                   </div>
                            </div>
                     </div>
              </div>





              <div class="site-section py-5 bg-warning">
                     <div class="container">
                            <div class="row justify-content-center">
                                   <div class="col-md-12 d-flex">
                                          <h2 class="text-white m-0">Bring Fun Life To Your Kids</h2>
                                          <a href="#" class="btn btn-primary btn-custom-1 py-3 px-5 ml-auto">Get Started</a>
                                   </div>
                            </div>
                     </div>
              </div>

              <%@include file="footer.jsp" %>
       </body>
</html>
