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

@WebServlet("/getByPage")
public class PagingController extends HttpServlet {

    private final StudentService studentService;

    public PagingController() throws SQLException, ClassNotFoundException {
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String pageStr = req.getParameter("page");
        int page = 1;
        Page<Student> studentPage = new Page<>();
        if (!"".equals(pageStr)) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        try {
            studentPage = studentService.getByPage(page, 5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("page", studentPage);
        req.getRequestDispatcher("./WEB-INF/jsp/listAllStudent.jsp").forward(req, resp);
    }
}
