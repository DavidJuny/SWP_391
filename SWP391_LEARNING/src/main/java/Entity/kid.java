package Entity;

import java.util.Date;

public class kid {

    private String kidID, parentID;
    private String kidAccount, kidName, kidImage;
    private Date kidBrithday;
    private accountUser account;

    public accountUser getAccount() {
        return account;
    }

    public void setAccount(accountUser account) {
        this.account = account;
    }

    public kid() {
    }

    public kid(String kidID) {
        this.kidID = kidID;
    }

    public String getKidID() {
        return kidID;
    }

    public void setKidID(String kidID) {
        this.kidID = kidID;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getKidAccount() {
        return kidAccount;
    }

    public void setKidAccount(String kidAccount) {
        this.kidAccount = kidAccount;
    }

    public String getKidName() {
        return kidName;
    }

    public void setKidName(String kidName) {
        this.kidName = kidName;
    }

    public String getKidImage() {
        return kidImage;
    }

    public void setKidImage(String kidImage) {
        this.kidImage = kidImage;
    }

    public Date getKidBrithday() {
        return kidBrithday;
    }

    public void setKidBrithday(Date kidBrithday) {
        this.kidBrithday = kidBrithday;
    }

    public kid(String kidID, String parentID, String kidAccount, String kidName, String kidImage, Date kidBrithday, accountUser account) {
        this.kidID = kidID;
        this.parentID = parentID;
        this.kidAccount = kidAccount;
        this.kidName = kidName;
        this.kidImage = kidImage;
        this.kidBrithday = kidBrithday;
        this.account = account;
    }

}
