package Model;

public class lessonpointModel {
    public int LessonPointId;
    public String KidId;
    public int LessonId;
    public float Point;
    public String KidName;
    public String ParentId;

    public lessonpointModel() {
    }

    public lessonpointModel(int lessonPointId, String kidId, int lessonId, float point, String kidName, String parentId) {
        LessonPointId = lessonPointId;
        KidId = kidId;
        LessonId = lessonId;
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
