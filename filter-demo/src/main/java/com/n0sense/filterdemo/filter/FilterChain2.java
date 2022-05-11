package com.n0sense.filterdemo.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器链上的第二个过滤器。
 * @author zgy
 * @since 2022/05/11
 */
public class FilterChain2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter #2");
        // 这个也是哦
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
