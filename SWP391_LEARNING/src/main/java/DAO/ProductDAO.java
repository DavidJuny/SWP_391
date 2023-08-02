/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.kidlearning;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ProductDAO {

       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;

       public void addLearningKid(String kidID, String courseID) {
              String query = "INSERT INTO dbo.KidLearning(kidlearningID,kidID, courseID, status) VALUES(?,?,?,?)";

              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, Integer.toString(GetNextKidLearningId()));
                     ps.setString(2, kidID);
                     ps.setString(3, courseID);
                     ps.setString(4, "Pending");
                     ps.executeUpdate();
              } catch (ClassNotFoundException | SQLException e) {
              }
       }

       public int GetNextKidLearningId() {
              String query = "SELECT MAX(kidlearningID) + 1 AS next_id FROM KidLearning";
              PaymentDAO paymentDAO = new PaymentDAO();
              return paymentDAO.GetNextId(query);
       }


       public ArrayList<kidlearning> getAllKidlearningbyID(String kidID) {
              ArrayList<kidlearning> list = new ArrayList<>();
              String query = "SELECT [kidlearningID],[kidID],[dbo].[KidLearning].[courseID],[courseName],[courseImage],[courseLevel],[status]\n"
                      + "FROM [dbo].[Course]"
                      + " JOIN [dbo].[KidLearning] "
                      + "ON [dbo].[Course].[courseID]=[dbo].[KidLearning].[courseID]\n"
                      + "WHERE [kidID]=?";
              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, kidID);
                     rs = ps.executeQuery();
                     while (rs.next()) {
                            list.add(
                                    new kidlearning(
                                            rs.getInt(1),
                                            rs.getString(2),
                                            rs.getString(3),
                                            rs.getString(4),
                                            rs.getString(5),
                                            rs.getString(6),
                                            rs.getString(7)));
                     }
              } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
              }
              return list;
       }
//    public ArrayList<kidlearning> getAllKidlearning() {
//        ArrayList<kidlearning> list = new ArrayList<>();
//        String query = "SELECT * FROM dbo.KidLearning";
//        try {
//            conn = DBContext.getConnection();
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(
//                        new kidlearning(
//                                Integer.parseInt(rs.getString(1)),
//                                rs.getString(2),
//                                rs.getString(3),
//                                rs.getString(4)));
//            }
//        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
//        }
//        return list;
//    }

       public void changeKidLearning(String kidID, String courseID) {
              String query = "UPDATE dbo.KidLearning SET [status] = 'Unlock' WHERE courseID = ? AND kidID = ?";
              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, courseID);
                     ps.setString(2, kidID);
                     ps.executeUpdate();
              } catch (ClassNotFoundException | SQLException e) {
              }
       }

       public boolean checkStatusKidLearning(String kidID, String courseID) {
              ArrayList<kidlearning> list = getAllKidlearningbyID(kidID);
              for (kidlearning u : list) {
                     if (u.getKidID().equals(kidID) && u.getCourseID().equals(courseID)) {
                            return false;
                     }
              }
              return true;
       }
}
