 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : parentpage
    Created on : Jun 15, 2023, 11:02:10 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%> 
<!DOCTYPE html>
<html>
        <head>
       <meta charset="UTF-8">
       <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
       <title>home</title>
       <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
       <link href="https://fonts.googleapis.com/css?family=DM+Sans:300,400,700|Indie+Flower" rel="stylesheet">
       <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"> 

       <!-- font awesome cdn link  -->
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">

       <!-- custom css file link  -->
       <link rel="stylesheet" href="assets/css/profile.css">
    </head>
    
        <body>

             <%@include file="sideBar.jsp" %>
               <!-- end sideBar -->

                <div class="main">
              <div class="col-md-8 mt-1">
                  <div class="card mb-3 content">
                      <h1 class="m-3 pt-3">Edit Profile</h1>
                      <div class="card-body">
                          <div class="row">
                              <div class="col-md-3">
                                  <h5>Full Name</h5>
                              </div>
                              <div class="col-md-9 text-secondary">
                                  <input class="editText" type="text" name="username" required="" value=01234>
                              </div>
                          </div>
                          <hr>
                          <div class="row">
                              <div class="col-md-3">
                                  <h5>Phone</h5>
                              </div>
                              <div class="col-md-9 text-secondary">
                                  <input class="editText" type="text" name="username" required="" value=01234>
                              </div>
                          </div>
                          <hr>
                          <div class="row">
                              <div class="col-md-3">
                                  <h5>Sex</h5>
                                  <div class="col-md-9 text-secondary">
                                      <select>
                                      <option value="">Male</option>
                                      <option value="">Female</option>
                                  </select>
                                  </div>
                              </div>
                          </div>
                          <hr>
                          <div class="card m-3 content">
                              <h3 class="m-3">Change UserName and Password</h3>
                              <div class="card-body">
                              <div class="row">
                                  <div class="col-md-3">
                                      <h5>UserName</h5>
                                  </div>
                                  <div class="col-md-9 text-secondary">
                                     <input class="editText" type="text" name="username" required="" value=01234>
                                  </div>    
                              </div>
                              <hr>
                                  <div class="row">
                                      <div class="col-md-3">
                                          <h5>Password</h5>
                                      </div>
                                      <div class="col-md-9 text-secondary">
                                     <input class="editText" type="text" name="username" required="" value=01234>
                                      </div>
                                  </div>
                              <hr>
                              <div class="row">
                                  <div class="col-md-3">
                                      <h5>Confim Password</h5>
                                  </div>
                                  <div class="col-md-9 text-secondary">
                                     <input class="editText" type="text" name="username" required="" value=01234>
                                  </div>
                              </div>
                          <hr>
                          </div>
                              </div>
                      </div>
                  </div>    
              </div>
          </div>
        </body>
</html>
