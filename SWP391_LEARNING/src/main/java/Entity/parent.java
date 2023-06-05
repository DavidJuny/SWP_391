package Entity;

public class parent {

       private String parentID;
       private String parentAccount;
       private String parentPassword;
       private String parentName;
       private String parentSex;
       private String parentPhone;

       public String getParentID() {
              return parentID;
       }

       public void setParentID(String parentID) {
              this.parentID = parentID;
       }

       public String getParentAccount() {
              return parentAccount;
       }

       public void setParentAccount(String parentAccount) {
              this.parentAccount = parentAccount;
       }

       public String getParentPassword() {
              return parentPassword;
       }

       public void setParentPassword(String parentPassword) {
              this.parentPassword = parentPassword;
       }

       public String getParentName() {
              return parentName;
       }

       public void setParentName(String parentName) {
              this.parentName = parentName;
       }

       public String getParentSex() {
              return parentSex;
       }

       public void setParentSex(String parentSex) {
              this.parentSex = parentSex;
       }

       public String getParentPhone() {
              return parentPhone;
       }

       public void setParentPhone(String parentPhone) {
              this.parentPhone = parentPhone;
       }

       public parent(String parentID, String parentAccount, String parentPassword, String parentName, String parentSex, String parentPhone) {
              this.parentID = parentID;
              this.parentAccount = parentAccount;
              this.parentPassword = parentPassword;
              this.parentName = parentName;
              this.parentSex = parentSex;
              this.parentPhone = parentPhone;
       }

       public parent() {
       }

}
