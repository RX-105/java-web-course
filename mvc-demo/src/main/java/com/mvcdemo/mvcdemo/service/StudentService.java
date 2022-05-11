package com.mvcdemo.mvcdemo.service;

import com.mvcdemo.mvcdemo.entity.Page;
import com.mvcdemo.mvcdemo.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    boolean addStudent(Student s) throws SQLException;
    boolean removeStudentByName(String name) throws SQLException;
    boolean removeStudentById(int id) throws SQLException;
    boolean updateStudent(Student s) throws SQLException;
    Student getStudentByName(String name) throws SQLException;
    Student getStudentById(int id) throws SQLException;
    List<Student> getAllStudent() throws SQLException;
    Page<Student> getByPage(int currentPage, int pageSize) throws SQLException;
}
