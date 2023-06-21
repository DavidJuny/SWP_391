package Entity;

public class payment {

    private int paymentID;
    private String parentID;

    public payment() {
    }

    public payment(int paymentID, String parentID) {
        this.paymentID = paymentID;
        this.parentID = parentID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

}
