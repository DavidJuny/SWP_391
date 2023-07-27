/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.detail_payment;
import Entity.kidlearning;
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
       ArrayList<detail_payment> detailList = new ArrayList<>();

       public ArrayList<detail_payment> getAllPayment() {
              String query = "SELECT p.*, u.*, k.* FROM [DetailPayment] p \n"
                      + "JOIN [Payment] u ON p.paymentID = u.paymentID\n"
                      + "JOIN [KidLearning] k ON p.kidlearningID = k.kidlearningID";
              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     rs = ps.executeQuery();
                     while (rs.next()) {
                            int detailID = Integer.parseInt(rs.getString(1));
                            int paymentID = Integer.parseInt(rs.getString(2));
                            int kidLearningID = Integer.parseInt(rs.getString(3));
                            float ammount = Float.parseFloat(rs.getString(4));

                            String date = rs.getString(5);
                            String status = rs.getString(6);
                            String parentID = rs.getString(8);
                            String kidID = rs.getString(10);
                            String courseID = rs.getString(11);

                            payment payment = new payment(paymentID, parentID);
                            kidlearning kidlearning = new kidlearning(kidLearningID, kidID, courseID);
                            detail_payment detail = new detail_payment(detailID, paymentID, kidLearningID, ammount, date, status, payment, kidlearning);

                            detailList.add(detail);

                     }
              } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
              }
              return detailList;
       }

       public ArrayList<detail_payment> getAllPaymentbyParentID(String parentID) {
              ArrayList<detail_payment> detail = new ArrayList<>();
              for (detail_payment dp : detailList) {
                     if (dp.getPayment().getParentID().equals(parentID)) {
                            detail.add(dp);
                     }
              }
              return detail;
       }

       public static void main(String[] args) {
              PaymentDAO pdao = new PaymentDAO();
             ArrayList<detail_payment> d = pdao.getAllPayment();
              ArrayList<detail_payment> pay = pdao.getAllPaymentbyParentID("Panguyen12");
              for (detail_payment object : d) {
                     System.out.println(object);
              }
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
                     PreparedStatement ps1 = conn.prepareStatement(query2);
                     rs = ps1.executeQuery();
                     while (rs.next()) {
                            payment = new payment(Integer.parseInt(rs.getString(1)), rs.getString(2));
                     }
              } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
              }
              return payment;
       }

       public void AddDetailPayment(int paymentID, String courseID, float amountCourse, String datePayment, String status) {
              String query = "INSERT INTO dbo.DetailPayment(detailpaymentID,paymentID,kidlearningID,amountCourse,datePayment,status) \n"
                      + " VALUES (?,?,?,?,?,?)";
              int number1 = GetNextDetailPaymentId();
              int number2 = GetLastKidLearningId();
              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     ps.setInt(1, number1);
                     ps.setInt(2, paymentID);
                     ps.setInt(3, number2);
                     ps.setFloat(4, amountCourse);
                     ps.setString(5, datePayment);
                     ps.setString(6, status);
                     ps.executeUpdate();
              } catch (ClassNotFoundException | SQLException e) {
              }
       }

       private int GetNextDetailPaymentId() {

              String query = "SELECT MAX(detailpaymentID) + 1 AS next_id FROM DetailPayment";
              return GetNextId(query);
       }

       public int GetNextId(String query) {
              int nextId = 0;
              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     rs = ps.executeQuery();
                     while (rs.next()) {
                            nextId = rs.getInt("next_id");
                     }
              } catch (ClassNotFoundException | SQLException e) {
              }

              return nextId;
       }

       public int GetLastKidLearningId() {
              int nextId = 0;
              String query = "SELECT MAX(kidlearningID) AS next_id FROM KidLearning";
              try {
                     conn = DBContext.getConnection();
                     ps = conn.prepareStatement(query);
                     rs = ps.executeQuery();
                     while (rs.next()) {
                            nextId = rs.getInt("next_id");
                     }
              } catch (ClassNotFoundException | SQLException e) {
              }

              return nextId;
       }

}
