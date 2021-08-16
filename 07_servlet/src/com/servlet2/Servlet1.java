package com.servlet2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lichuang
 * @description
 * @create 2021-08-14 11:44
 */
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数（办事的材料）查看
        String username = req.getParameter("username");
        System.out.println("在Servlet1（柜台1）查看参数（材料）" + username);

        // 给材料盖一个章并传递到（柜台2）去查看
        req.setAttribute("key","柜台1的章");

        // 问路：Servlet2(柜台2)怎么走
        /**
         * 请求转发必须要以斜杠打头，/ 表示地址为： http://ip:port/工程名/ ，映射到IDEA代码的web目录 <br/>
         */
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form.html");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("http://www.baidu.com"); // 无法访问

        // 走向Servlet2（柜台2）
        requestDispatcher.forward(req,resp);
    }
}
