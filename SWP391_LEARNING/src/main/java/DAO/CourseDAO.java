package DAO;

import DBcontext.DBContext;
import Entity.course;
import Entity.kid;

import javax.ejb.DuplicateKeyException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAO {

       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       ArrayList<course> courses = new ArrayList<>();

       public CourseDAO() {
              courses.clear();
       }

       public ArrayList<course> GetCourses() {
              String query = "SELECT * FROM [Course]";
              try (Connection conn = DBContext.getConnection();
                      PreparedStatement ps = conn.prepareStatement(query);
                      ResultSet rs = ps.executeQuery()) {

                     while (rs.next()) {
                            courses.add(new course(
                                    rs.getString(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4)
                            ));
                     }
              } catch (SQLException throwables) {
                     throwables.printStackTrace();
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }
              return courses;
       }

       public course FindCoursebyID(String courseID) {
              for (course i : courses) {
                     if (i.getCourseID().equals(courseID)) {
                            return i;
                     }
              }
              return null;
       }

       public static void main(String[] args) {
              CourseDAO n = new CourseDAO();
              ArrayList<course> ad = n.GetCourses();
              for (course object : ad) {
                     System.out.println(object);
              }
       }

       public void addCourse(course newCourse) throws SQLException {
              String query = "INSERT INTO [Course] (courseID, courseName, courseImage, courseLevel) VALUES (?, ?, ?, ?)";

              try (Connection conn = DBContext.getConnection();
                      PreparedStatement ps = conn.prepareStatement(query)) {

                     ps.setString(1, newCourse.getCourseID());
                     ps.setString(2, newCourse.getCourseName());
                     ps.setString(3, newCourse.getCourseImage());
                     ps.setString(4, newCourse.getCourseLevel());

                     ps.executeUpdate();

              } catch (SQLException throwables) {
                     String customMessage = "Course existed";
                     SQLException customException = new SQLException(customMessage);
                     customException.printStackTrace();
                     throw new SQLException(customException);
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }
       }

       public void updateCourse(course updatedCourse) {
              String checkQuery = "SELECT COUNT(*) FROM [Course] WHERE courseID = ?";
              String updateQuery = "UPDATE [Course] SET courseName = ?, courseImage = ?, courseLevel = ? WHERE courseID = ?";

              try (Connection conn = DBContext.getConnection();
                      PreparedStatement checkPs = conn.prepareStatement(checkQuery);
                      PreparedStatement updatePs = conn.prepareStatement(updateQuery)) {

                     checkPs.setString(1, updatedCourse.getCourseID());
                     ResultSet resultSet = checkPs.executeQuery();
                     resultSet.next();
                     int count = resultSet.getInt(1);

                     if (count == 0) {
                            System.out.println("Course does not exist.");
                            return; // or throw an exception if desired
                     }

                     updatePs.setString(1, updatedCourse.getCourseName());
                     updatePs.setString(2, updatedCourse.getCourseImage());
                     updatePs.setString(3, updatedCourse.getCourseLevel());
                     updatePs.setString(4, updatedCourse.getCourseID());

                     updatePs.executeUpdate();
              } catch (SQLException throwables) {
                     throwables.printStackTrace();
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }
       }

       public void deleteCourse(String courseID) {
              String checkQuery = "SELECT COUNT(*) FROM [Course] WHERE courseID = ?";
              String deleteQuery = "DELETE FROM [Course] WHERE courseID = ?";

              try (Connection conn = DBContext.getConnection();
                      PreparedStatement checkPs = conn.prepareStatement(checkQuery);
                      PreparedStatement deletePs = conn.prepareStatement(deleteQuery)) {

                     checkPs.setString(1, courseID);
                     ResultSet resultSet = checkPs.executeQuery();
                     resultSet.next();
                     int count = resultSet.getInt(1);

                     if (count == 0) {
                            System.out.println("Course does not exist.");
                            return; // or throw an exception if desired
                     }

                     deletePs.setString(1, courseID);
                     deletePs.executeUpdate();
              } catch (SQLException throwables) {
                     throwables.printStackTrace();
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }
       }

}
