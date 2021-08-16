package com.jsp.servlet;

import com.jsp.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lichuang
 * @create 2021-08-15 16:36
 */
public class SearchStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数
        // 发sql语句查询学生的信息
        // 使用for循环生成查询到的数据模拟
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int t = i + 1;
            studentList.add(new Student(t, "name" + t, 18 + t, "phone" + t));
        }
        // 保存查询的结果（学生信息）到request域中
        req.setAttribute("stuList",studentList);
        // 请求转发到showStudent.jsp页面
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req, resp);
    }
}
