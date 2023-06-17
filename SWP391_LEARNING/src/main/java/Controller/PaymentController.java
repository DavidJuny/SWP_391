/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.KidDAO;
import DAO.PaymentDAO;
import DAO.ProductDAO;
import Entity.parent;
import Entity.payment;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class PaymentController extends HttpServlet {

    private static final String ERROR = "payment.jsp";
    private static final String SUCCESS = "homepage.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            PaymentDAO paymentDAO = new PaymentDAO();
            KidDAO kidDAO = new KidDAO();
            ProductDAO proDAO = new ProductDAO();
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = currentDate.format(formatter);
            Float ammountCourse = Float.valueOf(request.getParameter("ammount"));
            String courseID = request.getParameter("courseID");
            parent parent = (parent) session.getAttribute("PARENT");
            String parentID = parent.getParentID();
            String kidName = request.getParameter("kidName"); // lay ben trang payment.jsp cho phep parent lua chon kid theo ten de mua khoa hoc cho.
            String kidID = kidDAO.findkidID(kidName, parentID);
            if (proDAO.checkStatusKidLearning(kidID, courseID)) {
                payment payment = paymentDAO.AddPayment(parentID);
                int paymentID = payment.getPaymentID();
                paymentDAO.AddDetailPayment(paymentID, courseID, ammountCourse, formattedDate, "Done");
                proDAO.addLearningKid(kidID, courseID);
                request.setAttribute("msg", "Payment successfully");
                url = SUCCESS;
            } else {
                request.setAttribute("msg", "Your kid already have this course!!!");
            }
        } catch (NumberFormatException e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
