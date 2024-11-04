package DB;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anhphuc
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/RestManDB";  
    private String jdbcUsername = "phuc";                             
    private String jdbcPassword = "123";                              

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}