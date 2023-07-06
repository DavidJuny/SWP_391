package Entity;

public class feedback {

    private int feedbackID;
    private String content;
    private String adminID;
    private String answer;
    private accountUser accountFeedback;

    public feedback(int feedbackID, String content, String adminID, String answer, accountUser accountFeedback) {
        this.feedbackID = feedbackID;
        this.content = content;
        this.adminID = adminID;
        this.answer = answer;
        this.accountFeedback = accountFeedback;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public accountUser getAccountFeedback() {
        return accountFeedback;
    }

    public void setAccountFeedback(accountUser accountFeedback) {
        this.accountFeedback = accountFeedback;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
