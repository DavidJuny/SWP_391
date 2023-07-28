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
       <meta name="viewp<ort" content="width=device-width, initial-scale=1.0">
       <title>home</title>
       <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
       <link href="https://fonts.googleapis.com/css?family=DM+Sans:300,400,700|Indie+Flower" rel="stylesheet">

       <!-- font awesome cdn link  -->
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">

       <!-- custom css file link  -->
       <link rel="stylesheet" href="assets/css/style_parent.css">

    </head>
    
        <body>

             <%@include file="sideBar.jsp" %>
               <!-- end sideBar -->

        <section class="courses">

           <h1 class="heading">your Chidren</h1>
           
          
           <div class="box-container">
               <c:forEach var="kid" items="${sessionScope.LISTKID}"> 
              <div class="box">
                 <div class="tutor">
                    <img src="${kid.kidImage}" alt="">
                    <div class="info">
                       <h3>
                       </h3>
                       <span>   ${kid.kidBrithday}</span>
                    </div>
                 </div>
                 <div class="thumb">
                    <img src="${kid.kidImage}" alt="">
                 </div>
                 <h3 class="title">${kid.kidName}</h3>
                 <a href="lessonPointController?kidID=${kid.kidID}" class="inline-btn">view progress</a>
              </div>
               </c:forEach>
                ${MESS}
           </div>
                   
                   
                   
           <div class="more-btn">
              <a href="profile.jsp" class="inline-option-btn">add your children</a>
           </div>

        </section>

        <footer class="footer">


        </footer>

        <!-- custom js file link  -->
        <script src="assets/js/script.js"></script>


        </body>
</html>
