package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
/**
 * @author lichuang
 * @description
 * @create 2021-08-13 16:47
 */
public class HelloServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet3的doGet方法");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet3的doPost方法");
    }
}
