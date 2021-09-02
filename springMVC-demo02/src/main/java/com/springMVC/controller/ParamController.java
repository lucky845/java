package com.springMVC.controller;

import com.springMVC.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @Author lichuang
 * @Create 2021-08-29 15:00
 * @Project_Name springMVC
 */
@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    // 形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession(); // 获得cookie
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + ",password: " + password);
        return "success";
    }

    @RequestMapping("/testParam")
    // 通过控制器获取请求参数
    public String testParam(
            @RequestParam(value = "user_name",required = false,defaultValue = "default") String username,
            String password,
            String[] hobby,
            @RequestHeader(value = "Host",required = false,defaultValue = "default") String host,
            @CookieValue("JSESSIONID") String cookie){
        // 若请求参数中出现多个同名的请求参数，可以在控制器方法的形参位置设置字符串类型或字符串数组接收此请求参数
        // 若使用字符串类型的形参，最终结果为请求参数的每一个值之间用逗号进行拼接
        System.out.println("username: " + username + ",password: " + password + ",hobby: " + Arrays.toString(hobby));
        System.out.println("host: " + host + ",JSESSIONID: " + cookie);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user); // 需要在web.xml中配制过滤器设置编码格式为UTF-8
        return "success";
        //最终结果-->User{id=null, username='张三', password='123', age=23, sex='男', email='123@qq.com'}
    }
}
