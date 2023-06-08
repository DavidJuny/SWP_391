package Entity;

public class detail_payment {
    private int detailPaymentID;
    private int paymentID;
    private String courseID;
    private float amountCourse;
    private String datePayment;
    private String status;

    public detail_payment(int detailPaymentID, int paymentID, String courseID, float amountCourse, String datePayment, String status) {
        this.detailPaymentID = detailPaymentID;
        this.paymentID = paymentID;
        this.courseID = courseID;
        this.amountCourse = amountCourse;
        this.datePayment = datePayment;
        this.status = status;
    }

    public int getDetailPaymentID() {
        return detailPaymentID;
    }

    public void setDetailPaymentID(int detailPaymentID) {
        this.detailPaymentID = detailPaymentID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public float getAmountCourse() {
        return amountCourse;
    }

    public void setAmountCourse(float amountCourse) {
        this.amountCourse = amountCourse;
    }

    public String getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(String datePayment) {
        this.datePayment = datePayment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
