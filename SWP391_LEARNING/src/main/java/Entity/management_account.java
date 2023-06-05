package Entity;

public class management_account {
    private int managementAccountID;
    private int adminID;
    private int accountID;
    private String status;

    public management_account(int managementAccountID, int adminID, int accountID, String status) {
        this.managementAccountID = managementAccountID;
        this.adminID = adminID;
        this.accountID = accountID;
        this.status = status;
    }

    public int getManagementAccountID() {
        return managementAccountID;
    }

    public void setManagementAccountID(int managementAccountID) {
        this.managementAccountID = managementAccountID;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
