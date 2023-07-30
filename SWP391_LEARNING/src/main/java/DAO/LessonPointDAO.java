package DAO;

import DBcontext.DBContext;
import Entity.lessonpoint;
import Model.lessonpointModel;
import com.google.type.DateTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class LessonPointDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void AddLessonPointByKidId(String KidId, int lessonId, float Point, Date DateTaken) throws SQLException {
        String queryInsert = "INSERT INTO LessonPoint(kidID, LessonItemId, Point, DateTaken) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement psInsert = conn.prepareStatement(queryInsert)) {

            // LessonPoint does not exist, perform the insert
            psInsert.setString(1, KidId);
            psInsert.setInt(2, lessonId);
            psInsert.setFloat(3, Point);
            psInsert.setDate(4, new java.sql.Date(DateTaken.getTime()));
            psInsert.executeUpdate();

        } catch (SQLException throwables) {
            String customMessage = "Failed to insert LessonPoint";
            SQLException customException = new SQLException(customMessage);
            customException.printStackTrace();
            throw new SQLException(customException);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<lessonpointModel> GetAllPointFromKidId(String kidId)
    {
        String query="SELECT LessonPoint.LessonPointId, LessonPoint.KidId, LessonPoint.LessonItemId, LessonPoint.Point,lessonPoint.DateTaken, Kids.kidName,Kids.parentID" +
                "FROM LessonPoint" +
                "JOIN Kids ON LessonPoint.KidId = Kids.KidId WHERE Kids.kidID=?";
        ArrayList<lessonpointModel> list = new ArrayList<>();
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, kidId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int lessonPointId= rs.getInt(1);
                String KidId= rs.getString(2);
                int lessonId= rs.getInt(3);
                float point = rs.getFloat(4);
                Date datetaken = rs.getDate(5);
                String KidName = rs.getString(6);
                String ParentId = rs.getString(7);


                lessonpointModel lessonpointModel = new lessonpointModel(lessonPointId,KidId,lessonId,point,datetaken,KidName,ParentId);
                list.add(lessonpointModel);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }

        return list;
    }
    
       public ArrayList<lessonpoint> GetPointFromKidId(String kidId){
        String query= "SELECT * FROM LessonPoint WHERE kidID = ?";
        ArrayList<lessonpoint> list = new ArrayList<>();
        try {
            conn = DBContext.getConnection(); // mo ket noi sql
            ps = conn.prepareStatement(query); // quang cau lenh vao sql
            ps.setString(1, kidId);
            rs = ps.executeQuery(); // Tra ve ket qua
            while(rs.next()){
                 int LessonPointId= rs.getInt(1);
                 kidId = rs.getString(2);
                 int LessonItemId = rs.getInt(3);
                 float Point = rs.getFloat(4);
                 lessonpoint lp = new lessonpoint(LessonPointId, kidId, LessonItemId, Point);
                 list.add(lp);
            }
            
        } catch (ClassNotFoundException | SQLException  e) {
        }
        return list;
    }
    
}
