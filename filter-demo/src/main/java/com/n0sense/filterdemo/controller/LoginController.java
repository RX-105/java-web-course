package com.n0sense.filterdemo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现登录功能的servlet。
 * @author zgy
 * @since 2022/05/11
 */
@WebServlet(urlPatterns = "/login", name = "login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置代码页为utf-8，方便获取中文输入
        req.setCharacterEncoding("utf-8");
        // 获取请求包含的属性
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 判断用户名和密码不能为空
        if ("".equals(username) && "".equals(password)) {
            resp.sendRedirect("login.jsp");
        } else {
            // 向session中写入用户名信息
            req.getSession().setAttribute("username", username);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
