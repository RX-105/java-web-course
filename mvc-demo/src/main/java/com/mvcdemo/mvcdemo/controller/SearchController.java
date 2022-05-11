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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class SearchController extends HttpServlet {

    private final StudentService studentService;

    public SearchController() throws SQLException, ClassNotFoundException {
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("./WEB-INF/jsp/search.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String sageStr = req.getParameter("sage");
        String major = req.getParameter("major");
        StringBuilder msg = new StringBuilder("");
        List<Student> originalStudentList = null, processedStudentList = new ArrayList<>();
        try {
            originalStudentList = studentService.getAllStudent();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (null != originalStudentList && !originalStudentList.isEmpty()){
            for (Student s : originalStudentList){
                if (String.valueOf(s.getSage()).contains(sageStr) && s.getMajor().contains(major)){
                    processedStudentList.add(s);
                }
            }
        }
        msg.append("当前条件：");
        if (!"".equals(sageStr)){
            msg.append("年龄=").append(sageStr).append(" ");
        }
        if (!"".equals(major)){
            msg.append("专业=").append(major).append(" ");
        }
        Page<Student> studentPage = new Page<>();
        try {
            studentPage = studentService.getByPage(1, 5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        studentPage.setEntityList(processedStudentList);
        req.setAttribute("page", studentPage);
        req.setAttribute("msg", msg);
        req.getRequestDispatcher("./WEB-INF/jsp/listAllStudent.jsp").forward(req, resp);
    }
}
