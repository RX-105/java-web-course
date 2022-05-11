package com.n0sense.filterdemo.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器链上的第一个过滤器。
 * @author zgy
 * @since 2022/05/11
 */
public class FilterChain1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter #1");
        // 需要继续执行过滤器链，后面的过滤器才能继续执行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
