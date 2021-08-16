package com.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lichuang
 * @create 2021-08-13 14:13
 */
public class HelloServlet implements Servlet {


    public HelloServlet() {
        System.out.println("1.构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.init初始化方法");

//        1、可以获取 Servlet 程序的别名 servlet-name 的值
        System.out.println("helloServlet程序的别名是：" + servletConfig.getServletName());

//        2、获取初始化参数 init-param
        System.out.println("初始化参数username的值是：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是：" + servletConfig.getInitParameter("url"));

//        3、获取 ServletContext 对象
        System.out.println(servletConfig.getServletContext());

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * server方法是专门用来处理请求和响应的
     * @Author lichuang
     * @Date 2021/8/13 14:37
     * @param servletRequest
     * @param servletResponse
     * @return void
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3.server方法======hello,servlet被访问了！");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String method = httpServletRequest.getMethod();

//        System.out.println(method);

//        if("GET".equals(method)){
//            System.out.println("get请求");
//            System.out.println("get请求");
//            System.out.println("get请求");
//        }else if("POST".equals(method)){
//            System.out.println("post请求");
//            System.out.println("post请求");
//            System.out.println("post请求");
//            System.out.println("post请求");
//        }

        if("GET".equals(method)){
            doGet();
        }else if("POST".equals(method)){
            doPost();
        }
    }

    /**
     * 做get请求操作
     * @Author lichuang
     * @Date 2021/8/13 16:22
     * @param
     * @return void
     */
    public void doGet(){
        System.out.println("get请求");
        System.out.println("get请求");
        System.out.println("get请求");
        System.out.println("get请求");
    }

    /**
     * 做post请求操作
     * @Author lichuang
     * @Date 2021/8/13 16:22
     * @param
     * @return void
     */
    public void doPost(){
        System.out.println("post请求");
        System.out.println("post请求");
        System.out.println("post请求");
        System.out.println("post请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.destroy销毁方法");
    }
}
