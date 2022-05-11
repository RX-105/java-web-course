package com.example.servletdemo.jstl;

import com.example.servletdemo.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/jstl")
public class Example1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("username", req.getParameter("username"));
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1001,"test1","SE",20,1));
        studentList.add(new Student(1002,"test2","SE",20,1));
        studentList.add(new Student(1003,"test3","SE",20,1));
        req.setAttribute("studentList", studentList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
