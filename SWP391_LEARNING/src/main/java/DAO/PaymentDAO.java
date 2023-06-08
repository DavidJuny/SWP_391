/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.detail_payment;
import Entity.payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class PaymentDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<payment> paymentList = new ArrayList<>();
    ArrayList<detail_payment> detailList = new ArrayList<>();

    public ArrayList<payment> getAllPayment() {
        String query = "SELECT * "
                + "FROM [Payment]";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                paymentList.add(
                        new payment(
                                Integer.parseInt(rs.getString(1)),
                                rs.getString(2)));
            }
        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
        }
        return paymentList;
    }

    public ArrayList<detail_payment> getAllDetailPayment() {
        String query = "SELECT * "
                + "FROM [DetailPayment]";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                detailList.add(
                        new detail_payment(
                                Integer.parseInt(rs.getString(1)),
                                Integer.parseInt(rs.getString(2)),
                                rs.getString(3),
                                Float.parseFloat(rs.getString(4)),
                                rs.getString(5),
                                rs.getString(6)));
            }
        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
        }
        return detailList;
    }

    public payment AddPayment(String parentID) {
        String query = "INSERT INTO dbo.Payment([parentID]) VALUES (?)";
        String query2 = "SELECT TOP 1 *\n"
                + "FROM dbo.Payment\n"
                + "ORDER BY [paymentID] DESC";
        payment payment = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, parentID);
            ps.executeUpdate();
            PreparedStatement ps1 = null;
            ps1 = conn.prepareStatement(query2);
            rs = ps1.executeQuery();
            while (rs.next()) {
                payment = new payment(Integer.parseInt(rs.getString(1)), rs.getString(2));
            }
        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
        }
        return payment;
    }

    public void AddDetailPayment(int paymentID, String courseID, float amountCourse, String datePayment, String status) {
        String query = "INSERT INTO dbo.DetailPayment([paymentID],[courseID],[amountCourse],[datePayment],[status]) \n"
                + " VALUES (?,?,?,?,?)";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, Integer.toString(paymentID));
            ps.setString(2, courseID);
            ps.setString(3, Float.toString(amountCourse));
            ps.setString(4, datePayment);
            ps.setString(5, status);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

}
