/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.accountUser;
import Entity.parent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public ParentDAO() {
        parentList.clear();
    }

    public ArrayList<parent> getAllParents() {
        String query = "SELECT p.*, u.* "
                + "FROM [Parent] p "
                + "JOIN [AccountUser] u ON p.account = u.account";

        try {
            conn = DBContext.getConnection(); // mo ket noi sql
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
                                new accountUser(
                                        rs.getString(6),
                                        rs.getString(7),
                                        rs.getString(8),
                                        rs.getString(9)
                                )));

            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return parentList;
    }
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


    public void register(String username, String fullname, String sex, String number) {
        String query = "INSERT INTO dbo.Parent(account, parentName, parentSex, parentNumber) VALUES(?,?,?,?)";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, fullname);
            ps.setString(3, sex);
            ps.setString(4, number);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public parent getParent(String account) {
        for (parent u : parentList) {
            if (u.getParentAccount().equals(account)) {
                return u;
            }
        }
        return null;
    }
    
 public boolean editParent(String fullname, String sex, String number, String parentAccount) throws SQLException{
        String query = "  UPDATE [dbo].[Parent] SET [dbo].[Parent].parentName = ?, [dbo].[Parent].parentSex = ?, [dbo].[Parent].parentNumber = ? FROM [dbo].[Parent] WHERE [dbo].[Parent].account = ?";
        boolean checkUpdate = false;
        try {
         conn = DBContext.getConnection();
         ps = conn.prepareStatement(query);
         ps.setString(1, fullname);
         ps.setString(2, sex);
         ps.setString(3, number);
         ps.setString(4, parentAccount);
         ps.executeUpdate();
         checkUpdate = true;
     } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ps!= null) ps.close();
            if(conn!= null) conn.close();
        }
        return checkUpdate;
        
    }
}
