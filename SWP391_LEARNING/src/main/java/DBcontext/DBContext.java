/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBcontext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

       private static final String USERNAME = "JunyD_SQLLogin_1";
       private static final String PASSWORD = "qo7jp3p364";
       private static final String SERVERNAME = "jdbc:sqlserver://LearningEnglish.mssql.somee.com;databaseName=LearningEnglish";

       public static Connection getConnection() throws SQLException, ClassNotFoundException {
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
              Connection conn;
              conn = DriverManager.getConnection(SERVERNAME, USERNAME, PASSWORD);
              return conn;
       }

       public static void main(String[] args) throws SQLException, ClassNotFoundException {
              try (Connection conn = getConnection()) {
                     if (conn == null) {
                            System.out.println("Fail");
                     } else {
                            System.out.println("Success");
                     }
              }
       }
}
