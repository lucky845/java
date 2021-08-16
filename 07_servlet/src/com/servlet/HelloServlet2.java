package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lichuang
 * @description
 * @create 2021-08-13 16:29
 */
public class HelloServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("重写了init初始化方法,做了一些工作!");
    }

    /**
     * @Author lichuang
     * @Description 在get请求用
     * @Date 2021/8/13 16:31
     * @param req
     * @param resp
     * @return void
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doGet方法");

        // 也可以使用ServletConfig
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);


        //        2、获取初始化参数 init-param
        System.out.println("初始化参数username的值是：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是：" + servletConfig.getInitParameter("url"));

    }
    /**
     * @Author lichuang
     * @Description 在post请求使用
     * @Date 2021/8/13 16:32
     * @param req
     * @param resp
     * @return void
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2的doPost方法");
    }
}
