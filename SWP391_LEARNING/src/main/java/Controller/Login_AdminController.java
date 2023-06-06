package Controller;

import DAO.AdminDAO;
import Entity.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Login_AdminController extends HttpServlet {
    private static final String SUCCESS = "index_Admin.jsp";
    private static final String FAILED = "authentication-login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String URL=FAILED;
        response.setContentType("text/html;charset=UTF-8");
        try {
            String username = request.getParameter("username1");
            String password = request.getParameter("password1");
            AdminDAO adminDAO = new AdminDAO();
            ArrayList<admin> admins = adminDAO.getAllAdmin();
            admin adminAccount = adminDAO.checkLogin(username,password);
            if(adminAccount==null)
            {
                String msg = "Account does not exist!!";
                request.setAttribute("login_msg", msg);
            }else
            {
                URL = SUCCESS;
            }
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }finally {
            request.getRequestDispatcher(URL).forward(request, response);

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
