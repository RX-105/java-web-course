package com.mvcdemo.mvcdemo.controller;

import com.mvcdemo.mvcdemo.entity.Page;
import com.mvcdemo.mvcdemo.entity.Student;
import com.mvcdemo.mvcdemo.service.StudentService;
import com.mvcdemo.mvcdemo.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/listAll")
public class ListAllController extends HttpServlet {

    private final StudentService studentService;

    public ListAllController() throws SQLException, ClassNotFoundException {
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Page<Student> studentPage = new Page<>();
        try {
            studentPage = studentService.getByPage(1, 5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("page", studentPage);
        req.getRequestDispatcher("./WEB-INF/jsp/listAllStudent.jsp").forward(req, resp);
    }
}
