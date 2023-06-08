/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class AdminDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<admin> adminList = new ArrayList<>();
    
    public ArrayList<admin> getAllAdmins(){
        String query = "SELECT * "
                      + "FROM [Admin]";
         try {
                     conn = DBContext.getConnection(); 
                     ps = conn.prepareStatement(query); 
                     rs = ps.executeQuery(); 
                     while (rs.next()) {
                            adminList.add(
                                    new admin(
                                            rs.getString(1),
                                            rs.getString(2),
                                            rs.getString(3)));
                     }
              } catch (ClassNotFoundException | SQLException e) {
              }
              return adminList;     
    }
    
    public admin checkExistedAdmin(String username) {
              for (admin u : adminList) {
                     if (u.getAdminAccount().equals(username)) {
                            return u;
                     }
              }
              return null;
       }
}
