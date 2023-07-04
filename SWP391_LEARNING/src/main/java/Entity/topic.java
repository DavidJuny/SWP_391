package Entity;

public class topic {
    private int topicID;
    private String courseID;
    private String topicName;
    private String topicImage;
    private course course;

    public topic(int topicID, String courseID, String topicName, String topicImage) {
        this.topicID = topicID;
        this.courseID = courseID;
        this.topicName = topicName;
        this.topicImage = topicImage;
    }

    public topic(int topicID, String courseID, String topicName, String topicImage, course course) {
        this.topicID = topicID;
        this.courseID = courseID;
        this.topicName = topicName;
        this.topicImage = topicImage;
        this.course = course;
    }
    
    public course getCourse() {
        return course;
    }

    public void setCourse(course course) {
        this.course = course;
    }
    
    

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
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
