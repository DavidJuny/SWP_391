<%-- 
    Document   : paymenthistory
    Created on : Jul 27, 2023, 4:54:21 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
       <head>
              <title>Payment</title>
              <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
       </head>
       <body>
              <%@include file="header.jsp" %>
              <div class="ftco-blocks-cover-1">
                     <!-- data-stellar-background-ratio="0.5" style="background-image: url('images/hero_1.jpg')" -->
                     <div class="site-section-cover overlay" data-stellar-background-ratio="0.5" style="background-image: url('assets/images/hero_1.jpg')">
                            <div class="container">
                                   <div class="row align-items-center ">

                                          <div class="col-md-5 mt-5 pt-5">
                                                 <span class="text-cursive h5 text-red">View Payment</span>
                                                 <h1 class="mb-3 font-weight-bold text-teal">Welcome ${PARENT.parentAccount}</h1>
                                                 <p><a href="homepage.jsp" class="text-white">Home</a> <span class="mx-3">/</span> <strong>View Payment</strong></p>
                                          </div>
                                   </div>
                            </div>
                     </div>
              </div>
              <div class="site-section bg-light">
                     <h2 class="h2 text-center">View Payment History of ${PARENT.parentName}</h2>
                     <div class="container mt-5">
                            <table class="table table-success table-striped">
                                   <thead>
                                          <tr>
                                                 <th scope="col">#</th>
                                                 <th scope="col">Course ID</th>
                                                 <th scope="col">Kid ID</th>
                                                 <th scope="col">Amount</th>
                                                 <th scope="col">Date</th>
                                                 <th scope="col">Status</th>
                                          </tr>
                                   </thead>
                                   <tbody>
                                          <%int i = 1;%>
                                          <c:forEach var="i" items="${DETAILPAYMENT}">
                                                 <tr>
                                                        <th scope="row"><%=i%></th>
                                                        <td>${i.kidlearning.courseID}</td>
                                                        <td>${i.kidlearning.kidID}</td>
                                                        <td>${i.amountCourse}</td>
                                                        <td>${i.datePayment}</td>
                                                        <td>${i.status}</td>
                                                 </tr>
                                                 <%i++;%>
                                          </c:forEach>
                                   </tbody>
                            </table>
                     </div>
              </div>
              <%@include file="footer.jsp" %>
       </body>
</html>
