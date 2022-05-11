package com.mvcdemo.mvcdemo.controller;

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

@WebServlet("/addStudent")
public class AddStudentController extends HttpServlet {

    private final StudentService studentService;

    public AddStudentController() throws SQLException, ClassNotFoundException {
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("msg", "");
        req.getRequestDispatcher("./WEB-INF/jsp/addForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String sname = req.getParameter("sname");
        int sage = Integer.parseInt(req.getParameter("sage"));
        String major = req.getParameter("major");
        int status = Integer.parseInt(req.getParameter("status"));
        Student student = new Student(0,sname,major,sage,status);
        System.out.println(student.toString());
        boolean result = false;
        try {
            result = studentService.addStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result){
            resp.sendRedirect("listAll");
        } else {
            req.setAttribute("msg", "出错了，请检查你的输入。");
            req.getRequestDispatcher("./WEB-INF/jsp/listAllStudent.jsp");
        }
    }
}
