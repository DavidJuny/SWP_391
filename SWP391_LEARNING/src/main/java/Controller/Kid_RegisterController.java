/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.KidDAO;
import DAO.ParentDAO;
import Entity.kid;
import Entity.parent;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class Kid_RegisterController extends HttpServlet {

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
              try (PrintWriter out = response.getWriter()) {
                     String parentID = request.getParameter("parentID");
                     String kusername = request.getParameter("kusername");
                     String kfullname = request.getParameter("kfullname");
                     String kpassword = request.getParameter("kpassword");
                     String kconfpassword = request.getParameter("kconfpassword");
                     String kbirthday = request.getParameter("kbirthday");
                     String tmp = request.getParameter("kimage");
                     String kimage = "assets\\images\\" + tmp;
                     request.setAttribute("msg", "");
                     if (!kpassword.equals(kconfpassword)) {
                            request.setAttribute("msg", "Your password is not match!");
                            request.getRequestDispatcher("profile.jsp").forward(request, response);
                     } else {
                            KidDAO kidDAO = new KidDAO();
                            kidDAO.getAllKids();
                            kid user = kidDAO.checkExistedAccount(kusername);
                            if (user == null) { //continue to signup
                                   try {
                                          kidDAO.registerk(parentID, kfullname, kusername, kpassword, kbirthday, kimage);
                                   } catch (Exception e) {
                                          e.printStackTrace();
                                   }
                                   request.setAttribute("msg", "Your account has been created !");
                                   request.getRequestDispatcher("profile.jsp").forward(request, response);
                            } else { //deny to signup
                                   request.setAttribute("msg", "Your account has already existed !");
                                   request.getRequestDispatcher("profile.jsp").forward(request, response);
                            }
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
