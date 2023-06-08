/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AdminDAO;
import DAO.KidDAO;
import DAO.ParentDAO;
import Entity.admin;
import Entity.kid;
import Entity.parent;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PC
 */

public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String SUCCESS_KID = "kidpage.jsp";
    private static final String SUCCESS_PARENT = "homepage.jsp";
    private static final String SUCCESS_ADMIN = "admin.jsp";
    private static final String FAILED = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = FAILED;
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
//                     String remember = request.getParameter("remember");
            ParentDAO parentDAO = new ParentDAO();
            KidDAO kidDAO = new KidDAO();
            AdminDAO adminDAO = new AdminDAO();
            ArrayList<parent> parentList = parentDAO.getAllParents();
            ArrayList<kid> kidList = kidDAO.getAllKids();
            ArrayList<admin> adminList = adminDAO.getAllAdmins();
            parent parentAcc = parentDAO.checkLogin(username, password);
            kid kidAcc = kidDAO.checkExistedAccount(username);
            admin adminAcc = adminDAO.checkExistedAdmin(username);
            if (parentAcc == null && kidAcc == null && adminAcc == null) {
                String msg = "Account does not exist!!";
                request.setAttribute("login_msg", msg);
            } else {
//phan quyen
//                String parentID = parentAcc.getParentID().substring(0, 1);
                if (kidAcc != null) {
//                    String kidID = kidAcc.getKidID().substring(0, 1);
                    HttpSession session = request.getSession();
                    session.setAttribute("KID", kidAcc);
                    Cookie cookieUsername = new Cookie("cookieUsername", username);
                    cookieUsername.setMaxAge(60 * 60);
                    Cookie cookiePassword = new Cookie("cookiePassword", password);
                    cookiePassword.setMaxAge(60 * 60);
//                            Cookie cookieRemember = new Cookie("cookieRemember", remember);
//                            cookieRemember.setMaxAge(60 * 60);
                    response.addCookie(cookieUsername);
                    response.addCookie(cookiePassword);
//                            response.addCookie(cookieRemember);
                    url = SUCCESS_KID;
                }
                if (parentAcc != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("PARENT", parentAcc);
                    Cookie cookieUsername = new Cookie("cookieUsername", username);
                    cookieUsername.setMaxAge(60 * 60);
                    Cookie cookiePassword = new Cookie("cookiePassword", password);
                    cookiePassword.setMaxAge(60 * 60);
//                            Cookie cookieRemember = new Cookie("cookieRemember", remember);
//                            cookieRemember.setMaxAge(60 * 60);
                    response.addCookie(cookieUsername);
                    response.addCookie(cookiePassword);
//                            response.addCookie(cookieRemember);
                    url = SUCCESS_PARENT;
                }
                if (adminAcc != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("ADMIN", parentAcc);
                    Cookie cookieUsername = new Cookie("cookieUsername", username);
                    cookieUsername.setMaxAge(60 * 60);
                    Cookie cookiePassword = new Cookie("cookiePassword", password);
                    cookiePassword.setMaxAge(60 * 60);
//                            Cookie cookieRemember = new Cookie("cookieRemember", remember);
//                            cookieRemember.setMaxAge(60 * 60);
                    response.addCookie(cookieUsername);
                    response.addCookie(cookiePassword);
//                            response.addCookie(cookieRemember);
                    url = SUCCESS_ADMIN;
                }

            }
        } catch (Exception e) {
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
