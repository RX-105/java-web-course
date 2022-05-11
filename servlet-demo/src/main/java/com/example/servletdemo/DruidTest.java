package com.example.servletdemo;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.*;

public class DruidTest {
    public static void main(String[] args) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        dataSource.setUrl("jdbc:derby://localhost:1527/mydatabase;create=true");
        dataSource.setUsername("app");
        dataSource.setPassword("app");

        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        String username = "10001";
        String sqlString = "delete from accounts where username=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
        preparedStatement.setString(1, username);
        int result = preparedStatement.executeUpdate();
        System.out.println("Result is "+result);

        connection.commit();

        preparedStatement.close();
        connection.close();
    }
}
