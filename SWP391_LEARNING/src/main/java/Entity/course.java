package Entity;

public class course {
    private int courseID;
    private String courseName;
    private String courseImage;
    private String courseLevel;

    public course(int courseID, String courseName, String courseImage, String courseLevel) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseImage = courseImage;
        this.courseLevel = courseLevel;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }
}
