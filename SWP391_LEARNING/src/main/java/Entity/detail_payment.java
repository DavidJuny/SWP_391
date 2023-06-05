package Entity;

import java.util.Date;

public class detail_payment {
    private int detailPaymentID;
    private int paymentID;
    private int courseID;
    private float amountCourse;
    private float amountMoney;
    private Date datePayment;
    private String status;

    public detail_payment(int detailPaymentID, int paymentID, int courseID, float amountCourse, float amountMoney, Date datePayment, String status) {
        this.detailPaymentID = detailPaymentID;
        this.paymentID = paymentID;
        this.courseID = courseID;
        this.amountCourse = amountCourse;
        this.amountMoney = amountMoney;
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

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public float getAmountCourse() {
        return amountCourse;
    }

    public void setAmountCourse(float amountCourse) {
        this.amountCourse = amountCourse;
    }

    public float getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(float amountMoney) {
        this.amountMoney = amountMoney;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
