package com.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lichuang
 * @description
 * @create 2021-08-14 13:52
 */
public class Response1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("到此一游 Response1");

//        req.setAttribute("key","value");

        // 设置响应状态码302，表示重定向（已搬迁）
        resp.setStatus(302);

        // 请求重定向方式一：设置响应头，说明 新的地址在哪里
//        resp.setHeader("Location","http://localhost:8080/07_servlet/response2");
        // 不能访问WEB-INF下的资源
//        resp.setHeader("Location","http://localhost:8080/07_servlet/WEB-INF/form.html");
        // 可以访问工程外的资源
//        resp.setHeader("Location","http://www.baidu.com");

        // 请求重定向方式二（推荐使用）：
        resp.sendRedirect("http://localhost:8080/07_servlet/response2");
    }
}
