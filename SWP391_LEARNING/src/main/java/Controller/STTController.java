package Controller;

import DAO.QuizDAO;
import DAO.SpeechDAO;
import Entity.lesson;
import Entity.lessonItem;
import Entity.question;
import Model.SpeechToText;
import Model.SpeechToTextResult;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class STTController extends HttpServlet {
    private static final String STTRESULT="Question.jsp";
    private static final String SPEECHPAGE="QuestionController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);}


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        SpeechDAO speechDAO= new SpeechDAO();
        QuizDAO quizDAO= new QuizDAO();
        SpeechToText speechToText=new SpeechToText();
        SpeechToTextResult result= new SpeechToTextResult();
        speechToText.setText(request.getParameter("transcript"));
        String pattern = request.getParameter("pattern");
        int lessonItemId = Integer.parseInt(request.getParameter("lessonItemID"));
        lessonItem lessonItem= quizDAO.getLessonItemByLessonItemId(lessonItemId);
        ArrayList<question> questions= quizDAO.GetListQuestionFromLessonItem(lessonItemId);

        lesson lesson1= quizDAO.getLessonByLessonItemID(lessonItemId);

        double point = speechDAO.SpeechAnalyze(speechToText.getText().trim(),pattern.trim());
        DecimalFormat decimalFormat = new DecimalFormat("#");
        String roundedNumber = decimalFormat.format(point);
        // comment in to use statistical ngram data:
        //langTool.activateLanguageModelRules(new File("/data/google-ngram-data"));

            ArrayList<String> answer=new ArrayList<>();
            answer.add("Spell Correct");
            result.setTextSaid(speechToText.getText());
            result.setRecommendAnswers(answer);
            request.setAttribute("result",result.getRecommendAnswers());
            request.setAttribute("speechPoint",roundedNumber);
            request.setAttribute("lessonItemId",lessonItemId);
        request.setAttribute("lesson", lesson1);
        request.setAttribute("text",result.getTextSaid());
        request.setAttribute("newquestions", questions);

        request.setAttribute("lessonItem", lessonItem);

        System.out.println("Spell correct");
            request.getRequestDispatcher(STTRESULT).forward(request, response);
        }
    }
