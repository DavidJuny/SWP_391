/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.lessonItem;
import java.io.IOException;
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
public class SortListController extends HttpServlet {

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
              try {
                     /* TODO output your page here. You may use following sample code. */
                     HttpSession session = request.getSession();
                     String ItemType_ID = request.getParameter("ItemType_ID");
                     ArrayList<lessonItem> list = (ArrayList<lessonItem>) session.getAttribute("LESSON_ITEM");
                     ArrayList<lessonItem> sortlist = new ArrayList<>();
                     if (list.isEmpty() || ItemType_ID.isEmpty()) {
                            response.sendRedirect("homepage.jsp");
                     }

                     for (lessonItem item : list) {
                            if (item.getItemTypeID().equalsIgnoreCase(ItemType_ID)) {
                                   sortlist.add(item);
                            }
                     }
                     session.removeAttribute("LESSON_ITEM");
                     session.setAttribute("LESSON_ITEM", sortlist);
                     request.getRequestDispatcher("learning.jsp").forward(request, response);
              } catch (Exception e) {
                     e.printStackTrace();
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
