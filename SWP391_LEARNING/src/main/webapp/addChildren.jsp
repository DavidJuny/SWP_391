<!-- <%-- 
    Document   : addChildren
    Created on : Jun 16, 2023, 10:38:45 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%> -->
<!DOCTYPE html>
<html>
 <head>
       <meta charset="UTF-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewp<ort" content="width=device-width, initial-scale=1.0">
       <title>AddChildren</title>
       <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
        <link href="https://fonts.googleapis.com/css?family=DM+Sans:300,400,700|Indie+Flower" rel="stylesheet">

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
        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="assets/css/style_parent.css">

    </head>
    <body>
         <!-- <%@include file="sideBar.jsp"%> -->



                                      <!-- end sideBar -->

              <div class="site-section bg-light" id="contact-section">
                  <div class="container" id="add-childrent" style="font-size: 1.5rem;">
                            <div class="row justify-content-center text-center">
                                   <div class="col-7 text-center mb-5">
                                          <h2>Create account for your Kid !!</h2>
                                          <p>Make sure that your kid have an account in order to learn English.</p>
                                   </div>
                             </div>
                            <!-- <c:if test="${sessionScope.PARENT==null} ">
                                   <a href="login.jsp">Login here !</a>
                            </c:if>  -->
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
    </body>
</html>
