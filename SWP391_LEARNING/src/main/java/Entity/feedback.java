package Entity;

public class feedback {
    private int feedbackID;
    private int feedbackerID;
    private String content;

    public feedback(int feedbackID, int feedbackerID, String content) {
        this.feedbackID = feedbackID;
        this.feedbackerID = feedbackerID;
        this.content = content;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public int getFeedbackerID() {
        return feedbackerID;
    }

    public void setFeedbackerID(int feedbackerID) {
        this.feedbackerID = feedbackerID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
