package com.example.servletdemo;

import com.example.servletdemo.bean.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTest {
    public static void main(String[] args) throws Exception{
        // 1. Load derby JDBC driver
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        // 2.Create database connection and statement
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/mydatabase;create=true","app","app");
        Statement statement = connection.createStatement();
        // 3.Define SQL command
        String sql = "select * from student";
        // 4.Execute
        ResultSet result = statement.executeQuery(sql);
        // 5.Save results and print
        List<Student> studentList = new ArrayList<>();
        while(result.next()){
            studentList.add(new Student(result.getInt(1),result.getString("sname"),
                    result.getString("major"),result.getInt("sage"),result.getInt("status")));
        }
        System.out.println("sid\tsname\tsmajor\tsage\tstatus");
        for(var elem:studentList){
            System.out.println(elem.getSid()+"\t"+elem.getSname()+"\t"+elem.getMajor()+"\t"+elem.getSage()+
                    "\t"+elem.getStatus());
        }
        statement.close();
        connection.close();
    }
}
