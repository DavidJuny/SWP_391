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

    public ArrayList<kidlearning> getAllKidlearning() {
        ArrayList<kidlearning> list = new ArrayList<>();
        String query = "SELECT * FROM dbo.KidLearning";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(
                        new kidlearning(
                                Integer.parseInt(rs.getString(1)),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4)));
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

}
