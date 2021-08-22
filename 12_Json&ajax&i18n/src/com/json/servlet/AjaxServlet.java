package com.json.servlet;

import com.google.gson.Gson;
import com.json.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lichuang
 * @create 2021-08-21 16:05
 * @project_name javaWEB
 */
public class AjaxServlet extends BaseServlet{

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ajax请求过来了");

        Person person = new Person(1,"小明");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // json格式的字符串
        Gson gson = new Gson();
        String PersonJsonString = gson.toJson(person);
        resp.getWriter().write(PersonJsonString);
    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryAjax请求过来了");
        Person person = new Person(1,"小明");
        // json格式的字符串
        Gson gson = new Gson();
        String PersonJsonString = gson.toJson(person);
        resp.getWriter().write(PersonJsonString);
    }

    protected void jQueryGET(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryGET请求过来了");
        Person person = new Person(1,"小明");
        // json格式的字符串
        Gson gson = new Gson();
        String PersonJsonString = gson.toJson(person);
        resp.getWriter().write(PersonJsonString);
    }

    protected void jQueryPOST(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryPOST请求过来了");
        Person person = new Person(1,"小明");
        // json格式的字符串
        Gson gson = new Gson();
        String PersonJsonString = gson.toJson(person);
        resp.getWriter().write(PersonJsonString);
    }

    protected void jQuerygetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerygetJSON请求过来了");
        Person person = new Person(1,"小明");
        // json格式的字符串
        Gson gson = new Gson();
        String PersonJsonString = gson.toJson(person);
        resp.getWriter().write(PersonJsonString);
    }
    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuerySerialize请求过来了");

        System.out.println("用户名" + req.getParameter("username"));
        System.out.println("密码" + req.getParameter("password"));

        Person person = new Person(1,"小明");
        // json格式的字符串
        Gson gson = new Gson();
        String PersonJsonString = gson.toJson(person);
        resp.getWriter().write(PersonJsonString);
    }
}
