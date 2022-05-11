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

@WebServlet("/update")
public class UpdateStudentController extends HttpServlet {

    private final StudentService studentService;

    public UpdateStudentController() throws SQLException, ClassNotFoundException {
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        try {
            req.setAttribute("student", studentService.getStudentById(sid));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("./WEB-INF/jsp/updateStudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int sid = Integer.parseInt(req.getParameter("sid"));
        String sname = req.getParameter("sname");
        int sage = Integer.parseInt(req.getParameter("sage"));
        String major = req.getParameter("major");
        int status = Integer.parseInt(req.getParameter("status"));
        Student student = new Student(sid, sname, major, sage, status);
        Page<Student> studentPage = new Page<>();
        try {
            studentService.updateStudent(student);
            studentPage = studentService.getByPage(1, 5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("page", studentPage);
        req.getRequestDispatcher("./WEB-INF/jsp/listAllStudent.jsp").forward(req, resp);
    }
}
