 <%-- 
    Document   : sideBar
    Created on : Jun 16, 2023, 10:16:07 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%> 
<!DOCTYPE html>
<html>
        <head>
           <meta charset="UTF-8">
           <meta http-equiv="X-UA-Compatible" content="IE=edge">
           <meta name="viewport" content="width=device-width, initial-scale=1.0">
           <title>Parent</title>
           
           <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
              <link href="https://fonts.googleapis.com/css?family=DM+Sans:300,400,700|Indie+Flower" rel="stylesheet">


           <!-- font awesome cdn link  -->
           <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">

           <!-- custom css file link  -->
           <link rel="stylesheet" href="assets/css/style_parent.css">

        </head>

            <body>
            <header class="header">

               <section class="flex">

                   <a href="homepage.jsp" class="logo">Educa.</a>

<!--                  <form action="search.html" method="post" class="search-form">
                     <input type="text" name="search_box" required placeholder="search courses..." maxlength="100">
                     <button type="submit" class="fas fa-search"></button>
                  </form>-->

                  <div class="icons">
                     <div id="menu-btn" class="fas fa-bars"></div>
                     <div id="search-btn" class="fas fa-search"></div>
                     <div id="user-btn" class="fas fa-user"></div>
                     <div id="toggle-btn" class="fas fa-sun"></div>
                  </div>

                  <div class="profile">
                      <img src="assets/images/the-human-icon.jpg" class="image" alt="">
                     <h3 class="name">${PARENT.parentName}</h3>
                     <p class="role">parent</p>
                     <a href="profile.jsp" class="btn">view profile</a>
                     <div class="flex-btn">
                        <a href="LogoutController" class="option-btn">Logout</a>
                     </div>
                  </div>

               </section>

            </header>   

            <div class="side-bar">

               <div id="close-btn">
                  <i class="fas fa-times"></i>
               </div>

               <div class="profile">
                   <img src="assets/images/the-human-icon.jpg" class="image" alt="">
                  <h3 class="name">${PARENT.parentName}</h3>
                  <p class="role">parent</p>
                  <a href="editProfile.jsp" class="btn">Edit profile</a>
               </div>

                <nav class="navbar"style="display: block;">
                  <a href="ParentController?parentID=${PARENT.parentID}"><i class="fa-solid fa-person"></i></i><span>your children</span></a>
                  <a href="#"><i class="fas fa-question"></i><span>Buy course</span></a>
                  <a href="course.jsp"><i class="fas fa-graduation-cap"></i><span>courses</span></a>
                  <a href="contact.jsp"><i class="fas fa-headset"></i><span>contact us</span></a>
               </nav>
            </div>
                        <script src="assets/js/script.js"></script>

        </body>
</html>
