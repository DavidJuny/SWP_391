package Entity;

public class lesson {
    private int lessonID;
    private int topicID;
    private String lessonName;

    public lesson(int lessonID, int topicID, String lessonName) {
        this.lessonID = lessonID;
        this.topicID = topicID;
        this.lessonName = lessonName;
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
