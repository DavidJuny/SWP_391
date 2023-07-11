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
                                            rs.getString(2)));
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

       public float CountTotalSale()
       {
           String query = "SELECT SUM(amountCourse)  AS TotalSale FROM DetailPayment";
           float TotalSale=0;
           try {
               conn = DBContext.getConnection();
               ps = conn.prepareStatement(query);
               rs = ps.executeQuery();
               while (rs.next()) {
                 TotalSale = rs.getFloat("TotalSale")   ;
               }
           } catch (ClassNotFoundException | SQLException e) {
           }
           return TotalSale;
       }

       public float TodaysMoney(String Today)
       {
           String query = "SELECT SUM(amountCourse) AS TODAYMONEY FROM DetailPayment WHERE datepayment = ?";
           float TodaysMoney=0;
           try {
               conn = DBContext.getConnection();
               ps = conn.prepareStatement(query);
               ps.setString(1,Today);
               rs = ps.executeQuery();
               while (rs.next()) {
                   TodaysMoney = rs.getFloat("TODAYMONEY")   ;
               }
           } catch (ClassNotFoundException | SQLException e) {
           }
           return TodaysMoney;
       }

       public int TotalUser()
       {
           String query="SELECT COUNT(*) AS TOTALUSER FROM AccountUser WHERE roleID = 'Pa' OR roleID='K'";
           int TotalUser=0;
           try {
               conn = DBContext.getConnection();
               ps = conn.prepareStatement(query);
               rs = ps.executeQuery();
               while (rs.next()) {
                   TotalUser = rs.getInt("TOTALUSER")   ;
               }
           } catch (ClassNotFoundException | SQLException e) {
           }
           return TotalUser;
       }
}
