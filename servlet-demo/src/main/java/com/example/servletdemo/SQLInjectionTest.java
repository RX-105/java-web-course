package com.example.servletdemo;

import java.sql.*;

public class SQLInjectionTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. Load derby JDBC driver
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        // 2.Create database connection and statement
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mydatabase;create=true","app","app");
        Statement statement = connection.createStatement();
        // 3.Set username and injected password
        String username = "10001";
        String password = "' or '1'='1";
        // 4.Build an injected SQL command
        String sql = "select * from accounts where username='"+username+"' and password='"+password+"'";
        // 5.Execute
        ResultSet result = statement.executeQuery(sql);
        // 6.Check
        if(result.next()){
            System.out.println("Verified");
        } else {
            System.out.println("Incorrect");
        }
    }
}
