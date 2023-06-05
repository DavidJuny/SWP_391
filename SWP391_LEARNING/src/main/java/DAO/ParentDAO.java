/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.parent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class ParentDAO {

       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       ArrayList<parent> parentList = new ArrayList<>();

       public ArrayList<parent> getAllParents() {

              String query = "SELECT * "
                      + "FROM [Parent]";
              try {
                     conn = new DBContext().getConnection(); // mo ket noi sql
                     ps = conn.prepareStatement(query); // quang cau lenh vao sql
                     rs = ps.executeQuery(); // Tra ve ket qua
                     while (rs.next()) {
                            parentList.add(
                                    new parent(
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
              return parentList;
       }

       public parent checkLogin(String username, String password) {
              for (parent u : parentList) {
                     if (u.getParentAccount().equals(username) && u.getParentPassword().equals(password)) {
                            return u;
                     }
              }
              return null;
       }

       public parent checkForgotPassword(String username) {
              for (parent u : parentList) {
                     if (u.getParentAccount().equals(username)) {
                            return u;
                     }
              }
              return null;
       }

       public parent checkExistedAccount(String username) {
              for (parent u : parentList) {
                     if (u.getParentAccount().equals(username)) {
                            return u;
                     }
              }
              return null;
       }

       public void register(String username, String fullname, String password, String sex, int number) {
              String query = "INSERT INTO dbo.Parent(parentAccount, parentPassword, parentName, parentSex, parentNumber) VALUES(?,?,?,?,?)";
              try {
                     conn = new DBContext().getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setString(1, username);
                     ps.setString(2, password);
                     ps.setString(3, fullname);
                     ps.setString(4, sex);
                     ps.setInt(5, number);
                     ps.executeUpdate();
              } catch (Exception e) {
                     e.printStackTrace();
              }
       }

       public static void main(String[] args) {
              ParentDAO parentDAO = new ParentDAO();
              parentDAO.getAllParents();
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
