<%-- 
    Document   : learning
    Created on : Jul 5, 2023, 5:29:03 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
       <head>
              <title>Home page</title>
              <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
              <link href="https://fonts.googleapis.com/css?family=DM+Sans:300,400,700|Indie+Flower" rel="stylesheet">

       </head>


       <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
              <%@include file="header.jsp" %>
              <div class="ftco-blocks-cover-1">
                     <!-- data-stellar-background-ratio="0.5" style="background-image: url('images/hero_1.jpg')" -->
                     <div class="site-section-cover overlay" data-stellar-background-ratio="0.5" style="background-image: url('assets/images/hero_1.jpg')">
                            <div class="container">
                                   <div class="row align-items-center ">

                                          <div class="col-md-5 mt-5 pt-5">
                                                 <span class="text-cursive h5 text-red">Begin to learn</span>
                                                 <h1 class="mb-3 font-weight-bold text-teal">Lesson Items</h1>
                                                 <p><a href="index.html" class="text-white">Home</a> <span class="mx-3">/</span> <strong>Course</strong><span class="mx-3">/</span><strong>Lesson</strong><span class="mx-3">/</span><strong>Lesson Items</strong></p>
                                          </div>
                                   </div>
                            </div>
                     </div>
              </div>
              <section class="site-section" style="background-color: #ebebeb">
                     <h2 class="heading mt-3 text-center">Begin to Learn !</h2>
                     <div class="container  justify-content-center  ">
                            <div class=" bg-white p-5 m-3">

                                   <div class="row">
                                          <div class="col-12">
                                                 <form action="SortItemController" method="POST">
                                                        <label  for="sltype">Please chose your Lesson Type: </label>
                                                        <select class="btn btn-warning m-0 p-2 pr-0" style="border-top-right-radius:0;border-bottom-right-radius: 0;" id="sltype" name="ItemType_ID" >
                                                               <option value="READ" selected>READ</option>
                                                        </select>
                                                        <button class=" btn btn-warning m-0 p-2 pl-0" style="border-top-left-radius:0;border-bottom-left-radius: 0;" type="submit">
                                                               <span class="fa fa-search" ></span>
                                                        </button>
                                                 </form>
                                          </div>
                                   </div>
                                   <hr>
                                   <div class='row'>
                                          <c:if test="${ITEM==null }">
                                                 <c:forEach var="i" items="${LESSON_ITEM}">
                                                        <div class='col-12'>
                                                               <div class="card">
                                                                      <div class="card-body">
                                                                             <h5 class="card-title">Lesson Type : ${i.itemTypeID} </h5>

                                                                             <p class="card-text">Content:</p>
                                                                             <p ><textarea disabled class="form-control"> ${i.content}</textarea></p>
                                                                             <form method="GET" action="QuestionController">
                                                                                    <input type="hidden" name="lessonItemID" value="${i.lessonItemID}">
                                                                                    <button type="submit" class="btn btn-primary" >
                                                                                           Question
                                                                                    </button>
                                                                             </form>
                                                                      </div>
                                                               </div>
                                                        </div>
                                                 </c:forEach>
                                          </c:if>
                                   </div>
                            </div>
                     </div>
              </section>
       </body>
</html>