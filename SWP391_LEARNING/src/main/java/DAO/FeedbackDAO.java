/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBcontext.DBContext;
import Entity.accountUser;
import Entity.feedback;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class FeedbackDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<feedback> getAllFeedback() {
        ArrayList<feedback> list = new ArrayList<>();
        String query = "SELECT f.*, a.* FROM Feedback f\n"
                + "JOIN AccountUser a ON f.accountFeedback = a.account";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int FeedbackID = Integer.parseInt(rs.getString(1));
                String adminID = rs.getString(2);
                String accountFeedback = rs.getString(3);
                String content = rs.getString(4);
                String answer = rs.getString(5);
                String roleID = rs.getString(7);
                list.add(new feedback(FeedbackID, content, adminID, answer, new accountUser(accountFeedback, roleID)));
            }
        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
        }
        return list;
    }

    public void answerFeedback(String answer, String feedbackID) throws SQLException, ClassNotFoundException {
        String query = "UPDATE Feedback\n"
                + "SET answer = ?\n"
                + "WHERE feedbackID = ?";
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, answer);
            ps.setString(2, feedbackID);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
        }

    }
}
