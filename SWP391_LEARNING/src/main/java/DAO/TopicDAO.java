package DAO;

import DBcontext.DBContext;
import Entity.course;
import Entity.topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TopicDAO {


    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ArrayList<topic> topics = new ArrayList<>();

    public TopicDAO() {
        topics.clear();
    }

    public ArrayList<topic> GetAllTopics()
    {
        String query = "SELECT * FROM TOPIC";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                topics.add(new topic(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return topics;
    }

    public void AddTopic(topic topic)         throws SQLException {
        String query = "INSERT INTO TOPIC (topicID, courseID, topicName, topicImage) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, topic.getTopicID());
            ps.setString(2, topic.getCourseID());
            ps.setString(3, topic.getTopicName());
            ps.setString(4, topic.getTopicImage());

            ps.executeUpdate();

        } catch (SQLException throwables) {
            String customMessage = "Topic existed";
            SQLException customException = new SQLException(customMessage);
            customException.printStackTrace();
            throw new SQLException(customException);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void updateTopic(topic updatedTopic) {
        String checkQuery = "SELECT COUNT(*) FROM TOPIC WHERE topicID = ?";
            String updateQuery = "UPDATE TOPIC SET courseID = ?, topicName = ?, topicImage = ? WHERE topicID = ?";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement checkPs = conn.prepareStatement(checkQuery);
             PreparedStatement updatePs = conn.prepareStatement(updateQuery)) {

            checkPs.setInt(1, updatedTopic.getTopicID());
            ResultSet resultSet = checkPs.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count == 0) {
                System.out.println("Topic does not exist.");
                return; // or throw an exception if desired
            }

            updatePs.setString(1, updatedTopic.getCourseID());
            updatePs.setString(2, updatedTopic.getTopicName());
            updatePs.setString(3, updatedTopic.getTopicImage());
            updatePs.setInt(4, updatedTopic.getTopicID());

            updatePs.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteTopic(int topicId) {
        String checkQuery = "SELECT COUNT(*) FROM TOPIC WHERE topicID = ?";
        String deleteQuery = "DELETE FROM TOPIC WHERE topicID = ?";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement checkPs = conn.prepareStatement(checkQuery);
             PreparedStatement deletePs = conn.prepareStatement(deleteQuery)) {

            checkPs.setInt(1, topicId);
            ResultSet resultSet = checkPs.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count == 0) {
                System.out.println("Topic does not exist.");
                return; // or throw an exception if desired
            }

            deletePs.setInt(1, topicId);
            deletePs.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
