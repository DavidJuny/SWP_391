package Entity;

public class report {
    private int reportID;
    private int kidID;
    private int courseID;
    private int parentID;
    private int courseGrade;
    private String detailReport;
    private int quizGrade;
    private int readingGrade;
    private int listeningGrade;
    private int speakingGrade;

    public report(int reportID, int kidID, int courseID, int parentID, int courseGrade, String detailReport, int quizGrade, int readingGrade, int listeningGrade, int speakingGrade) {
        this.reportID = reportID;
        this.kidID = kidID;
        this.courseID = courseID;
        this.parentID = parentID;
        this.courseGrade = courseGrade;
        this.detailReport = detailReport;
        this.quizGrade = quizGrade;
        this.readingGrade = readingGrade;
        this.listeningGrade = listeningGrade;
        this.speakingGrade = speakingGrade;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public int getKidID() {
        return kidID;
    }

    public void setKidID(int kidID) {
        this.kidID = kidID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public int getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(int courseGrade) {
        this.courseGrade = courseGrade;
    }

    public String getDetailReport() {
        return detailReport;
    }

    public void setDetailReport(String detailReport) {
        this.detailReport = detailReport;
    }

    public int getQuizGrade() {
        return quizGrade;
    }

    public void setQuizGrade(int quizGrade) {
        this.quizGrade = quizGrade;
    }

    public int getReadingGrade() {
        return readingGrade;
    }

    public void setReadingGrade(int readingGrade) {
        this.readingGrade = readingGrade;
    }

    public int getListeningGrade() {
        return listeningGrade;
    }

    public void setListeningGrade(int listeningGrade) {
        this.listeningGrade = listeningGrade;
    }

    public int getSpeakingGrade() {
        return speakingGrade;
    }

    public void setSpeakingGrade(int speakingGrade) {
        this.speakingGrade = speakingGrade;
    }
}
