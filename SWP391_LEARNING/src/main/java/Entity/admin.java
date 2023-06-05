package Entity;

public class admin {
    private int adminID;
    private String adminAccount;
    private String adminPassword;

    public admin(int adminID, String adminAccount, String adminPassword) {
        this.adminID = adminID;
        this.adminAccount = adminAccount;
        this.adminPassword = adminPassword;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
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
