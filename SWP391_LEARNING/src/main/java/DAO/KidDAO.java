/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.kid;
import Entity.parent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author PC
 */
public class KidDAO {

       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       ArrayList<kid> kidList = new ArrayList<>();

       public ArrayList<kid> getAllKids() {

              String query = "SELECT * "
                      + "FROM [Kids]";
              try {
                     conn = new DBContext().getConnection(); // mo ket noi sql
                     ps = conn.prepareStatement(query); // quang cau lenh vao sql
                     rs = ps.executeQuery(); // Tra ve ket qua
                     while (rs.next()) {
                            kidList.add(
                                    new kid(
                                            rs.getString(1),
                                            rs.getString(2),
                                            rs.getString(3),
                                            rs.getString(4),
                                            rs.getString(5),
                                            rs.getString(6)));
                     }
              } catch (Exception e) {
                     e.printStackTrace();
              }
              return kidList;
       }

       public void registerk(String parentID, String kidName, String kidAccount, String kidPassword, String kidBrithday, String kidImage) {
              String query = "INSERT INTO [dbo].[Kids]([parentID],[kidName],[kidAccount],[kidPassword],[kidBirthday],[kidImage])\n"
                      + "VALUES (?,?,?,?,?,?)";
              try {
                     conn = new DBContext().getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, parentID);
                     ps.setString(2, kidName);
                     ps.setString(3, kidAccount);
                     ps.setString(4, kidPassword);
                     ps.setString(5, kidBrithday);
                     ps.setString(6, kidImage);
                     ps.executeUpdate();
              } catch (Exception e) {
                     e.printStackTrace();
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

       public static void main(String[] args) {
              KidDAO kidDAO = new KidDAO();
              ArrayList<kid> kidList = new ArrayList<>();
//
//              kidList = kidDAO.getAllKids();
//
//              for (kid i : kidList) {
//                     System.out.println(i);
//              }

//              kidDAO.registerk("Pa1", "Nguyen Hanh Nguyen", "kiddo", "123", "2023-01-01", "a");
       }

}
