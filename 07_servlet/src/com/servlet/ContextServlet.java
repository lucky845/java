package com.servlet; /**
 * @author lichuang
 * @description ${description}
 * @create 2021-08-13 19:21
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1、获取 web.xml 中配置的上下文参数 context-param
        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        System.out.println("context-param参数username的值是：" + username);
        System.out.println("context-param参数password的值是：" + context.getInitParameter("password"));
//        System.out.println("init-param参数url的值是：" + context.getInitParameter("url")); // 获取不了

//        2、获取当前的工程路径，格式: /工程路径
        System.out.println("当前工程路径" + context.getContextPath());

//        3、获取工程部署后在服务器硬盘上的绝对路径
        /**
         *  / 被服务器解析地址为： http://ip:port/工程名/  <br/>
         */
        System.out.println("获取工程部署后在服务器硬盘上的绝对路径" + context.getRealPath("/"));
        System.out.println("获取工程下的css目录部署后在服务器硬盘上的绝对路径" + context.getRealPath("/css"));
        System.out.println("获取工程下的imgs目录下的1.jpg部署后在服务器硬盘上的绝对路径" + context.getRealPath("/imgs/1.jpg"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
