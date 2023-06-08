package Entity;

public class quiz {
    private int quizID;
    private int lessonID;

    public quiz(int quizID, int lessonID) {
        this.quizID = quizID;
        this.lessonID = lessonID;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }
}
