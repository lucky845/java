package com.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lichuang
 * @create 2021-08-19 18:05
 * @project_name javaWEB
 */
public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter2前置代码 ");
        System.out.println("filter2线程 " + Thread.currentThread().getName());
        System.out.println("filter2:  " + servletRequest.getParameter("username"));
        System.out.println("filter2取的filter1的数据:  " + servletRequest.getAttribute("key1"));
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter2线程   " + Thread.currentThread().getName());
        System.out.println("Filter2后置代码");
    }

    @Override
    public void destroy() {

    }
}
