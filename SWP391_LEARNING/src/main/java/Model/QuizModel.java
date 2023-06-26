package Model;

import java.util.ArrayList;

public class QuizModel {
    private int questionID;
    private int typeID;
    private String question;
    private ArrayList<String> answer;

    public QuizModel(int questionID, int typeID, String question, ArrayList<String> answer) {
        this.questionID = questionID;
        this.typeID = typeID;
        this.question = question;
        this.answer = answer;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<String> answer) {
        this.answer = answer;
    }
}
