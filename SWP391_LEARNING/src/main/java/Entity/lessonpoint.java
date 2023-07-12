package Entity;

public class lessonpoint {
    public int LessonPointId;
    public String KidId;
    public int LessonId;
    public float Point;

    public lessonpoint(int lessonPointId, String kidId, int lessonId, float point) {
        LessonPointId = lessonPointId;
        KidId = kidId;
        LessonId = lessonId;
        Point = point;
    }

    public lessonpoint() {
    }

    public int getLessonPointId() {
        return LessonPointId;
    }

    public void setLessonPointId(int lessonPointId) {
        LessonPointId = lessonPointId;
    }

    public String getKidId() {
        return KidId;
    }

    public void setKidId(String kidId) {
        KidId = kidId;
    }

    public int getLessonId() {
        return LessonId;
    }

    public void setLessonId(int lessonId) {
        LessonId = lessonId;
    }

    public float getPoint() {
        return Point;
    }

    public void setPoint(float point) {
        Point = point;
    }
}
