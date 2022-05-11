package com.mvcdemo.mvcdemo.dao;

import com.mvcdemo.mvcdemo.entity.Page;
import com.mvcdemo.mvcdemo.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    List<Student> getAll() throws SQLException;
    Student getById(int id) throws SQLException;
    Student getBySname(String Sname) throws SQLException;
    boolean add(Student s) throws SQLException;
    boolean delete(Student s) throws SQLException;
    boolean deleteById(int id) throws SQLException;
    boolean deleteByName(String Sname) throws SQLException;
    boolean update(Student s) throws SQLException;
    Page<Student> getByPage(int currentPage, int pageSize) throws SQLException;
}
