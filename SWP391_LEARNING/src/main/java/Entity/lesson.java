package Entity;

public class lesson {

    private int lessonID;
    private int topicID;
    private String lessonName;
    private topic topic;

    public lesson(int lessonID, int topicID, String lessonName) {
        this.lessonID = lessonID;
        this.topicID = topicID;
        this.lessonName = lessonName;
    }

    public lesson(int lessonID, int topicID, String lessonName, topic topic) {
        this.lessonID = lessonID;
        this.topicID = topicID;
        this.lessonName = lessonName;
        this.topic = topic;
    }

    public topic getTopic() {
        return topic;
    }

    public void setTopic(topic topic) {
        this.topic = topic;
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }
}
