package Entity;

public class listening {
    private int listeningID;
    private int lessonID;
    private byte mp3File;

    public listening(int listeningID, int lessonID, byte mp3File) {
        this.listeningID = listeningID;
        this.lessonID = lessonID;
        this.mp3File = mp3File;
    }

    public int getListeningID() {
        return listeningID;
    }

    public void setListeningID(int listeningID) {
        this.listeningID = listeningID;
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public byte getMp3File() {
        return mp3File;
    }

    public void setMp3File(byte mp3File) {
        this.mp3File = mp3File;
    }
}
