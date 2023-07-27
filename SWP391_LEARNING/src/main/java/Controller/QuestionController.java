package Controller;

import DAO.LessonPointDAO;
import DAO.QuizDAO;
import Entity.kid;
import Entity.lesson;
import Entity.lessonItem;
import Entity.question;
import Model.QuizModel;
import Model.QuizResult;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.*;

public class QuestionController extends HttpServlet {

       private static final String QUESTION = "Question.jsp";

       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
              response.setContentType("text/html;charset=UTF-8");

       }

       public static ArrayList<QuizModel> shuffleAnswers(List<question> questions) {
              ArrayList<QuizModel> newQuestion = new ArrayList<>();
              for (question question : questions) {
                     String answers = question.getAnswer();
                     List<String> words = Arrays.asList(answers.split(","));
                     ArrayList<String> Answers = new ArrayList<>();
                     for (String word : words) {

                            Answers.add(word);
                     }
                     Collections.shuffle(Answers);
                     QuizModel quizModel = new QuizModel(question.getQuestionID(), question.getTypeID(), question.getQuestion(), Answers);
                     newQuestion.add(quizModel);
              }
              return newQuestion;
       }

       @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           processRequest(request, response);
           QuizDAO quizDAO = new QuizDAO();
           int lessonItemType = Integer.parseInt(request.getParameter("lessonItemID"));
           ArrayList<question> questions = quizDAO.GetListQuestionFromLessonItem(lessonItemType);
           lessonItem lessonItem = quizDAO.getLessonItemByLessonItemId(lessonItemType);
           ArrayList<QuizModel> newquestions = shuffleAnswers(questions);
           lesson lesson1 = quizDAO.getLessonByLessonItemID(lessonItemType);
           request.setAttribute("newquestions", newquestions);
           request.setAttribute("lesson", lesson1);
           request.setAttribute("lessonItem", lessonItem);
           request.getRequestDispatcher(QUESTION).forward(request, response);
           response.setContentType("application/json");
           response.setCharacterEncoding("UTF-8");
           response.getWriter().write(new Gson().toJson(newquestions));
       }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        QuizDAO quizDAO = new QuizDAO();
        String action = request.getParameter("action");
        if(action.equals("Submit Answer")) {
            HttpSession session = request.getSession();
            kid kid = (kid) session.getAttribute("KID");
            int lessonItemID = Integer.parseInt(request.getParameter("lessonItemID"));
            lessonItem lessonItem = quizDAO.getLessonItemByLessonItemId(lessonItemID);
            ArrayList<question> questions = quizDAO.GetListQuestionFromLessonItem(lessonItemID);

            HashMap<Integer, String> submittedAnswers = new HashMap<>();
            ArrayList<Integer> questionIds = new ArrayList<>();
            for (String paramName : request.getParameterMap().keySet()) {
                if (paramName.startsWith("answers")) {
                    Integer questionId = Integer.parseInt(paramName.substring(paramName.indexOf('[') + 1, paramName.indexOf(']')));
                    String answer = request.getParameter(paramName);
                    submittedAnswers.put(questionId, answer);
                    questionIds.add(questionId);
                }
            }

            LessonPointDAO lessonPointDAO = new LessonPointDAO();
            QuizResult quizResult = quizDAO.GetAnswerFromQuestion(questionIds, submittedAnswers);
            try {
                lessonPointDAO.AddLessonPointByKidId(kid.getKidID(), lessonItemID, quizResult.getPoints());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.setAttribute("questions", questions);
            request.setAttribute("points", quizResult.getPoints());
            request.setAttribute("incorrectAnswers", quizResult.getIncorrectAnswers());
            request.setAttribute("lessonItem", lessonItem);

            request.getRequestDispatcher(QUESTION).forward(request, response);
        }else
        {
            int lessonItemType = Integer.parseInt(request.getParameter("lessonItemID"));
            ArrayList<question> questions= quizDAO.GetListQuestionFromLessonItem(lessonItemType);
            lessonItem lessonItem= quizDAO.getLessonItemByLessonItemId(lessonItemType);
            ArrayList<QuizModel> newquestions= shuffleAnswers(questions);
            lesson lesson1= quizDAO.getLessonByLessonItemID(lessonItemType);
            request.setAttribute("newquestions", newquestions);
            request.setAttribute("lesson", lesson1);
            request.setAttribute("lessonItem", lessonItem);
            request.getRequestDispatcher(QUESTION).forward(request, response);
        }
    }
}
