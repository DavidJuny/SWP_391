/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class CourseDAO {

       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;

       ArrayList<course> courseList = new ArrayList<>();

       public ArrayList<course> getAllCourses() {
              String query = "SELECT * "
                      + "FROM [Course]";
              try {
                     conn = DBContext.getConnection(); // mo ket noi sql
                     ps = conn.prepareStatement(query); // quang cau lenh vao sql
                     rs = ps.executeQuery(); // Tra ve ket qua
                     while (rs.next()) {
                            courseList.add(
                                    new course(
                                            rs.getString(1),
                                            rs.getString(2),
                                            rs.getString(3),
                                            rs.getString(4)));
                     }
              } catch (ClassNotFoundException | SQLException e) {
              }
              return courseList;
       }

       public static void main(String[] args) {
              CourseDAO courseDAO = new CourseDAO();
              ArrayList<course> courseList = new ArrayList<>();
//
              courseList = courseDAO.getAllCourses();
//
              for (course i : courseList) {
                     System.out.println(i);
//              }

//              kidDAO.registerk("Pa1", "Nguyen Hanh Nguyen", "kiddo", "123", "2023-01-01", "a");
              }

       }
}
