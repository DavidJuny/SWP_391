/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.course;
import Entity.lesson;
import Entity.lessonItem;
import Entity.topic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class LessonDAO {

       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;

       public ArrayList<lesson> getLesson(String kidID) {
              String query = "SELECT *\n"
                      + "FROM KidLearning kl\n"
                      + "JOIN Course c ON kl.courseID = c.courseID\n"
                      + "JOIN Topic t ON c.courseID = t.courseID\n"
                      + "JOIN Lesson l ON t.topicID = l.topicID\n"
                      + "WHERE kl.kidID = ?;";
              ArrayList<lesson> list = new ArrayList<>();
              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, kidID);
                     rs = ps.executeQuery();
                     while (rs.next()) {
                            String courseID = rs.getString(5);
                            String courseName = rs.getString(6);
                            String courseImage = rs.getString(7);
                            String courseLevel = rs.getString(8);
                            int topicID = rs.getInt(9);
                            String topicName = rs.getString(11);
                            String topicImage = rs.getString(12);
                            int lessonID = rs.getInt(13);
                            String lessonName = rs.getString(15);
                            course course = new course(courseID, courseName, courseImage, courseLevel);
                            topic topic = new topic(topicID, courseID, topicName, topicImage, course);
                            lesson lesson = new lesson(lessonID, topicID, lessonName, topic);
                            list.add(lesson);
                     }
              } catch (ClassNotFoundException | SQLException e) {
              }

              return list;
       }


       public static void main(String[] args) {
              LessonDAO test = new LessonDAO();
              ArrayList<lesson> tmp = test.getLesson("Knhi13");
              for (lesson object : tmp) {
                     System.out.println(object);
              }
       }

       public ArrayList<lessonItem> getLessonItem(int lessonID) {
              ArrayList<lessonItem> list = new ArrayList<>();
              String query = "SELECT *\n"
                      + "FROM LessonItem li\n"
                      + "JOIN ItemType i ON li.ItemTypeID = i.ItemtypeID\n"
                      + "WHERE li.lessonID = ?";
              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setInt(1, lessonID);
                     rs = ps.executeQuery();
                     while (rs.next()) {
                            int lessonItemID = rs.getInt(1);
                            String ItemType = rs.getString(3);
                            String content = rs.getString(4);
                            String nameType = rs.getString(6);
                            lessonItem item = new lessonItem(lessonItemID, lessonID, ItemType, nameType, content);
                            list.add(item);
                     }
              } catch (ClassNotFoundException | SQLException e) {
              }
              return list;
       }

}
