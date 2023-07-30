package Controller;

import DAO.CourseDAO;
import DAO.LessonDAO;
import DAO.QuizDAO;
import Entity.course;
import Entity.lessonItem;
import Entity.question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminLessonItemController extends HttpServlet {
    private static final String LessonItemTable="lessonItem_table.jsp";
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
        LessonDAO lessonDAO=new LessonDAO();
        try
        {
            ArrayList<lessonItem> lessonItems = lessonDAO.GetAllLessonItem();
            request.setAttribute("lessonItems", lessonItems);
            request.getRequestDispatcher(LessonItemTable).forward(request, response);


        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

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
        LessonDAO lessonDAO=new LessonDAO();

        String action = request.getParameter("action");
        if (action != null && action.equals("CreateLessonItem")) {

            int lessonID= Integer.parseInt(request.getParameter("lessonID"));
            String ItemTypeID= request.getParameter("ItemTypeID");
            String content= request.getParameter("content");

            try
            {
                lessonDAO.insertLessonItem(lessonID,ItemTypeID,content);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
            response.sendRedirect("AdminLessonItemController");

        }else if (action!=null && action.equals("DeleteLessonItem"))
        {
            int lessonItemID= Integer.parseInt(request.getParameter("lessonItemID"));
            lessonDAO.deleteLessonItem(lessonItemID);
            response.sendRedirect("AdminLessonItemController");
        }else if (action!=null && action.equals("UpdateLessonItem"))
        {
            int lessonItemID= Integer.parseInt(request.getParameter("lessonItemID"));
            int lessonID = Integer.parseInt(request.getParameter("lessonID"));
            String itemTypeID = request.getParameter("itemTypeID");
            String content = request.getParameter("content");
            lessonItem lessonItem = new lessonItem(lessonItemID,lessonID,itemTypeID,content);
            try {
                lessonDAO.updateLessonItem(lessonItem);
                response.sendRedirect("AdminLessonItemController");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

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
