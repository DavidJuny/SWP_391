package Controller;

import DAO.KidDAO;
import DAO.ParentDAO;
import Entity.kid;
import Entity.parent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AdminController extends HttpServlet {
    private final static String TABLE ="tables.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");





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
        ParentDAO parentDAO= new ParentDAO();
        KidDAO kidDAO = new KidDAO();

        ArrayList<parent> parents= parentDAO.getAllParents();
        ArrayList<kid> kids= kidDAO.getAllKids();
        request.setAttribute("kids", kids);
        request.setAttribute("parents", parents);
        request.getRequestDispatcher(TABLE).forward(request, response);
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
        String action = request.getParameter("action");
        if (action != null && action.equals("UpdateParent")) {
            String parentAccount = request.getParameter("parentAccount");
            ParentDAO parentDAO = new ParentDAO();

            // Perform the necessary logic to update the parent's status
            parentDAO.updateStatus(parentAccount);
            response.sendRedirect("AdminController");
        }else if (action != null && action.equals("UpdateKid")) {
            String kidAccount = request.getParameter("kidAccount");
            KidDAO kidDAO= new KidDAO();

            // Perform the necessary logic to update the parent's status
            kidDAO.updateStatus(kidAccount);
            response.sendRedirect("AdminController");

        }


            // Redirect back to the original page or perform any other necessary actions

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
