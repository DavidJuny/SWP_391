<%-- 
    Document   : Show cart
    Created on : Aug 3, 2023, 1:47:20 AM
    Author     : PC
--%>

<%@page import="Entity.detail_payment"%>
<%@page import="java.util.ArrayList"%>
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
                     <h2 class="h2 text-center">View Shopping Cart of ${PARENT.parentName}</h2>
                     <div class="container py-5 h-100">
                            <div class="row d-flex justify-content-center align-items-center h-100">
                                   <div class="col">
                                          <div class="card">
                                                 <div class="card-body p-4">

                                                        <div class="row justify-content-center">

                                                               <div class="col-lg-8">
                                                                      <h5 class="mb-3"><a href="Parent_CourseController" class="text-body"><i
                                                                                           class="fa fa-chevron-left fa-fw"></i>Return to Courses</a></h5>
                                                                      <hr>

                                                                      <div class="d-flex justify-content-between align-items-center mb-4">
                                                                             <div>
                                                                                    <p class="mb-1">Shopping cart</p>
                                                                                    <p class="mb-0">You have ${ITEMS} items in your cart</p>
                                                                             </div>
                                                                      </div>
                                                                      <c:forEach var="i" items="${CART}">
                                                                             <div class="card mb-3">
                                                                                    <div class="card-body">
                                                                                           <div class="d-flex justify-content-between">
                                                                                                  <div class="d-flex flex-row align-items-center">
                                                                                                         <div class="ms-3">
                                                                                                                <h5>Course ${i.kidlearning.courseID} </h5>
                                                                                                                <p class="small mb-0">Paid for: ${i.kidlearning.kidID} <span class="ml-3">Date of Payment: ${i.datePayment}</span></p>
                                                                                                         </div>
                                                                                                  </div>
                                                                                                  <div class="d-flex flex-row align-items-center">
                                                                                                         <div style="width: 80px;">
                                                                                                                <h5 class="mb-0">$${i.amountCourse}</h5>
                                                                                                         </div>
                                                                                                         <a href="#!" style="color: #cecece;"><i class="fas fa-trash-alt"></i></a>
                                                                                                  </div>
                                                                                           </div>
                                                                                    </div>
                                                                             </div>
                                                                      </c:forEach>
                                                                      <input type='hidden' name='checkout' value='${CART}'>
                                                                      <p>Total amount: $${TOTAL} <span class="ml-4"><a class="btn btn-info" href="CheckoutController">Checkout</a></span></p>
                                                               </div>
                                                        </div>
                                                 </div>
                                          </div>
                                   </div>
                            </div>
                     </div>
              </div>
              <%@include file="footer.jsp" %>
       </body>
</html>
