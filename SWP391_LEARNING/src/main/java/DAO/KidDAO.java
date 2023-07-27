/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.accountUser;
import Entity.kid;
import Entity.parent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author PC
 */
public class KidDAO {

       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       ArrayList<kid> kidList = new ArrayList<>();

       public KidDAO() {
              kidList.clear();
       }

       public ArrayList<kid> getAllKids() {

              String query = "SELECT p.*, u.* "
                      + "FROM [Kids] p "
                      + "JOIN [AccountUser] u ON p.account = u.account";
              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

              try (Connection conn = DBContext.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

                     while (rs.next()) {
                            String kidID = rs.getString(1);
                            String kidAccount = rs.getString(2);
                            String parentID = rs.getString(3);
                            String kidName = rs.getString(4);
                            java.sql.Date sqlBirthDate = rs.getDate(5);
                            String kidImage = rs.getString(6);

                            String account = rs.getString(7);
                            String password = rs.getString(8);
                            String roleID = rs.getString(9);
                            String status = rs.getString(10);

                            // Convert the SQL Date to java.util.Date
                            Date birthDate = null;
                            if (sqlBirthDate != null) {
                                   try {
                                          birthDate = dateFormat.parse(sqlBirthDate.toString());
                                   } catch (ParseException e) {
                                          e.printStackTrace();
                                   }
                            }

                            accountUser accountUser = new accountUser(account, password, roleID, status);
                            kid kid = new kid(kidID, parentID, kidAccount, kidName, kidImage, birthDate, accountUser);
                            kidList.add(kid);
                     }
              } catch (ClassNotFoundException | SQLException e) {
              }
              return kidList;
       }

       public ArrayList<kid> getAllKidbyParentID(String parentID) {
              ArrayList<kid> kids = new ArrayList<>();
              for (kid i : kidList) {
                     if (i.getParentID().equals(parentID)) {
                            kids.add(i);
                     }
              }
              return kids;
       }

       public static void main(String[] args) {
              KidDAO test = new KidDAO();
              test.getAllKids();
              ArrayList<kid> pa = test.getAllKidbyParentID("Panguyen12");
              for (kid i : pa) {
                     System.out.println(i.toString());
              }
       }

// chuan bi sua
       public void updateStatus(String account) {
              String query = "UPDATE [AccountUser] SET status = CASE WHEN status = 'active' THEN 'ban' ELSE 'active' END WHERE account = ?";

              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, account);

                     int rowsAffected = ps.executeUpdate();
                     if (rowsAffected > 0) {
                            System.out.println("Status updated successfully.");
                     } else {
                            System.out.println("Status update failed.");
                     }
              } catch (ClassNotFoundException | SQLException e) {
                     // Handle exceptions
              } finally {
                     // Close resources
              }
       }

       public void registerk(String parentID, String kidName, String kidAccount, String kidBrithday, String kidImage) {
              String query = "INSERT INTO [dbo].[Kids]([account],[parentID],[kidName],[kidBirthday],[kidImage])\n"
                      + "VALUES (?,?,?,?,?)";
//        String query1 = "SELECT TOP 1 * FROM dbo.Kids ORDER BY CAST(SUBSTRING(kidID, PATINDEX('%[0-9]%', kidID), LEN(kidID)) AS INTEGER) DESC";
              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, kidAccount);
                     ps.setString(2, parentID);
                     ps.setString(3, kidName);
                     ps.setString(4, kidBrithday);
                     ps.setString(5, kidImage);
                     ps.executeUpdate();
//            PreparedStatement ps1 = conn.prepareStatement(query1);
//            rs = ps1.executeQuery();
//            rs.next();
//            String kidID = rs.getString("kidID");
              } catch (ClassNotFoundException | SQLException e) {
              }
       }

       public kid checkExistedAccount(String username) {
              for (kid u : kidList) {
                     if (u.getKidAccount().equals(username)) {
                            return u;
                     }
              }
              return null;
       }

//    public kid takeLastKid() {
//        String query = "SELECT TOP 1 * FROM dbo.Kids ORDER BY CAST(SUBSTRING(kidID, PATINDEX('%[0-9]%', kidID), LEN(kidID)) AS INTEGER) DESC";
//        try {
//            conn = DBContext.getConnection();
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            rs.next();
//            String kidID = rs.getString("kidID");
//            kid kid = new kid(kidID);
//            return kid;
//        } catch (ClassNotFoundException | SQLException e) {
//        }
//        return null;
//    }
       public String findkidID(String kidName, String parentID) {
              String query = "SELECT kidID FROM dbo.Kids WHERE kidName = ? AND parentID = ?";
              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, kidName);
                     ps.setString(2, parentID);
                     rs = ps.executeQuery();
                     String name = null, id = null;
                     while (rs.next()) {
                            name = rs.getString(1);
                            id = rs.getString(2);
                     }
                     for (kid u : kidList) {
                            if (u.getKidName().equals(name) && u.getParentID().equals(id)) {
                                   return u.getKidID();
                            }
                     }
              } catch (ClassNotFoundException | SQLException e) {
              }
              return null;
       }

       public ArrayList<kid> findkidByID(String parentID) {
              String query = "SELECT p.*, u.* "
                      + "FROM [Kids] p "
                      + "JOIN [AccountUser] u ON p.account = u.account WHERE parentID = ? ";
              ArrayList<kid> childrenList = new ArrayList<>();
              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, parentID);
                     rs = ps.executeQuery();

                     while (rs.next()) {
                            String kidID = rs.getString(1);
                            String kidAccount = rs.getString(2);
                            String kidName = rs.getString(4);
                            java.sql.Date sqlBirthDate = rs.getDate(5);
                            String kidImage = rs.getString(6);

                            String account = rs.getString(7);
                            String password = rs.getString(8);
                            String roleID = rs.getString(9);
                            String status = rs.getString(10);

                            Date birthDate = null;
                            if (sqlBirthDate != null) {
                                   try {
                                          birthDate = dateFormat.parse(sqlBirthDate.toString());
                                   } catch (ParseException e) {
                                          e.printStackTrace();
                                   }
                            }

                            accountUser accountUser = new accountUser(account, password, roleID, status);
                            kid kids = new kid(kidID, parentID, kidAccount, kidName, kidImage, birthDate, accountUser);
                            childrenList.add(kids);

                     }

              } catch (ClassNotFoundException | SQLException e) {
              }
              return childrenList;
       }

       public kid getKidbyID(String kidID) {
              for (kid i : kidList) {
                     if (i.getKidID().equals(kidID)) {
                            return i;
                     }
              }
              return null;
       }

       public ArrayList getAllKidsbyID(String kidID) {
              ArrayList<kid> result = new ArrayList<>();
              for (kid i : kidList) {
                     if (i.getKidID().equals(kidID)) {
                            result.add(i);
                     }
              }
              return result;
       }
}
