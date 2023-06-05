package Entity;

import java.util.Date;

public class kid {

       private String kidID;
       private String kidAccount, kidPassword, kidName, kidImage;
       private String kidBrithday;

       public kid() {
       }

       public kid(String kidID, String kidAccount, String kidPassword, String kidName, String kidImage, String kidBrithday) {
              this.kidID = kidID;
              this.kidAccount = kidAccount;
              this.kidPassword = kidPassword;
              this.kidName = kidName;
              this.kidImage = kidImage;
              this.kidBrithday = kidBrithday;
       }

       public String getKidID() {
              return kidID;
       }

       public void setKidID(String kidID) {
              this.kidID = kidID;
       }

       public String getKidAccount() {
              return kidAccount;
       }

       public void setKidAccount(String kidAccount) {
              this.kidAccount = kidAccount;
       }

       public String getKidPassword() {
              return kidPassword;
       }

       public void setKidPassword(String kidPassword) {
              this.kidPassword = kidPassword;
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

       public String getKidBrithday() {
              return kidBrithday;
       }

       public void setKidBrithday(String kidBrithday) {
              this.kidBrithday = kidBrithday;
       }

}
