package Controller;

import DAO.QuizDAO;
import Entity.lesson;
import Entity.lessonItem;
import Entity.question;
import Model.QuizModel;
import Model.QuizResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class QuestionController extends HttpServlet {
    private static final String QUESTION="Question.jsp";
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
            QuizModel quizModel=new QuizModel(question.getQuestionID(),question.getTypeID(),question.getQuestion(),Answers);
            newQuestion.add(quizModel);

        }
        return newQuestion;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        QuizDAO questionDAO= new QuizDAO();
        int lessonItemType= 1;
        ArrayList<question> questions= questionDAO.GetListQuestionFromLessonItem(lessonItemType);
        lessonItem lessonItem= questionDAO.getLessonItemByLessonItemId(lessonItemType);
        ArrayList<QuizModel> newquestions= shuffleAnswers(questions);
        lesson lesson1= questionDAO.getLessonByLessonItemID(lessonItemType);
        request.setAttribute("newquestions", newquestions);
        request.setAttribute("lesson", lesson1);
        request.setAttribute("lessonItem", lessonItem);
        request.getRequestDispatcher(QUESTION).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        String action = request.getParameter("action");
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
        QuizDAO quizDAO=new QuizDAO();
        QuizResult quizResult = quizDAO.GetAnswerFromQuestion(questionIds, submittedAnswers);

        request.setAttribute("points", quizResult.getPoints());
        request.setAttribute("incorrectAnswers", quizResult.getIncorrectAnswers());
        request.getRequestDispatcher(QUESTION).forward(request, response);
    }
}
