 <%@page import="java.util.Date"%>
<%@page import="Model.lessonpointModel"%>
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

                 <link rel="icon" type="image/x-icon" href="./assets/images/logo.png">
       <link href="https://fonts.googleapis.com/css?family=DM+Sans:300,400,700|Indie+Flower" rel="stylesheet">

       <!-- font awesome cdn link  -->
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">

       <!-- custom css file link  -->
       <link rel="stylesheet" href="assets/css/style_parent.css">
       
            <style>
        body {
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #0056b3;
        }
         h2 {
            color: #0056b3; 
            font-size: 24px; 
            margin-top: 20px; 
            text-align: center; 
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ccc;
        }
        th {
            background-color: #9933cc; 
            font-weight: bold; 
            font-size: 20px;
            color: #fff; 
        }
        .no-data {
            text-align: center;
            color: #cc0000;
            font-style: italic;
        }
        canvas {
            max-width: 400px; 
            margin: 20px auto; 
        }

        /* Custom CSS for the table */
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
  
            </style>
        </head>
    
        <body>
            <%@include file="sideBar.jsp" %>
                     <h2>
                        <c:forEach var="kid" items="${sessionScope.GETKID}">
                            ${kid.kidName}
                        </c:forEach>
                     </h2>
    <table>
        <tr>
            <th>DateTaken</th>
            <th>Point</th>
            <th>Lesson</th>
        </tr>
        <%
            ArrayList<lessonpointModel> list = (ArrayList<lessonpointModel>) request.getSession().getAttribute("LISTPOINT");
            if (list != null && !list.isEmpty()) {
                String currentDate = null;
                String currentItemTypeID = null;
                boolean sameDateAndItemTypeID = false;
                
                for (lessonpointModel l : list) {
                    String dateTaken = l.getDateTaken().toString();
                    String itemTypeID = l.getItemTypeID();
                    if (dateTaken.equals(currentDate) && itemTypeID.equals(currentItemTypeID)) {
                        sameDateAndItemTypeID = true;
                    } else {
                        sameDateAndItemTypeID = false;
                    }
                    
                    if (!sameDateAndItemTypeID) {
                        currentDate = dateTaken;
                        currentItemTypeID = itemTypeID;
                        int rowCount = getRowCountForDateTaken(list, dateTaken, itemTypeID);
        %>
        <tr>
            <td rowspan="<%= rowCount %>"><%= dateTaken %></td>
            <td><%= l.getPoint() %></td>
            <td rowspan="<%= rowCount %>"><%= itemTypeID %></td>
        </tr>
        <%
                    } else {
        %>
        <tr>
            <td><%= l.getPoint() %></td>
        </tr>
        <%
                    }
                }
            } else {
        %>
        <tr>
            <td colspan="3" class="no-data">No data available.</td>
        </tr>
        <% } %>
    </table>
</body>
</html>
<%! 
    int getRowCountForDateTaken(ArrayList<lessonpointModel> list, String dateTaken, String itemTypeID) {
        int count = 0;
        for (lessonpointModel l : list) {
            String currentDate = l.getDateTaken().toString();
            String currentItemID = l.getItemTypeID();
            if (dateTaken.equals(currentDate) && itemTypeID.equals(currentItemID)) {
                count++;
            }
        }
        return count;
    }
%>











