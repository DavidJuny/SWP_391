package Model;

import java.util.Date;

public class lessonpointModel {
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

    public lessonpointModel(int lessonPointId, String kidId, int lessonItemId, float point, Date dateTaken, String kidName, String parentId) {
        LessonPointId = lessonPointId;
        KidId = kidId;
        LessonItemId = lessonItemId;
        Point = point;
        DateTaken = dateTaken;
        KidName = kidName;
        ParentId = parentId;
    }

    public String KidName;
    public String ParentId;

    public lessonpointModel() {
    }

    public lessonpointModel(int lessonPointId, String kidId, int lessonItemId, float point, String kidName, String parentId) {
        LessonPointId = lessonPointId;
        KidId = kidId;
        LessonItemId = lessonItemId;
        Point = point;
        KidName = kidName;
        ParentId = parentId;
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

    public String getKidName() {
        return KidName;
    }

    public void setKidName(String kidName) {
        KidName = kidName;
    }

    public String getParentId() {
        return ParentId;
    }

    public void setParentId(String parentId) {
        ParentId = parentId;
    }
}
