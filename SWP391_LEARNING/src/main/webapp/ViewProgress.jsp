 <%@page import="Entity.kid"%>
<%@page import="Entity.lessonpoint"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
          <title>View Progress</title>
          <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
          <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet"><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
          <link rel="stylesheet" href="assets/css/style_point.css">
        </head>
    
        <body>
           
                     <div class="container">
                         <h2>
                        <c:forEach var="kid" items="${sessionScope.GETKID}">
                            ${kid.kidName}
                        </c:forEach>
                        </h2>
                   <ul class="responsive-table">
                   <li class="table-header">
                      <div class="col col-2">Lesson</div>
                      <div class="col col-3">Mark</div>
                      <div class="col col-4">Status</div>
                    </li>
                  </ul>
                  </div>
                 <%
                    ArrayList<lessonpoint> listPoint = (ArrayList<lessonpoint>) session.getAttribute("LISTPOINT");
                if (listPoint != null) {
                    for (lessonpoint point :listPoint ) {
            %>
            <div class="container">
                  <ul class="responsive-table">
                    <li class="table-row">
                        <div class="col col-2" data-label="Customer Name">No.<%=point.getLessonItemId()%></div>
                      <div class="col col-3" data-label="Amount"><%=point.getPoint()%></div>
                      <div class="col col-4" data-label="Payment Status">
                                Finish
                      </div>
                     </li>
                  </ul>
                </div>
    <%
             }
         }
    %>
                   

        </body>
</html>
