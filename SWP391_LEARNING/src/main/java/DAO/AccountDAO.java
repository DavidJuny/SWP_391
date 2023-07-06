/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.accountUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class AccountDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<accountUser> accountUser = new ArrayList<>();

    public AccountDAO() {
        accountUser.clear();             
    }
    
    public ArrayList<accountUser> getAllAccount() {

        String query = "SELECT * "
                + "FROM [AccountUser]";
        try {
            conn = DBContext.getConnection(); // mo ket noi sql
            ps = conn.prepareStatement(query); // quang cau lenh vao sql
            rs = ps.executeQuery(); // Tra ve ket qua
            while (rs.next()) {
                accountUser.add(
                        new accountUser(
                                rs.getString(1),
                                rs.getString(3),
                                rs.getString(2),
                                rs.getString(4)));
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return accountUser;
    }

    public accountUser checkExsit(String username) {
        for (accountUser u : accountUser) {
            if (u.getAccount().equals(username)) {
                return u;
            }
        }
        return null;
    }

    public accountUser checkLoginAccount(String username, String password) {
        for (accountUser u : accountUser) {
            if (u.getAccount().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public void register(String username, String password, String roleID) {
        String query = "INSERT INTO dbo.AccountUser(account, roleID, password, status) VALUES(?,?,?,?)";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, roleID);
            ps.setString(3, password);
            ps.setString(4, "Active");
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

}
