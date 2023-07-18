/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.KidDAO;
import DAO.LessonPointDAO;
import Entity.kid;
import Entity.lessonpoint;
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
 * @author Lenovo
 */
public class lessonPointController extends HttpServlet {
    private static final String SUCCES = "ViewProgress.jsp";
    private static final String ERROR = "parentpage.jsp";

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
        String kidID = request.getParameter("kidID");

             LessonPointDAO dao = new LessonPointDAO();
              ArrayList<lessonpoint> list = dao.GetPointFromKidId(kidID);
              KidDAO test = new KidDAO();
              test.getAllKids();
              ArrayList<kid> pa = test.getAllKidbyID(kidID);
              
              HttpSession session = request.getSession();

              if(!list.isEmpty()){
             session.setAttribute("LISTPOINT", list);
             if(!pa.isEmpty()){
             session.setAttribute("GETKID", pa);
              url = SUCCES;
             }

         }else{
              session.setAttribute("MESS", "HAVE NOT JIONED COURSE!");
                url = ERROR;
               }
        } catch (Exception e) {
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
