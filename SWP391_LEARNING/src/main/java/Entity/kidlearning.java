package Entity;

public class kidlearning {
    private int kidlearningID;
    private int kidID;
    private int parentID;
    private int courseID;
    private String courseName;
    private String status;

    public kidlearning(int kidlearningID, int kidID, int parentID, int courseID, String courseName, String status) {
        this.kidlearningID = kidlearningID;
        this.kidID = kidID;
        this.parentID = parentID;
        this.courseID = courseID;
        this.courseName = courseName;
        this.status = status;
    }

    public int getKidlearningID() {
        return kidlearningID;
    }

    public void setKidlearningID(int kidlearningID) {
        this.kidlearningID = kidlearningID;
    }

    public int getKidID() {
        return kidID;
    }

    public void setKidID(int kidID) {
        this.kidID = kidID;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
