package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lichuang
 * @create 2021-08-19 16:11
 * @project_name javaWEB
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if("abc123".equals(username) && "123456".equals(password)){
            req.getSession().setAttribute("user",username);
            resp.getWriter().write("登陆成功");
        }else{
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
