package Controller;

import DAO.CourseDAO;
import DAO.TopicDAO;
import Entity.course;
import Entity.topic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class TopicController extends HttpServlet {
    private static final String TOPIC_TABLE="topic_tables.jsp";
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
        TopicDAO topicDAO = new TopicDAO();
        ArrayList<topic> topics = topicDAO.GetAllTopics();
        request.setAttribute("topics", topics);
        request.getRequestDispatcher(TOPIC_TABLE).forward(request, response);

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
TopicDAO topicDAO = new TopicDAO();
        if (action != null && action.equals("CreateTopic")) {
            int topicId = Integer.parseInt(request.getParameter("topicID"));
            String courseName = request.getParameter("courseName");
            String TopicName = request.getParameter("topicName");
            String TopicImage = request.getParameter("topicImage");

            topic topic = new topic(topicId, courseName, TopicName, TopicImage);
            try {
                topicDAO.AddTopic(topic);
                response.sendRedirect("TopicController");
            } catch (SQLException e) {
                request.setAttribute("error", "Error adding topic: " + e.getMessage());
                request.getRequestDispatcher("CreateTopicForm.jsp").forward(request, response);
            }

        } else if (action != null && action.equals("DeleteTopic")) {
            int topicID = Integer.parseInt(request.getParameter("topicID"));
            topicDAO.deleteTopic(topicID);
            response.sendRedirect("TopicController");
        } else if (action != null && action.equals("UpdateTopic")) {
            int topicID = Integer.parseInt(request.getParameter("topicID"));
            String topicName = request.getParameter("topicName");
            String TopicImage = request.getParameter("topicImage");
            String courseId = request.getParameter("courseID");
            topic topic = new topic(topicID,courseId,topicName,TopicImage);

            try {
                topicDAO.updateTopic(topic);
                response.sendRedirect("TopicController");
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
