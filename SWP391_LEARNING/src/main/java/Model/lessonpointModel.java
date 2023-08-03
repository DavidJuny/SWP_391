package Model;

import java.util.Date;

public class lessonpointModel {
    public int LessonPointId;
    public String KidId;
    public int LessonItemId;
    public float Point;
    public Date DateTaken;
    public String ItemTypeID;
    public String LessionName;
    public String CourseName;

    public lessonpointModel() {
    }

    public lessonpointModel(int LessonPointId, String KidId, int LessonItemId, float Point, Date DateTaken, String ItemTypeID, String LessionName, String CourseName) {
        this.LessonPointId = LessonPointId;
        this.KidId = KidId;
        this.LessonItemId = LessonItemId;
        this.Point = Point;
        this.DateTaken = DateTaken;
        this.ItemTypeID = ItemTypeID;
        this.LessionName = LessionName;
        this.CourseName = CourseName;
    }

    public int getLessonPointId() {
        return LessonPointId;
    }

    public void setLessonPointId(int LessonPointId) {
        this.LessonPointId = LessonPointId;
    }

    public String getKidId() {
        return KidId;
    }

    public void setKidId(String KidId) {
        this.KidId = KidId;
    }

    public int getLessonItemId() {
        return LessonItemId;
    }

    public void setLessonItemId(int LessonItemId) {
        this.LessonItemId = LessonItemId;
    }

    public float getPoint() {
        return Point;
    }

    public void setPoint(float Point) {
        this.Point = Point;
    }

    public Date getDateTaken() {
        return DateTaken;
    }

    public void setDateTaken(Date DateTaken) {
        this.DateTaken = DateTaken;
    }

    public String getItemTypeID() {
        return ItemTypeID;
    }

    public void setItemTypeID(String ItemTypeID) {
        this.ItemTypeID = ItemTypeID;
    }

    public String getLessionName() {
        return LessionName;
    }

    public void setLessionName(String LessionName) {
        this.LessionName = LessionName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }
}
