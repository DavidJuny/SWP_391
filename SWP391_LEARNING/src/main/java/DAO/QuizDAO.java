package DAO;

import DBcontext.DBContext;
import Entity.*;
import Model.QuizResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class QuizDAO {

       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       ArrayList<question> questions = new ArrayList<>();

       public QuizDAO() {
              questions.clear();
       }

       public ArrayList<question> GetListQuestionFromLessonItem(int LessonItemId) {
              ArrayList<question> questions = new ArrayList<>();
              String query = "SELECT * FROM [Question] WHERE lessonItemID = ? ";
              try (Connection conn = DBContext.getConnection();
                      PreparedStatement ps = conn.prepareStatement(query)) {
                     ps.setInt(1, LessonItemId); // Set the LessonItemId parameter
                     try (ResultSet rs = ps.executeQuery()) {
                            while (rs.next()) {
                                   questions.add(new question(
                                           rs.getInt(1),
                                           rs.getInt(2),
                                           rs.getString(3),
                                           rs.getString(4)
                                   ));
                            }
                     }
              } catch (SQLException throwables) {
                     throwables.printStackTrace();
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }
              return questions;
       }

       public lesson getLessonByLessonItemID(int lessonItemID) {
              lesson lesson = null;

              String query = "SELECT * FROM LessonItem WHERE lessonItemID=?";
              try (Connection conn = DBContext.getConnection();
                      PreparedStatement ps = conn.prepareStatement(query)) {
                     ps.setInt(1, lessonItemID);
                     try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                   int lessonID = rs.getInt("lessonID");
                                   lesson = getLessonByLessonID(lessonID);
                            }
                     }
              } catch (SQLException throwables) {
                     throwables.printStackTrace();
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }

              return lesson;
       }

       public QuizResult GetAnswerFromQuestion(ArrayList<Integer> questionIds, HashMap<Integer, String> submittedAnswers) {
              String answer = "";
              HashMap<String, String> QuestionAndAnswer = new HashMap<>();
              String questionIdsStr = String.join(",", questionIds.stream().map(String::valueOf).collect(Collectors.toList()));
              String query = "SELECT * FROM Question WHERE questionID IN (" + questionIdsStr + ")";
              try (Connection conn = DBContext.getConnection();
                      PreparedStatement ps = conn.prepareStatement(query);
                      ResultSet rs = ps.executeQuery()) {
                     while (rs.next()) {
                            int questionID = rs.getInt("questionID");
                            int typeID = rs.getInt("lessonItemID");
                            String questionText = rs.getString("question");
                            String answer1 = rs.getString("answer");
                            String[] sentences = answer1.split(",");

                            if (sentences.length > 0) {
                                   // Trim leading and trailing spaces from the first sentence
                                   answer = sentences[0].trim();
                            } else {
                                   answer = "";
                            }

                            questions.add(new question(questionID, typeID, questionText, answer));
                     }
              } catch (SQLException | ClassNotFoundException e) {
                     e.printStackTrace();
              }
              int totalPoints = 0;
              HashMap<Integer, String> incorrectAnswers = new HashMap<>();

              for (question question : questions) {
                     int questionId = question.getQuestionID();
                     String submittedAnswer = submittedAnswers.getOrDefault(questionId, "").trim();
                     String correctAnswer = question.getAnswer().trim();

                     if (submittedAnswer.equals(correctAnswer)) {
                            totalPoints++;
                     } else {
                            incorrectAnswers.put(questionId, submittedAnswer);
                     }
              }

              return new QuizResult(totalPoints, incorrectAnswers);

       }

       public lesson getLessonByLessonID(int lessonID) {
              lesson lesson1 = null;

              String query = "SELECT * FROM Lesson WHERE lessonID=?";
              try (Connection conn = DBContext.getConnection();
                      PreparedStatement ps = conn.prepareStatement(query)) {
                     ps.setInt(1, lessonID);
                     try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                   int topicID = rs.getInt("topicID");
                                   String lessonName = rs.getString("lessonName");
                                   lesson1 = new lesson(lessonID, topicID, lessonName);
                            }
                     }
              } catch (SQLException throwables) {
                     throwables.printStackTrace();
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }

              return lesson1;
       }

       public lessonItem getLessonItemByLessonItemId(int lessonItemId) {
              lessonItem lessonItem = null;
              String query = "SELECT * FROM LessonItem WHERE lessonItemID = ?";

              try (Connection conn = DBContext.getConnection();
                      PreparedStatement ps = conn.prepareStatement(query)) {

                     ps.setInt(1, lessonItemId);

                     try (ResultSet rs = ps.executeQuery()) {
                            if (rs.next()) {
                                   int lessonItemID = rs.getInt("lessonItemID");
                                   int lessonID = rs.getInt("lessonID");
                                   String itemTypeID = rs.getString("itemTypeID");
                                   String content = rs.getString("content");

                                   lessonItem = new lessonItem(lessonItemID, lessonID, itemTypeID, content);
                            }
                     }
              } catch (SQLException | ClassNotFoundException e) {
                     e.printStackTrace();
              }

              return lessonItem;
       }

}
