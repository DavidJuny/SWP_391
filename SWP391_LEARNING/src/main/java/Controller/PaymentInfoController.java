/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CourseDAO;
import DAO.KidDAO;
import Entity.course;
import Entity.kid;
import Entity.parent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */
public class PaymentInfoController extends HttpServlet {

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
                     /* TODO output your page here. You may use following sample code. */
                     CourseDAO crs = new CourseDAO();
                     KidDAO kidDao = new KidDAO();
                     HttpSession session = request.getSession();
                     parent pa = (parent) session.getAttribute("PARENT");
                     kidDao.getAllKids();
                     crs.GetCourses();
                     ArrayList<kid> kids = kidDao.getAllKidbyParentID(pa.getParentID());
                     if (kids != null) {
                            String courseID = request.getParameter("courseID");
                            course info = crs.FindCoursebyID(courseID);
                            request.setAttribute("KIDLIST", kids);
                            request.setAttribute("INFO", info);
                            request.getRequestDispatcher("payment.jsp").forward(request, response);
                     } else {
                            response.sendError(0);
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
