package Entity;

public class kidlearning {

    private int kidlearningID;
    private String kidID;
    private String courseID;
    private String status;

    public kidlearning(int kidlearningID, String kidID, String courseID) {
        this.kidlearningID = kidlearningID;
        this.kidID = kidID;
        this.courseID = courseID;
    }

    public kidlearning(int kidlearningID, String kidID, String courseID, String status) {
        this.kidlearningID = kidlearningID;
        this.kidID = kidID;
        this.courseID = courseID;
        this.status = status;
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
