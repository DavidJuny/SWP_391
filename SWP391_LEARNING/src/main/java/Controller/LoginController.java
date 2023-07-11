/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccountDAO;
import DAO.AdminDAO;
import DAO.KidDAO;
import DAO.ParentDAO;
import Entity.accountUser;
import Entity.kid;
import Entity.parent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private static final String SUCCESS_KID = "homepage.jsp";
    private static final String SUCCESS_PARENT = "homepage.jsp";
    private static final String SUCCESS_ADMIN = "index_admin.jsp";
    private static final String FAILED = "login.jsp";
    private static final String ADMIN = "Ad";
    private static final String PARENT = "Pa";
    private static final String KID = "K";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = FAILED;
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String remember = request.getParameter("remember");
            HttpSession session = request.getSession();
            AccountDAO dao = new AccountDAO();
            ParentDAO parentDAO = new ParentDAO();
            KidDAO kidDAO = new KidDAO();
            kidDAO.getAllKids();
            parentDAO.getAllParents();
            dao.getAllAccount();
            accountUser account = dao.checkLoginAccount(username, password);
            if (account == null) {
                String msg = "Wrong password or username!!!";
                request.setAttribute("login_msg", msg);
            } else {
                if (account.getRoleID().equals(ADMIN) && account.getStatus().equalsIgnoreCase("active")) {
                    session.setAttribute("ADMIN", account);
                    Cookie cookieUsername = new Cookie("cookieUsername", username);
                    cookieUsername.setMaxAge(60 * 60);
                    Cookie cookiePassword = new Cookie("cookiePassword", password);
                    cookiePassword.setMaxAge(60 * 60);
//                  Cookie cookieRemember = new Cookie("cookieRemember", remember);
//                  cookieRemember.setMaxAge(60 * 60);
                    response.addCookie(cookieUsername);
                    response.addCookie(cookiePassword);
                    AdminDAO adminDAO = new AdminDAO();
                    request.setAttribute("Totalsale",adminDAO.CountTotalSale());
                    LocalDate currentDate = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String TodayDate = currentDate.format(formatter);
                    request.setAttribute("TodaysMoney",adminDAO.TodaysMoney(TodayDate));
                    request.setAttribute("TotalUser",adminDAO.TotalUser());


//                  response.addCookie(cookieRemember);
                    url = SUCCESS_ADMIN;
                } else if (account.getRoleID().equals(KID) && account.getStatus().equalsIgnoreCase("active")) {
                    kid kid = kidDAO.checkExistedAccount(account.getAccount());
                    session.setAttribute("KID", kid);
                    Cookie cookieUsername = new Cookie("cookieUsername", username);
                    cookieUsername.setMaxAge(60 * 60);
                    Cookie cookiePassword = new Cookie("cookiePassword", password);
                    cookiePassword.setMaxAge(60 * 60);
                    Cookie cookieRemember = new Cookie("cookieRemember", remember);
                    cookieRemember.setMaxAge(60 * 60);
                    response.addCookie(cookieUsername);
                    response.addCookie(cookiePassword);
                    response.addCookie(cookieRemember);
                    url = SUCCESS_KID;
                } else if (account.getRoleID().equals(PARENT) && account.getStatus().equalsIgnoreCase("active")) {
                    parent parent = parentDAO.getParent(account.getAccount());
                    session.setAttribute("PARENT", parent);
                    Cookie cookieUsername = new Cookie("cookieUsername", username);
                    cookieUsername.setMaxAge(60 * 60);
                    Cookie cookiePassword = new Cookie("cookiePassword", password);
                    cookiePassword.setMaxAge(60 * 60);
                    Cookie cookieRemember = new Cookie("cookieRemember", remember);
                    cookieRemember.setMaxAge(60 * 60);
                    response.addCookie(cookieUsername);
                    response.addCookie(cookiePassword);
                    response.addCookie(cookieRemember);
                    url = SUCCESS_PARENT;
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
