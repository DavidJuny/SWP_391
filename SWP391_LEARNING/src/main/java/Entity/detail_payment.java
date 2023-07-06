package Entity;

public class detail_payment {

    private int detailPaymentID;
    private int paymentID;
    private int kidLearningID;
    private float amountCourse;
    private String datePayment;
    private String status;
    private payment payment;
    private kidlearning kidlearning;

    public detail_payment(int detailPaymentID, int paymentID, int kidLearningID, float amountCourse, String datePayment, String status, payment payment, kidlearning kidlearning) {
        this.detailPaymentID = detailPaymentID;
        this.paymentID = paymentID;
        this.kidLearningID = kidLearningID;
        this.amountCourse = amountCourse;
        this.datePayment = datePayment;
        this.status = status;
        this.payment = payment;
        this.kidlearning = kidlearning;
    }
    
    

    public kidlearning getKidlearning() {
        return kidlearning;
    }

    public void setKidlearning(kidlearning kidlearning) {
        this.kidlearning = kidlearning;
    }
    
    public payment getPayment() {
        return payment;
    }

    public void setPayment(payment payment) {
        this.payment = payment;
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

    public int getKidLearningID() {
        return kidLearningID;
    }

    public void setKidLearningID(int kidLearningID) {
        this.kidLearningID = kidLearningID;
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
