/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.PaymentDAO;
import Entity.detail_payment;
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
public class ShoppingCart extends HttpServlet {

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
                     PaymentDAO pdao = new PaymentDAO();
                     HttpSession session = request.getSession();
                     ArrayList<detail_payment> detail = new ArrayList<>();
                     int totalAmount = 0;
                     int items = 0;

                     pdao.getAllPayment();
                     parent pa = (parent) session.getAttribute("PARENT");
                     ArrayList<detail_payment> tmp = pdao.getAllPaymentbyParentID(pa.getParentID());

                     for (detail_payment object : tmp) {
                            if (object.getStatus().equalsIgnoreCase("Pending")) {
                                   detail.add(object);
                            }
                     }

                     for (detail_payment dp : detail) {
                            items += 1;
                            totalAmount += dp.getAmountCourse();
                     }
                     request.setAttribute("ITEMS", items);
                     request.setAttribute("TOTAL", totalAmount);
                     request.setAttribute("CART", detail);
                     request.getRequestDispatcher("showcart.jsp").forward(request, response);
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
