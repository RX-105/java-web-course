package com.example.servletdemo;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "test",value = "/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Method:"+req.getMethod());
        System.out.println("QueryString:"+req.getQueryString());
        System.out.println("ContextPath:"+req.getContextPath());
        System.out.println("PathInfo:"+req.getPathInfo());
        System.out.println("URI:"+req.getRequestURI());
        System.out.println("URL:"+req.getRequestURL());

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String address = req.getParameter("address");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write("<h1>Username:"+username+"</h1>");
        out.write("<h1>Password:"+password+"</h1>");
        out.write("<h1>Address:"+address+"</h1>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
