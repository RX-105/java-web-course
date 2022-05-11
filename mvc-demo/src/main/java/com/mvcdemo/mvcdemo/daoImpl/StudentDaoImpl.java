package com.mvcdemo.mvcdemo.daoImpl;

import com.mvcdemo.mvcdemo.dao.StudentDao;
import com.mvcdemo.mvcdemo.entity.Page;
import com.mvcdemo.mvcdemo.entity.Student;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private final Connection connection;
    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public StudentDaoImpl() throws SQLException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("MYSQL123");
        connection = dataSource.getConnection();
    }

    @Override
    public List<Student> getAll() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        sql = "select * from student";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            studentList.add(
                    new Student(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(4),
                            resultSet.getInt(3),
                            resultSet.getInt(5))
            );
        }
        preparedStatement.close();
        resultSet.close();
        return studentList;
    }

    private Student getStudent(ResultSet resultSet) throws SQLException {
        Student student = null;
        if (resultSet.next()) {
            student = new Student(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(4),
                    resultSet.getInt(3),
                    resultSet.getInt(5)
            );
        }
        preparedStatement.close();
        resultSet.close();
        return student;
    }

    @Override
    public Student getById(int id) throws SQLException {
        sql = "select * from student where sid=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        return getStudent(resultSet);
    }

    @Override
    public Student getBySname(String Sname) throws SQLException {
        sql = "select * from student where sid=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, Sname);
        ResultSet resultSet = preparedStatement.executeQuery();
        return getStudent(resultSet);
    }

    @Override
    public boolean add(Student s) throws SQLException {
        sql = "insert into student(sname,sage,major,status) values (?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, s.getSname());
        preparedStatement.setInt(2, s.getSage());
        preparedStatement.setString(3, s.getMajor());
        preparedStatement.setInt(4, s.getStatus());
        int result = preparedStatement.executeUpdate();
        return result > 0;
    }

    @Override
    public boolean delete(Student s) throws SQLException {
        sql = "delete from student where sid=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, s.getSid());
        int result = preparedStatement.executeUpdate();
        preparedStatement.close();
        return result > 0;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        sql = "delete from student where sid=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int result = preparedStatement.executeUpdate();
        preparedStatement.close();
        return result > 0;
    }

    @Override
    public boolean deleteByName(String Sname) throws SQLException {
        sql = "delete from student where sname=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, Sname);
        int result = preparedStatement.executeUpdate();
        return result > 0;
    }

    @Override
    public boolean update(Student s) throws SQLException {
        sql = "update student set sname=?,sage=?,major=?,status=? where sid=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, s.getSname());
        preparedStatement.setInt(2, s.getSage());
        preparedStatement.setString(3, s.getMajor());
        preparedStatement.setInt(4, s.getStatus());
        preparedStatement.setInt(5, s.getSid());
        int result = preparedStatement.executeUpdate();
        preparedStatement.close();
        return result > 0;
    }

    @Override
    public Page<Student> getByPage(int currentPage, int pageSize) throws SQLException {
        sql = "select count(*) from student";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int recordCount = resultSet.getInt(1);
        int pageCount = 0;
        if (recordCount % pageSize == 0) {
            pageCount = recordCount / pageSize;
        } else {
            pageCount = recordCount / pageSize + 1;
        }
        sql = "select * from student limit ?,?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, (currentPage - 1) * pageSize);
        preparedStatement.setInt(2, pageSize);
        resultSet = preparedStatement.executeQuery();
        List<Student> studentList = new ArrayList<>();
        while (resultSet.next()) {
            studentList.add(
                    new Student(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(4),
                            resultSet.getInt(3),
                            resultSet.getInt(5))
            );
        }
        resultSet.close();
        preparedStatement.close();
        return new Page<Student>(pageCount, recordCount, currentPage, pageSize, studentList);
    }
}
