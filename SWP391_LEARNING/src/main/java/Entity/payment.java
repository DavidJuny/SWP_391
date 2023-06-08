package Entity;

public class payment {
    private int paymentID;
    private int parentID;

    public payment(int paymentID, int parentID) {
        this.paymentID = paymentID;
        this.parentID = parentID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }
}
