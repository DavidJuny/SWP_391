/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ParentDAO;
import Entity.parent;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class RegisterController extends HttpServlet {

       /**
        * Processes requests for both HTTP <code>GET</code> and
        * <code>POST</code> methods.
        *
        * @param request servlet request
        * @param response servlet response
        * @throws ServletException if a servlet-specific error occurs
        * @throws IOException if an I/O error occurs
        */
       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
              response.setContentType("text/html;charset=UTF-8");

              String username = request.getParameter("username");
              String fullname = request.getParameter("fullname");
              String password = request.getParameter("password");
              String confirmpassword = request.getParameter("confirmpassword");
              String sex = request.getParameter("sex");
              int phone = Integer.getInteger(request.getParameter("phone"));
              request.setAttribute("msg", "");
              if (!password.equals(confirmpassword)) {
                     request.setAttribute("msg", "Your password is not match!");
                     request.getRequestDispatcher("register.jsp").forward(request, response);
              } else {
                     ParentDAO parentDAO = new ParentDAO();
                     parentDAO.getAllParents();
                     parent user = parentDAO.checkExistedAccount(username);
                     if (user == null) { //continue to signup
                            try {
                                   parentDAO.register(username, password, fullname, sex, phone);
                            } catch (Exception e) {
                                   e.printStackTrace();
                            }

                            response.sendRedirect("login.jsp");
                            request.removeAttribute("msg");
                     } else { //deny to signup
                            request.setAttribute("msg", "Your account has already existed!");
                            request.getRequestDispatcher("register.jsp").forward(request, response);
                     }
              }
       }

       // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
       /**
        * Handles the HTTP <code>GET</code> method.
        *
        * @param request servlet request
        * @param response servlet response
        * @throws ServletException if a servlet-specific error occurs
        * @throws IOException if an I/O error occurs
        */
       @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
              processRequest(request, response);
       }

       /**
        * Handles the HTTP <code>POST</code> method.
        *
        * @param request servlet request
        * @param response servlet response
        * @throws ServletException if a servlet-specific error occurs
        * @throws IOException if an I/O error occurs
        */
       @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
              processRequest(request, response);
       }

       /**
        * Returns a short description of the servlet.
        *
        * @return a String containing servlet description
        */
       @Override
       public String getServletInfo() {
              return "Short description";
       }// </editor-fold>

}
