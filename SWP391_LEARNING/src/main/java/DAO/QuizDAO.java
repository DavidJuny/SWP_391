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
       public boolean insertQuestionWithDuplicateCheck(int lessonItemID, String question, String answer) {
              boolean isDuplicate = false;

              try {
                     // Check if the question already exists in the table
                     String selectQuery = "SELECT COUNT(*) FROM Question WHERE question = ? AND answer = ?";
                     Connection conn = DBContext.getConnection();
                     PreparedStatement ps = conn.prepareStatement(selectQuery);
                     ps.setString(1, question);
                     ps.setString(2, answer);

                     ResultSet resultSet = ps.executeQuery();
                     if (resultSet.next()) {
                            int count = resultSet.getInt(1);
                            if (count > 0) {
                                   // The question is a duplicate
                                   isDuplicate = true;
                            }
                     }
                     resultSet.close();
                     ps.close();

                     if (!isDuplicate) {
                            // If the question is not a duplicate, insert it into the table
                            String insertQuery = "INSERT INTO Question (questionID, lessonItemID, question, answer) VALUES (?, ?, ?, ?)";
                            Connection connection = DBContext.getConnection();
                            PreparedStatement ps1 = conn.prepareStatement(insertQuery);
                            int nextQuestionID = getNextQuestionID();
                            ps1.setInt(1, nextQuestionID);
                            ps1.setInt(2, lessonItemID);
                            ps1.setString(3, question);
                            ps1.setString(4, answer);

                            int rowsAffected = ps1.executeUpdate();
                            if (rowsAffected > 0) {
                                   // The question was inserted successfully
                                   System.out.println("Question inserted successfully.");
                            }
                            ps1.close();
                     }
              } catch (SQLException | ClassNotFoundException e) {
                     e.printStackTrace();
              }

              return isDuplicate;
       }
       private int getNextQuestionID() throws SQLException, ClassNotFoundException {
              String countQuery = "SELECT COUNT(*) FROM Question";
              Connection connection = DBContext.getConnection();
              PreparedStatement countStmt = connection.prepareStatement(countQuery);
              ResultSet resultSet = countStmt.executeQuery();
              resultSet.next();
              int count = resultSet.getInt(1);
              resultSet.close();
              countStmt.close();

              // Increment the count to get the next questionID
              return count + 1;
       }
       public ArrayList<question> GetAllQuestions()
       {
              ArrayList<question> questions = new ArrayList<>();
              String query = "SELECT * FROM Question";
              try (Connection conn = DBContext.getConnection();
                   PreparedStatement ps = conn.prepareStatement(query)) {
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

       public void deleteQuestion(int questionID) {
              String checkQuery = "SELECT COUNT(*) FROM [Question] WHERE questionID = ?";
              String deleteQuery = "DELETE FROM [Question] WHERE questionID = ?";

              try (Connection conn = DBContext.getConnection();
                   PreparedStatement checkPs = conn.prepareStatement(checkQuery);
                   PreparedStatement deletePs = conn.prepareStatement(deleteQuery)) {

                     checkPs.setInt(1, questionID);
                     ResultSet resultSet = checkPs.executeQuery();
                     resultSet.next();
                     int count = resultSet.getInt(1);

                     if (count == 0) {
                            System.out.println("Question does not exist.");
                            return; // or throw an exception if desired
                     }

                     deletePs.setInt(1, questionID);
                     deletePs.executeUpdate();
              } catch (SQLException throwables) {
                     throwables.printStackTrace();
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }
       }
       public void updateQuestion(question updatedquestion) {
              String checkQuery = "SELECT COUNT(*) FROM Question WHERE questionID = ?";
              String updateQuery = "UPDATE Question SET lessonItemID = ?, question = ?, answer = ? WHERE questionID = ?";

              try (Connection conn = DBContext.getConnection();
                   PreparedStatement checkPs = conn.prepareStatement(checkQuery);
                   PreparedStatement updatePs = conn.prepareStatement(updateQuery)) {

                     checkPs.setInt(1, updatedquestion.getQuestionID());
                     ResultSet resultSet = checkPs.executeQuery();
                     resultSet.next();
                     int count = resultSet.getInt(1);

                     if (count == 0) {
                            System.out.println("Course does not exist.");
                            return; // or throw an exception if desired
                     }

                     updatePs.setInt(1, updatedquestion.getTypeID());
                     updatePs.setString(2, updatedquestion.getQuestion());
                     updatePs.setString(3, updatedquestion.getAnswer());
                     updatePs.setInt(4, updatedquestion.getQuestionID());
                     updatePs.executeUpdate();
              } catch (SQLException throwables) {
                     throwables.printStackTrace();
              } catch (ClassNotFoundException e) {
                     e.printStackTrace();
              }
       }


}
