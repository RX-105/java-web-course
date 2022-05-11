package com.n0sense.filterdemo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 一个过滤器类。
 * 其功能为过滤所有路由，判断是否存在登录信息，或者前往登录界面。
 * 如果不匹配，则跳转到登陆界面。
 * @author zgy
 * @since 2022/05/11
 */
// 使用通配符匹配所有的路由
@WebFilter(urlPatterns = "/*", filterName = "MyFilter")
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        // 需要显式转换到HttpServletRequest
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 从session中读取用户字段，如果不存在的话，将会得到空对象，用于后面if条件判断
        Object user = httpServletRequest.getSession().getAttribute("username");
        // 如果session中存在用户字段，或者请求路径上包含排除的字符串，则放行
        if (user != null || httpServletRequest.getRequestURL().toString().contains("login")) {
            // 放行也就是执行过滤器链后续内容，比如执行后续的过滤器，或者执行路由匹配的servlet
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 不放行的情况下，需要给请求写入一个信息属性显示到页面上
            // 并把请求转发到登陆页面上
            httpServletRequest.setCharacterEncoding("utf-8");
            httpServletRequest.setAttribute("msg", "You're not logged in.");
            httpServletRequest.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
        }
    }
}
