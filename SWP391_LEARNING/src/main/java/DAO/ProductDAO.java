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
 * @author PC
 */
public class ProductDAO {

       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;

       public void addLearningKid1(String kidID) {
              String query = "INSERT INTO dbo.KidLearning(kidID, courseID, status) VALUES(?,?,?)";

              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, kidID);
                     ps.setString(2, "C1");
                     ps.setString(3, "Lock");
                     ps.executeUpdate();
              } catch (ClassNotFoundException | SQLException e) {
              }
       }

       public void addLearningKid2(String kidID) {
              String query = "INSERT INTO dbo.KidLearning(kidID, courseID, status) VALUES(?,?,?)";

              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, kidID);
                     ps.setString(2, "C2");
                     ps.setString(3, "Lock");
                     ps.executeUpdate();
              } catch (ClassNotFoundException | SQLException e) {
              }
       }

       public void addLearningKid3(String kidID) {
              String query = "INSERT INTO dbo.KidLearning(kidID, courseID, status) VALUES(?,?,?)";

              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, kidID);
                     ps.setString(2, "C3");
                     ps.setString(3, "Lock");
                     ps.executeUpdate();
              } catch (ClassNotFoundException | SQLException e) {
              }
       }

//       public ArrayList<kidlearning> getAllKidlearning() {
//              ArrayList<kidlearning> list = new ArrayList<>();
//              String query = "SELECT * FROM dbo.KidLearning";
//              try {
//                     conn = DBContext.getConnection();
//                     ps = conn.prepareStatement(query);
//                     rs = ps.executeQuery();
//                     while (rs.next()) {
//                            list.add(
//                                    new kidlearning(
//                                            Integer.parseInt(rs.getString(1)),
//                                            rs.getString(2),
//                                            rs.getString(3),
//                                            rs.getString(4)));
//                     }
//              } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
//              }
//              return list;
//       }
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

       public boolean checkStatusKidLearning(String kidID) {
              String query = "SELECT [status] FROM dbo.KidLearning WHERE kidID = ?";
              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, kidID);
                     rs = ps.executeQuery();
                     rs.next();
                     String status = rs.getString(1);
                     if (status.equals("Lock")) {
                            return true;
                     }
              } catch (ClassNotFoundException | SQLException e) {
              }
              return false;
       }

       public static void main(String[] args) {
              ProductDAO testdao = new ProductDAO();
              ArrayList<kidlearning> test = testdao.getAllKidlearningbyID("K2");
              for (kidlearning i : test) {
                     System.out.println(i.toString());
              }
//              parent user = parentDAO.checkExistedAccount("Nguyen123");
//              if (user == null) {
//                     System.out.println("no");
//              }
//              System.out.print(parentDAO.getAllParents().toString());
//              parent a = parentDAO.checkLogin("nguyen123", "123");
//              parentDAO.register("Nguyen123", "Nguyen Hanh Nguyen", "333", "Male", 010230110);
//              System.out.println(a);
       }

}
