package Entity;

public class topic {
    private int topicID;
    private int courseID;
    private String topicName;
    private String topicImage;

    public topic(int topicID, int courseID, String topicName, String topicImage) {
        this.topicID = topicID;
        this.courseID = courseID;
        this.topicName = topicName;
        this.topicImage = topicImage;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicImage() {
        return topicImage;
    }

    public void setTopicImage(String topicImage) {
        this.topicImage = topicImage;
    }
}
