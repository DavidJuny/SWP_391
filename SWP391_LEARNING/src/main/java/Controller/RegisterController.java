/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import DAO.ParentDAO;
import Entity.accountUser;
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
AccountDAO accountDAO=new AccountDAO();
              String username = request.getParameter("username");
              String fullname = request.getParameter("fullname");
              String password = request.getParameter("password");
              String confirmpassword = request.getParameter("confirmpassword");
              String sex = request.getParameter("sex");
              String phone = request.getParameter("phone");
              request.setAttribute("msg", "");
              if (!password.equals(confirmpassword)) {
                     request.setAttribute("msg", "Your password is not match!");
                     request.getRequestDispatcher("register.jsp").forward(request, response);
              }else if(!accountDAO.isPasswordValid(password))
              {
                     request.setAttribute("msg", "Your password must be at least 6 and contain at least 1 special character!");
                     request.getRequestDispatcher("register.jsp").forward(request, response);

              }else if(!accountDAO.isValidUsername(username)|| !accountDAO.isValidUsername(fullname))
              {
                     request.setAttribute("msg", "Your username or full name must be at least 5 characters and does not contain special character");
                     request.getRequestDispatcher("register.jsp").forward(request, response);

              }else if(!accountDAO.validatePhoneNumber(phone))
              {
                     request.setAttribute("msg", "Phone must be a number and have 10 digits");
                     request.getRequestDispatcher("register.jsp").forward(request, response);

              }
              else {
                     ParentDAO parentDAO = new ParentDAO();
                     AccountDAO accDAO = new AccountDAO();
                     accDAO.getAllAccount();
                     accountUser account = accDAO.checkExsit(username);
                     if (account == null) { //continue to signup
                            try {
                                   accDAO.register(username, password, "Pa");
                                   parentDAO.register(username, fullname, sex, phone);
                            } catch (Exception e) {
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
