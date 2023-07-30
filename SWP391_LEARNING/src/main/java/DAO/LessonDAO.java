/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.*;

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

              public void insertLesson( String topicID, String lessonName) throws SQLException, ClassNotFoundException {
                     int id=getNextLesson();
                     String query = "INSERT INTO Lesson (lessonID, topicID, lessonName) VALUES (?, ?, ?)";

                     try  {
                            conn = DBContext.getConnection();
                            ps = conn.prepareStatement(query);
                            ps.setInt(1, id);
                            ps.setString(2, topicID);
                            ps.setString(3, lessonName);
                            ps.executeUpdate();
                            System.out.println("Lesson inserted successfully!");
                     } catch (SQLException | ClassNotFoundException e) {
                            e.printStackTrace();
                     }
              }
       private boolean isLessonNameDuplicate(String lessonName) throws SQLException {
              String query = "SELECT COUNT(*) FROM Lesson WHERE lessonName = ?";
              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, lessonName);
                     try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                   int count = rs.getInt(1);
                                   return count > 0; // If count > 0, it means a lesson with the same name already exists.
                            }
                     }
              } catch (SQLException | ClassNotFoundException e) {
                     e.printStackTrace();
              }
              return false;
       }
       public void insertLessonItem(int lessonID, String ItemTypeID, String content) throws SQLException, ClassNotFoundException {
              int id = getNextLessonItem();

              String query = "INSERT INTO LessonItem (lessonItemID, lessonID, ItemTypeID, content) VALUES (?, ?, ?, ?)";
              try  {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setInt(1, id);
                     ps.setInt(2, lessonID);
                     ps.setString(3, ItemTypeID);
                     ps.setString(4, content);

                     ps.executeUpdate();
                     System.out.println("LessonItem inserted successfully!");
              } catch (SQLException | ClassNotFoundException e) {
                     e.printStackTrace();
              }
       }
       public void updateLessonItem(lessonItem updatedLessonItem) {
              String checkQuery = "SELECT COUNT(*) FROM [LessonItem] WHERE lessonItemID = ?";
              String updateQuery = "UPDATE [LessonItem] SET lessonID = ?, ItemTypeID = ?, content = ? WHERE lessonItemID = ?";

              try (Connection conn = DBContext.getConnection();
                   PreparedStatement checkPs = conn.prepareStatement(checkQuery);
                   PreparedStatement updatePs = conn.prepareStatement(updateQuery)) {

                     checkPs.setInt(1, updatedLessonItem.getLessonItemID());
                     ResultSet resultSet = checkPs.executeQuery();
                     resultSet.next();
                     int count = resultSet.getInt(1);

                     if (count == 0) {
                            System.out.println("Course does not exist.");
                            return; // or throw an exception if desired
                     }

                     updatePs.setInt(1, updatedLessonItem.getLessonID());
                     updatePs.setString(2, updatedLessonItem.getItemTypeID());
                     updatePs.setString(3, updatedLessonItem.getContent());
                     updatePs.setInt(4, updatedLessonItem.getLessonItemID());

                     updatePs.executeUpdate();
              } catch (SQLException throwables) {
                     throwables.printStackTrace();
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }
       } public void updateLesson(lesson updatedLesson) {
              String checkQuery = "SELECT COUNT(*) FROM Lesson WHERE lessonID = ?";
              String updateQuery = "UPDATE Lesson SET topicID = ?, lessonName = ? WHERE lessonID = ?";

              try (Connection conn = DBContext.getConnection();
                   PreparedStatement checkPs = conn.prepareStatement(checkQuery);
                   PreparedStatement updatePs = conn.prepareStatement(updateQuery)) {

                     checkPs.setInt(1, updatedLesson.getLessonID());
                     ResultSet resultSet = checkPs.executeQuery();
                     resultSet.next();
                     int count = resultSet.getInt(1);

                     if (count == 0) {
                            System.out.println("Course does not exist.");
                            return; // or throw an exception if desired
                     }

                     updatePs.setInt(1, updatedLesson.getTopicID());
                     updatePs.setString(2, updatedLesson.getLessonName());
                     updatePs.setInt(3, updatedLesson.getLessonID());

                     updatePs.executeUpdate();
              } catch (SQLException throwables) {
                     throwables.printStackTrace();
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }
       }
       public void deleteLessonItem(int lessonItemID) {
              String checkQuery = "SELECT COUNT(*) FROM LessonItem WHERE lessonItemID = ?";
              String deleteQuery = "DELETE FROM LessonItem WHERE lessonItemID = ?";

              try (Connection conn = DBContext.getConnection();
                   PreparedStatement checkPs = conn.prepareStatement(checkQuery);
                   PreparedStatement deletePs = conn.prepareStatement(deleteQuery)) {

                     checkPs.setInt(1, lessonItemID);
                     ResultSet resultSet = checkPs.executeQuery();
                     resultSet.next();
                     int count = resultSet.getInt(1);

                     if (count == 0) {
                            System.out.println("Course does not exist.");
                            return; // or throw an exception if desired
                     }

                     deletePs.setInt(1, lessonItemID);
                     deletePs.executeUpdate();
              } catch (SQLException throwables) {
                     throwables.printStackTrace();
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }
       } public void deleteLesson(int lessonID) {
              String checkQuery = "SELECT COUNT(*) FROM Lesson WHERE lessonID = ?";
              String deleteQuery = "DELETE FROM Lesson WHERE lessonID = ?";

              try (Connection conn = DBContext.getConnection();
                   PreparedStatement checkPs = conn.prepareStatement(checkQuery);
                   PreparedStatement deletePs = conn.prepareStatement(deleteQuery)) {

                     checkPs.setInt(1, lessonID);
                     ResultSet resultSet = checkPs.executeQuery();
                     resultSet.next();
                     int count = resultSet.getInt(1);

                     if (count == 0) {
                            System.out.println("Course does not exist.");
                            return; // or throw an exception if desired
                     }

                     deletePs.setInt(1, lessonID);
                     deletePs.executeUpdate();
              } catch (SQLException throwables) {
                     throwables.printStackTrace();
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }
       }

       private boolean isLessonItemIDDuplicate(int lessonItemID) throws SQLException {
              String query = "SELECT COUNT(*) FROM LessonItem WHERE lessonItemID = ?";
              try  {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setInt(1, lessonItemID);
                     try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                   int count = rs.getInt(1);
                                   return count > 0; // If count > 0, it means a lesson item with the same ID already exists.
                            }
                     }
              } catch (SQLException | ClassNotFoundException e) {
                     e.printStackTrace();
              }
              return false;
       }
       public ArrayList<lessonItem> GetAllLessonItem()
       {
              ArrayList<lessonItem> lessonItems = new ArrayList<>();
              String query = "SELECT * FROM LessonItem";
              try (Connection conn = DBContext.getConnection();
                   PreparedStatement ps = conn.prepareStatement(query)) {
                     try (ResultSet rs = ps.executeQuery()) {
                            while (rs.next()) {
                                   lessonItems.add(new lessonItem(
                                           rs.getInt(1),
                                           rs.getInt(2),
                                           rs.getString(3),
                                           rs.getString(4)
                                   ));
                            }
                     }
              } catch (SQLException throwables) {
                     throwables.printStackTrace();
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }
              return lessonItems;
       }
       private int getNextLessonItem() throws SQLException, ClassNotFoundException {
              String countQuery = "SELECT COUNT(*) FROM LessonItem";
              Connection connection = DBContext.getConnection();
              PreparedStatement countStmt = connection.prepareStatement(countQuery);
              ResultSet resultSet = countStmt.executeQuery();
              resultSet.next();
              int count = resultSet.getInt(1);
              resultSet.close();
              countStmt.close();

              // Increment the count to get the next questionID
              return count + 1;
       }  private int getNextLesson() throws SQLException, ClassNotFoundException {
              String countQuery = "SELECT COUNT(*) FROM Lesson";
              Connection connection = DBContext.getConnection();
              PreparedStatement countStmt = connection.prepareStatement(countQuery);
              ResultSet resultSet = countStmt.executeQuery();
              resultSet.next();
              int count = resultSet.getInt(1);
              resultSet.close();
              countStmt.close();

              // Increment the count to get the next questionID
              return count + 1;
       }

       public ArrayList<lesson> GetAllLesson()
       {
              ArrayList<lesson> lessons = new ArrayList<>();
              String query = "SELECT * FROM Lesson";
              try (Connection conn = DBContext.getConnection();
                   PreparedStatement ps = conn.prepareStatement(query)) {
                     try (ResultSet rs = ps.executeQuery()) {
                            while (rs.next()) {
                                   lessons.add(new lesson(
                                           rs.getInt(1),
                                           rs.getInt(2),
                                           rs.getString(3)
                                   ));
                            }
                     }
              } catch (SQLException throwables) {
                     throwables.printStackTrace();
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }
              return lessons;

       }
}


