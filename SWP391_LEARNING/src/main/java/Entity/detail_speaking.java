package Entity;

public class detail_speaking {
    private int detailSpeakingID;
    private int speakingID;

    public detail_speaking(int detailSpeakingID, int speakingID) {
        this.detailSpeakingID = detailSpeakingID;
        this.speakingID = speakingID;
    }

    public int getDetailSpeakingID() {
        return detailSpeakingID;
    }

    public void setDetailSpeakingID(int detailSpeakingID) {
        this.detailSpeakingID = detailSpeakingID;
    }

    public int getSpeakingID() {
        return speakingID;
    }

    public void setSpeakingID(int speakingID) {
        this.speakingID = speakingID;
    }
}
