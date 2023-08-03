 <%@page import="java.util.Date"%>
<%@page import="Model.lessonpointModel"%>
<%@page import="Entity.kid"%>
<%@page import="Entity.lessonpoint"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat" %>

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
/*        table {
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
        }*/
        
                #chart {
          width: 600px;
          height: 400px;
          margin: 40px auto; /* Add some spacing around the chart */
        }

        /* Style the table */
        table {
          width: 100%;
          border-collapse: collapse;
          margin-top: 20px; /* Add some spacing between the table and chart */
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .no-data {
          text-align: center;
          font-style: italic;
        }
  
            </style>
            
  <script src="https://d3js.org/d3.v6.min.js"></script>


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
            <th>Date Taken</th>
            <th>Point</th>
            <th>Lesson</th>
            <th>Course</th>

            
        </tr>
        <%
            ArrayList<lessonpointModel> list = (ArrayList<lessonpointModel>) request.getSession().getAttribute("LISTPOINT");
            if (list != null && !list.isEmpty()) {
                String currentDate = null;
                String currentLessonName=null;
                String currentCourseName= null;

                boolean sameDateAndCourseName = false;
                
                for (lessonpointModel l : list) {
                    String dateTaken = l.getDateTaken().toString();
                     String lessonName = l.getLessionName();
                    String courseName = l.getCourseName();
                    if (dateTaken.equals(currentDate) && lessonName.equals(currentLessonName) && courseName.equals(currentCourseName) ) {
                        sameDateAndCourseName = true;
                    } else {
                        sameDateAndCourseName = false;
                    }
                    
                    if (!sameDateAndCourseName) {
                        currentDate = dateTaken;
                        currentLessonName = lessonName;
                        currentCourseName = courseName;
                        
                        int rowCount = getRowCountForDateTaken(list, dateTaken, lessonName, courseName);
        %>
        <tr>
            <td rowspan="<%= rowCount %>"><%= dateTaken %></td>
            <td><%= l.getPoint() %></td>
            <td rowspan="<%= rowCount %>"><%= lessonName %></td>
            <td rowspan="<%= rowCount %>"><%= courseName %></td>
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

    <div id="chart"></div>
  <script>
    var data = [
      <c:forEach var="point" items="${sessionScope.LISTPOINT}" varStatus="loop">
        {
          "dateTaken": "${point.getDateTaken()}",
          "point": ${point.getPoint()}
        }
        <c:if test="${not loop.last}">,</c:if>
      </c:forEach>
    ];

    var parseDate = d3.timeParse("%Y-%m-%d");
    data.forEach((item) => {
      item.dateTaken = parseDate(item.dateTaken);
    });

    var datePoints = d3.rollup(data, v => d3.mean(v, d => d.point), d => d.dateTaken);

    var averageData = Array.from(datePoints, ([dateTaken, averagePoint]) => ({ dateTaken, averagePoint }));

    var width = 600;
    var height = 400;
    var margin = { top: 50, right: 30, bottom: 50, left: 50 }; // ??i giá tr? c?a top thành 30

    var xScale = d3.scaleBand()
      .domain(averageData.map(d => d.dateTaken))
      .range([margin.left, width - margin.right])
      .padding(0.1);

    var yScale = d3.scaleLinear()
      .domain([0, d3.max(averageData, d => d.averagePoint)])
      .nice()
      .range([height - margin.bottom, margin.top]);

    var svg = d3.select("#chart")
      .append("svg")
      .attr("width", width)
      .attr("height", height);

    svg.selectAll("rect")
      .data(averageData)
      .join("rect")
      .attr("x", d => xScale(d.dateTaken))
      .attr("y", d => yScale(d.averagePoint))
      .attr("width", xScale.bandwidth())
      .attr("height", d => yScale(0) - yScale(d.averagePoint))
      .attr("fill", "steelblue");

    svg.selectAll(".label")
      .data(averageData)
      .join("text")
      .attr("class", "label")
      .attr("x", d => xScale(d.dateTaken) + xScale.bandwidth() / 2)
      .attr("y", d => yScale(d.averagePoint) - 5)
      .attr("text-anchor", "middle")
      .text(d => d.averagePoint.toFixed(2));

    var xAxis = g => g
      .attr("transform", `translate(0,${height - margin.bottom})`)
      .call(d3.axisBottom(xScale).tickFormat(d3.timeFormat("%Y-%m-%d")));

    var yAxis = g => g
      .attr("transform", `translate(${margin.left},0)`)
      .call(d3.axisLeft(yScale).ticks(5));

    svg.append("g")
      .call(xAxis);

    svg.append("g")
      .call(yAxis);

  </script>
</body>
</html>
<%! 
    int getRowCountForDateTaken(ArrayList<lessonpointModel> list, String dateTaken, String lessonName, String courseName) {
        int count = 0;
        for (lessonpointModel l : list) {
            String currentDate = l.getDateTaken().toString();
            String currentLessionName = l.getLessionName();
            String currentCourseName = l.getCourseName();
            if (dateTaken.equals(currentDate) && currentLessionName.equals(lessonName) && courseName.equals(currentCourseName)) {
                count++;
            }
        }
        return count;
    }
%>
