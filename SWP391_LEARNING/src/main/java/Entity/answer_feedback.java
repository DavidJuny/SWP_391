package Entity;

public class answer_feedback {
    private int answerFeedbackID;
    private int adminID;
    private int feedbackID;
    private String answer;

    public answer_feedback(int answerFeedbackID, int adminID, int feedbackID, String answer) {
        this.answerFeedbackID = answerFeedbackID;
        this.adminID = adminID;
        this.feedbackID = feedbackID;
        this.answer = answer;
    }

    public int getAnswerFeedbackID() {
        return answerFeedbackID;
    }

    public void setAnswerFeedbackID(int answerFeedbackID) {
        this.answerFeedbackID = answerFeedbackID;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
