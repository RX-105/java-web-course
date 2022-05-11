package com.example.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/cookie")
public class CookieDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        Cookie nameCookie = new Cookie("username",username);
        Cookie pwCookie = new Cookie("password",password);
        if ("on".equals(remember)){
            nameCookie.setMaxAge(24*60*60*7);
            pwCookie.setMaxAge(24*60*60*7);
        } else {
            nameCookie.setMaxAge(-1);
            pwCookie.setMaxAge(-1);
        }
        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        req.getRequestDispatcher("./demo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
