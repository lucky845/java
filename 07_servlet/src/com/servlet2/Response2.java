package com.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lichuang
 * @description
 * @create 2021-08-14 13:55
 */
public class Response2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 不共享Request域中的数据
//        System.out.println(req.getAttribute("key"));

        resp.getWriter().write("response2: response1!");
    }
}
