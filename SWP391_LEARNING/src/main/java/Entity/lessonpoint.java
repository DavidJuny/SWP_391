package Entity;

import java.util.Date;

public class lessonpoint {
    public int LessonPointId;
    public String KidId;
    public int LessonItemId;
    public float Point;
    public Date DateTaken;

    public Date getDateTaken() {
        return DateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        DateTaken = dateTaken;
    }

    public lessonpoint(int lessonPointId, String kidId, int lessonItemId, float point, Date dateTaken) {
        LessonPointId = lessonPointId;
        KidId = kidId;
        LessonItemId = lessonItemId;
        Point = point;
        DateTaken = dateTaken;
    }

    public lessonpoint() {
    }

    public lessonpoint(int lessonPointId, String kidId, int lessonItemId, float point) {
        LessonPointId = lessonPointId;
        KidId = kidId;
        LessonItemId = lessonItemId;
        Point = point;
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

    public int getLessonItemId() {
        return LessonItemId;
    }

    public void setLessonItemId(int lessonItemId) {
        LessonItemId = lessonItemId;
    }

    public float getPoint() {
        return Point;
    }

    public void setPoint(float point) {
        Point = point;
    }
}
