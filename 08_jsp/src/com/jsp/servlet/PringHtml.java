package com.jsp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lichuang
 * @create 2021-08-15 10:14
 */
public class PringHtml extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过响应的回传流回传html 页面数据

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.write("<!DOCTYPE html>\r\n");
        writer.write("<html lang=\"zh_CN\">\r\n");
        writer.write("<head>\r\n");
        writer.write("<meta charset=\"UTF-8\">\r\n");
        writer.write("<title>Title</title>\r\n");
        writer.write("</head>\r\n");
        writer.write("<body>\r\n");
        writer.write(" 这是html页面数据\r\n");
        writer.write("</body>\r\n");
        writer.write("</html>\r\n");

//                <!DOCTYPE html>
//        <html lang="zh_CN">
//        <head>
//            <meta charset="UTF-8">
//            <title>Title</title>
//        </head>
//        <body>
//                        这是html页面数据
//                        </body>
//        </html>
    }
}
