<%-- 
    Document   : report
    Created on : Jul 13, 2023, 12:50:17 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <head>
              <title>Report</title>
              <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
       </head>

       <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

              <%@include file="header.jsp" %>

              <div class="ftco-blocks-cover-1">
                     <div class="site-section-cover overlay" data-stellar-background-ratio="0.5" style="background-image: url('assets/images/hero_1.jpg')">
                            <div class="container">
                                   <div class="row align-items-center ">

                                          <div class="col-md-5 mt-5 pt-5">
                                                 <span class="text-cursive h5 text-red">Education Report of your Kids</span>
                                                 <h1 class="mb-3 font-weight-bold text-teal">Report</h1>
                                                 <p><a href="index.html" class="text-white">Home</a> <span class="mx-3">/</span> <strong>Report</strong></p>
                                          </div>
                                   </div>
                            </div>
                     </div>
              </div>
              <div class="site-section">
                     <div class="container">
                            <h2 class="text-center h2">Please review your kids report daily</h2>
                            <hr>
                            <div class="text-center mt-5">
                                   <form action="ReportInfoController" method="post">
                                          <p> Please choose your kids to view thier report: 
                                                 <select class="form-select" name="kids" required="">
                                                        <c:forEach var="kid" items="${KLIST}">
                                                               <option value="${kid.kidID}">${kid.kidName}</option>
                                                        </c:forEach>
                                                 </select>
                                                 <br>
                                                 <button class= "btn-success ml-3" type="submit">View Report</button>
                                          </p>
                                   </form>
                            </div>
                            <c:if test="${REPORTKID != null}">
                                   <div class="mt-5 p-5  border bg-light">
                                          <h2 class="text-center">View ${KINFO.kidName} Report</h2>
                                          <br>
                                          <div class="row d-flex justify-content-center align-items-center h-100">
                                                 <%int i = 1;%>
                                                 <c:forEach var="i" items="${REPORTKID}">
                                                        <div class="col col-lg-8 mb-4 mb-lg-0 mt-3">
                                                               <div class="card">
                                                                      <div class="card-header">
                                                                             <%=i%># Report 
                                                                      </div>
                                                                      <div class="card-body">
                                                                             <h5 class="card-title">Review Section</h5>
                                                                             <p class="card-text">${KINFO.kidName}'s academic level: <span class="text-red">${i.detailReport}</span></p>
                                                                             <button type="button" class="btn btn-success" data-toggle="modal" data-target="#viewReport<%=i%>">
                                                                                    View Detail
                                                                             </button>
                                                                             <div class="modal fade" id="viewReport<%=i%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                                                                                    <div class="modal-dialog" role="document">
                                                                                           <div class="modal-content">
                                                                                                  <div class="modal-header bg-success">
                                                                                                         <h5 class="modal-title text-white" id="exampleModalLongTitle">Report Details</h5>
                                                                                                         <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                                                                <span aria-hidden="true">&times;</span>
                                                                                                         </button>
                                                                                                  </div>
                                                                                                  <div class="modal-body ">
                                                                                                         <div class="mb-3" style="border-radius: .5rem;">
                                                                                                                <div class="row g-0">
                                                                                                                       <div class="col-md-12">
                                                                                                                              <div class="card-body p-4">
                                                                                                                                     <h6>${KINFO.kidName}'s Report</h6>
                                                                                                                                     <hr class="mt-0 mb-4">
                                                                                                                                     <div class="row pt-1">
                                                                                                                                            <div class="col-6 mb-3">
                                                                                                                                                   <h6>Course ID :</h6>
                                                                                                                                                   <p class="text-muted">${i.courseID}</p>
                                                                                                                                            </div>
                                                                                                                                            <div class="col-6 mb-3">
                                                                                                                                                   <h6>Course Grade :</h6>
                                                                                                                                                   <p class="text-muted">${i.courseGrade}</p>
                                                                                                                                            </div>
                                                                                                                                     </div>
                                                                                                                                     <h6>Details</h6>
                                                                                                                                     <hr class="mt-0 mb-4">
                                                                                                                                     <div class="row pt-1">
                                                                                                                                            <div class="col-6 mb-3">
                                                                                                                                                   <h6>Report Details</h6>
                                                                                                                                                   <textarea class="form-control" disabled>${i.detailReport}</textarea>
                                                                                                                                            </div>
                                                                                                                                     </div>
                                                                                                                              </div>
                                                                                                                       </div>
                                                                                                                </div>
                                                                                                         </div>
                                                                                                  </div>
                                                                                                  <div class="modal-footer btn-close">
                                                                                                         <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                                                                                                  </div>
                                                                                           </div>
                                                                                    </div>
                                                                             </div>
                                                                      </div>
                                                               </div>
                                                        </div>
                                                        <%i += 1;%>         
                                                 </c:forEach>
                                          </div>
                                   </div>
                            </div>

                            <!-- Modal -->

                            <!--                                                        <div class="col col-lg-6 mb-4 mb-lg-0">
                                                                                           <div class="card mb-3" style="border-radius: .5rem;">
                                                                                                  <div class="row g-0">
                                                                                                         <div class="col-md-4 gradient-custom text-center text-white"
                                                                                                              style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
                                                                                                                <img src="${KINFO.kidImage}"
                                                                                                                     alt="Avatar" class="img-fluid my-5" style="width: 80px;" />
                                                                                                                <h5>${KINFO.kidName}</h5>
                                                                                                                <i class="far fa-edit mb-5"></i>
                                                                                                         </div>
                                                                                                         <div class="col-md-8">
                                                                                                                <div class="card-body p-4">
                                                                                                                       <h6>Report</h6>
                                                                                                                       <hr class="mt-0 mb-4">
                                                                                                                       <div class="row pt-1">
                                                                                                                              <div class="col-6 mb-3">
                                                                                                                                     <h6>Course ID :</h6>
                                                                                                                                     <p class="text-muted">${i.courseID}</p>
                                                                                                                              </div>
                                                                                                                              <div class="col-6 mb-3">
                                                                                                                                     <h6>Course Grade :</h6>
                                                                                                                                     <p class="text-muted">${i.courseGrade}</p>
                                                                                                                              </div>
                                                                                                                       </div>
                                                                                                                       <h6>Details</h6>
                                                                                                                       <hr class="mt-0 mb-4">
                                                                                                                       <div class="row pt-1">
                                                                                                                              <div class="col-6 mb-3">
                                                                                                                                     <h6>Report Details</h6>
                                                                                                                                     <textarea class="form-control" disabled>${i.detailReport}</textarea>
                                                                                                                              </div>
                                                                                                                       </div>
                                                                                                                </div>
                                                                                                         </div>
                                                                                                  </div>
                                                                                           </div>
                                                                                    </div>-->

                     </div>
              </div>
       </c:if>
</div>
</div>

<%@include file="footer.jsp" %>
</html>
