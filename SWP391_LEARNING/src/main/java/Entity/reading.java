package Entity;

public class reading {
    private int readingID;
    private int lessonID;
    private String reading;

    public reading(int readingID, int lessonID, String reading) {
        this.readingID = readingID;
        this.lessonID = lessonID;
        this.reading = reading;
    }

    public int getReadingID() {
        return readingID;
    }

    public void setReadingID(int readingID) {
        this.readingID = readingID;
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }
}
