package com.example.servletdemo;

import java.sql.*;

public class PrepareStatementTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. Load derby JDBC driver
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        // 2.Create database connection and sql string
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mydatabase;create=true","app","app");
        String sqlString = "select * from accounts where username=? and password=?";
        // 3.Create prepared statement
        PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
        String username = "10001";
        String password = "' or '1'='1";
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.println("Verified");
        } else {
            System.out.println("Invalid");
        }
        preparedStatement.close();
        connection.close();
    }
}
