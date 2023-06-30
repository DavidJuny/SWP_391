package Model;

import java.util.ArrayList;

public class SpeechToTextResult {
    public String TextSaid;
    public ArrayList<String> RecommendAnswers;

    public SpeechToTextResult() {

    }

    public String getTextSaid() {
        return TextSaid;
    }

    public void setTextSaid(String textSaid) {
        TextSaid = textSaid;
    }

    public ArrayList<String> getRecommendAnswers() {
        return RecommendAnswers;
    }

    public void setRecommendAnswers(ArrayList<String> recommendAnswers) {
        RecommendAnswers = recommendAnswers;
    }

    public SpeechToTextResult(String textSaid, ArrayList<String> recommendAnswers) {
        TextSaid = textSaid;
        RecommendAnswers = recommendAnswers;
    }
}
