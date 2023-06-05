package Entity;

public class speaking {
    private int speakingID;
    private int lessonID;

    public speaking(int speakingID, int lessonID) {
        this.speakingID = speakingID;
        this.lessonID = lessonID;
    }

    public int getSpeakingID() {
        return speakingID;
    }

    public void setSpeakingID(int speakingID) {
        this.speakingID = speakingID;
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }
}
