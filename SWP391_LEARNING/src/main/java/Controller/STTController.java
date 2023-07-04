package Controller;

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
import java.util.ArrayList;
import java.util.List;

public class STTController extends HttpServlet {
    private static final String STTRESULT="STT.jsp";
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
        SpeechToText speechToText=new SpeechToText();
        SpeechToTextResult result= new SpeechToTextResult();
        speechToText.setText(request.getParameter("transcript"));
        JLanguageTool langTool = new JLanguageTool(new AmericanEnglish());
        // comment in to use statistical ngram data:
        //langTool.activateLanguageModelRules(new File("/data/google-ngram-data"));
        ArrayList<RuleMatch> matches = (ArrayList<RuleMatch>) langTool.check(speechToText.getText());
        if(matches.size()==0)
        {
            ArrayList<String> answer=new ArrayList<>();
            answer.add("Spell Correct");
            result.setTextSaid(speechToText.getText());
            result.setRecommendAnswers(answer);
            request.setAttribute("result",result.getRecommendAnswers());
            request.setAttribute("text",result.getTextSaid());
            System.out.println("Spell correct");
            request.getRequestDispatcher(STTRESULT).forward(request, response);
        }else {
            for (RuleMatch match : matches) {
                System.out.println("Potential error at characters " +
                        match.getFromPos() + "-" + match.getToPos() + ": " +
                        match.getMessage());
                System.out.println("Suggested correction(s): " +
                        match.getSuggestedReplacements());
                result.setRecommendAnswers((ArrayList<String>) match.getSuggestedReplacements());
            }
            result.setTextSaid(speechToText.getText());
            request.setAttribute("text",result.getTextSaid());
            request.setAttribute("result",result.getRecommendAnswers());
            request.getRequestDispatcher(STTRESULT).forward(request, response);
        }
    }


}
