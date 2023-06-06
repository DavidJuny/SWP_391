package DAO;

import DBcontext.DBContext;
import Entity.admin;
import Entity.admin;
import Entity.parent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<admin> admins=new ArrayList<admin>();
    public ArrayList<admin> getAllAdmin() {

        String query = "SELECT * "
                + "FROM [Admin]";
        try {
            conn = new DBContext().getConnection(); // mo ket noi sql
            ps = conn.prepareStatement(query); // quang cau lenh vao sql
            rs = ps.executeQuery(); // Tra ve ket qua
            while (rs.next()) {
                admins.add(
                        new admin(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admins;
    }
    public admin checkLogin(String username, String password) {
        for (admin u : admins) {
            if (u.getAdminAccount().equals(username) && u.getAdminPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public admin checkForgotPassword(String username) {
        for (admin u : admins) {
            if (u.getAdminAccount().equals(username)) {
                return u;
            }
        }
        return null;
    }

    public admin checkExistedAccount(String username) {
        for (admin u : admins) {
            if (u.getAdminAccount().equals(username)) {
                return u;
            }
        }
        return null;
    }

    public void RegisterAdmin(String username,String password)
    {
        String query = "INSERT INTO dbo.Admin(accountAdmin,passwordAdmin) VALUES (?,?)";
        try
        {
            conn = new DBContext().getConnection();
            ps=conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
