package com.filter;

import javax.servlet.*;
import java.io.IOException;


/**
 * @author lichuang
 * @create 2021-08-19 18:05
 * @project_name javaWEB
 */
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter1前置代码 ");
        System.out.println("filter1线程  " + Thread.currentThread().getName());
        System.out.println("filter1:   " + servletRequest.getParameter("username"));
        servletRequest.setAttribute("key1","value1");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter1线程  " + Thread.currentThread().getName());
        System.out.println("Filter1后置代码 ");
    }

    @Override
    public void destroy() {

    }
}
