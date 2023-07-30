package Controller;

import DAO.LessonDAO;
import DAO.QuizDAO;
import Entity.lessonItem;
import Entity.question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminQuestionController extends HttpServlet {
private static final String QuestionTable="question_table.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        QuizDAO quizDAO=new QuizDAO();
        try
        {
            ArrayList<question> questions = quizDAO.GetAllQuestions();
            request.setAttribute("questions", questions);
            request.getRequestDispatcher(QuestionTable).forward(request, response);


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
        QuizDAO quizDAO = new QuizDAO();
        String action = request.getParameter("action");
        if (action != null && action.equals("CreateQuestion")) {
            int lessonItemID = Integer.parseInt(request.getParameter("lessonItemID"));
            String question = request.getParameter("question");
            String answer = request.getParameter("answer");

            quizDAO.insertQuestionWithDuplicateCheck(lessonItemID, question, answer);
            response.sendRedirect("AdminQuestionController");

        }else if (action!=null && action.equals("DeleteQuestion"))
        {
            int questionID= Integer.parseInt(request.getParameter("questionID"));
            quizDAO.deleteQuestion(questionID);
            response.sendRedirect("AdminQuestionController");
        }else if (action!=null && action.equals("UpdateQuestion"))
        {
            int questionID= Integer.parseInt(request.getParameter("questionID"));
            int lessonItemID = Integer.parseInt(request.getParameter("lessonItemID"));
            String question1 = request.getParameter("question");
            String answer = request.getParameter("answer");
            question question = new question(questionID,lessonItemID,question1,answer);
            try {
                quizDAO.updateQuestion(question);
                response.sendRedirect("AdminQuestionController");
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
