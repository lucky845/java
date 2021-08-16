package com.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author lichuang
 * @description
 * @create 2021-08-14 11:10
 */
public class ParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("------------doGet------------------");

        // getParameter()  获取请求的参数
        System.out.println("用户名：" + req.getParameter("username"));
        System.out.println("密码：" + req.getParameter("password"));

        // getParameterValues()  获取请求的多个参数(返回一个数组)
        System.out.println("兴趣爱好：" + Arrays.asList(req.getParameterValues("hobby")));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求的字符集为UTF-8,从而解决乱码问题
        // 也要在获取请求参数之前调用才有效
        req.setCharacterEncoding("UTF-8");
        System.out.println("------------doPost------------------");

        // getParameter()  获取请求的参数
        System.out.println("用户名：" + req.getParameter("username"));
        System.out.println("密码：" + req.getParameter("password"));

        // getParameterValues()  获取请求的多个参数(返回一个数组)
        System.out.println("兴趣爱好：" + Arrays.asList(req.getParameterValues("hobby")));

    }
}
