/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author admin
 */
public class lessonItem {
    
    private int lessonItemID;
    private String lessonID;
    private String itemTypeID;
    private String content;

    public lessonItem() {
    }
    
    public lessonItem(int lessonItemID, String lessonID, String itemTypeID, String content) {
        this.lessonItemID = lessonItemID;
        this.lessonID = lessonID;
        this.itemTypeID = itemTypeID;
        this.content = content;
    }

    public int getLessonItemID() {
        return lessonItemID;
    }

    public void setLessonItemID(int lessonItemID) {
        this.lessonItemID = lessonItemID;
    }

    public String getLessonID() {
        return lessonID;
    }

    public void setLessonID(String lessonID) {
        this.lessonID = lessonID;
    }

    public String getItemTypeID() {
        return itemTypeID;
    }

    public void setItemTypeID(String itemTypeID) {
        this.itemTypeID = itemTypeID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
    
}
