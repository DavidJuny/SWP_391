<%-- 
    Document   : header
    Created on : Jun 4, 2023, 6:47:42 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "jared.simpledatabase.*" %>
<!DOCTYPE html>
<html>
       <head>
              <meta charset="utf-8">
              <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
              <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

       <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

              <div class="site-wrap" id="home-section">

                     <div class="site-mobile-menu site-navbar-target">
                            <div class="site-mobile-menu-header">
                                   <div class="site-mobile-menu-close mt-3">
                                          <span class="icon-close2 js-menu-toggle"></span>
                                   </div>
                            </div>
                            <div class="site-mobile-menu-body"></div>
                     </div>
              </div>



              <header class="site-navbar site-navbar-target" role="banner">

                     <div class="container mb-3">
                            <div class="d-flex align-items-center">
                                   <div class="site-logo mr-auto">
                                          <a href="homepage.jsp">Kiddy<span class="text-primary">.</span></a>
                                   </div>
                                   <div class="site-quick-contact d-none d-lg-flex ml-auto ">
                                          <div class="d-flex site-info align-items-center mr-5">
                                                 <span class="block-icon mr-3"><span class="icon-map-marker text-yellow"></span></span>
                                                 <span>34 Street Name, City Name Here, <br> United States</span>
                                          </div>
                                          <div class="d-flex site-info align-items-center">
                                                 <span class="block-icon mr-3"><span class="icon-clock-o"></span></span>
                                                 <span>Sunday - Friday 8:00AM - 4:00PM <br> Saturday CLOSED</span>
                                          </div>
                                   </div>
                            </div>
                     </div>
                     <div class="container">
                            <div class="menu-wrap d-flex align-items-center">
                                   <span class="d-inline-block d-lg-none"><a href="#" class="text-black site-menu-toggle js-menu-toggle py-5"><span class="icon-menu h3 text-black"></span></a></span>
                                   <nav class="site-navigation text-left mr-auto d-none d-lg-block" role="navigation">
                                          <ul class="site-menu main-menu js-clone-nav mr-auto ">
                                                 <li class="active"><a href="homepage.jsp" class="nav-link">Home</a></li>
                                                 <li><a href="about.jsp" class="nav-link">About</a></li>
                                                 <li><a href="packages.jsp" class="nav-link">Packages</a></li>
                                                 <li><a href="gallery.jsp" class="nav-link">Gallery</a></li>
                                                 <li><a href="pricing.jsp" class="nav-link">Pricing</a></li>
                                                 <li><a href="contact.jsp" class="nav-link">Contact</a></li>
                                          </ul>
                                   </nav>
                                   <div class="top-social ml-auto">

                                          <c:if test="${sessionScope.PARENT == null}">
                                                 <a href="login.jsp" class="nav-link"> Login<i class="fa fa-sign-in fa-fw fa-lg" aria-hidden="true"></i></a>
                                                 </c:if>

                                          <c:if test="${sessionScope.PARENT != null}">
                                                 <div class="dropdown">
                                                        <a class="nav-link" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
                                                               <i class="fa fa-user-circle fa-2x" aria-hidden="true"></i>
                                                        </a>

                                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                                               <li><a class="dropdown-item"  href="profile.jsp"><span class="fa fa-user fa-fw"></span>Profile</a></li>
                                                               <li><a  href="LogoutController"><span class=" fa fa-sign-out fa-fw""></span>Log out</a></li>
                                                        </ul>
                                                 </div>
                                          </c:if>
                                          <!-- 
                                          <a href="#"><span class="icon-linkedin text-yellow"></span></a>
                                          <a href="#"><span class="icon-facebook text-teal"></span></a>
                                          <a href="#"><span class="icon-twitter text-success"></span></a>
                                          -->
                                   </div>
                            </div>
                     </div>
              </header>
       </body>
</html>
