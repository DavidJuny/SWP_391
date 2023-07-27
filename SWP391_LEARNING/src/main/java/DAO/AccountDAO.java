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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public boolean isPasswordValid(String password) {
        // Check if the password is not null and its length is greater than 5 characters
        if (password != null && password.length() > 5) {
            // Define the regular expression pattern for the password
            // It requires at least one special character and allows alphanumeric characters
            String regex = "^(?=.*[@#$%^&+=])(?=\\S+$).{6,}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);
            return matcher.find();
        }
        return false;
    }
    public  boolean isValidUsername(String username) {
        // Define a regular expression pattern to check for special characters
        Pattern specialCharsPattern = Pattern.compile("[^\\w\\s]");

        // Check if the username contains any special characters
        Matcher matcher = specialCharsPattern.matcher(username);
        if (matcher.find()) {
            return false;
        }

        // Check if the length of the username is within the desired range (e.g., 3 to 20 characters)
        int minLength = 5;
        int maxLength = 20;
        if (username.length() < minLength || username.length() > maxLength) {
            return false;
        }

        return true;
    }


}
