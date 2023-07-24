package Entity;

public class report {

       private int reportID;
       private String kidID;
       private String courseID;
       private float courseGrade;
       private String detailReport;

       public report() {
       }

       public int getReportID() {
              return reportID;
       }

       public void setReportID(int reportID) {
              this.reportID = reportID;
       }

       public String getKidID() {
              return kidID;
       }

       public void setKidID(String kidID) {
              this.kidID = kidID;
       }

       public String getCourseID() {
              return courseID;
       }

       public void setCourseID(String courseID) {
              this.courseID = courseID;
       }

       public float getCourseGrade() {
              return courseGrade;
       }

       public void setCourseGrade(float courseGrade) {
              this.courseGrade = courseGrade;
       }

       public String getDetailReport() {
              return detailReport;
       }

       public void setDetailReport(String detailReport) {
              this.detailReport = detailReport;
       }

       public report( String kidID, String courseID, float courseGrade, String detailReport) {
              this.kidID = kidID;
              this.courseID = courseID;
              this.courseGrade = courseGrade;
              this.detailReport = detailReport;
       }
}
