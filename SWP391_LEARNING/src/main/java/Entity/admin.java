package Entity;

public class admin {

    private String adminID;
    private String adminAccount;

    public admin() {
    }

    public admin(String adminID, String adminAccount) {
        this.adminID = adminID;
        this.adminAccount = adminAccount;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

}
