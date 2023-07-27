<!-- logout.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.IOException" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
  // Get the current session
  session = request.getSession(false);
  if (session != null) {
    // Invalidate the session (clear all session attributes and end the session)
    session.invalidate();
  }

  // Redirect to the login page or any other desired page after logout
  response.sendRedirect("login.jsp");
%>
