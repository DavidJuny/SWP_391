/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.accountUser;
import Entity.lessonItem;
import Entity.report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class ReportDAO {

       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       ArrayList<report> reports = new ArrayList<>();

//       public ArrayList<report> getReports(String kidID) {
//              String query = "SELECT * "
//                      + "FROM [dbo].[Report]"
//                      + "WHERE [kidID] = ?";
////                      + "ORDER BY [reportID] DESC";
//              try {
//                     conn = DBContext.getConnection(); // mo ket noi sql
//                     ps = conn.prepareStatement(query); // quang cau lenh vao sql
//                     ps.setString(1, kidID);
//                     rs = ps.executeQuery(); // Tra ve ket qua
//                     while (rs.next()) {
//                            reports.add(new report(
//                                    rs.getInt(1),
//                                    rs.getString(2),
//                                    rs.getString(3),
//                                    rs.getInt(4),
//                                    rs.getString(5)));
//                     }
//              } catch (ClassNotFoundException | SQLException e) {
//              }
//              return reports;
//
//       }
//
//       public report getLatestReports(String kidID) {
//              report rp = null;
//              String query = "SELECT TOP 1 * "
//                      + "FROM [dbo].[Report]"
//                      + "WHERE [kidID] = ?";
////                      + "ORDER BY reportID DESC";
//              try {
//                     conn = DBContext.getConnection(); // mo ket noi sql
//                     ps = conn.prepareStatement(query); // quang cau lenh vao sql
//                     ps.setString(1, kidID);
//                     rs = ps.executeQuery(); // Tra ve ket qua
//                     while (rs.next()) {
//                            rp = new report(
//                                    rs.getInt(1),
//                                    rs.getString(2),
//                                    rs.getString(3),
//                                    rs.getInt(4),
//                                    rs.getString(5));
//                     }
//              } catch (ClassNotFoundException | SQLException e) {
//              }
//              return rp;
//
//       }
       public ArrayList<report> GetListReport(String kidID) {
              ArrayList<report> rp = new ArrayList<>();
//              String query = "SELECT\n"
//                      + "    c.courseID,\n"
//                      + "    c.courseName,\n"
//                      + "    lp.kidID,\n"
//                      + "    AVG(lp.Point) AS average_points\n"
//                      + "FROM\n"
//                      + "    course c\n"
//                      + "    JOIN topic t ON c.courseID = t.courseID\n"
//                      + "    JOIN lesson l ON t.topicID = l.topicID\n"
//                      + "    JOIN lessonItem li ON l.lessonID = li.lessonID\n"
//                      + "    JOIN LessonPoint lp ON li.lessonItemID=lp.lessonItemId\n"
//                      + "WHERE  lp.kidID = ? "
//                      + "GROUP BY\n"
//                      + "    c.courseID,\n"
//                      + "    c.courseName,\n"
//                      + "    lp.kidID\n";

              String query = "SELECT\n"
                      + "                        [dbo].[Course].courseID,\n"
                      + "                          [dbo].[Course].courseName,\n"
                      + "                         kidID,\n"
                      + "                          AVG([dbo].[LessonPoint].Point) AS average_points\n"
                      + "                      FROM\n"
                      + "                         course\n"
                      + "                          JOIN topic ON [dbo].[Course].courseID = [dbo].[Topic].courseID\n"
                      + "                          JOIN lesson ON [dbo].[Topic].topicID = [dbo].[Lesson].topicID\n"
                      + "                         JOIN lessonItem ON [dbo].[Lesson].lessonID =[dbo].[LessonItem].lessonID\n"
                      + "                          JOIN LessonPoint ON [dbo].[LessonItem].lessonItemID=[dbo].[LessonPoint].lessonItemId\n"
                      + "                      WHERE  kidID = ?\n"
                      + "                      GROUP BY\n"
                      + "                         [dbo].[Course].courseID,\n"
                      + "                          [dbo].[Course].courseName,\n"
                      + "                        kidID";
              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, kidID);
                     rs = ps.executeQuery();
                     while (rs.next()) {
                            String courseId = rs.getString(1);
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
                            rp.add(reportModel);
                     }
              } catch (ClassNotFoundException | SQLException e) {
                     // Handle exception
              }

              return rp;
       }

       public static void main(String[] args) {
              ReportDAO rpdao = new ReportDAO();
              ArrayList<report> a = rpdao.GetListReport("Kthinh13");
              for (report object : a) {
                     System.out.println(object);
              }
       }
}
