package Entity;

public class kidlearning {

    private int kidlearningID;
    private String kidID;
    private String courseID;
       private String courseName;
       private String courseImage;
       private String courseLevel;
    private String status;

    public kidlearning() {
    }

    public kidlearning(int kidlearningID, String kidID, String courseID) {
        this.kidlearningID = kidlearningID;
        this.kidID = kidID;
        this.courseID = courseID;
    }

    public kidlearning(int kidlearningID, String kidID, String courseID, String courseName, String courseImage, String courseLevel, String status) {
        this.kidlearningID = kidlearningID;
        this.kidID = kidID;
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseImage = courseImage;
        this.courseLevel = courseLevel;
        this.status = status;
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

    public int getKidlearningID() {
        return kidlearningID;
    }

    public void setKidlearningID(int kidlearningID) {
        this.kidlearningID = kidlearningID;
    }

    public String getKidID() {
        return kidID;
    }

    public void setKidID(String kidID) {
        this.kidID = kidID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
