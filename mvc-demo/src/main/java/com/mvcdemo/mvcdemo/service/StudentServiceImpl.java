package com.mvcdemo.mvcdemo.service;

import com.mvcdemo.mvcdemo.dao.StudentDao;
import com.mvcdemo.mvcdemo.daoImpl.StudentDaoImpl;
import com.mvcdemo.mvcdemo.entity.Page;
import com.mvcdemo.mvcdemo.entity.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentDao studentDao;

    public StudentServiceImpl() throws SQLException, ClassNotFoundException {
        studentDao = new StudentDaoImpl();
    }

    @Override
    public boolean addStudent(Student s) throws SQLException {
        return studentDao.add(s);
    }

    @Override
    public boolean removeStudentByName(String name) throws SQLException {
        return studentDao.deleteByName(name);
    }

    @Override
    public boolean removeStudentById(int id) throws SQLException {
        return studentDao.deleteById(id);
    }

    @Override
    public boolean updateStudent(Student s) throws SQLException {
        return studentDao.update(s);
    }

    @Override
    public Student getStudentByName(String name) throws SQLException {
        return studentDao.getBySname(name);
    }

    @Override
    public Student getStudentById(int id) throws SQLException {
        return studentDao.getById(id);
    }

    @Override
    public List<Student> getAllStudent() throws SQLException {
        return studentDao.getAll();
    }

    @Override
    public Page<Student> getByPage(int currentPage, int pageSize) throws SQLException {
        return studentDao.getByPage(currentPage, pageSize);
    }
}
