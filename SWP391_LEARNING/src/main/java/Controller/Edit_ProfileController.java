/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.ParentDAO;
import Entity.accountUser;
import Entity.parent;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lenovo
 */
public class Edit_ProfileController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "editProfile.jsp";        
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String parentAccount = request.getParameter("account");
            String fullName = request.getParameter("name");
            String phone = request.getParameter("phone");
            String sex = request.getParameter("sex");
            ParentDAO dao = new ParentDAO();
//            accountUser user = new accountUser("", "", "", "");
//            parent dto = new parent("", "", fullName, sex, phone, user);
//            
            boolean checkUpdate = dao.editParent(fullName, sex, phone, parentAccount);
            if(checkUpdate){
              HttpSession session = request.getSession();
              parent loginUser = (parent) session.getAttribute("PARENT");
              if(loginUser.getParentAccount().equals(parentAccount)){
              loginUser.setParentName(fullName);
              loginUser.setParentSex(sex);
              loginUser.setParentPhone(phone);
              }
              url = SUCCESS;
              request.setAttribute("MESS", "SUSSCESSFULLY");
            }
        } catch (Exception e) {
            log("Erorr: "+ e.toString());
        }finally {
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
