/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.accountUser;
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
       ArrayList<report> courses = new ArrayList<>();

       public report getLastestReport() {
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
       }
}
