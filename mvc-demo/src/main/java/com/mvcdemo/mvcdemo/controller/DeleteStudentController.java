package com.mvcdemo.mvcdemo.controller;

import com.mvcdemo.mvcdemo.service.StudentService;
import com.mvcdemo.mvcdemo.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteStudent")
public class DeleteStudentController extends HttpServlet {

    private final StudentService studentService;

    public DeleteStudentController() throws SQLException, ClassNotFoundException {
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        boolean result = false;
        try {
            result = studentService.removeStudentById(sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result){
            req.setAttribute("msg", "删除成功。");
        } else {
            req.setAttribute("msg", "删除失败。");
        }
        req.getRequestDispatcher("listAll").forward(req, resp);
    }
}
