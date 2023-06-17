/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.kid;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

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

        String query = "SELECT * "
                + "FROM [Kids]";
        try {
            conn = DBContext.getConnection(); // mo ket noi sql
            ps = conn.prepareStatement(query); // quang cau lenh vao sql
            rs = ps.executeQuery(); // Tra ve ket qua
            while (rs.next()) {
                kidList.add(
                        new kid(
                                rs.getString(1),
                                rs.getString(3),
                                rs.getString(2),
                                rs.getString(4),
                                rs.getString(6),
                                rs.getString(5)));
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return kidList;
    }
// chuan bi sua

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

}
