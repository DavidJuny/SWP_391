/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.accountUser;
import Entity.report;
import Model.lessonpointModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author PC
 */
public class ReportDAO {

       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       ArrayList<report> courses = new ArrayList<>();

//       public report getLastestReport() {
//              report rp;
//
//              String query = "SELECT * "
//                      + "FROM [AccountUser]";
//              try {
//                     conn = DBContext.getConnection(); // mo ket noi sql
//                     ps = conn.prepareStatement(query); // quang cau lenh vao sql
//                     rs = ps.executeQuery(); // Tra ve ket qua
//                     rp = new rp(
//                             rs.getString(1),
//                             rs.getString(3),
//                             rs.getString(2),
//                             rs.getString(4));
//              } catch (ClassNotFoundException | SQLException e) {
//              }
//              return rp;
//       }

       public ArrayList<report> GetListReport(ArrayList<String> kidIDs) {
              ArrayList<report> reports = new ArrayList<>();
              String query = "SELECT\n" +
                      "    c.courseID,\n" +
                      "    c.courseName,\n" +
                      "    lp.kidID,\n" +
                      "    AVG(lp.Point) AS average_points\n" +
                      "FROM\n" +
                      "    course c\n" +
                      "    JOIN topic t ON c.courseID = t.courseID\n" +
                      "    JOIN lesson l ON t.topicID = l.topicID\n" +
                      "    JOIN lessonItem li ON l.lessonID = li.lessonID\n" +
                      "    JOIN LessonPoint lp ON li.lessonItemID=lp.lessonItemId\n" +
                      "WHERE  lp.kidID IN (" + String.join(",", Collections.nCopies(kidIDs.size(), "?")) + ")\n" +
                      "GROUP BY\n" +
                      "    c.courseID,\n" +
                      "    c.courseName,\n" +
                      "    lp.kidID\n";
              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     for (int i = 0; i < kidIDs.size(); i++) {
                            ps.setString(i + 1, kidIDs.get(i));
                     }
                     rs = ps.executeQuery();
                     while (rs.next()) {
                            String courseId = rs.getString(1);
                            String kidID = rs.getString(3);
                            float point = rs.getFloat(4);
                            String reportDetail = "";
                            if (point <= 1) {
                                   reportDetail = "Need Practice";
                            } else if (point > 1 && point <= 3) {
                                   reportDetail = "Average";
                            } else if (point > 3) {
                                   reportDetail = "Good";
                            }

                            report reportModel = new report(kidID, courseId, point, reportDetail);
                            reports.add(reportModel);
                     }
              } catch (ClassNotFoundException | SQLException e) {
                     // Handle exception
              }

              return reports;
       }
}
