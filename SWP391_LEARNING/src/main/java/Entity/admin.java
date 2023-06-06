package Entity;

public class admin {
    private String adminID;
    private String adminAccount;
    private String adminPassword;

    public admin(String adminID, String adminAccount, String adminPassword) {
        this.adminID = adminID;
        this.adminAccount = adminAccount;
        this.adminPassword = adminPassword;
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

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
