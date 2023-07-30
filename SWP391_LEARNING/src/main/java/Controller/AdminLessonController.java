package Controller;

import DAO.LessonDAO;
import Entity.lesson;
import Entity.lessonItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminLessonController extends HttpServlet {
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
        ArrayList<lesson> lessons = lessonDAO.GetAllLesson();
        request.setAttribute("lessons",lessons);
        request.getRequestDispatcher("lesson_table.jsp").forward(request,response);

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
        if (action != null && action.equals("CreateLesson")) {

            String topicID= request.getParameter("topicID");
            String lessonName= request.getParameter("lessonName");
            try
            {
                lessonDAO.insertLesson(topicID,lessonName);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
            response.sendRedirect("AdminLessonController");

        }else if (action!=null && action.equals("DeleteLesson"))
        {
            int lessonID= Integer.parseInt(request.getParameter("lessonID"));
            lessonDAO.deleteLesson(lessonID);
            response.sendRedirect("AdminLessonController");
        }else if (action!=null && action.equals("UpdateLesson"))
        {
            int lessonID= Integer.parseInt(request.getParameter("lessonID"));
            int topicID= Integer.parseInt(request.getParameter("topicID"));
            String lessonName = request.getParameter("lessonName");
            lesson lesson1=new lesson(lessonID,topicID,lessonName);
            try {
                lessonDAO.updateLesson(lesson1);
                response.sendRedirect("AdminLessonController");
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
