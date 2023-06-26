package Model;

import java.util.HashMap;

public class QuizResult {
    private int points;
    private HashMap<Integer, String> incorrectAnswers;
    public QuizResult(int points, HashMap<Integer, String> incorrectAnswers) {
        this.points = points;
        this.incorrectAnswers = incorrectAnswers;
    }

    public int getPoints() {
        return points;
    }

    public HashMap<Integer, String> getIncorrectAnswers() {
        return incorrectAnswers;
    }
}
